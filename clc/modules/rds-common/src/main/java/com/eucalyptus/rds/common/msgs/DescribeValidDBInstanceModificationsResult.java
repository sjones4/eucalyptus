/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;


public class DescribeValidDBInstanceModificationsResult extends EucalyptusData {

  private ValidDBInstanceModificationsMessage validDBInstanceModificationsMessage;

  public ValidDBInstanceModificationsMessage getValidDBInstanceModificationsMessage() {
    return validDBInstanceModificationsMessage;
  }

  public void setValidDBInstanceModificationsMessage(final ValidDBInstanceModificationsMessage validDBInstanceModificationsMessage) {
    this.validDBInstanceModificationsMessage = validDBInstanceModificationsMessage;
  }

}
