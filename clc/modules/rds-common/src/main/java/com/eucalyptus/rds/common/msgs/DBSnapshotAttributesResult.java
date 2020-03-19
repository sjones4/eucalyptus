/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;


public class DBSnapshotAttributesResult extends EucalyptusData {

  private DBSnapshotAttributeList dBSnapshotAttributes;

  private String dBSnapshotIdentifier;

  public DBSnapshotAttributeList getDBSnapshotAttributes() {
    return dBSnapshotAttributes;
  }

  public void setDBSnapshotAttributes(final DBSnapshotAttributeList dBSnapshotAttributes) {
    this.dBSnapshotAttributes = dBSnapshotAttributes;
  }

  public String getDBSnapshotIdentifier() {
    return dBSnapshotIdentifier;
  }

  public void setDBSnapshotIdentifier(final String dBSnapshotIdentifier) {
    this.dBSnapshotIdentifier = dBSnapshotIdentifier;
  }

}
