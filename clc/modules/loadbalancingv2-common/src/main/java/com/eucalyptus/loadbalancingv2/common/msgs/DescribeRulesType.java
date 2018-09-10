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



public class DescribeRulesType extends Loadbalancingv2Message {

  private String listenerArn;
  private String marker;
  @FieldRange(min=1, max=400)
  private Integer pageSize;
  private RuleArns ruleArns;

  public String getListenerArn( ) {
    return listenerArn;
  }

  public void setListenerArn( final String listenerArn ) {
    this.listenerArn = listenerArn;
  }

  public String getMarker( ) {
    return marker;
  }

  public void setMarker( final String marker ) {
    this.marker = marker;
  }

  public Integer getPageSize( ) {
    return pageSize;
  }

  public void setPageSize( final Integer pageSize ) {
    this.pageSize = pageSize;
  }

  public RuleArns getRuleArns( ) {
    return ruleArns;
  }

  public void setRuleArns( final RuleArns ruleArns ) {
    this.ruleArns = ruleArns;
  }

}
