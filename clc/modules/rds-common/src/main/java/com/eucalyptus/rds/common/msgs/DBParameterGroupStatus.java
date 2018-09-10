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


public class DBParameterGroupStatus extends EucalyptusData {

  private String dBParameterGroupName;
  private String parameterApplyStatus;

  public String getDBParameterGroupName( ) {
    return dBParameterGroupName;
  }

  public void setDBParameterGroupName( final String dBParameterGroupName ) {
    this.dBParameterGroupName = dBParameterGroupName;
  }

  public String getParameterApplyStatus( ) {
    return parameterApplyStatus;
  }

  public void setParameterApplyStatus( final String parameterApplyStatus ) {
    this.parameterApplyStatus = parameterApplyStatus;
  }

}
