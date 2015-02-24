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

import java.util.List;
import java.util.UUID;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OrderColumn;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import com.eucalyptus.container.common.EcsMetadata;
import com.eucalyptus.entities.AbstractOwnedPersistent;
import com.eucalyptus.util.OwnerFullName;

/**
 *
 */
@Entity
@PersistenceContext( name = "eucalyptus_ecs" )
@Table( name = "ecs_container" )
@Cache( usage = CacheConcurrencyStrategy.TRANSACTIONAL )
public class Container extends AbstractOwnedPersistent implements EcsMetadata.ContainerMetadata {
  private static final long serialVersionUID = 1L;

  @Column( name = "name", nullable = false, updatable = false )
  private String name;

  @Column( name = "task_arn", nullable = false, updatable = false )
  private String taskArn;

  @ManyToOne
  @JoinColumn( name = "task_id", nullable = false, updatable = false )
  @Cache( usage = CacheConcurrencyStrategy.TRANSACTIONAL )
  private Task task;

  @Column( name = "last_status", nullable = false )
  private String lastStatus;

  @Column( name = "exit_code" )
  private Integer exitCode;

  @Column( name = "reason" )
  private String reason;

  @ElementCollection
  @CollectionTable( name = "ecs_container_network_binding" )
  @JoinColumn( name = "container_id" )
  @OrderColumn( name = "network_binding_index")
  @Cache( usage = CacheConcurrencyStrategy.TRANSACTIONAL )
  private List<NetworkBinding> networkBindings;

  protected Container( final OwnerFullName owner, final String displayName ) {
    super( owner, displayName );
  }

  protected Container( ) {
    super( );
  }

  public static Container create( final OwnerFullName owner, final ContainerDefinition containerDefinition ) {
    final String name = UUID.randomUUID( ).toString( );
    final Container container = new Container( owner, name );
    container.setName( containerDefinition.getName( ) );
    container.setLastStatus( "PENDING" );
    container.updateTimeStamps( ); // initialize natural identifier
    return container;
  }

  @Override
  public String getArn( ) {
    return String.format(
        "arn:aws:ecs::%1s:container/%2s",
        getOwnerAccountNumber( ),
        getNaturalId( ) );
  }

  public String getName() {
    return name;
  }

  public void setName( final String name ) {
    this.name = name;
  }

  public String getTaskArn() {
    return taskArn;
  }

  public void setTaskArn( final String taskArn ) {
    this.taskArn = taskArn;
  }

  public Task getTask() {
    return task;
  }

  public void setTask( final Task task ) {
    this.task = task;
  }

  public String getLastStatus() {
    return lastStatus;
  }

  public void setLastStatus( final String lastStatus ) {
    this.lastStatus = lastStatus;
  }

  public String getReason() {
    return reason;
  }

  public void setReason( final String reason ) {
    this.reason = reason;
  }

  public Integer getExitCode() {
    return exitCode;
  }

  public void setExitCode( final Integer exitCode ) {
    this.exitCode = exitCode;
  }

  public List<NetworkBinding> getNetworkBindings() {
    return networkBindings;
  }

  public void setNetworkBindings( final List<NetworkBinding> networkBindings ) {
    this.networkBindings = networkBindings;
  }
}
