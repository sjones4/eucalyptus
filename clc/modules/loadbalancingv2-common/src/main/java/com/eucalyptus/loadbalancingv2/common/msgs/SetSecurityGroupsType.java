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



public class SetSecurityGroupsType extends Loadbalancingv2Message {

  @Nonnull
  private String loadBalancerArn;
  @Nonnull
  private SecurityGroups securityGroups;

  public String getLoadBalancerArn( ) {
    return loadBalancerArn;
  }

  public void setLoadBalancerArn( final String loadBalancerArn ) {
    this.loadBalancerArn = loadBalancerArn;
  }

  public SecurityGroups getSecurityGroups( ) {
    return securityGroups;
  }

  public void setSecurityGroups( final SecurityGroups securityGroups ) {
    this.securityGroups = securityGroups;
  }

}
