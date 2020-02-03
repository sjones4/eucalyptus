/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import javax.annotation.Nonnull;


public class DeleteDBClusterEndpointType extends RdsMessage {

  @Nonnull
  private String dBClusterEndpointIdentifier;

  public String getDBClusterEndpointIdentifier() {
    return dBClusterEndpointIdentifier;
  }

  public void setDBClusterEndpointIdentifier(final String dBClusterEndpointIdentifier) {
    this.dBClusterEndpointIdentifier = dBClusterEndpointIdentifier;
  }

}
