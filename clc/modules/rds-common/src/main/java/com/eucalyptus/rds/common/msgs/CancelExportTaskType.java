/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import javax.annotation.Nonnull;


public class CancelExportTaskType extends RdsMessage {

  @Nonnull
  private String exportTaskIdentifier;

  public String getExportTaskIdentifier() {
    return exportTaskIdentifier;
  }

  public void setExportTaskIdentifier(final String exportTaskIdentifier) {
    this.exportTaskIdentifier = exportTaskIdentifier;
  }

}
