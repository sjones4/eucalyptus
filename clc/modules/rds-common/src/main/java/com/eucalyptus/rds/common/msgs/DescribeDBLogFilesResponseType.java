/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

public class DescribeDBLogFilesResponseType extends RdsMessage {

  private DescribeDBLogFilesResult result = new DescribeDBLogFilesResult();

  private ResponseMetadata responseMetadata = new ResponseMetadata();

  public DescribeDBLogFilesResult getDescribeDBLogFilesResult() {
    return result;
  }

  public void setDescribeDBLogFilesResult(final DescribeDBLogFilesResult result) {
    this.result = result;
  }

  public ResponseMetadata getResponseMetadata() {
    return responseMetadata;
  }

  public void setResponseMetadata(final ResponseMetadata responseMetadata) {
    this.responseMetadata = responseMetadata;
  }

}
