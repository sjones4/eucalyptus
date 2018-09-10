/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.loadbalancingv2.common.msgs;

import javax.annotation.Nonnull;
import com.eucalyptus.binding.HttpContent;
import com.eucalyptus.binding.HttpHeaderMapping;
import com.eucalyptus.binding.HttpNoContent;
import com.eucalyptus.loadbalancingv2.common.Loadbalancingv2MessageValidation.FieldRange;
import com.eucalyptus.loadbalancingv2.common.Loadbalancingv2MessageValidation.FieldRegex;
import com.eucalyptus.loadbalancingv2.common.Loadbalancingv2MessageValidation.FieldRegexValue;



public class RegisterTargetsResponseType extends Loadbalancingv2Message {

  private RegisterTargetsResult result = new RegisterTargetsResult( );
  private ResponseMetadata responseMetadata = new ResponseMetadata( );

  public RegisterTargetsResult getRegisterTargetsResult( ) {
    return result;
  }

  public void setRegisterTargetsResult( final RegisterTargetsResult result ) {
    this.result = result;
  }
  public ResponseMetadata getResponseMetadata( ) {
    return responseMetadata;
  }

  public void setResponseMetadata( final ResponseMetadata responseMetadata ) {
    this.responseMetadata = responseMetadata;
  }

}
