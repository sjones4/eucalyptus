/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;


public class DescribeEngineDefaultClusterParametersResult extends EucalyptusData {

  private EngineDefaults engineDefaults;

  public EngineDefaults getEngineDefaults() {
    return engineDefaults;
  }

  public void setEngineDefaults(final EngineDefaults engineDefaults) {
    this.engineDefaults = engineDefaults;
  }

}
