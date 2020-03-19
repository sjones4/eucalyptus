/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;


public class CustomAvailabilityZone extends EucalyptusData {

  private String customAvailabilityZoneId;

  private String customAvailabilityZoneName;

  private String customAvailabilityZoneStatus;

  private VpnDetails vpnDetails;

  public String getCustomAvailabilityZoneId() {
    return customAvailabilityZoneId;
  }

  public void setCustomAvailabilityZoneId(final String customAvailabilityZoneId) {
    this.customAvailabilityZoneId = customAvailabilityZoneId;
  }

  public String getCustomAvailabilityZoneName() {
    return customAvailabilityZoneName;
  }

  public void setCustomAvailabilityZoneName(final String customAvailabilityZoneName) {
    this.customAvailabilityZoneName = customAvailabilityZoneName;
  }

  public String getCustomAvailabilityZoneStatus() {
    return customAvailabilityZoneStatus;
  }

  public void setCustomAvailabilityZoneStatus(final String customAvailabilityZoneStatus) {
    this.customAvailabilityZoneStatus = customAvailabilityZoneStatus;
  }

  public VpnDetails getVpnDetails() {
    return vpnDetails;
  }

  public void setVpnDetails(final VpnDetails vpnDetails) {
    this.vpnDetails = vpnDetails;
  }

}
