/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import javax.annotation.Nonnull;


public class DeleteDBClusterType extends RdsMessage {

  @Nonnull
  private String dBClusterIdentifier;

  private String finalDBSnapshotIdentifier;

  private Boolean skipFinalSnapshot;

  public String getDBClusterIdentifier() {
    return dBClusterIdentifier;
  }

  public void setDBClusterIdentifier(final String dBClusterIdentifier) {
    this.dBClusterIdentifier = dBClusterIdentifier;
  }

  public String getFinalDBSnapshotIdentifier() {
    return finalDBSnapshotIdentifier;
  }

  public void setFinalDBSnapshotIdentifier(final String finalDBSnapshotIdentifier) {
    this.finalDBSnapshotIdentifier = finalDBSnapshotIdentifier;
  }

  public Boolean getSkipFinalSnapshot() {
    return skipFinalSnapshot;
  }

  public void setSkipFinalSnapshot(final Boolean skipFinalSnapshot) {
    this.skipFinalSnapshot = skipFinalSnapshot;
  }

}
