/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import javax.annotation.Nonnull;


public class FailoverDBClusterType extends RdsMessage {

  @Nonnull
  private String dBClusterIdentifier;

  private String targetDBInstanceIdentifier;

  public String getDBClusterIdentifier() {
    return dBClusterIdentifier;
  }

  public void setDBClusterIdentifier(final String dBClusterIdentifier) {
    this.dBClusterIdentifier = dBClusterIdentifier;
  }

  public String getTargetDBInstanceIdentifier() {
    return targetDBInstanceIdentifier;
  }

  public void setTargetDBInstanceIdentifier(final String targetDBInstanceIdentifier) {
    this.targetDBInstanceIdentifier = targetDBInstanceIdentifier;
  }

}
