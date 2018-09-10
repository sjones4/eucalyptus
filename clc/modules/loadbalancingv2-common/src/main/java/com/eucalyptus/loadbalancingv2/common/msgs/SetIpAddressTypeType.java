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



public class SetIpAddressTypeType extends Loadbalancingv2Message {

  @Nonnull
  @FieldRegex(FieldRegexValue.ENUM_IPADDRESSTYPE)
  private String ipAddressType;
  @Nonnull
  private String loadBalancerArn;

  public String getIpAddressType( ) {
    return ipAddressType;
  }

  public void setIpAddressType( final String ipAddressType ) {
    this.ipAddressType = ipAddressType;
  }

  public String getLoadBalancerArn( ) {
    return loadBalancerArn;
  }

  public void setLoadBalancerArn( final String loadBalancerArn ) {
    this.loadBalancerArn = loadBalancerArn;
  }

}
