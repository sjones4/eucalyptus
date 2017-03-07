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

import java.util.Date;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;
import com.eucalyptus.simplequeue.persistence.Queue;

/**
 *
 */
@Table(value = "queues_by_partition")
public class QueueByPartition {

  @PrimaryKeyColumn(name = "partition_token", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
  private String partitionToken;

  @PrimaryKeyColumn(name = "account_id", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
  private String accountId;

  @PrimaryKeyColumn(name = "queue_name", ordinal = 2, type = PrimaryKeyType.CLUSTERED)
  private String queueName;

  @Column("last_lookup")
  private Date lastLookup;

  public static QueueByPartition forQueue( final Queue queue ) {
    return named( queue.getPartitionToken( ), queue.getAccountId( ), queue.getQueueName( ) );
  }

  public static QueueByPartition named( final String partitionToken, final String accountId, final String queueName ) {
    final QueueByPartition queueByPartition = new QueueByPartition( );
    queueByPartition.setPartitionToken( partitionToken );
    queueByPartition.setAccountId( accountId );
    queueByPartition.setQueueName( queueName );
    return queueByPartition;
  }

  public QueueByPartition( ) {
  }

  public String getAccountId( ) {
    return accountId;
  }

  public void setAccountId( final String accountId ) {
    this.accountId = accountId;
  }

  public Date getLastLookup( ) {
    return lastLookup;
  }

  public void setLastLookup( final Date lastLookup ) {
    this.lastLookup = lastLookup;
  }

  public String getPartitionToken( ) {
    return partitionToken;
  }

  public void setPartitionToken( final String partitionToken ) {
    this.partitionToken = partitionToken;
  }

  public String getQueueName( ) {
    return queueName;
  }

  public void setQueueName( final String queueName ) {
    this.queueName = queueName;
  }

  public QueueByPartition touch( ) {
    setLastLookup( new Date( ) );
    return this;
  }
}
