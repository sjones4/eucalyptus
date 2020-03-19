/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

public class RemoveFromGlobalClusterType extends RdsMessage {

  private String dbClusterIdentifier;

  private String globalClusterIdentifier;

  public String getDbClusterIdentifier() {
    return dbClusterIdentifier;
  }

  public void setDbClusterIdentifier(final String dbClusterIdentifier) {
    this.dbClusterIdentifier = dbClusterIdentifier;
  }

  public String getGlobalClusterIdentifier() {
    return globalClusterIdentifier;
  }

  public void setGlobalClusterIdentifier(final String globalClusterIdentifier) {
    this.globalClusterIdentifier = globalClusterIdentifier;
  }

}
