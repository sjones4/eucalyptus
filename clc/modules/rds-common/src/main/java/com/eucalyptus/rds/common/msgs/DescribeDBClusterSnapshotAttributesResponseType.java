/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

public class DescribeDBClusterSnapshotAttributesResponseType extends RdsMessage {

  private DescribeDBClusterSnapshotAttributesResult result = new DescribeDBClusterSnapshotAttributesResult();

  private ResponseMetadata responseMetadata = new ResponseMetadata();

  public DescribeDBClusterSnapshotAttributesResult getDescribeDBClusterSnapshotAttributesResult() {
    return result;
  }

  public void setDescribeDBClusterSnapshotAttributesResult(final DescribeDBClusterSnapshotAttributesResult result) {
    this.result = result;
  }

  public ResponseMetadata getResponseMetadata() {
    return responseMetadata;
  }

  public void setResponseMetadata(final ResponseMetadata responseMetadata) {
    this.responseMetadata = responseMetadata;
  }

}
