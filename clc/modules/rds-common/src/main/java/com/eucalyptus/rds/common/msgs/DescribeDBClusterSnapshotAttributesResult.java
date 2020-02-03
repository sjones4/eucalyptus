/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;


public class DescribeDBClusterSnapshotAttributesResult extends EucalyptusData {

  private DBClusterSnapshotAttributesResult dBClusterSnapshotAttributesResult;

  public DBClusterSnapshotAttributesResult getDBClusterSnapshotAttributesResult() {
    return dBClusterSnapshotAttributesResult;
  }

  public void setDBClusterSnapshotAttributesResult(final DBClusterSnapshotAttributesResult dBClusterSnapshotAttributesResult) {
    this.dBClusterSnapshotAttributesResult = dBClusterSnapshotAttributesResult;
  }

}
