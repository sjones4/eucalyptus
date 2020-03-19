/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

public class CreateDBSubnetGroupResponseType extends RdsMessage {

  private CreateDBSubnetGroupResult result = new CreateDBSubnetGroupResult();

  private ResponseMetadata responseMetadata = new ResponseMetadata();

  public CreateDBSubnetGroupResult getCreateDBSubnetGroupResult() {
    return result;
  }

  public void setCreateDBSubnetGroupResult(final CreateDBSubnetGroupResult result) {
    this.result = result;
  }

  public ResponseMetadata getResponseMetadata() {
    return responseMetadata;
  }

  public void setResponseMetadata(final ResponseMetadata responseMetadata) {
    this.responseMetadata = responseMetadata;
  }

}
