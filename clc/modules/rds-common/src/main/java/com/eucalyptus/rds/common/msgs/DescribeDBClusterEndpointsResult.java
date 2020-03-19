/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;


public class DescribeDBClusterEndpointsResult extends EucalyptusData {

  private DBClusterEndpointList dBClusterEndpoints;

  private String marker;

  public DBClusterEndpointList getDBClusterEndpoints() {
    return dBClusterEndpoints;
  }

  public void setDBClusterEndpoints(final DBClusterEndpointList dBClusterEndpoints) {
    this.dBClusterEndpoints = dBClusterEndpoints;
  }

  public String getMarker() {
    return marker;
  }

  public void setMarker(final String marker) {
    this.marker = marker;
  }

}
