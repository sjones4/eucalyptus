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



public class DescribeTargetGroupsType extends Loadbalancingv2Message {

  private String loadBalancerArn;
  private String marker;
  private TargetGroupNames names;
  @FieldRange(min=1, max=400)
  private Integer pageSize;
  private TargetGroupArns targetGroupArns;

  public String getLoadBalancerArn( ) {
    return loadBalancerArn;
  }

  public void setLoadBalancerArn( final String loadBalancerArn ) {
    this.loadBalancerArn = loadBalancerArn;
  }

  public String getMarker( ) {
    return marker;
  }

  public void setMarker( final String marker ) {
    this.marker = marker;
  }

  public TargetGroupNames getNames( ) {
    return names;
  }

  public void setNames( final TargetGroupNames names ) {
    this.names = names;
  }

  public Integer getPageSize( ) {
    return pageSize;
  }

  public void setPageSize( final Integer pageSize ) {
    this.pageSize = pageSize;
  }

  public TargetGroupArns getTargetGroupArns( ) {
    return targetGroupArns;
  }

  public void setTargetGroupArns( final TargetGroupArns targetGroupArns ) {
    this.targetGroupArns = targetGroupArns;
  }

}
