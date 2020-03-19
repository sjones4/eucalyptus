/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

public class CopyDBParameterGroupResponseType extends RdsMessage {

  private CopyDBParameterGroupResult result = new CopyDBParameterGroupResult();

  private ResponseMetadata responseMetadata = new ResponseMetadata();

  public CopyDBParameterGroupResult getCopyDBParameterGroupResult() {
    return result;
  }

  public void setCopyDBParameterGroupResult(final CopyDBParameterGroupResult result) {
    this.result = result;
  }

  public ResponseMetadata getResponseMetadata() {
    return responseMetadata;
  }

  public void setResponseMetadata(final ResponseMetadata responseMetadata) {
    this.responseMetadata = responseMetadata;
  }

}
