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

import static com.eucalyptus.container.ContainerInstances.ContainerInstanceStringFunctions.CLUSTER;
import static com.eucalyptus.container.TaskDefinitions.TaskDefinitionStringFunctions.FAMILY;
import static com.eucalyptus.container.common.ContainerMetadata.ContainerInstanceMetadata;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;
import com.eucalyptus.auth.Accounts;
import com.eucalyptus.auth.AuthQuotaException;
import com.eucalyptus.auth.policy.key.Keys;
import com.eucalyptus.auth.principal.AccountFullName;
import com.eucalyptus.auth.principal.UserFullName;
import com.eucalyptus.component.ServiceUris;
import com.eucalyptus.component.annotation.ComponentNamed;
import com.eucalyptus.compute.common.Compute;
import com.eucalyptus.compute.common.DescribeInstancesResponseType;
import com.eucalyptus.compute.common.DescribeInstancesType;
import com.eucalyptus.compute.common.Filter;
import com.eucalyptus.container.common.*;
import com.eucalyptus.context.Context;
import com.eucalyptus.context.Contexts;
import com.eucalyptus.container.common.model.*;
import com.eucalyptus.entities.AbstractPersistent;
import com.eucalyptus.entities.Entities;
import com.eucalyptus.util.Exceptions;
import com.eucalyptus.util.Internets;
import com.eucalyptus.util.Pair;
import com.eucalyptus.util.RestrictedType;
import com.eucalyptus.util.RestrictedTypes;
import com.eucalyptus.util.Strings;
import com.eucalyptus.util.TypeMappers;
import com.eucalyptus.util.async.AsyncRequests;
import com.eucalyptus.ws.Role;
import com.google.common.base.Functions;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Supplier;
import com.google.common.collect.Lists;
import edu.ucsb.eucalyptus.msgs.BaseCallerContext;
import edu.ucsb.eucalyptus.msgs.EvaluatedIamConditionKey;

/**
 *
 */
@SuppressWarnings( "UnusedDeclaration" )
@ComponentNamed
public class ContainerService {

  private static final Logger logger = Logger.getLogger( ContainerService.class );

  private final Clusters clusters;
  private final ContainerInstances containerInstances;
  private final TaskDefinitions taskDefinitions;

  @Inject
  public ContainerService( final Clusters clusters,
                           final ContainerInstances containerInstances,
                           final TaskDefinitions taskDefinitions ) {
    this.clusters = clusters;
    this.containerInstances = containerInstances;
    this.taskDefinitions = taskDefinitions;
  }

