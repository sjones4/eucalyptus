/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;


public class DescribeDBProxyTargetsResult extends EucalyptusData {

  private String marker;

  private TargetList targets;

  public String getMarker() {
    return marker;
  }

  public void setMarker(final String marker) {
    this.marker = marker;
  }

  public TargetList getTargets() {
    return targets;
  }

  public void setTargets(final TargetList targets) {
    this.targets = targets;
  }

}
