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


public class DescribeDBParameterGroupsResult extends EucalyptusData {

  private DBParameterGroupList dBParameterGroups;
  private String marker;

  public DBParameterGroupList getDBParameterGroups( ) {
    return dBParameterGroups;
  }

  public void setDBParameterGroups( final DBParameterGroupList dBParameterGroups ) {
    this.dBParameterGroups = dBParameterGroups;
  }

  public String getMarker( ) {
    return marker;
  }

  public void setMarker( final String marker ) {
    this.marker = marker;
  }

}
