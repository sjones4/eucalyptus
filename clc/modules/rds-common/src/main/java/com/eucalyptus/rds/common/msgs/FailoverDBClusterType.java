/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import javax.annotation.Nonnull;
import com.eucalyptus.binding.HttpContent;
import com.eucalyptus.binding.HttpNoContent;
import com.eucalyptus.binding.HttpHeaderMapping;
import com.eucalyptus.binding.HttpParameterMapping;
import com.eucalyptus.binding.HttpRequestMapping;
import com.eucalyptus.binding.HttpUriMapping;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRange;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRegex;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRegexValue;



public class FailoverDBClusterType extends RdsMessage {

  private String dBClusterIdentifier;
  private String targetDBInstanceIdentifier;

  public String getDBClusterIdentifier( ) {
    return dBClusterIdentifier;
  }

  public void setDBClusterIdentifier( final String dBClusterIdentifier ) {
    this.dBClusterIdentifier = dBClusterIdentifier;
  }

  public String getTargetDBInstanceIdentifier( ) {
    return targetDBInstanceIdentifier;
  }

  public void setTargetDBInstanceIdentifier( final String targetDBInstanceIdentifier ) {
    this.targetDBInstanceIdentifier = targetDBInstanceIdentifier;
  }

}
