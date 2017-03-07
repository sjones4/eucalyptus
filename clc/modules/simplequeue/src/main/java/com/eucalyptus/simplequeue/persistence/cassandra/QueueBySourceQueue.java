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

/**
 *
 */
@Table(value = "queues_by_source_queue")
public class QueueBySourceQueue {

  @PrimaryKeyColumn(name = "source_queue_arn", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
  private String sourceQueueArn;

  @PrimaryKeyColumn(name = "account_id", ordinal = 1, type = PrimaryKeyType.CLUSTERED)
  private String accountId;

  @PrimaryKeyColumn(name = "queue_name", ordinal = 2, type = PrimaryKeyType.CLUSTERED)
  private String queueName;

  @Column("last_lookup")
  private Date lastLookup;

  public static QueueBySourceQueue named( final String sourceQueueArn, final String accountId, final String queueName ) {
    final QueueBySourceQueue queueBySourceQueue = new QueueBySourceQueue( );
    queueBySourceQueue.setSourceQueueArn( sourceQueueArn );
    queueBySourceQueue.setAccountId( accountId );
    queueBySourceQueue.setQueueName( queueName );
    return queueBySourceQueue;
  }

  public QueueBySourceQueue( ) {
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

  public String getQueueName( ) {
    return queueName;
  }

  public void setQueueName( final String queueName ) {
    this.queueName = queueName;
  }

  public String getSourceQueueArn( ) {
    return sourceQueueArn;
  }

  public void setSourceQueueArn( final String sourceQueueArn ) {
    this.sourceQueueArn = sourceQueueArn;
  }
}
