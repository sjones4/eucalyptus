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
package com.eucalyptus.container;

import java.sql.SQLException;
import java.util.Collections;
import javax.inject.Inject;
import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;
import com.eucalyptus.auth.AuthQuotaException;
import com.eucalyptus.auth.principal.AccountFullName;
import com.eucalyptus.auth.principal.UserFullName;
import com.eucalyptus.component.annotation.ComponentNamed;
import com.eucalyptus.container.common.ContainerMetadatas;
import com.eucalyptus.context.Context;
import com.eucalyptus.context.Contexts;
import com.eucalyptus.container.common.model.*;
import com.eucalyptus.entities.AbstractPersistent;
import com.eucalyptus.entities.Entities;
import com.eucalyptus.util.Exceptions;
import com.eucalyptus.util.RestrictedType;
import com.eucalyptus.util.RestrictedTypes;
import com.eucalyptus.util.TypeMappers;
import com.eucalyptus.ws.Role;
import com.google.common.base.Functions;
import com.google.common.base.Predicate;
import com.google.common.base.Supplier;

/**
 *
 */
@SuppressWarnings( "UnusedDeclaration" )
@ComponentNamed
public class ContainerService {

  private static final Logger logger = Logger.getLogger( ContainerService.class );

  private final Clusters clusters;
  private final TaskDefinitions taskDefinitions;

  @Inject
  public ContainerService( final Clusters clusters,
                           final TaskDefinitions taskDefinitions ) {
    this.clusters = clusters;
    this.taskDefinitions = taskDefinitions;
  }

  public EcsMessage createCluster( final CreateClusterRequest request ) throws EcsException {
    final CreateClusterResponse response = new CreateClusterResponse( );
    final Context ctx = Contexts.lookup( );
    final UserFullName userFullName = ctx.getUserFullName( );
    final Cluster cluster = allocate( new Supplier<Cluster>( ) {
      @Override
      public Cluster get( ) {
        try {
          final Cluster cluster = Cluster.create(
              userFullName,
              request.getClusterName( ) );
          return clusters.save( cluster );
        } catch ( Exception ex ) {
          throw new RuntimeException( ex );
        }
      }
    }, Cluster.class, request.getClusterName( ) );
    response.setResult( new CreateClusterResult( )
        .withCluster( TypeMappers.transform( cluster, com.eucalyptus.container.common.model.Cluster.class ) ) );
    return request.reply( response );
  }

  public EcsMessage deleteCluster( final DeleteClusterRequest request ) throws EcsException {
    final Context ctx = Contexts.lookup( );
    final AccountFullName accountFullName = ctx.getUserFullName( ).asAccountFullName( );
    final Predicate<? super Cluster> accessible =
        ContainerMetadatas.filteringFor( Cluster.class ).byPrivileges( ) .buildPredicate( );
    final Cluster cluster;
    try {
      cluster = clusters.lookupByName( accountFullName, request.getCluster( ), Functions.<Cluster>identity( ) );
      clusters.delete( cluster );
    } catch ( EcsMetadataNotFoundException e ) {
      throw new EcsClientException( "UnknownResourceFault", "Cluster not found: " + request.getCluster() );
    } catch ( Exception e ) {
      throw handleException( e );
    }

    return request.reply( new DeleteClusterResult( )
        .withCluster( TypeMappers.transform( cluster, com.eucalyptus.container.common.model.Cluster.class ) ) );
  }

  public EcsMessage deregisterContainerInstance( final DeregisterContainerInstanceRequest request ) throws EcsException {
    return request.reply( new EcsMessage( ) );
  }

  public EcsMessage deregisterTaskDefinition( final DeregisterTaskDefinitionRequest request ) throws EcsException {
    return request.reply( new EcsMessage( ) );
  }

