/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import javax.annotation.Nonnull;


public class DeleteInstallationMediaType extends RdsMessage {

  @Nonnull
  private String installationMediaId;

  public String getInstallationMediaId() {
    return installationMediaId;
  }

  public void setInstallationMediaId(final String installationMediaId) {
    this.installationMediaId = installationMediaId;
  }

}
