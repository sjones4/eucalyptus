/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRange;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRegex;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRegexValue;


public class ModifyDBClusterResult extends EucalyptusData {

  private DBCluster dBCluster;

  public DBCluster getDBCluster( ) {
    return dBCluster;
  }

  public void setDBCluster( final DBCluster dBCluster ) {
    this.dBCluster = dBCluster;
  }

}
