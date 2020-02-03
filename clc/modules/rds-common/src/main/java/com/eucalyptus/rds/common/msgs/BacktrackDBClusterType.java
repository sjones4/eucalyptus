/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import javax.annotation.Nonnull;


public class BacktrackDBClusterType extends RdsMessage {

  @Nonnull
  private java.util.Date backtrackTo;

  @Nonnull
  private String dBClusterIdentifier;

  private Boolean force;

  private Boolean useEarliestTimeOnPointInTimeUnavailable;

  public java.util.Date getBacktrackTo() {
    return backtrackTo;
  }

  public void setBacktrackTo(final java.util.Date backtrackTo) {
    this.backtrackTo = backtrackTo;
  }

  public String getDBClusterIdentifier() {
    return dBClusterIdentifier;
  }

  public void setDBClusterIdentifier(final String dBClusterIdentifier) {
    this.dBClusterIdentifier = dBClusterIdentifier;
  }

  public Boolean getForce() {
    return force;
  }

  public void setForce(final Boolean force) {
    this.force = force;
  }

  public Boolean getUseEarliestTimeOnPointInTimeUnavailable() {
    return useEarliestTimeOnPointInTimeUnavailable;
  }

  public void setUseEarliestTimeOnPointInTimeUnavailable(final Boolean useEarliestTimeOnPointInTimeUnavailable) {
    this.useEarliestTimeOnPointInTimeUnavailable = useEarliestTimeOnPointInTimeUnavailable;
  }

}
