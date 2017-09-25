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
package com.eucalyptus.storage.msgs.s3;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;

public class LifecycleRule extends EucalyptusData {

  private String id;
  private String prefix;
  private String status;
  private Expiration expiration;
  private Transition transition;

  public String getId( ) {
    return id;
  }

  public void setId( String id ) {
    this.id = id;
  }

  public String getPrefix( ) {
    return prefix;
  }

  public void setPrefix( String prefix ) {
    this.prefix = prefix;
  }

  public String getStatus( ) {
    return status;
  }

  public void setStatus( String status ) {
    this.status = status;
  }

  public Expiration getExpiration( ) {
    return expiration;
  }

  public void setExpiration( Expiration expiration ) {
    this.expiration = expiration;
  }

  public Transition getTransition( ) {
    return transition;
  }

  public void setTransition( Transition transition ) {
    this.transition = transition;
  }
}
