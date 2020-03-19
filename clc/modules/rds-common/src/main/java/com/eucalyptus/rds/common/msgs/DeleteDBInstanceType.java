/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import javax.annotation.Nonnull;


public class DeleteDBInstanceType extends RdsMessage {

  @Nonnull
  private String dBInstanceIdentifier;

  private Boolean deleteAutomatedBackups;

  private String finalDBSnapshotIdentifier;

  private Boolean skipFinalSnapshot;

  public String getDBInstanceIdentifier() {
    return dBInstanceIdentifier;
  }

  public void setDBInstanceIdentifier(final String dBInstanceIdentifier) {
    this.dBInstanceIdentifier = dBInstanceIdentifier;
  }

  public Boolean getDeleteAutomatedBackups() {
    return deleteAutomatedBackups;
  }

  public void setDeleteAutomatedBackups(final Boolean deleteAutomatedBackups) {
    this.deleteAutomatedBackups = deleteAutomatedBackups;
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
