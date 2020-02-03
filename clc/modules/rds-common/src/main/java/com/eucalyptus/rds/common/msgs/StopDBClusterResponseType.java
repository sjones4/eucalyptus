/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

public class StopDBClusterResponseType extends RdsMessage {

  private StopDBClusterResult result = new StopDBClusterResult();

  private ResponseMetadata responseMetadata = new ResponseMetadata();

  public ResponseMetadata getResponseMetadata() {
    return responseMetadata;
  }

  public void setResponseMetadata(final ResponseMetadata responseMetadata) {
    this.responseMetadata = responseMetadata;
  }

  public StopDBClusterResult getStopDBClusterResult() {
    return result;
  }

  public void setStopDBClusterResult(final StopDBClusterResult result) {
    this.result = result;
  }

}
