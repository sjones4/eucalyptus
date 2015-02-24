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
import static com.eucalyptus.container.Tasks.TaskStringFunctions;
import static com.eucalyptus.container.common.EcsMetadata.ContainerInstanceMetadata;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;
import com.eucalyptus.auth.Accounts;
import com.eucalyptus.auth.AuthQuotaException;
import com.eucalyptus.auth.policy.ern.Ern;
import com.eucalyptus.auth.policy.key.Keys;
import com.eucalyptus.auth.principal.AccountFullName;
import com.eucalyptus.auth.principal.UserFullName;
import com.eucalyptus.component.ServiceUris;
import com.eucalyptus.component.annotation.ComponentNamed;
import com.eucalyptus.compute.common.Compute;
import com.eucalyptus.compute.common.DescribeInstancesResponseType;
import com.eucalyptus.compute.common.DescribeInstancesType;
import com.eucalyptus.compute.common.Filter;
import com.eucalyptus.container.agent.AgentRendezvous;
import com.eucalyptus.container.common.*;
import com.eucalyptus.context.Context;
import com.eucalyptus.context.Contexts;
import com.eucalyptus.container.common.model.*;
import com.eucalyptus.entities.AbstractPersistent;
import com.eucalyptus.entities.Entities;
import com.eucalyptus.util.CollectionUtils;
import com.eucalyptus.util.Exceptions;
import com.eucalyptus.util.Internets;
import com.eucalyptus.util.NonNullFunction;
import com.eucalyptus.util.Pair;
import com.eucalyptus.util.RestrictedType;
import com.eucalyptus.util.RestrictedTypes;
import com.eucalyptus.util.Strings;
import com.eucalyptus.util.TypeMappers;
import com.eucalyptus.util.async.AsyncRequests;
import com.eucalyptus.ws.Role;
import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Supplier;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import edu.ucsb.eucalyptus.msgs.BaseCallerContext;
import edu.ucsb.eucalyptus.msgs.EvaluatedIamConditionKey;
import net.sf.json.JSONException;

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
  private final Tasks tasks;
  private final Random random = new Random( );

  @Inject
  public ContainerService( final Clusters clusters,
                           final ContainerInstances containerInstances,
                           final TaskDefinitions taskDefinitions,
                           final Tasks tasks ) {
    this.clusters = clusters;
    this.containerInstances = containerInstances;
    this.taskDefinitions = taskDefinitions;
    this.tasks = tasks;
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
      cluster = clusters.lookupByName( accountFullName, arnResourceName( ).apply( request.getCluster() ), accessible, Functions.<Cluster>identity( ) );
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
    final DeregisterContainerInstanceResponse response = new DeregisterContainerInstanceResponse( );
    final Context ctx = Contexts.lookup( );
    final AccountFullName accountFullName = ctx.getUserFullName( ).asAccountFullName( );
    final Predicate<? super ContainerInstance> accessible =
        ContainerMetadatas.filteringFor( ContainerInstance.class ).byPrivileges( ) .buildPredicate( );
    final Pair<ContainerInstanceMetadata,com.eucalyptus.container.common.model.ContainerInstance> containerInstancePair;
    try {
      containerInstancePair = containerInstances.lookupByName(
          accountFullName,
          arnResourceName( ).apply( request.getContainerInstance( ) ),
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
    // Not supported in AWS/ECS
    throw new EcsClientException( "InvalidAction", "Deregistering task definitions is currently unsupported." );
  }

  public DescribeClustersResponse describeClusters( final DescribeClustersRequest request ) throws EcsException {
    final DescribeClustersResponse response = new DescribeClustersResponse( );
    final Context ctx = Contexts.lookup( );
    final AccountFullName accountFullName = ctx.getUserFullName( ).asAccountFullName();
    final Set<String> clusterNames =
        Sets.newLinkedHashSet( Iterables.transform( request.getClusters(), arnResourceName( ) ) );
    final Predicate<? super Cluster> requestedAndAccessible = ContainerMetadatas.filteringFor( Cluster.class )
        .byId( Iterables.isEmpty( clusterNames ) ? Collections.singleton( "default" ) : clusterNames )
        .byPrivileges()
        .buildPredicate();
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

  // TODO:STEVE: Port reservations
  // The default reserved ports are 22 for SSH, the Docker ports 2375 and 2376, and the Amazon ECS container agent
  // port 51678. Any host port that was previously user-specified for a running task is also reserved while the
  // task is running (after a task stops, the host port is released). The current reserved ports are displayed in
  // the remainingResources of describe-container-instances output, and a container instance may have up to 50
  // reserved ports at a time, including the default reserved ports (automatically assigned ports do not count
  // toward this limit).
  public DescribeContainerInstancesResponse describeContainerInstances( final DescribeContainerInstancesRequest request ) throws EcsException {
    final DescribeContainerInstancesResponse response = new DescribeContainerInstancesResponse( );
    final Context ctx = Contexts.lookup( );
    final AccountFullName accountFullName = ctx.getUserFullName( ).asAccountFullName( );
    final Predicate<? super ContainerInstance> requestedAndAccessible = ContainerMetadatas
        .filteringFor( ContainerInstance.class )
        .byId( Sets.newLinkedHashSet( Iterables.transform( request.getContainerInstances( ), arnResourceName( ) ) ) )
        .byProperty( Optional.fromNullable( request.getCluster( ) ).transform( arnResourceName( ) ).asSet(), CLUSTER )
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
          arnResourceName( ).apply( request.getTaskDefinition() ),
          accessible,
          TypeMappers.lookup( TaskDefinition.class, com.eucalyptus.container.common.model.TaskDefinition.class ) ) ) );
    } catch ( Exception e ) {
      //TODO:STEVE: not found error
      throw handleException( e );
    }
    return request.reply( response );
  }

  public DescribeTasksResponse describeTasks( final DescribeTasksRequest request ) throws EcsException {
    final DescribeTasksResponse response = new DescribeTasksResponse( );
    final Context ctx = Contexts.lookup( );
    final AccountFullName accountFullName = ctx.getUserFullName( ).asAccountFullName( );
    final Predicate<? super Task> requestedAndAccessible = ContainerMetadatas.filteringFor( Task.class )
        .byId( Sets.newLinkedHashSet( Iterables.transform( request.getTasks( ), arnResourceName( ) ) ) )
        .byProperty( Optional.fromNullable( request.getCluster( ) ).transform( arnResourceName( ) ).asSet( ), TaskStringFunctions.CLUSTER )
        .byPrivileges()
        .buildPredicate();
    try {
      response.setResult( new DescribeTasksResult( ).withTasks( tasks.list(
          accountFullName,
          Restrictions.conjunction( ),
          Collections.<String, String>emptyMap( ),
          requestedAndAccessible,
          TypeMappers.lookup( Task.class, com.eucalyptus.container.common.model.Task.class ) ) ) );
      // TODO:STEVE: failures
    } catch ( Exception e ) {
      throw handleException( e );
    }
    return request.reply( response );
  }

  public DiscoverPollEndpointResponse discoverPollEndpoint( final DiscoverPollEndpointRequest request ) throws EcsException {
    final DiscoverPollEndpointResponse response = new DiscoverPollEndpointResponse( );
    final String endpoint =  "http://" + StringUtils.substringBefore( ServiceUris.remotePublicify( com.eucalyptus.container.common.Container.class ).getHost(), ":" );
    response.setResult( new DiscoverPollEndpointResult( ).withEndpoint( endpoint ) );
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
    final ListTaskDefinitionFamiliesResponse response = new ListTaskDefinitionFamiliesResponse( );
    final Context ctx = Contexts.lookup( );
    final AccountFullName accountFullName = ctx.getUserFullName( ).asAccountFullName( );
    final Predicate<? super TaskDefinition> requestedAndAccessible = ContainerMetadatas.filteringFor( TaskDefinition.class )
        .byPredicate( request.getFamilyPrefix( ) == null ?
            Predicates.<TaskDefinition>alwaysTrue( ) :
            Predicates.compose( Strings.startsWith( request.getFamilyPrefix( ) ), FAMILY ) )
        .byPrivileges()
        .buildPredicate();
    try {
      response.setResult( new ListTaskDefinitionFamiliesResult( ).withFamilies( Sets.newTreeSet( taskDefinitions.list(
          accountFullName,
          Restrictions.conjunction(),
          Collections.<String, String>emptyMap(),
          requestedAndAccessible,
          FAMILY ) ) ) );
    } catch ( Exception e ) {
      throw handleException( e );
    }
    return request.reply( response );
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
    final ListTasksResponse response = new ListTasksResponse( );
    final Context ctx = Contexts.lookup( );
    final AccountFullName accountFullName = ctx.getUserFullName( ).asAccountFullName( );
    final Predicate<? super Task> requestedAndAccessible = ContainerMetadatas.filteringFor( Task.class )
        .byProperty( Optional.fromNullable( request.getCluster() ).transform( arnResourceName() ).asSet(), TaskStringFunctions.CLUSTER )
        .byProperty( Optional.fromNullable( request.getContainerInstance() ).transform( arnResourceName( ) ).asSet(), TaskStringFunctions.CONTAINER_INSTANCE )
        .byProperty( Optional.fromNullable( request.getFamily() ).asSet(), TaskStringFunctions.FAMILY )
        .byProperty( Optional.fromNullable( request.getStartedBy() ).asSet(), TaskStringFunctions.STARTED_BY )
        .byPrivileges()
        .buildPredicate();
    try {
      response.setResult( new ListTasksResult( ).withTaskArns( tasks.list(
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

  public RegisterContainerInstanceResponse registerContainerInstance( final RegisterContainerInstanceRequest request ) throws EcsException {
    final RegisterContainerInstanceResponse response = new RegisterContainerInstanceResponse( );
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
                clusters.lookupByName( userFullName.asAccountFullName( ), arnResourceName( ).apply( request.getCluster() ), Predicates.alwaysTrue(), Functions.<Cluster>identity( ) );
          } catch ( EcsMetadataNotFoundException e ) {
            if ( "default".equals( request.getCluster( ) ) ) {
              cluster = clusters.save( Cluster.create( userFullName, "default" ) );
            } else {
              throw Exceptions.toUndeclared( new EcsClientException( "ValidationError", "Cluster not found '"+request.getCluster()+"'" ) );
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
              taskDefinitions.getNextRevision( userFullName.asAccountFullName( ), request.getFamily( ) ) );
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
    final RunTaskResponse response = new RunTaskResponse( );
    final RunTaskResult result = new RunTaskResult( );
    final Context ctx = Contexts.lookup( );
    final UserFullName userFullName = ctx.getUserFullName( );
    final AccountFullName accountFullName = userFullName.asAccountFullName( );
    allocate( new Supplier<Task>( ) {
      @Override
      public Task get( ) {
        try {
          final Cluster cluster = clusters.lookupByName(
              accountFullName,
              Optional.fromNullable( request.getCluster( ) ).transform( arnResourceName( ) ).or( "default" ),
              RestrictedTypes.filterPrivileged( ),
              Functions.<Cluster>identity( ) );

          final TaskDefinition taskDefinition = taskDefinitions.lookupByName(
              accountFullName,
              arnResourceName( ).apply( request.getTaskDefinition() ),
              RestrictedTypes.filterPrivileged( ),
              Functions.<TaskDefinition>identity( ) );

          final List<ContainerInstance> containerInstanceList = containerInstances.list(
              accountFullName,
              Restrictions.and(
                  Restrictions.eq( "clusterName", cluster.getDisplayName( ) ),
                  Restrictions.eq( "agentConnected", true )
              ),
              Collections.<String,String>emptyMap( ),
              RestrictedTypes.filterPrivileged( ),
              Functions.<ContainerInstance>identity( ) );

          //TODO:STEVE: overrides
          Task task = null;
          if ( !containerInstanceList.isEmpty( ) ) {
            final int index = Math.abs( random.nextInt( ) % containerInstanceList.size( ) );
            //TODO:STEVE: verify resources
            final ContainerInstance instance = containerInstanceList.get( index );
            final List<Container> containers = Lists.newArrayList( );
            for ( final ContainerDefinition containerDefinition : taskDefinition.getContainerDefinitions( ) ) {
              containers.add( Container.create( userFullName, containerDefinition ) );
            }
            task = tasks.save( Task.create( userFullName, cluster, instance, taskDefinition, containers, request.getStartedBy( ) ) );
            result.getTasks( ).add( TypeMappers.transform( task, com.eucalyptus.container.common.model.Task.class ) );
            AgentRendezvous.dispatchTask( instance, taskDefinition, task );
          } else {
            result.getFailures( ).add( new Failure( )
                .withArn( taskDefinition.getArn() )
                .withReason( "Container instance not available" ) );
          }
          return task;
        } catch ( Exception ex ) {
          logger.error( ex, ex );
          throw new RuntimeException( ex );
        }
      }
    }, Task.class, request.getTaskDefinition( ), Objects.firstNonNull( request.getCount( ), 1 ) );
    response.setResult( result );
    return request.reply( response );
  }

  public StartTaskResponse startTask( final StartTaskRequest request ) throws EcsException {
    final StartTaskResponse response = new StartTaskResponse( );
    final StartTaskResult result = new StartTaskResult( );
    final Context ctx = Contexts.lookup( );
    final UserFullName userFullName = ctx.getUserFullName( );
    final AccountFullName accountFullName = userFullName.asAccountFullName( );
    final List<String> taskContainerInstances = Lists.newArrayList( request.getContainerInstances( ) );
    allocate( new Supplier<Task>( ) {
      @Override
      public Task get( ) {
        try {
          final Cluster cluster = clusters.lookupByName(
              accountFullName,
              Optional.fromNullable( request.getCluster( ) ).transform( arnResourceName( ) ).or( "default" ),
              RestrictedTypes.filterPrivileged( ),
              Functions.<Cluster>identity( ) );

          final TaskDefinition taskDefinition = taskDefinitions.lookupByName(
              accountFullName,
              arnResourceName( ).apply( request.getTaskDefinition() ),
              RestrictedTypes.filterPrivileged( ),
              Functions.<TaskDefinition>identity( ) );

          final ContainerInstance instance = containerInstances.lookupByName(
              accountFullName,
              arnResourceName( ).apply( taskContainerInstances.remove( 0 ) ),
              RestrictedTypes.filterPrivileged( ),
              Functions.<ContainerInstance>identity( ) );

          //TODO:STEVE: overrides
          //TODO:STEVE: verify resources
          Task task = null;
          if ( instance.getAgentConnected( ) ) {
            final List<Container> containers = Lists.newArrayList();
            for ( final ContainerDefinition containerDefinition : taskDefinition.getContainerDefinitions() ) {
              containers.add( Container.create( userFullName, containerDefinition ) );
            }
            task = tasks.save( Task.create( userFullName, cluster, instance, taskDefinition, containers, request.getStartedBy() ) );
            result.getTasks().add( TypeMappers.transform( task, com.eucalyptus.container.common.model.Task.class ) );
            AgentRendezvous.dispatchTask( instance, taskDefinition, task );
          } else {
            result.getFailures( ).add( new Failure( )
                .withArn( taskDefinition.getArn() )
                .withReason( "Container instance not available" ) );
          }

          return task;
        } catch ( Exception ex ) {
          logger.error( ex, ex );
          throw new RuntimeException( ex );
        }
      }
    }, Task.class, request.getTaskDefinition( ), request.getContainerInstances( ).size( ) );
    response.setResult( result );
    return request.reply( response );
  }

  public StopTaskResponse stopTask( final StopTaskRequest request ) throws EcsException {
    final StopTaskResponse response = new StopTaskResponse( );
    final Context ctx = Contexts.lookup();
    final AccountFullName accountFullName = ctx.getUserFullName( ).asAccountFullName( );
    final String task = arnResourceName( ).apply( request.getTask( ) );
    final String cluster = arnResourceName( ).apply( Objects.firstNonNull( request.getCluster( ), "default" ) );
    try {
      response.setResult( new StopTaskResult( )
          .withTask( tasks.updateByExample(
              Task.exampleWithNameAndCluster( accountFullName, task, cluster ),
              accountFullName,
              task,
              new Function<Task, com.eucalyptus.container.common.model.Task>( ){
                @Nullable
                @Override
                public com.eucalyptus.container.common.model.Task apply( final Task task ) {
                  task.setDesiredStatus( "STOPPED" );

                  try {
                    final TaskDefinition taskDefinition = taskDefinitions.lookupByName(
                        accountFullName,
                        arnResourceName().apply( task.getTaskDefinitionArn() ),
                        Predicates.alwaysTrue( ),
                        Functions.<TaskDefinition>identity() );

                    final ContainerInstance instance = containerInstances.lookupByName(
                        accountFullName,
                        arnResourceName().apply( task.getContainerInstanceArn() ),
                        Predicates.alwaysTrue(),
                        Functions.<ContainerInstance>identity() );

                    AgentRendezvous.dispatchTask( instance, taskDefinition, task );
                  } catch ( Exception e ) {
                    logger.error( "Error dispatching stop task", e );
                  }

                  return TypeMappers.transform( task, com.eucalyptus.container.common.model.Task.class );
                }
              } ) ) );
    } catch ( EcsMetadataNotFoundException e ) {
      throw new EcsClientException( "UnknownResourceFault", "Task not found: " + request.getTask() );
    } catch ( Exception e ) {
      throw handleException( e );
    }
    return request.reply( response );
  }

  public SubmitContainerStateChangeResponse submitContainerStateChange( final SubmitContainerStateChangeRequest request ) throws EcsException {
    final SubmitContainerStateChangeResponse response = new SubmitContainerStateChangeResponse( );
    final Context ctx = Contexts.lookup( );
    final AccountFullName accountFullName = ctx.getUserFullName( ).asAccountFullName( );
    try {
      final String taskUuid = arnResourceName( ).apply( request.getTask( ) );
      tasks.updateByExample(
          Task.exampleWithNameAndCluster( accountFullName, taskUuid, arnResourceName( ).apply( request.getCluster( ) ) ),
          accountFullName,
          taskUuid,
          new Function<Task, Void>( ){
            @Nullable
            @Override
            public Void apply( final Task task ) {
              task.updateTimeStamps( );
              final Optional<Container> container = Iterables.tryFind(
                  task.getContainers( ),
                  CollectionUtils.propertyPredicate( request.getContainerName( ), RestrictedTypes.toDisplayName( ) ) );
              if ( container.isPresent( ) ) {
                container.get( ).setLastStatus( request.getStatus( ) );
                container.get( ).setReason( request.getReason( ) );
                container.get( ).setExitCode( request.getExitCode( ) );
                container.get( ).setNetworkBindings( Lists.transform(
                    request.getNetworkBindings( ),
                    TypeMappers.lookup( com.eucalyptus.container.common.model.NetworkBinding.class, NetworkBinding.class ) ) );
              }
              return null;
            }
          } );
      response.setResult( new SubmitContainerStateChangeResult( ).withAcknowledgment( "" ) );
    } catch ( EcsMetadataNotFoundException e ) {
      throw new EcsClientException( "UnknownResourceFault", "Task not found: " + request.getTask() );
    } catch ( Exception e ) {
      throw handleException( e );
    }    return request.reply( response );
  }

  public SubmitTaskStateChangeResponse submitTaskStateChange ( final SubmitTaskStateChangeRequest request ) throws EcsException {
    final SubmitTaskStateChangeResponse response = new SubmitTaskStateChangeResponse( );
    final Context ctx = Contexts.lookup( );
    final AccountFullName accountFullName = ctx.getUserFullName( ).asAccountFullName( );
    try {
      final String taskUuid = arnResourceName( ).apply( request.getTask( ) );
      tasks.updateByExample(
          Task.exampleWithNameAndCluster( accountFullName, taskUuid, arnResourceName( ).apply( request.getCluster() ) ),
          accountFullName,
          taskUuid,
          new Function<Task, Void>( ){
            @Nullable
            @Override
            public Void apply( final Task task ) {
              task.setLastStatus( request.getStatus( ) ); //TODO:STEVE: should be recording the reason?
              return null;
            }
          } );
      response.setResult( new SubmitTaskStateChangeResult().withAcknowledgment( "" ) );
    } catch ( EcsMetadataNotFoundException e ) {
      throw new EcsClientException( "UnknownResourceFault", "Task not found: " + request.getTask() );
    } catch ( Exception e ) {
      throw handleException( e );
    }
    return request.reply( response );
  }

  public static NonNullFunction<String,String> arnResourceName( ) {
    return new NonNullFunction<String,String>( ){
      @Nonnull
      @Override
      public String apply( final String perhapsArn ) {
        try {
          return perhapsArn.startsWith( "arn:" ) ?
              Ern.parse( perhapsArn ).getResourceName( ) :
              perhapsArn;
        } catch ( JSONException e ) {
          return perhapsArn;
        }
      }
    };
  }

  private <T extends AbstractPersistent & RestrictedType> T allocate(
      final Supplier<T> allocator,
      final Class<T> type,
      final String name
  ) throws EcsException {
    return allocate( allocator, type, name, 1 ).get( 0 );
  }

  private <T extends AbstractPersistent & RestrictedType> List<T> allocate(
      final Supplier<T> allocator,
      final Class<T> type,
      final String name,
      final int count
  ) throws EcsException {
    try {
      return RestrictedTypes.allocateUnitlessResources( type, count, transactional( allocator ) );
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
