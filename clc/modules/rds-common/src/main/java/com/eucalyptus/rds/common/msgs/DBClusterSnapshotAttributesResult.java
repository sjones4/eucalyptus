/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;
import javax.annotation.Nonnull;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRange;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRegex;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRegexValue;


public class DBClusterSnapshotAttributesResult extends EucalyptusData {

  private DBClusterSnapshotAttributeList dBClusterSnapshotAttributes;
  private String dBClusterSnapshotIdentifier;

  public DBClusterSnapshotAttributeList getDBClusterSnapshotAttributes( ) {
    return dBClusterSnapshotAttributes;
  }

  public void setDBClusterSnapshotAttributes( final DBClusterSnapshotAttributeList dBClusterSnapshotAttributes ) {
    this.dBClusterSnapshotAttributes = dBClusterSnapshotAttributes;
  }

  public String getDBClusterSnapshotIdentifier( ) {
    return dBClusterSnapshotIdentifier;
  }

  public void setDBClusterSnapshotIdentifier( final String dBClusterSnapshotIdentifier ) {
    this.dBClusterSnapshotIdentifier = dBClusterSnapshotIdentifier;
  }

}
