/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

public class RemoveSourceIdentifierFromSubscriptionResponseType extends RdsMessage {

  private RemoveSourceIdentifierFromSubscriptionResult result = new RemoveSourceIdentifierFromSubscriptionResult();

  private ResponseMetadata responseMetadata = new ResponseMetadata();

  public RemoveSourceIdentifierFromSubscriptionResult getRemoveSourceIdentifierFromSubscriptionResult() {
    return result;
  }

  public void setRemoveSourceIdentifierFromSubscriptionResult(final RemoveSourceIdentifierFromSubscriptionResult result) {
    this.result = result;
  }

  public ResponseMetadata getResponseMetadata() {
    return responseMetadata;
  }

  public void setResponseMetadata(final ResponseMetadata responseMetadata) {
    this.responseMetadata = responseMetadata;
  }

}
