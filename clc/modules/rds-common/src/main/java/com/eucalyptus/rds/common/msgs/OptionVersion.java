/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;


public class OptionVersion extends EucalyptusData {

  private Boolean isDefault;

  private String version;

  public Boolean getIsDefault() {
    return isDefault;
  }

  public void setIsDefault(final Boolean isDefault) {
    this.isDefault = isDefault;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(final String version) {
    this.version = version;
  }

}
