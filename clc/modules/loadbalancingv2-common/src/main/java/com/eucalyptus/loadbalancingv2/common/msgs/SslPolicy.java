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


public class SslPolicy extends EucalyptusData {

  private Ciphers ciphers;
  private String name;
  private SslProtocols sslProtocols;

  public Ciphers getCiphers( ) {
    return ciphers;
  }

  public void setCiphers( final Ciphers ciphers ) {
    this.ciphers = ciphers;
  }

  public String getName( ) {
    return name;
  }

  public void setName( final String name ) {
    this.name = name;
  }

  public SslProtocols getSslProtocols( ) {
    return sslProtocols;
  }

  public void setSslProtocols( final SslProtocols sslProtocols ) {
    this.sslProtocols = sslProtocols;
  }

}
