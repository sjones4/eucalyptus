/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import javax.annotation.Nonnull;


public class ModifyDBClusterEndpointType extends RdsMessage {

  @Nonnull
  private String dBClusterEndpointIdentifier;

  private String endpointType;

  private StringList excludedMembers;

  private StringList staticMembers;

  public String getDBClusterEndpointIdentifier() {
    return dBClusterEndpointIdentifier;
  }

  public void setDBClusterEndpointIdentifier(final String dBClusterEndpointIdentifier) {
    this.dBClusterEndpointIdentifier = dBClusterEndpointIdentifier;
  }

  public String getEndpointType() {
    return endpointType;
  }

  public void setEndpointType(final String endpointType) {
    this.endpointType = endpointType;
  }

  public StringList getExcludedMembers() {
    return excludedMembers;
  }

  public void setExcludedMembers(final StringList excludedMembers) {
    this.excludedMembers = excludedMembers;
  }

  public StringList getStaticMembers() {
    return staticMembers;
  }

  public void setStaticMembers(final StringList staticMembers) {
    this.staticMembers = staticMembers;
  }

}
