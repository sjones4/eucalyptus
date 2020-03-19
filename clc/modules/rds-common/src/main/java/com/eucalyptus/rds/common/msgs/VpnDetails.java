/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;


public class VpnDetails extends EucalyptusData {

  private String vpnGatewayIp;

  private String vpnId;

  private String vpnName;

  private String vpnPSK;

  private String vpnState;

  private String vpnTunnelOriginatorIP;

  public String getVpnGatewayIp() {
    return vpnGatewayIp;
  }

  public void setVpnGatewayIp(final String vpnGatewayIp) {
    this.vpnGatewayIp = vpnGatewayIp;
  }

  public String getVpnId() {
    return vpnId;
  }

  public void setVpnId(final String vpnId) {
    this.vpnId = vpnId;
  }

  public String getVpnName() {
    return vpnName;
  }

  public void setVpnName(final String vpnName) {
    this.vpnName = vpnName;
  }

  public String getVpnPSK() {
    return vpnPSK;
  }

  public void setVpnPSK(final String vpnPSK) {
    this.vpnPSK = vpnPSK;
  }

  public String getVpnState() {
    return vpnState;
  }

  public void setVpnState(final String vpnState) {
    this.vpnState = vpnState;
  }

  public String getVpnTunnelOriginatorIP() {
    return vpnTunnelOriginatorIP;
  }

  public void setVpnTunnelOriginatorIP(final String vpnTunnelOriginatorIP) {
    this.vpnTunnelOriginatorIP = vpnTunnelOriginatorIP;
  }

}
