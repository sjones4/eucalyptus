/*************************************************************************
 * (c) Copyright 2017 Hewlett Packard Enterprise Development Company LP
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
 ************************************************************************/
package com.eucalyptus.deploy.init;

import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.log4j.Logger;
import com.eucalyptus.bootstrap.Bootstrap;
import com.eucalyptus.component.ComponentIds;
import com.eucalyptus.component.Topology;
import com.eucalyptus.config.PropertiesClient;
import com.eucalyptus.empyrean.Empyrean;
import com.eucalyptus.empyrean.ServiceStatusType;
import com.eucalyptus.empyrean.configuration.ServiceRegistrationClient;
import com.eucalyptus.event.ClockTick;
import com.eucalyptus.event.EventListener;
import com.eucalyptus.event.Listeners;
import com.eucalyptus.util.Internets;
import com.eucalyptus.util.async.AsyncProxy;
import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.common.collect.Sets;

/**
 *
 */
public class DeployEventListener implements EventListener<ClockTick> {

  private static final Logger logger = Logger.getLogger( DeployEventListener.class );

  private AtomicBoolean deployed = new AtomicBoolean( false );

  public static void register( ) {
    Listeners.register( ClockTick.class, new DeployEventListener( ) );
  }

  @Override
  public void fireEvent( final ClockTick event ) {
    if ( Bootstrap.isFinished( ) && Topology.isEnabledLocally( Empyrean.class ) && deployed.compareAndSet( false, true ) ) {
      final String register = System.getProperty( "com.eucalyptus.deploy.register", "" );
      final Set<String> typesToRegister = Sets.newTreeSet(
          Splitter.on( CharMatcher.anyOf( ", ;:" ) ).omitEmptyStrings( ).trimResults( ).split( register ) );
      logger.info( "Deploying basic services for local cloud " + typesToRegister );
      final ServiceRegistrationClient client = AsyncProxy.privilegedClient( ServiceRegistrationClient.class );
      for ( final ServiceStatusType serviceStatus : client.describePublicServices( ).getServiceStatuses( ) ) {
        logger.info( "Found public service " + serviceStatus.getServiceId( ).getType( ) );
        typesToRegister.remove( serviceStatus.getServiceId( ).getType(  ) );
      }
      logger.info( "Registering services with types " + typesToRegister );
      final String host = Internets.localHostAddress( );
      typesToRegister.forEach( type -> {
        final boolean partitioned = ComponentIds.lookup( type ).isPartitioned( );
        logger.info( "Registering service with type " + type );
        client.registerService( type, partitioned ? "one" : host, host, null, host + "." + type );
      } );

      logger.info( "Configuring services" );
      final PropertiesClient propertiesClient = AsyncProxy.privilegedClient( PropertiesClient.class );
      typesToRegister.forEach( type -> {
        switch ( type ) {
          case "objectstorage":
          case "user-api":
            logger.info( "Configuring provider client for objectstorage" );
            propertiesClient.modifyProperty( "objectstorage.providerclient", "walrus" );
            break;
        }
      } );

      //TODO:STEVE: create a fake image?
    }
  }
}