  public EcsMessage describeClusters( final DescribeClustersRequest request ) throws EcsException {
    final DescribeClustersResult describeClustersResult = new DescribeClustersResult( );
    final Context ctx = Contexts.lookup( );
    final AccountFullName accountFullName = ctx.getUserFullName( ).asAccountFullName( );
    final Predicate<? super Cluster> requestedAndAccessible = ContainerMetadatas.filteringFor( Cluster.class )
        .byId( request.getClusters( ) )
        .byPrivileges( )
        .buildPredicate( );
    try {
      describeClustersResult.getClusters( ).addAll( clusters.list(
          accountFullName,
          Restrictions.conjunction( ),
          Collections.<String, String>emptyMap( ),
          requestedAndAccessible,
          TypeMappers.lookup( Cluster.class, com.eucalyptus.container.common.model.Cluster.class ) ) );
    } catch ( Exception e ) {
      throw handleException( e );
    }
    return request.reply( describeClustersResult );
  }

  public EcsMessage describeContainerInstances( final DescribeContainerInstancesRequest request ) throws EcsException {
    return request.reply( new EcsMessage( ) );
  }

  public EcsMessage describeTaskDefinition( final DescribeTaskDefinitionRequest request ) throws EcsException {
    final DescribeTaskDefinitionResult describeTaskDefinitionResult = new DescribeTaskDefinitionResult( );
    final Context ctx = Contexts.lookup( );
    final AccountFullName accountFullName = ctx.getUserFullName( ).asAccountFullName( );
    try {
      describeTaskDefinitionResult.setTaskDefinition( taskDefinitions.lookupByName( //TODO:STEVE: authorization
          accountFullName,
          request.getTaskDefinition( ),
          TypeMappers.lookup( TaskDefinition.class, com.eucalyptus.container.common.model.TaskDefinition.class ) ) );
    } catch ( Exception e ) {
      //TODO:STEVE: not found error
      throw handleException( e );
    }
    return request.reply( describeTaskDefinitionResult );
  }

  public EcsMessage describeTasks( final DescribeTasksRequest request ) throws EcsException {
    return request.reply( new EcsMessage( ) );
  }

  public EcsMessage discoverPollEndpoint( final DiscoverPollEndpointRequest request ) throws EcsException {
    return request.reply( new EcsMessage( ) );
  }

  public EcsMessage listClusters( final ListClustersRequest request ) throws EcsException {
    final ListClustersResult listClustersResult = new ListClustersResult( );
    final Context ctx = Contexts.lookup( );
    final AccountFullName accountFullName = ctx.getUserFullName( ).asAccountFullName( );
    final Predicate<? super Cluster> requestedAndAccessible = ContainerMetadatas.filteringFor( Cluster.class )
        .byPrivileges( )
        .buildPredicate( );
    try {
      listClustersResult.getClusterArns().addAll( clusters.list(
          accountFullName,
          Restrictions.conjunction( ),
          Collections.<String, String>emptyMap( ),
          requestedAndAccessible,
          ContainerMetadatas.toArn() ) );
    } catch ( Exception e ) {
      throw handleException( e );
    }
    return request.reply( listClustersResult );
  }

  public EcsMessage listContainerInstances( final ListContainerInstancesRequest request ) throws EcsException {
    return request.reply( new EcsMessage( ) );
  }

  public EcsMessage listTaskDefinitions( final ListTaskDefinitionsRequest request ) throws EcsException {
    final ListTaskDefinitionsResult listTaskDefinitionsResult = new ListTaskDefinitionsResult( );
    final Context ctx = Contexts.lookup( );
    final AccountFullName accountFullName = ctx.getUserFullName( ).asAccountFullName( );
    final Predicate<? super TaskDefinition> requestedAndAccessible = ContainerMetadatas.filteringFor( TaskDefinition.class )
        .byPrivileges( )
        .buildPredicate( );
    try {
      listTaskDefinitionsResult.getTaskDefinitionArns().addAll( taskDefinitions.list(
          accountFullName,
          Restrictions.conjunction( ),
          Collections.<String, String>emptyMap( ),
          requestedAndAccessible,
          ContainerMetadatas.toArn() ) );
    } catch ( Exception e ) {
      throw handleException( e );
    }
    return request.reply( listTaskDefinitionsResult );
  }

  public EcsMessage listTasks( final ListTasksRequest request ) throws EcsException {
    return request.reply( new EcsMessage( ) );
  }

  public EcsMessage registerContainerInstance( final RegisterContainerInstanceRequest request ) throws EcsException {
    return request.reply( new EcsMessage( ) );
  }

