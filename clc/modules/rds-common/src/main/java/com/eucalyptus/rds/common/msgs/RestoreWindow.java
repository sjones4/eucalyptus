/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;


public class RestoreWindow extends EucalyptusData {

  private java.util.Date earliestTime;

  private java.util.Date latestTime;

  public java.util.Date getEarliestTime() {
    return earliestTime;
  }

  public void setEarliestTime(final java.util.Date earliestTime) {
    this.earliestTime = earliestTime;
  }

  public java.util.Date getLatestTime() {
    return latestTime;
  }

  public void setLatestTime(final java.util.Date latestTime) {
    this.latestTime = latestTime;
  }

}
