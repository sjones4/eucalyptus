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
import java.util.Map;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import com.eucalyptus.entities.AbstractPersistent;

/**
 *
 */
@Entity
@PersistenceContext( name = "eucalyptus_ecs" )
@Table( name = "ecs_container_definition" )
@Cache( usage = CacheConcurrencyStrategy.TRANSACTIONAL )
public class ContainerDefinition extends AbstractPersistent {
  private static final long serialVersionUID = 1L;

  @ManyToOne
  @JoinColumn( name = "task_definition_id", nullable = false, updatable = false )
  @Cache( usage = CacheConcurrencyStrategy.TRANSACTIONAL )
  private TaskDefinition taskDefinition;

  @ElementCollection
  @CollectionTable( name = "ecs_container_definition_command" )
  @Column( name = "command", length = 1024 )
  @JoinColumn( name = "task_definition_id" )
  @OrderColumn( name = "command_index")
  @Cache( usage = CacheConcurrencyStrategy.TRANSACTIONAL )
  private List<String> commands;

  @Column( name = "cpu" )
  private Integer cpu;

  @ElementCollection
  @CollectionTable( name = "ecs_container_definition_entry_point" )
  @Column( name = "entry_point", length = 1024 )
  @JoinColumn( name = "task_definition_id" )
  @OrderColumn( name = "entry_point_index")
  @Cache( usage = CacheConcurrencyStrategy.TRANSACTIONAL )
  private List<String> entryPoints;

  @ElementCollection
  @CollectionTable( name = "ecs_container_definition_environment" )
  @JoinColumn( name = "task_definition_id" )
  @MapKeyColumn( name = "environment_name" )
  @Column( name = "environment_value" )
  @Cache( usage = CacheConcurrencyStrategy.TRANSACTIONAL )
  Map<String, String> environment;

  @Column( name = "essential" )
  private Boolean essential;

  @Column( name = "image" )
  private String image;

  @ElementCollection
  @CollectionTable( name = "ecs_container_definition_link" )
  @Column( name = "link" )
  @JoinColumn( name = "task_definition_id" )
  @OrderColumn( name = "link_index")
  @Cache( usage = CacheConcurrencyStrategy.TRANSACTIONAL )
  private List<String> links;

  @Column( name = "memory" )
  private Integer memory;

  @Column( name = "name" )
  private String name;

  @ElementCollection
  @CollectionTable( name = "ecs_container_port_mapping" )
  @JoinColumn( name = "task_definition_id" )
  @OrderColumn( name = "port_mapping_index")
  @Cache( usage = CacheConcurrencyStrategy.TRANSACTIONAL )
  private List<PortMapping> portMappings;

  protected ContainerDefinition( ) {

  }

  public ContainerDefinition( final List<String> commands,
                              final Integer cpu,
                              final List<String> entryPoints,
                              final Map<String,String> environment,
                              final Boolean essential,
                              final String image,
                              final List<String> links,
                              final Integer memory,
                              final String name,
                              final List<PortMapping> portMappings ) {
    this.commands = commands;
    this.cpu = cpu;
    this.entryPoints = entryPoints;
    this.environment = environment;
    this.essential = essential;
    this.image = image;
    this.links = links;
    this.memory = memory;
    this.name = name;
    this.portMappings = portMappings;
  }

  public TaskDefinition getTaskDefinition( ) {
    return taskDefinition;
  }

  public void setTaskDefinition( final TaskDefinition taskDefinition ) {
    this.taskDefinition = taskDefinition;
  }

  public List<String> getCommands( ) {
    return commands;
  }

  public void setCommands( final List<String> commands ) {
    this.commands = commands;
  }

  public Integer getCpu( ) {
    return cpu;
  }

  public void setCpu( final Integer cpu ) {
    this.cpu = cpu;
  }

  public List<String> getEntryPoints( ) {
    return entryPoints;
  }

  public void setEntryPoints( final List<String> entryPoints ) {
    this.entryPoints = entryPoints;
  }

  public Map<String, String> getEnvironment() {
    return environment;
  }

  public void setEnvironment( final Map<String, String> environment ) {
    this.environment = environment;
  }

  public Boolean getEssential( ) {
    return essential;
  }

  public void setEssential( final Boolean essential ) {
    this.essential = essential;
  }

  public String getImage( ) {
    return image;
  }

  public void setImage( final String image ) {
    this.image = image;
  }

  public List<String> getLinks( ) {
    return links;
  }

  public void setLinks( final List<String> links ) {
    this.links = links;
  }

  public Integer getMemory( ) {
    return memory;
  }

  public void setMemory( final Integer memory ) {
    this.memory = memory;
  }

  public String getName( ) {
    return name;
  }

  public void setName( final String name ) {
    this.name = name;
  }

  public List<PortMapping> getPortMappings() {
    return portMappings;
  }

  public void setPortMappings( final List<PortMapping> portMappings ) {
    this.portMappings = portMappings;
  }
}
