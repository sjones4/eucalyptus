/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.loadbalancingv2.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;
import javax.annotation.Nonnull;
import com.eucalyptus.loadbalancingv2.common.Loadbalancingv2MessageValidation.FieldRange;
import com.eucalyptus.loadbalancingv2.common.Loadbalancingv2MessageValidation.FieldRegex;
import com.eucalyptus.loadbalancingv2.common.Loadbalancingv2MessageValidation.FieldRegexValue;


public class FixedResponseActionConfig extends EucalyptusData {

  @FieldRange(max=32)
  private String contentType;
  @FieldRange(max=1024)
  private String messageBody;
  @Nonnull
  private String statusCode;

  public String getContentType( ) {
    return contentType;
  }

  public void setContentType( final String contentType ) {
    this.contentType = contentType;
  }

  public String getMessageBody( ) {
    return messageBody;
  }

  public void setMessageBody( final String messageBody ) {
    this.messageBody = messageBody;
  }

  public String getStatusCode( ) {
    return statusCode;
  }

  public void setStatusCode( final String statusCode ) {
    this.statusCode = statusCode;
  }

}
