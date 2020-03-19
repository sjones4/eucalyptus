/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

public class DescribePendingMaintenanceActionsResponseType extends RdsMessage {

  private DescribePendingMaintenanceActionsResult result = new DescribePendingMaintenanceActionsResult();

  private ResponseMetadata responseMetadata = new ResponseMetadata();

  public DescribePendingMaintenanceActionsResult getDescribePendingMaintenanceActionsResult() {
    return result;
  }

  public void setDescribePendingMaintenanceActionsResult(final DescribePendingMaintenanceActionsResult result) {
    this.result = result;
  }

  public ResponseMetadata getResponseMetadata() {
    return responseMetadata;
  }

  public void setResponseMetadata(final ResponseMetadata responseMetadata) {
    this.responseMetadata = responseMetadata;
  }

}
