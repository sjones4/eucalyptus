/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudformation.resources.standard.info;

import com.eucalyptus.cloudformation.resources.ResourceInfo;
import com.eucalyptus.cloudformation.resources.annotations.AttributeJson;
import com.google.common.base.MoreObjects;

/**
 *
 */
public class AWSRDSDBInstanceResourceInfo  extends ResourceInfo {

  @AttributeJson(name="Endpoint.Address")
  private String endpointAddress;

  @AttributeJson(name="Endpoint.Port")
  private String endpointPort;

  public AWSRDSDBInstanceResourceInfo( ) {
    setType( "AWS::RDS::DBInstance" );
  }

  @Override
  public boolean supportsTags( ) {
    return true;
  }

  public String getEndpointAddress() {
    return endpointAddress;
  }

  public void setEndpointAddress(final String endpointAddress) {
    this.endpointAddress = endpointAddress;
  }

  public String getEndpointPort() {
    return endpointPort;
  }

  public void setEndpointPort(final String endpointPort) {
    this.endpointPort = endpointPort;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("endpointAddress", endpointAddress)
        .add("endpointPort", endpointPort)
        .toString();
  }
}

