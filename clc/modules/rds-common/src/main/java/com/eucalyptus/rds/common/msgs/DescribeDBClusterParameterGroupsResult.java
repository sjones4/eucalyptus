/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;


public class DescribeDBClusterParameterGroupsResult extends EucalyptusData {

  private DBClusterParameterGroupList dBClusterParameterGroups;

  private String marker;

  public DBClusterParameterGroupList getDBClusterParameterGroups() {
    return dBClusterParameterGroups;
  }

  public void setDBClusterParameterGroups(final DBClusterParameterGroupList dBClusterParameterGroups) {
    this.dBClusterParameterGroups = dBClusterParameterGroups;
  }

  public String getMarker() {
    return marker;
  }

  public void setMarker(final String marker) {
    this.marker = marker;
  }

}
