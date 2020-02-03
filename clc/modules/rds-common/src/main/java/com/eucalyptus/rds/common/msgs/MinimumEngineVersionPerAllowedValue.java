/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;


public class MinimumEngineVersionPerAllowedValue extends EucalyptusData {

  private String allowedValue;

  private String minimumEngineVersion;

  public String getAllowedValue() {
    return allowedValue;
  }

  public void setAllowedValue(final String allowedValue) {
    this.allowedValue = allowedValue;
  }

  public String getMinimumEngineVersion() {
    return minimumEngineVersion;
  }

  public void setMinimumEngineVersion(final String minimumEngineVersion) {
    this.minimumEngineVersion = minimumEngineVersion;
  }

}
