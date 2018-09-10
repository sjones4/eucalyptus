/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;
import javax.annotation.Nonnull;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRange;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRegex;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRegexValue;


public class DBClusterParameterGroup extends EucalyptusData {

  private String dBClusterParameterGroupArn;
  private String dBClusterParameterGroupName;
  private String dBParameterGroupFamily;
  private String description;

  public String getDBClusterParameterGroupArn( ) {
    return dBClusterParameterGroupArn;
  }

  public void setDBClusterParameterGroupArn( final String dBClusterParameterGroupArn ) {
    this.dBClusterParameterGroupArn = dBClusterParameterGroupArn;
  }

  public String getDBClusterParameterGroupName( ) {
    return dBClusterParameterGroupName;
  }

  public void setDBClusterParameterGroupName( final String dBClusterParameterGroupName ) {
    this.dBClusterParameterGroupName = dBClusterParameterGroupName;
  }

  public String getDBParameterGroupFamily( ) {
    return dBParameterGroupFamily;
  }

  public void setDBParameterGroupFamily( final String dBParameterGroupFamily ) {
    this.dBParameterGroupFamily = dBParameterGroupFamily;
  }

  public String getDescription( ) {
    return description;
  }

  public void setDescription( final String description ) {
    this.description = description;
  }

}
