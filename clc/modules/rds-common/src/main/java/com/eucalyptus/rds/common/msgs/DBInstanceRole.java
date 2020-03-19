/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;


public class DBInstanceRole extends EucalyptusData {

  private String featureName;

  private String roleArn;

  private String status;

  public String getFeatureName() {
    return featureName;
  }

  public void setFeatureName(final String featureName) {
    this.featureName = featureName;
  }

  public String getRoleArn() {
    return roleArn;
  }

  public void setRoleArn(final String roleArn) {
    this.roleArn = roleArn;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(final String status) {
    this.status = status;
  }

}
