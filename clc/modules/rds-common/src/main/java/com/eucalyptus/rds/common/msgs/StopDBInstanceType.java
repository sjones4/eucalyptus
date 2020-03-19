/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import javax.annotation.Nonnull;


public class StopDBInstanceType extends RdsMessage {

  @Nonnull
  private String dBInstanceIdentifier;

  private String dBSnapshotIdentifier;

  public String getDBInstanceIdentifier() {
    return dBInstanceIdentifier;
  }

  public void setDBInstanceIdentifier(final String dBInstanceIdentifier) {
    this.dBInstanceIdentifier = dBInstanceIdentifier;
  }

  public String getDBSnapshotIdentifier() {
    return dBSnapshotIdentifier;
  }

  public void setDBSnapshotIdentifier(final String dBSnapshotIdentifier) {
    this.dBSnapshotIdentifier = dBSnapshotIdentifier;
  }

}
