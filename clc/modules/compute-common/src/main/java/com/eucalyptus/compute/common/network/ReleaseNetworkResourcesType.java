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
package com.eucalyptus.compute.common.network;

import java.util.ArrayList;
import com.google.common.collect.Lists;

public class ReleaseNetworkResourcesType extends NetworkingMessage {

  private String vpc;
  private ArrayList<NetworkResource> resources = Lists.newArrayList( );

  public ReleaseNetworkResourcesType( ) {
  }

  public ReleaseNetworkResourcesType( final String vpc, final ArrayList<NetworkResource> resources ) {
    this.vpc = vpc;
    this.resources = resources;
  }

  public String getVpc( ) {
    return vpc;
  }

  public void setVpc( String vpc ) {
    this.vpc = vpc;
  }

  public ArrayList<NetworkResource> getResources( ) {
    return resources;
  }

  public void setResources( ArrayList<NetworkResource> resources ) {
    this.resources = resources;
  }
}
