/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

public class ModifyGlobalClusterType extends RdsMessage {

  private Boolean deletionProtection;

  private String globalClusterIdentifier;

  private String newGlobalClusterIdentifier;

  public Boolean getDeletionProtection() {
    return deletionProtection;
  }

  public void setDeletionProtection(final Boolean deletionProtection) {
    this.deletionProtection = deletionProtection;
  }

  public String getGlobalClusterIdentifier() {
    return globalClusterIdentifier;
  }

  public void setGlobalClusterIdentifier(final String globalClusterIdentifier) {
    this.globalClusterIdentifier = globalClusterIdentifier;
  }

  public String getNewGlobalClusterIdentifier() {
    return newGlobalClusterIdentifier;
  }

  public void setNewGlobalClusterIdentifier(final String newGlobalClusterIdentifier) {
    this.newGlobalClusterIdentifier = newGlobalClusterIdentifier;
  }

}
