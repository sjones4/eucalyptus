/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;


public class CopyDBParameterGroupResult extends EucalyptusData {

  private DBParameterGroup dBParameterGroup;

  public DBParameterGroup getDBParameterGroup() {
    return dBParameterGroup;
  }

  public void setDBParameterGroup(final DBParameterGroup dBParameterGroup) {
    this.dBParameterGroup = dBParameterGroup;
  }

}