  public CreateClusterResponse createCluster( final CreateClusterRequest request ) throws EcsException {
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

  public DeleteClusterResponse deleteCluster( final DeleteClusterRequest request ) throws EcsException {
    final DeleteClusterResponse response = new DeleteClusterResponse( );
    final Context ctx = Contexts.lookup( );
    final AccountFullName accountFullName = ctx.getUserFullName( ).asAccountFullName( );
    final Predicate<? super Cluster> accessible =
        ContainerMetadatas.filteringFor( Cluster.class ).byPrivileges( ) .buildPredicate( );
    final Cluster cluster;
    try {
      cluster = clusters.lookupByName( accountFullName, request.getCluster( ), accessible, Functions.<Cluster>identity( ) );
      clusters.delete( cluster );
    } catch ( EcsMetadataNotFoundException e ) {
      throw new EcsClientException( "UnknownResourceFault", "Cluster not found: " + request.getCluster() );
    } catch ( Exception e ) {
      throw handleException( e );
    }
    response.setResult( new DeleteClusterResult( )
        .withCluster( TypeMappers.transform( cluster, com.eucalyptus.container.common.model.Cluster.class ) ) );
    return request.reply( response );
  }

  public DeregisterContainerInstanceResponse deregisterContainerInstance( final DeregisterContainerInstanceRequest request ) throws EcsException {
    logger.error( "DeregisterContainerInstance: " + request.getCluster() ); //TODO:STEVE: remove  // default
    logger.error( "DeregisterContainerInstance: " + request.getContainerInstance() );//TODO:STEVE: remove  // arn:aws:ecs::315214428084:container-instance/400f014e-4963-45db-a096-7b0cbe97d4fc
    logger.error( "DeregisterContainerInstance: " + request.getForce() ); //TODO:STEVE: remove // null
    final DeregisterContainerInstanceResponse response = new DeregisterContainerInstanceResponse( );
    final Context ctx = Contexts.lookup( );
    final AccountFullName accountFullName = ctx.getUserFullName( ).asAccountFullName( );
    final Predicate<? super ContainerInstance> accessible =
        ContainerMetadatas.filteringFor( ContainerInstance.class ).byPrivileges( ) .buildPredicate( );
    final Pair<ContainerInstanceMetadata,com.eucalyptus.container.common.model.ContainerInstance> containerInstancePair;
    try {
      containerInstancePair = containerInstances.lookupByName(
          accountFullName,
          request.getContainerInstance( ).substring( request.getContainerInstance( ).length( ) - 36 ),
          accessible,
          Pair.builder(
              Functions.<ContainerInstanceMetadata>identity( ),
              TypeMappers.lookup( ContainerInstance.class, com.eucalyptus.container.common.model.ContainerInstance.class ) ) );
      containerInstances.delete( containerInstancePair.getLeft( ) );
      //TODO:STEVE: seems like we should be using cluster for something ...
      //TODO:STEVE: force / check for tasks
    } catch ( EcsMetadataNotFoundException e ) {
      throw new EcsClientException( "UnknownResourceFault", "Cluster not found: " + request.getCluster() );
    } catch ( Exception e ) {
      throw handleException( e );
    }
    response.setResult( new DeregisterContainerInstanceResult( ).withContainerInstance( containerInstancePair.getRight( ) ) );
    return request.reply( response );
  }

  public DeregisterTaskDefinitionResponse deregisterTaskDefinition( final DeregisterTaskDefinitionRequest request ) throws EcsException {
    return request.reply( new DeregisterTaskDefinitionResponse( ) );
  }

  public DescribeClustersResponse describeClusters( final DescribeClustersRequest request ) throws EcsException {
    final DescribeClustersResponse response = new DescribeClustersResponse( );
    final Context ctx = Contexts.lookup( );
    final AccountFullName accountFullName = ctx.getUserFullName( ).asAccountFullName( );
    final Predicate<? super Cluster> requestedAndAccessible = ContainerMetadatas.filteringFor( Cluster.class )
        .byId( request.getClusters( ) )  //TODO:STEVE: allow for ARN
        .byPrivileges()
        .buildPredicate( );
    try {
      response.setResult( new DescribeClustersResult().withClusters( clusters.list(
          accountFullName,
          Restrictions.conjunction(),
          Collections.<String, String>emptyMap(),
          requestedAndAccessible,
          TypeMappers.lookup( Cluster.class, com.eucalyptus.container.common.model.Cluster.class ) ) ) );
    } catch ( Exception e ) {
      throw handleException( e );
    }
    return request.reply( response );
  }

  public DescribeContainerInstancesResponse describeContainerInstances( final DescribeContainerInstancesRequest request ) throws EcsException {
    final DescribeContainerInstancesResponse response = new DescribeContainerInstancesResponse( );
    final Context ctx = Contexts.lookup( );
    final AccountFullName accountFullName = ctx.getUserFullName( ).asAccountFullName( );
    final Predicate<? super ContainerInstance> requestedAndAccessible = ContainerMetadatas
        .filteringFor( ContainerInstance.class )
        .byId( request.getContainerInstances() ) //TODO:STEVE: allow for ARN also
        .byProperty( Optional.fromNullable( request.getCluster( ) ).asSet(), CLUSTER ) //TODO:STEVE: allow for ARN
        .byPrivileges()
        .buildPredicate();
    try {
      response.setResult( new DescribeContainerInstancesResult( ).withContainerInstances( containerInstances.list(
          accountFullName,
          Restrictions.conjunction( ),
          Collections.<String, String>emptyMap( ),
          requestedAndAccessible,
          TypeMappers.lookup( ContainerInstance.class, com.eucalyptus.container.common.model.ContainerInstance.class ) ) ) );
    } catch ( Exception e ) {
      throw handleException( e );
    }
    return request.reply( response );
  }

  public DescribeTaskDefinitionResponse describeTaskDefinition( final DescribeTaskDefinitionRequest request ) throws EcsException {
    final DescribeTaskDefinitionResponse response = new DescribeTaskDefinitionResponse( );
    final Context ctx = Contexts.lookup( );
    final AccountFullName accountFullName = ctx.getUserFullName( ).asAccountFullName();
    final Predicate<? super TaskDefinition> accessible =
        ContainerMetadatas.filteringFor( TaskDefinition.class ).byPrivileges() .buildPredicate();
    try {
      response.setResult( new DescribeTaskDefinitionResult( ).withTaskDefinition( taskDefinitions.lookupByName(
          accountFullName,
          request.getTaskDefinition(),
          accessible,
          TypeMappers.lookup( TaskDefinition.class, com.eucalyptus.container.common.model.TaskDefinition.class ) ) ) );
    } catch ( Exception e ) {
      //TODO:STEVE: not found error
      throw handleException( e );
    }
    return request.reply( response );
  }

  public DescribeTasksResponse describeTasks( final DescribeTasksRequest request ) throws EcsException {
    return request.reply( new DescribeTasksResponse( ) );
  }

  public DiscoverPollEndpointResponse discoverPollEndpoint( final DiscoverPollEndpointRequest request ) throws EcsException {
    logger.error( "DiscoverPollEndpoint: " + request.getContainerInstance( ) ); //TODO:STEVE: remove
    final DiscoverPollEndpointResponse response = new DiscoverPollEndpointResponse( );
    response.setResult( new DiscoverPollEndpointResult( ).withEndpoint( "http://" + StringUtils.substringBefore( ServiceUris.remotePublicify( com.eucalyptus.container.common.Container.class ).getHost(), ":" ) ) );
    return request.reply( response );
  }

  public ListClustersResponse listClusters( final ListClustersRequest request ) throws EcsException {
    final ListClustersResponse response = new ListClustersResponse( );
    final Context ctx = Contexts.lookup( );
    final AccountFullName accountFullName = ctx.getUserFullName( ).asAccountFullName( );
    final Predicate<? super Cluster> accessible = ContainerMetadatas.filteringFor( Cluster.class )
        .byPrivileges( )
        .buildPredicate( );
    try {
      response.setResult( new ListClustersResult( ).withClusterArns( clusters.list(
          accountFullName,
          Restrictions.conjunction( ),
          Collections.<String, String>emptyMap( ),
          accessible,
          ContainerMetadatas.toArn( ) ) ) );
    } catch ( Exception e ) {
      throw handleException( e );
    }
    return request.reply( response );
  }

  public ListContainerInstancesResponse listContainerInstances( final ListContainerInstancesRequest request ) throws EcsException {
    final ListContainerInstancesResponse response = new ListContainerInstancesResponse( );
    final Context ctx = Contexts.lookup( );
    final AccountFullName accountFullName = ctx.getUserFullName( ).asAccountFullName( );
    final Predicate<? super ContainerInstance> requestedAndAccessible = ContainerMetadatas
        .filteringFor( ContainerInstance.class )
        .byPrivileges( )
        .buildPredicate( );
    try {
      response.setResult(
        new ListContainerInstancesResult( ).withContainerInstanceArns(
            containerInstances.list(
                accountFullName,
                Restrictions.conjunction( ),
                Collections.<String, String>emptyMap( ),
                requestedAndAccessible,
                ContainerMetadatas.toArn( ) ) )
      );
    } catch ( Exception e ) {
      throw handleException( e );
    }
    return request.reply( response );
  }

  public ListTaskDefinitionFamiliesResponse listTaskDefinitionFamilies( final ListTaskDefinitionFamiliesRequest request ) throws EcsException {
    return request.reply( new ListTaskDefinitionFamiliesResponse( ) );
  }

  public ListTaskDefinitionsResponse listTaskDefinitions( final ListTaskDefinitionsRequest request ) throws EcsException {
    final ListTaskDefinitionsResponse response = new ListTaskDefinitionsResponse( );
    final Context ctx = Contexts.lookup( );
    final AccountFullName accountFullName = ctx.getUserFullName( ).asAccountFullName( );
    final Predicate<? super TaskDefinition> requestedAndAccessible = ContainerMetadatas.filteringFor( TaskDefinition.class )
        .byPredicate( request.getFamilyPrefix( ) == null ?
            Predicates.<TaskDefinition>alwaysTrue( ) :
            Predicates.compose( Strings.startsWith( request.getFamilyPrefix( ) ), FAMILY ) )
        .byPrivileges()
        .buildPredicate();
    try {
      response.setResult( new ListTaskDefinitionsResult( ).withTaskDefinitionArns( taskDefinitions.list(
          accountFullName,
          Restrictions.conjunction( ),
          Collections.<String, String>emptyMap( ),
          requestedAndAccessible,
          ContainerMetadatas.toArn( ) ) ) );
    } catch ( Exception e ) {
      throw handleException( e );
    }
    return request.reply( response );
  }

  public ListTasksResponse listTasks( final ListTasksRequest request ) throws EcsException {
    return request.reply( new ListTasksResponse( ) );
  }

  public RegisterContainerInstanceResponse registerContainerInstance( final RegisterContainerInstanceRequest request ) throws EcsException {
    final RegisterContainerInstanceResponse response = new RegisterContainerInstanceResponse( );
    //TODO:STEVE: allow ARN for cluster

    final Context ctx = Contexts.lookup( );
    final UserFullName userFullName = ctx.getUserFullName( );
    final String ip = ctx.getRemoteAddress( ).getHostAddress( );
    final String instanceId;
    try {
      final DescribeInstancesType describeInstances = new DescribeInstancesType( );
      describeInstances.setUserId( Accounts.lookupSystemAdmin().getUserId() );
      describeInstances.setCallerContext( new BaseCallerContext( Lists.newArrayList(
          new EvaluatedIamConditionKey( Keys.AWS_SOURCEIP, Internets.localHostAddress( ) )
      ) ) );
      final Filter filter = new Filter( );
      filter.setName( "private-ip-address" ); //TODO:STEVE: also ip-address
      filter.setValueSet( Lists.newArrayList( ip ) );
      describeInstances.getFilterSet( ).add( filter );
      DescribeInstancesResponseType describeInstancesResponse =
          AsyncRequests.sendSync( Compute.class, describeInstances );
      instanceId = describeInstancesResponse.getReservationSet( ).get( 0 ).getInstancesSet( ).get( 0 ).getInstanceId( );
    } catch ( Exception e ) {
      logger.error( "Error describing instance on container instance registration for ip " + ip, e );
      throw new EcsException( "InternalError", Role.Receiver, "Error" );
    }

    final ContainerInstance containerInstance = allocate( new Supplier<ContainerInstance>( ) {
      @Override
      public ContainerInstance get( ) {
        try {
          Cluster cluster;
          try {
            cluster =
                clusters.lookupByName( userFullName.asAccountFullName( ), request.getCluster( ), Predicates.alwaysTrue(), Functions.<Cluster>identity( ) );
          } catch ( EcsMetadataNotFoundException e ) {
            if ( "default".equals( request.getCluster( ) ) ) {
              cluster = clusters.save( Cluster.create( userFullName, "default" ) );
            } else {
              throw Exceptions.toUndeclared( new EcsClientException( "ValidationError", "Cluster not found '"+request.getCluster()+"'" ) ); //TODO:STEVE: return the right error
            }
          }

          final List<ContainerResource> resources = Lists.newArrayList( );
          for ( final Resource resource : request.getTotalResources()  ) {
            resources.add( TypeMappers.transform( resource, ContainerResource.class ) );
          }
          final ContainerInstance containerInstance = ContainerInstance.create(
              userFullName,
              cluster,
              instanceId,
              resources );
          return containerInstances.save( containerInstance );
        } catch ( Exception ex ) {
          throw new RuntimeException( ex );
        }
      }
    }, ContainerInstance.class, request.getCluster() );

    response.setResult( new RegisterContainerInstanceResult()
            .withContainerInstance( TypeMappers.transform( containerInstance, com.eucalyptus.container.common.model.ContainerInstance.class ) )
    );
    return request.reply( response );
  }

  public RegisterTaskDefinitionResponse registerTaskDefinition( final RegisterTaskDefinitionRequest request ) throws EcsException {
    final RegisterTaskDefinitionResponse response = new RegisterTaskDefinitionResponse( );
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
    response.setResult( new RegisterTaskDefinitionResult( )
        .withTaskDefinition( TypeMappers.transform( taskDefinition, com.eucalyptus.container.common.model.TaskDefinition.class ) ) );
    return request.reply( response );
  }

  public RunTaskResponse runTask( final RunTaskRequest request ) throws EcsException {
    return request.reply( new RunTaskResponse( ) );
  }

  public StartTaskResponse startTask( final StartTaskRequest request ) throws EcsException {
    return request.reply( new StartTaskResponse( ) );
  }

  public StopTaskResponse stopTask( final StopTaskRequest request ) throws EcsException {
    return request.reply( new StopTaskResponse( ) );
  }

  public SubmitContainerStateChangeResponse submitContainerStateChange( final SubmitContainerStateChangeRequest request ) throws EcsException {
    return request.reply( new SubmitContainerStateChangeResponse( ) );
  }

  public SubmitTaskStateChangeResponse submitTaskStateChange ( final SubmitTaskStateChangeRequest request ) throws EcsException {
    return request.reply( new SubmitTaskStateChangeResponse( ) );
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
