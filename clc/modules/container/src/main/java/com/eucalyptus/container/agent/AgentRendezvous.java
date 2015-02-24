/*************************************************************************
 * Copyright 2009-2015 Eucalyptus Systems, Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; version 3 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses/.
 *
 * Please contact Eucalyptus Systems, Inc., 6755 Hollister Ave., Goleta
 * CA 93117, USA or visit http://www.eucalyptus.com/licenses/ if you need
 * additional information or have any questions.
 ************************************************************************/
package com.eucalyptus.container.agent;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nullable;
import org.apache.log4j.Logger;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;
import org.jboss.netty.channel.Channels;
import com.eucalyptus.auth.policy.ern.Ern;
import com.eucalyptus.auth.principal.AccountFullName;
import com.eucalyptus.bootstrap.Bootstrap;
import com.eucalyptus.component.Topology;
import com.eucalyptus.container.ContainerDefinition;
import com.eucalyptus.container.ContainerInstance;
import com.eucalyptus.container.TaskDefinition;
import com.eucalyptus.entities.Entities;
import com.eucalyptus.entities.TransactionException;
import com.eucalyptus.event.ClockTick;
import com.eucalyptus.event.EventListener;
import com.eucalyptus.event.Listeners;
import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 *
 */
public class AgentRendezvous {
  private static final Logger logger = Logger.getLogger( AgentRendezvous.class );

  private static final ConcurrentMap<String,AgentConnectionInfo> agents = Maps.newConcurrentMap( );

  public static void register( final String containerInstanceArn, final Channel channel ) {
    logger.info( "Registering agent channel for " + containerInstanceArn  );
    agents.put( containerInstanceArn, new AgentConnectionInfo( channel, containerInstanceArn ) );
    setAgentConnected( containerInstanceArn, true );
    channel.getCloseFuture( ).addListener( new ChannelFutureListener( ) {
      @Override
      public void operationComplete( final ChannelFuture channelFuture ) throws Exception {
        logger.info( "De-registering agent channel for " + containerInstanceArn  );
        agents.remove( containerInstanceArn );
        setAgentConnected( containerInstanceArn, false );
      }
    } );
  }

  public static void dispatchTask( final ContainerInstance instance,
                                   final TaskDefinition taskDefinition,
                                   final com.eucalyptus.container.Task containerTask ) {
    final AgentConnectionInfo agentConnectionInfo = agents.get( instance.getArn( ) );
    if ( agentConnectionInfo != null && agentConnectionInfo.channel.isConnected( ) ) {

      final List<Container> containers = Lists.newArrayList( );
      for ( final ContainerDefinition containerDefinition : taskDefinition.getContainerDefinitions( ) ) {
        final List<PortMapping> portMappings = Lists.newArrayList( );
        for ( final com.eucalyptus.container.PortMapping portMapping : containerDefinition.getPortMappings( ) ) {
          portMappings.add( new PortMapping( portMapping.getContainerPort( ), portMapping.getHostPort( ) ) );
        }

        final Container container = new Container( );
        container.setName( containerDefinition.getName( ) );
        container.setImage( containerDefinition.getImage() );
        container.setCpu( containerDefinition.getCpu() );
        container.setMemory( containerDefinition.getMemory() );
        container.setCommand( containerDefinition.getCommands() );
        container.setEssential( containerDefinition.getEssential() );
        container.setEnvironment( containerDefinition.getEnvironment( ) );
        container.setLinks( containerDefinition.getLinks() );
        container.setPortMappings( portMappings );
        containers.add( container );
      }

      final Task task = new Task( );
      task.setArn( containerTask.getArn() );
      task.setFamily( containerTask.getFamily() );
      task.setVersion( String.valueOf( taskDefinition.getRevision( ) ) );
      task.setDesiredStatus( containerTask.getDesiredStatus( ) );
      task.setTaskDefinitionAccountId( instance.getOwnerAccountNumber( ) );
      task.setContainers( containers );

      final PayloadMessage payloadMessage = new PayloadMessage( );
      payloadMessage.setClusterArn( instance.getCluster( ).getArn( ) );
      payloadMessage.setContainerInstanceArn( instance.getArn( ) );
      payloadMessage.setGeneratedAt( System.currentTimeMillis( ) );
      payloadMessage.setSeqNum( agentConnectionInfo.sequenceNum.incrementAndGet( ) );
      payloadMessage.setMessageId( UUID.randomUUID( ).toString( ) );
      payloadMessage.setTasks( Lists.newArrayList( task ) );

      final PollResponse message = new PollResponse();
      message.setType( "PayloadMessage" );
      message.setMessage( payloadMessage );

      Channels.write( agentConnectionInfo.channel, message );
    } else {
      logger.error( "Channel not found for instance: " + instance.getArn( ) );
    }
  }

  private static final class AgentConnectionInfo {
    private final long since;
    private final Channel channel;
    private final String containerInstanceArn;
    private final AtomicLong sequenceNum = new AtomicLong( 0 );

    private AgentConnectionInfo( final Channel channel, final String containerInstanceArn ) {
      this.since = System.currentTimeMillis( );
      this.channel = channel;
      this.containerInstanceArn = containerInstanceArn;
    }
  }

  private static void setAgentConnected( final String containerInstanceArn, final boolean connected ) {
    try {
      final Ern ern = Ern.parse( containerInstanceArn );
      final String accountNumber = ern.getNamespace( );
      final String uuid = ern.getResourceName( );

      Entities.asDistinctTransaction( ContainerInstance.class, new Predicate<String>( ){
        @Override
        public boolean apply( @Nullable final String containerInstanceArn ) {
          try {
            final ContainerInstance containerInstance =
                Entities.uniqueResult( ContainerInstance.exampleWithName( AccountFullName.getInstance( accountNumber ), uuid ) );
            containerInstance.setAgentConnected( connected );
          } catch ( TransactionException e ) {
            logger.error( "Error updating connected state (" + connected + ") for " + containerInstanceArn, e );
          } catch ( NoSuchElementException e ) {
            logger.error( "Container instance not found when updating connected state ("+connected+") for " + containerInstanceArn );
          }
          return true;
        }
      } ).apply( containerInstanceArn );
    } catch( Exception e ) {
      logger.error( "Error updating connected state ("+connected+") for " + containerInstanceArn, e );
    }
  }

  public static final class AgentHeartbeatEventListener implements EventListener<ClockTick> {
    public static void register( ) {
      Listeners.register( ClockTick.class, new AgentHeartbeatEventListener( ) );
    }

    @Override
    public void fireEvent( final ClockTick event ) {
      if ( Topology.isEnabled( com.eucalyptus.container.common.Container.class ) &&
          Bootstrap.isOperational( ) ) {
        for ( final AgentConnectionInfo agentConnectionInfo : agents.values( ) ) try {
          if ( agentConnectionInfo.channel.isConnected( ) ) {
            final HeartbeatMessage heartbeatMessage = new HeartbeatMessage( );
            heartbeatMessage.setHealthy( true );

            final PollResponse message = new PollResponse();
            message.setType( "HeartbeatMessage" );
            message.setMessage( heartbeatMessage );

            Channels.write( agentConnectionInfo.channel, message );
          }
        } catch ( final Exception e ) {
          logger.error( "Error sending heartbeat", e );
        }
      }
    }
  }
}
