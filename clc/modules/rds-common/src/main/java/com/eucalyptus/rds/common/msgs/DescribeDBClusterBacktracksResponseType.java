/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

public class DescribeDBClusterBacktracksResponseType extends RdsMessage {

  private DescribeDBClusterBacktracksResult result = new DescribeDBClusterBacktracksResult();

  private ResponseMetadata responseMetadata = new ResponseMetadata();

  public DescribeDBClusterBacktracksResult getDescribeDBClusterBacktracksResult() {
    return result;
  }

  public void setDescribeDBClusterBacktracksResult(final DescribeDBClusterBacktracksResult result) {
    this.result = result;
  }

  public ResponseMetadata getResponseMetadata() {
    return responseMetadata;
  }

  public void setResponseMetadata(final ResponseMetadata responseMetadata) {
    this.responseMetadata = responseMetadata;
  }

}
