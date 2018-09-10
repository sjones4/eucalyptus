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
import com.eucalyptus.binding.HttpNoContent;
import com.eucalyptus.binding.HttpHeaderMapping;
import com.eucalyptus.binding.HttpParameterMapping;
import com.eucalyptus.binding.HttpRequestMapping;
import com.eucalyptus.binding.HttpUriMapping;
import com.eucalyptus.loadbalancingv2.common.Loadbalancingv2MessageValidation.FieldRange;
import com.eucalyptus.loadbalancingv2.common.Loadbalancingv2MessageValidation.FieldRegex;
import com.eucalyptus.loadbalancingv2.common.Loadbalancingv2MessageValidation.FieldRegexValue;



public class ModifyListenerType extends Loadbalancingv2Message {

  private CertificateList certificates;
  private Actions defaultActions;
  @Nonnull
  private String listenerArn;
  @FieldRange(min=1, max=65535)
  private Integer port;
  @FieldRegex(FieldRegexValue.ENUM_PROTOCOLENUM)
  private String protocol;
  private String sslPolicy;

  public CertificateList getCertificates( ) {
    return certificates;
  }

  public void setCertificates( final CertificateList certificates ) {
    this.certificates = certificates;
  }

  public Actions getDefaultActions( ) {
    return defaultActions;
  }

  public void setDefaultActions( final Actions defaultActions ) {
    this.defaultActions = defaultActions;
  }

  public String getListenerArn( ) {
    return listenerArn;
  }

  public void setListenerArn( final String listenerArn ) {
    this.listenerArn = listenerArn;
  }

  public Integer getPort( ) {
    return port;
  }

  public void setPort( final Integer port ) {
    this.port = port;
  }

  public String getProtocol( ) {
    return protocol;
  }

  public void setProtocol( final String protocol ) {
    this.protocol = protocol;
  }

  public String getSslPolicy( ) {
    return sslPolicy;
  }

  public void setSslPolicy( final String sslPolicy ) {
    this.sslPolicy = sslPolicy;
  }

}
