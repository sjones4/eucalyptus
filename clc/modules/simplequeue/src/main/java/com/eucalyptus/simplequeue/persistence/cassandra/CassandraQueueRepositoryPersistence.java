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
package com.eucalyptus.simplequeue.persistence.cassandra;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.data.cassandra.core.CassandraBatchOperations;
import org.springframework.data.cassandra.repository.MapId;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.eucalyptus.cassandra.common.CassandraPersistence;
import com.eucalyptus.simplequeue.config.SimpleQueueProperties;
import com.eucalyptus.simplequeue.exceptions.QueueAlreadyExistsException;
import com.eucalyptus.simplequeue.exceptions.QueueDoesNotExistException;
import com.eucalyptus.simplequeue.persistence.Queue;
import com.eucalyptus.simplequeue.persistence.Queue.Key;
import com.eucalyptus.simplequeue.persistence.QueuePersistence;
import com.eucalyptus.util.ThrowingFunction;
import com.google.common.base.MoreObjects;

/**
 * Cassandra queue persistence using spring data repository api
 */
public class CassandraQueueRepositoryPersistence implements QueuePersistence {

  private static final int NUM_PARTITIONS = 25;

  private static final Collection<String> partitionTokens =
      IntStream.range(0, NUM_PARTITIONS).boxed().map(String::valueOf).collect(Collectors.toSet());

  @Override
  public long countQueues( final String accountNumber ) {
    return doWithRepository( repository -> repository.countByAccountId( accountNumber ) );
  }

  @Override
  public Queue lookupQueue( final String accountId, final String queueName ) {
    return doWithRepository( repository -> {
      final Queue queue = repository.findOne( key( repository, accountId, queueName ) );
      if ( queue != null ) {
        repository.template( ).update( QueueByPartition.forQueue( queue ).touch( ) );
      }
      return queue;
    } );
  }

  @Override
  public Queue createQueue(
      final String accountId,
      final String queueName,
      final Map<String, String> attributes
  ) throws QueueAlreadyExistsException {
    throw new QueueAlreadyExistsException( "Queue already exists " + queueName ); //TODO:STEVE: implement
  }

  @Override
  public Collection<Key> listQueues( final String accountId, final String queueNamePrefix ) {
    return doWithRepository( repository ->
        //TODO:STEVE: admin listing support
        ( queueNamePrefix == null ?
          repository.findByAccountId( accountId ) :
          repository.findByAccountIdAndQueueName( accountId, queueNamePrefix ) )
        .stream( )
        .map( nameProjection -> new Queue.Key( accountId, nameProjection.getQueueName( ) ) )
        .collect( Collectors.toList( ) ) );
  }

  @Override
  public Collection<Key> listDeadLetterSourceQueues( final String accountId, final String deadLetterTargetArn ) {
    return Collections.emptyList( ); //TODO:STEVE: implement
  }

  @Override
  public Queue updateQueueAttributes(
      final String accountId,
      final String queueName,
      final Map<String, String> attributes
  ) throws QueueDoesNotExistException {
    return lookupQueue( accountId, queueName );  //TODO:STEVE: implement
  }

  @Override
  public void deleteQueue( final String accountId, final String queueName ) throws QueueDoesNotExistException {
    doThrowsWithRepository( repository -> {
      final Queue queue = repository.findOne( key( repository, accountId, queueName ) );
      if ( queue == null ) {
        throw new QueueDoesNotExistException( "The specified queue does not exist." );
      }
      repository.template( ).batchOps( )
          .delete( queue )
          .delete( QueueByPartition.forQueue( queue ) )
          .delete( queue.getDeadLetterTargetArn( ) != null ?
              Collections.singleton( QueueBySourceQueue.named( queue.getDeadLetterTargetArn( ), accountId, queueName ) ) :
              Collections.emptyList( )
          )
          .execute( );
      return null;
    } );
  }

  @Override
  public Collection<Key> listActiveQueues( final String partitionToken ) {
    return doWithRepository( repository -> {
      final Date now = new Date( );
      final long activityTime = SimpleQueueProperties.ACTIVE_QUEUE_TIME_SECS * 1000L;
      return repository.template( ).select(
          QueryBuilder.select( )
              .from( repository.template( ).keyspace( ), "queues_by_partition" )
              .where( QueryBuilder.eq( "partition_token", partitionToken ) )
              .limit( Integer.MAX_VALUE )
          , QueueByPartition.class
      ).stream( )
      .filter( queueByPartition -> now.getTime( ) - queueByPartition.getLastLookup( ).getTime( ) < activityTime )
      .map( queueByPartition -> new Key( queueByPartition.getAccountId( ), queueByPartition.getQueueName( ) ) )
      .collect( Collectors.toList( ) );
    } );
  }

  @Override
  public Collection<String> getPartitionTokens() {
    return MoreObjects.firstNonNull( SimpleQueueProperties.ENABLE_METRICS_COLLECTION, false ) ?
      partitionTokens :
      Collections.emptyList( );
  }

  private MapId key( final QueueRepository repository, final String accountId, final String queueName ) {
    return repository.id( ).with( "accountId", accountId ).with( "queueName", queueName );
  }

  private static <R> R doWithRepository( final Function<QueueRepository,R> callback ) {
    return CassandraPersistence.doWithRepository( QueueRepository.class, callback );
  }

  private static <R, E extends Throwable> R doThrowsWithRepository(
      final ThrowingFunction<QueueRepository,R, E> callback
  ) throws E {
    return CassandraPersistence.doThrowsWithRepository( QueueRepository.class, callback );
  }
}
