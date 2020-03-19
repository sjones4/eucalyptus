/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import javax.annotation.Nonnull;


public class RegisterDBProxyTargetsType extends RdsMessage {

  private StringList dBClusterIdentifiers;

  private StringList dBInstanceIdentifiers;

  @Nonnull
  private String dBProxyName;

  private String targetGroupName;

  public StringList getDBClusterIdentifiers() {
    return dBClusterIdentifiers;
  }

  public void setDBClusterIdentifiers(final StringList dBClusterIdentifiers) {
    this.dBClusterIdentifiers = dBClusterIdentifiers;
  }

  public StringList getDBInstanceIdentifiers() {
    return dBInstanceIdentifiers;
  }

  public void setDBInstanceIdentifiers(final StringList dBInstanceIdentifiers) {
    this.dBInstanceIdentifiers = dBInstanceIdentifiers;
  }

  public String getDBProxyName() {
    return dBProxyName;
  }

  public void setDBProxyName(final String dBProxyName) {
    this.dBProxyName = dBProxyName;
  }

  public String getTargetGroupName() {
    return targetGroupName;
  }

  public void setTargetGroupName(final String targetGroupName) {
    this.targetGroupName = targetGroupName;
  }

}
