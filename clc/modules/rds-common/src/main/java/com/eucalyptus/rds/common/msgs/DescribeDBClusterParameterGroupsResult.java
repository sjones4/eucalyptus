/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRange;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRegex;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRegexValue;


public class DescribeDBClusterParameterGroupsResult extends EucalyptusData {

  private DBClusterParameterGroupList dBClusterParameterGroups;
  private String marker;

  public DBClusterParameterGroupList getDBClusterParameterGroups( ) {
    return dBClusterParameterGroups;
  }

  public void setDBClusterParameterGroups( final DBClusterParameterGroupList dBClusterParameterGroups ) {
    this.dBClusterParameterGroups = dBClusterParameterGroups;
  }

  public String getMarker( ) {
    return marker;
  }

  public void setMarker( final String marker ) {
    this.marker = marker;
  }

}
