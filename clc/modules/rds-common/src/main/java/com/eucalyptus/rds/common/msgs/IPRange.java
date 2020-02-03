/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;


public class IPRange extends EucalyptusData {

  private String cIDRIP;

  private String status;

  public String getCIDRIP() {
    return cIDRIP;
  }

  public void setCIDRIP(final String cIDRIP) {
    this.cIDRIP = cIDRIP;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(final String status) {
    this.status = status;
  }

}
