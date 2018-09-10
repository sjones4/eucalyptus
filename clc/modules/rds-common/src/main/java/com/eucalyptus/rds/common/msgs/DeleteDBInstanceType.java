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



public class DeleteDBInstanceType extends RdsMessage {

  @Nonnull
  private String dBInstanceIdentifier;
  private String finalDBSnapshotIdentifier;
  private Boolean skipFinalSnapshot;

  public String getDBInstanceIdentifier( ) {
    return dBInstanceIdentifier;
  }

  public void setDBInstanceIdentifier( final String dBInstanceIdentifier ) {
    this.dBInstanceIdentifier = dBInstanceIdentifier;
  }

  public String getFinalDBSnapshotIdentifier( ) {
    return finalDBSnapshotIdentifier;
  }

  public void setFinalDBSnapshotIdentifier( final String finalDBSnapshotIdentifier ) {
    this.finalDBSnapshotIdentifier = finalDBSnapshotIdentifier;
  }

  public Boolean getSkipFinalSnapshot( ) {
    return skipFinalSnapshot;
  }

  public void setSkipFinalSnapshot( final Boolean skipFinalSnapshot ) {
    this.skipFinalSnapshot = skipFinalSnapshot;
  }

}
