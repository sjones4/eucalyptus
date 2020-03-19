/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

public class DescribeOptionGroupsResponseType extends RdsMessage {

  private DescribeOptionGroupsResult result = new DescribeOptionGroupsResult();

  private ResponseMetadata responseMetadata = new ResponseMetadata();

  public DescribeOptionGroupsResult getDescribeOptionGroupsResult() {
    return result;
  }

  public void setDescribeOptionGroupsResult(final DescribeOptionGroupsResult result) {
    this.result = result;
  }

  public ResponseMetadata getResponseMetadata() {
    return responseMetadata;
  }

  public void setResponseMetadata(final ResponseMetadata responseMetadata) {
    this.responseMetadata = responseMetadata;
  }

}