  public EcsMessage registerTaskDefinition( final RegisterTaskDefinitionRequest request ) throws EcsException {
    final Context ctx = Contexts.lookup( );
    final UserFullName userFullName = ctx.getUserFullName( );
    final TaskDefinition taskDefinition = allocate( new Supplier<TaskDefinition>( ) {
      @Override
      public TaskDefinition get( ) {
        try {
          final TaskDefinition taskDefinition = TaskDefinition.create(
              userFullName,
              request.getFamily(),
              1 ); //TODO:STEVE: determine next revision#
           for ( final com.eucalyptus.container.common.model.ContainerDefinition definition : request.getContainerDefinitions( )  ) {
             taskDefinition.getContainerDefinitions( ).add( TypeMappers.transform( definition, ContainerDefinition.class ) );
           }
          return taskDefinitions.save( taskDefinition );
        } catch ( Exception ex ) {
          throw new RuntimeException( ex );
        }
      }
    }, TaskDefinition.class, request.getFamily( ) );
    return request.reply( new RegisterTaskDefinitionResult( )
        .withTaskDefinition( TypeMappers.transform( taskDefinition, com.eucalyptus.container.common.model.TaskDefinition.class ) ) );
  }

  public EcsMessage runTask( final RunTaskRequest request ) throws EcsException {
    return request.reply( new EcsMessage( ) );
  }

  public EcsMessage startTask( final StartTaskRequest request ) throws EcsException {
    return request.reply( new EcsMessage( ) );
  }

  public EcsMessage stopTask( final StopTaskRequest request ) throws EcsException {
    return request.reply( new EcsMessage( ) );
  }

  public EcsMessage submitContainerStateChange( final SubmitContainerStateChangeRequest request ) throws EcsException {
    return request.reply( new EcsMessage( ) );
  }

  public EcsMessage submitTaskStateChange ( final SubmitTaskStateChangeRequest request ) throws EcsException {
    return request.reply( new EcsMessage( ) );
  }

  private <T extends AbstractPersistent & RestrictedType> T allocate(
      final Supplier<T> allocator,
      final Class<T> type,
      final String name
  ) throws EcsException {
    try {
      return RestrictedTypes.allocateUnitlessResources( type, 1, transactional( allocator ) ).get( 0 );
    } catch ( Exception e ) {
      final SQLException sqlException = Exceptions.findCause( e, SQLException.class );
      final ConstraintViolationException constraintViolationException =
          Exceptions.findCause( e, ConstraintViolationException.class );
      if ( constraintViolationException != null || ( sqlException != null && "23505".equals( sqlException.getSQLState( ) ) ) ) {
        final String typeName = type.getSimpleName( );
        final String faultPrefix = typeName.endsWith( "Type" ) ? "Type" : typeName;
        throw new EcsClientException( faultPrefix + "AlreadyExistsFault", typeName + " already exists: " + name );
      }
      throw handleException( e );
    }
  }

  protected <E extends AbstractPersistent> Supplier<E> transactional( final Supplier<E> supplier ) {
    return Entities.asTransaction( supplier );
  }

  /**
   * Method always throws, signature allows use of "throw up ..."
   */
  private static RuntimeException up( final Throwable throwable ) {
    throw Exceptions.toUndeclared( throwable );
  }

  /**
   * Method always throws, signature allows use of "throw upClient ..."
   */
  private static RuntimeException upClient( final String errorCode,
                                            final String message ) {
    throw up( new EcsClientException( errorCode, message ) );
  }

  /**
   * Method always throws, signature allows use of "throw handleException ..."
   */
  private EcsException handleException( final Exception e ) throws EcsException {
    final EcsException cause = Exceptions.findCause( e, EcsException.class );
    if ( cause != null ) {
      throw cause;
    }

    final AuthQuotaException quotaCause = Exceptions.findCause( e, AuthQuotaException.class );
    if ( quotaCause != null ) {
      throw new EcsClientException( "LimitExceededFault", "Request would exceed quota for type: " + quotaCause.getType( ) );
    }

    logger.error( e, e );

    final EcsException exception = new EcsException( "InternalError", Role.Receiver, String.valueOf(e.getMessage( )) );
    if ( Contexts.lookup( ).hasAdministrativePrivileges( ) ) {
      exception.initCause( e );
    }
    throw exception;
  }
}
