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

import static com.eucalyptus.container.common.EcsMetadata.TaskMetadata;
import java.util.List;
import java.util.UUID;
import javax.annotation.Nullable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import com.eucalyptus.entities.AbstractOwnedPersistent;
import com.eucalyptus.util.OwnerFullName;
import com.google.common.collect.Lists;

/**
 *
 */
@Entity
@PersistenceContext( name = "eucalyptus_ecs" )
@Table( name = "ecs_task" )
@Cache( usage = CacheConcurrencyStrategy.TRANSACTIONAL )
public class Task extends AbstractOwnedPersistent implements TaskMetadata {
  private static final long serialVersionUID = 1L;

  //TODO:STEVE: references (cluster, container instance, task definition, containers?)

  @Column( name = "cluster_arn", nullable = false, updatable = false )
  private String clusterArn;

  @Column( name = "cluster_name", nullable = false, updatable = false )
  private String clusterName;

  @Column( name = "container_instance_arn", nullable = false, updatable = false )
  private String containerInstanceArn;

  @Column( name = "container_instance_name", nullable = false, updatable = false )
  private String containerInstanceName;

  @Column( name = "family", nullable = false, updatable = false )
  private String family;

  @Column( name = "started_by", nullable = true, updatable = false )
  private String startedBy;

  @OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, orphanRemoval = true, mappedBy = "task" )
  @OrderColumn( name = "container_index")
  private List<Container> containers = Lists.newArrayList();

  @Column( name = "desired_status", nullable = false )
  private String desiredStatus;

  @Column( name = "last_status" )
  private String lastStatus;

  //TODO:STEVE: task overrides

  @Column( name = "task_definition_arn" )
  private String taskDefinitionArn;

  protected Task( ) {
  }

  protected Task( final OwnerFullName owner, final String displayName ) {
    super( owner, displayName );
  }

  public static Task create( final OwnerFullName owner,
                             final Cluster cluster,
                             final ContainerInstance containerInstance,
                             final TaskDefinition taskDefinition,
                             final Iterable<Container> containers,
                             @Nullable final String startedBy ) {
    final String name = UUID.randomUUID( ).toString( );
    final Task task = new Task( owner, name );
    task.setNaturalId( name );
    task.setClusterArn( cluster.getArn() );
    task.setClusterName( cluster.getDisplayName() );
    task.setContainerInstanceArn( containerInstance.getArn() );
    task.setContainerInstanceName( containerInstance.getDisplayName() );
    task.setFamily( taskDefinition.getFamily() );
    task.setStartedBy( startedBy);
    task.setDesiredStatus( "RUNNING" );
    task.setLastStatus( "PENDING" );
    task.setTaskDefinitionArn( taskDefinition.getArn( ) );
    for ( final Container container : containers ) {
      container.setTask( task );
      container.setTaskArn( task.getArn( ) );
      task.getContainers( ).add( container );
    }
    return task;
  }

  public static Task exampleWithOwner( final OwnerFullName owner ) {
    return new Task( owner, null );
  }

  public static Task exampleWithName( final OwnerFullName owner, final String name ) {
    return new Task( owner, name );
  }

  public static Task exampleWithNameAndCluster( final OwnerFullName owner, final String name, final String clusterName ) {
    final Task task = exampleWithName( owner, name );
    task.setClusterName( clusterName );
    return task;
  }

  @Override
  public String getArn( ) {
    return String.format(
        "arn:aws:ecs::%1s:task/%2s",
        getOwnerAccountNumber(),
        getNaturalId() );
  }

  public String getClusterArn() {
    return clusterArn;
  }

  public void setClusterArn( final String clusterArn ) {
    this.clusterArn = clusterArn;
  }

  public String getClusterName() {
    return clusterName;
  }

  public void setClusterName( final String clusterName ) {
    this.clusterName = clusterName;
  }

  public String getContainerInstanceArn() {
    return containerInstanceArn;
  }

  public void setContainerInstanceArn( final String containerInstanceArn ) {
    this.containerInstanceArn = containerInstanceArn;
  }

  public String getContainerInstanceName() {
    return containerInstanceName;
  }

  public void setContainerInstanceName( final String containerInstanceName ) {
    this.containerInstanceName = containerInstanceName;
  }

  public String getFamily() {
    return family;
  }

  public void setFamily( final String family ) {
    this.family = family;
  }

  public String getStartedBy() {
    return startedBy;
  }

  public void setStartedBy( final String startedBy ) {
    this.startedBy = startedBy;
  }

  public List<Container> getContainers() {
    return containers;
  }

  public void setContainers( final List<Container> containers ) {
    this.containers = containers;
  }

  public String getDesiredStatus() {
    return desiredStatus;
  }

  public void setDesiredStatus( final String desiredStatus ) {
    this.desiredStatus = desiredStatus;
  }

  public String getLastStatus() {
    return lastStatus;
  }

  public void setLastStatus( final String lastStatus ) {
    this.lastStatus = lastStatus;
  }

  public String getTaskDefinitionArn() {
    return taskDefinitionArn;
  }

  public void setTaskDefinitionArn( final String taskDefinitionArn ) {
    this.taskDefinitionArn = taskDefinitionArn;
  }
}
