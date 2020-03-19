/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

public class ModifyDBClusterEndpointResponseType extends RdsMessage {

  private ModifyDBClusterEndpointResult result = new ModifyDBClusterEndpointResult();

  private ResponseMetadata responseMetadata = new ResponseMetadata();

  public ModifyDBClusterEndpointResult getModifyDBClusterEndpointResult() {
    return result;
  }

  public void setModifyDBClusterEndpointResult(final ModifyDBClusterEndpointResult result) {
    this.result = result;
  }

  public ResponseMetadata getResponseMetadata() {
    return responseMetadata;
  }

  public void setResponseMetadata(final ResponseMetadata responseMetadata) {
    this.responseMetadata = responseMetadata;
  }

}
