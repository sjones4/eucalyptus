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

import static com.eucalyptus.container.common.ContainerMetadata.TaskDefinitionMetadata;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.PersistenceContext;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
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
@Table( name = "ecs_task_definition" )
@Cache( usage = CacheConcurrencyStrategy.TRANSACTIONAL )
public class TaskDefinition extends AbstractOwnedPersistent implements TaskDefinitionMetadata {
  private static final long serialVersionUID = 1L;

  @Column( name = "family", nullable = false, updatable = false )
  private String family;

  @Column( name = "revision", nullable = false, updatable = false )
  private Integer revision;

  @OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, orphanRemoval = true, mappedBy = "taskDefinition" )
  @OrderColumn( name = "container_index")
  private List<ContainerDefinition> containerDefinitions = Lists.newArrayList( );

  protected TaskDefinition( ) {
  }

  protected TaskDefinition( final OwnerFullName owner, final String displayName ) {
    super( owner, displayName );
  }

  public static TaskDefinition create( final OwnerFullName owner,
                                       final String family,
                                       final Integer revision ) {
    final TaskDefinition taskDefinition = new TaskDefinition( owner, name( family, revision ) );
    taskDefinition.setFamily( family );
    taskDefinition.setRevision( revision );
    return taskDefinition;
  }

  public static TaskDefinition exampleWithOwner( final OwnerFullName owner ) {
    return new TaskDefinition( owner, null );
  }

  public static TaskDefinition exampleWithName( final OwnerFullName owner, final String name ) {
    return new TaskDefinition( owner, name );
  }

  @Override
  public String getArn( ) {
    return String.format(
        "arn:aws:ecs::%1s:task-definition/%2s",
        getOwnerAccountNumber(),
        getDisplayName() );
  }

  public String getFamily( ) {
    return family;
  }

  public void setFamily( final String family ) {
    this.family = family;
  }

  public Integer getRevision( ) {
    return revision;
  }

  public void setRevision( final Integer revision ) {
    this.revision = revision;
  }

  public List<ContainerDefinition> getContainerDefinitions( ) {
    return containerDefinitions;
  }

  public void setContainerDefinitions( final List<ContainerDefinition> containerDefinitions ) {
    this.containerDefinitions = containerDefinitions;
  }

  @Override
  protected String createUniqueName() {
    return getOwnerAccountNumber( ) + ":" + getDisplayName() + ":" + getRevision( );
  }

  @PrePersist
  @PreUpdate
  private void setContainerDefinitionParent( ) {
    for ( final ContainerDefinition containerDefinition : containerDefinitions ) {
      containerDefinition.setTaskDefinition( this );
    }
  }

  private static String name( final String family, final Integer revision ) {
    return String.format( "%1s:%1s", family, revision );
  }
}