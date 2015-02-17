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
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table( name = "ecs_container_resource" )
@Cache( usage = CacheConcurrencyStrategy.TRANSACTIONAL )
public class ContainerResource extends AbstractPersistent {
  private static final long serialVersionUID = 1L;

  public enum Type {
    INTEGER, DOUBLE, LONG, STRINGSET;
  }

  @ManyToOne
  @JoinColumn( name = "container_instance_id", nullable = false, updatable = false )
  @Cache( usage = CacheConcurrencyStrategy.TRANSACTIONAL )
  private ContainerInstance containerInstance;

  @Column( name = "resource_name", nullable = false, updatable = false )
  private String name;

  @Column( name = "resource_double_value", updatable = false )
  private Double doubleValue;

  @Column( name = "resource_integer_value", updatable = false )
  private Integer integerValue;

  @Column( name = "resource_long_value", updatable = false )
  private Long longValue;

  @ElementCollection
  @CollectionTable( name = "ecs_container_resource_string_value" )
  @Column( name = "resource_string_value" )
  @JoinColumn( name = "resource_id" )
  @OrderColumn( name = "resource__index")
  @Cache( usage = CacheConcurrencyStrategy.TRANSACTIONAL )
  private List<String> stringSetValue;

  @Column( name = "resource_type", nullable = false, updatable = false )
  @Enumerated( EnumType.STRING )
  private Type type;

  private Boolean registered;


  public String getName( ) {
    return name;
  }

  public void setName( final String name ) {
    this.name = name;
  }

  public Double getDoubleValue( ) {
    return doubleValue;
  }

  public void setDoubleValue( final Double doubleValue ) {
    this.doubleValue = doubleValue;
  }

  public Integer getIntegerValue( ) {
    return integerValue;
  }

  public void setIntegerValue( final Integer integerValue ) {
    this.integerValue = integerValue;
  }

  public Long getLongValue()  {
    return longValue;
  }

  public void setLongValue( final Long longValue ) {
    this.longValue = longValue;
  }

  public List<String> getStringSetValue( ) {
    return stringSetValue;
  }

  public void setStringSetValue( final List<String> stringSetValue ) {
    this.stringSetValue = stringSetValue;
  }

  public Type getType() {
    return type;
  }

  public void setType( final Type type ) {
    this.type = type;
  }

  public ContainerInstance getContainerInstance( ) {
    return containerInstance;
  }

  public void setContainerInstance( final ContainerInstance containerInstance ) {
    this.containerInstance = containerInstance;
  }

  public Boolean getRegistered( ) {
    return registered;
  }

  public void setRegistered( final Boolean registered ) {
    this.registered = registered;
  }
}
