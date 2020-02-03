/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

public class RestoreDBClusterToPointInTimeResponseType extends RdsMessage {

  private RestoreDBClusterToPointInTimeResult result = new RestoreDBClusterToPointInTimeResult();

  private ResponseMetadata responseMetadata = new ResponseMetadata();

  public ResponseMetadata getResponseMetadata() {
    return responseMetadata;
  }

  public void setResponseMetadata(final ResponseMetadata responseMetadata) {
    this.responseMetadata = responseMetadata;
  }

  public RestoreDBClusterToPointInTimeResult getRestoreDBClusterToPointInTimeResult() {
    return result;
  }

  public void setRestoreDBClusterToPointInTimeResult(final RestoreDBClusterToPointInTimeResult result) {
    this.result = result;
  }

}
