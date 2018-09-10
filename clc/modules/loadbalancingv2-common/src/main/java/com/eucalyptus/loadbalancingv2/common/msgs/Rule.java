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


public class Rule extends EucalyptusData {

  private Actions actions;
  private RuleConditionList conditions;
  private Boolean isDefault;
  private String priority;
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

  public Boolean getIsDefault( ) {
    return isDefault;
  }

  public void setIsDefault( final Boolean isDefault ) {
    this.isDefault = isDefault;
  }

  public String getPriority( ) {
    return priority;
  }

  public void setPriority( final String priority ) {
    this.priority = priority;
  }

  public String getRuleArn( ) {
    return ruleArn;
  }

  public void setRuleArn( final String ruleArn ) {
    this.ruleArn = ruleArn;
  }

}
