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


public class RulePriorityPair extends EucalyptusData {

  @FieldRange(min=1, max=50000)
  private Integer priority;
  private String ruleArn;

  public Integer getPriority( ) {
    return priority;
  }

  public void setPriority( final Integer priority ) {
    this.priority = priority;
  }

  public String getRuleArn( ) {
    return ruleArn;
  }

  public void setRuleArn( final String ruleArn ) {
    this.ruleArn = ruleArn;
  }

}
