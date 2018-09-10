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



public class PromoteReadReplicaType extends RdsMessage {

  private Integer backupRetentionPeriod;
  @Nonnull
  private String dBInstanceIdentifier;
  private String preferredBackupWindow;

  public Integer getBackupRetentionPeriod( ) {
    return backupRetentionPeriod;
  }

  public void setBackupRetentionPeriod( final Integer backupRetentionPeriod ) {
    this.backupRetentionPeriod = backupRetentionPeriod;
  }

  public String getDBInstanceIdentifier( ) {
    return dBInstanceIdentifier;
  }

  public void setDBInstanceIdentifier( final String dBInstanceIdentifier ) {
    this.dBInstanceIdentifier = dBInstanceIdentifier;
  }

  public String getPreferredBackupWindow( ) {
    return preferredBackupWindow;
  }

  public void setPreferredBackupWindow( final String preferredBackupWindow ) {
    this.preferredBackupWindow = preferredBackupWindow;
  }

}
