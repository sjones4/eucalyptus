/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

public class ModifyDBProxyResponseType extends RdsMessage {

  private ModifyDBProxyResult result = new ModifyDBProxyResult();

  private ResponseMetadata responseMetadata = new ResponseMetadata();

  public ModifyDBProxyResult getModifyDBProxyResult() {
    return result;
  }

  public void setModifyDBProxyResult(final ModifyDBProxyResult result) {
    this.result = result;
  }

  public ResponseMetadata getResponseMetadata() {
    return responseMetadata;
  }

  public void setResponseMetadata(final ResponseMetadata responseMetadata) {
    this.responseMetadata = responseMetadata;
  }

}
