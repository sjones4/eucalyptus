/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import javax.annotation.Nonnull;


public class CreateCustomAvailabilityZoneType extends RdsMessage {

  @Nonnull
  private String customAvailabilityZoneName;

  private String existingVpnId;

  private String newVpnTunnelName;

  private String vpnTunnelOriginatorIP;

  public String getCustomAvailabilityZoneName() {
    return customAvailabilityZoneName;
  }

  public void setCustomAvailabilityZoneName(final String customAvailabilityZoneName) {
    this.customAvailabilityZoneName = customAvailabilityZoneName;
  }

  public String getExistingVpnId() {
    return existingVpnId;
  }

  public void setExistingVpnId(final String existingVpnId) {
    this.existingVpnId = existingVpnId;
  }

  public String getNewVpnTunnelName() {
    return newVpnTunnelName;
  }

  public void setNewVpnTunnelName(final String newVpnTunnelName) {
    this.newVpnTunnelName = newVpnTunnelName;
  }

  public String getVpnTunnelOriginatorIP() {
    return vpnTunnelOriginatorIP;
  }

  public void setVpnTunnelOriginatorIP(final String vpnTunnelOriginatorIP) {
    this.vpnTunnelOriginatorIP = vpnTunnelOriginatorIP;
  }

}
