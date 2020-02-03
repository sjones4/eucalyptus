/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;


public class PendingCloudwatchLogsExports extends EucalyptusData {

  private LogTypeList logTypesToDisable;

  private LogTypeList logTypesToEnable;

  public LogTypeList getLogTypesToDisable() {
    return logTypesToDisable;
  }

  public void setLogTypesToDisable(final LogTypeList logTypesToDisable) {
    this.logTypesToDisable = logTypesToDisable;
  }

  public LogTypeList getLogTypesToEnable() {
    return logTypesToEnable;
  }

  public void setLogTypesToEnable(final LogTypeList logTypesToEnable) {
    this.logTypesToEnable = logTypesToEnable;
  }

}
