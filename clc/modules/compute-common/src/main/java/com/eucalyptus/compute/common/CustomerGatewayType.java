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
package com.eucalyptus.compute.common;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;

public class CustomerGatewayType extends EucalyptusData {

  private String customerGatewayId;
  private String state;
  private String type;
  private String ipAddress;
  private Integer bgpAsn;
  private ResourceTagSetType tagSet;

  public String getCustomerGatewayId( ) {
    return customerGatewayId;
  }

  public void setCustomerGatewayId( String customerGatewayId ) {
    this.customerGatewayId = customerGatewayId;
  }

  public String getState( ) {
    return state;
  }

  public void setState( String state ) {
    this.state = state;
  }

  public String getType( ) {
    return type;
  }

  public void setType( String type ) {
    this.type = type;
  }

  public String getIpAddress( ) {
    return ipAddress;
  }

  public void setIpAddress( String ipAddress ) {
    this.ipAddress = ipAddress;
  }

  public Integer getBgpAsn( ) {
    return bgpAsn;
  }

  public void setBgpAsn( Integer bgpAsn ) {
    this.bgpAsn = bgpAsn;
  }

  public ResourceTagSetType getTagSet( ) {
    return tagSet;
  }

  public void setTagSet( ResourceTagSetType tagSet ) {
    this.tagSet = tagSet;
  }
}
