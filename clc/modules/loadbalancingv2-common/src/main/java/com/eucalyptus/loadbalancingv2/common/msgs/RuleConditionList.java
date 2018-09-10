/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.loadbalancingv2.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;
import java.util.ArrayList;


public class RuleConditionList extends EucalyptusData {

  private ArrayList<RuleCondition> member = new ArrayList<>();

  public ArrayList<RuleCondition> getMember( ) {
    return member;
  }

  public void setMember( final ArrayList<RuleCondition> member ) {
    this.member = member;
  }
}
