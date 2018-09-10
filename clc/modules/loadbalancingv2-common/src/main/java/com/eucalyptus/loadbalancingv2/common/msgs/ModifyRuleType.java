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



public class ModifyRuleType extends Loadbalancingv2Message {

  private Actions actions;
  private RuleConditionList conditions;
  @Nonnull
  private String ruleArn;

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

  public String getRuleArn( ) {
    return ruleArn;
  }

  public void setRuleArn( final String ruleArn ) {
    this.ruleArn = ruleArn;
  }

}
