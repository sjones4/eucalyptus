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



public class CreateRuleType extends Loadbalancingv2Message {

  @Nonnull
  private Actions actions;
  @Nonnull
  private RuleConditionList conditions;
  @Nonnull
  private String listenerArn;
  @Nonnull
  @FieldRange(min=1, max=50000)
  private Integer priority;

  public Actions getActions( ) {
    return actions;
  }

  public void setActions( final Actions actions ) {
    this.actions = actions;
  }

  public RuleConditionList getConditions( ) {
    return conditions;
  }

  public void setConditions( final RuleConditionList conditions ) {
    this.conditions = conditions;
  }

  public String getListenerArn( ) {
    return listenerArn;
  }

  public void setListenerArn( final String listenerArn ) {
    this.listenerArn = listenerArn;
  }

  public Integer getPriority( ) {
    return priority;
  }

  public void setPriority( final Integer priority ) {
    this.priority = priority;
  }

}
