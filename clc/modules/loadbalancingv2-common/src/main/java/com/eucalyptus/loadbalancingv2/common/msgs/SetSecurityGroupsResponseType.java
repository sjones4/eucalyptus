/*
 * Copyright 2021 AppScale Systems, Inc
 *
 * SPDX-License-Identifier: BSD-2-Clause
 */
package com.eucalyptus.loadbalancingv2.common.msgs;

public class SetSecurityGroupsResponseType extends Loadbalancingv2Message {

  private SetSecurityGroupsResult result = new SetSecurityGroupsResult();

  private ResponseMetadata responseMetadata = new ResponseMetadata();

  public ResponseMetadata getResponseMetadata() {
    return responseMetadata;
  }

  public void setResponseMetadata(final ResponseMetadata responseMetadata) {
    this.responseMetadata = responseMetadata;
  }

  public SetSecurityGroupsResult getSetSecurityGroupsResult() {
    return result;
  }

  public void setSetSecurityGroupsResult(final SetSecurityGroupsResult result) {
    this.result = result;
  }

}
