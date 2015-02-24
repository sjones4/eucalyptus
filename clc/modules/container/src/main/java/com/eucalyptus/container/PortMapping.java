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

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;


/**
 *
 */
@Embeddable
public class PortMapping implements Serializable {
  private static final long serialVersionUID = 1L;

  @Column( name = "container_port", nullable = false )
  private Integer containerPort;

  @Column( name = "host_port", nullable = false )
  private Integer hostPort;


  public PortMapping( ) {
  }

  public PortMapping( final Integer containerPort, final Integer hostPort ) {
    this.containerPort = containerPort;
    this.hostPort = hostPort;
  }

  public Integer getContainerPort( ) {
    return containerPort;
  }

  public void setContainerPort( final Integer containerPort ) {
    this.containerPort = containerPort;
  }

  public Integer getHostPort( ) {
    return hostPort;
  }

  public void setHostPort( final Integer hostPort ) {
    this.hostPort = hostPort;
  }
}
