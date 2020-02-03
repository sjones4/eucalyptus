/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

public class CopyOptionGroupResponseType extends RdsMessage {

  private CopyOptionGroupResult result = new CopyOptionGroupResult();

  private ResponseMetadata responseMetadata = new ResponseMetadata();

  public CopyOptionGroupResult getCopyOptionGroupResult() {
    return result;
  }

  public void setCopyOptionGroupResult(final CopyOptionGroupResult result) {
    this.result = result;
  }

  public ResponseMetadata getResponseMetadata() {
    return responseMetadata;
  }

  public void setResponseMetadata(final ResponseMetadata responseMetadata) {
    this.responseMetadata = responseMetadata;
  }

}
