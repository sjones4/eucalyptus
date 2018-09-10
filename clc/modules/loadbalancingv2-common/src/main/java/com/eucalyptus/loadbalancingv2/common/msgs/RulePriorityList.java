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


public class RulePriorityList extends EucalyptusData {

  private ArrayList<RulePriorityPair> member = new ArrayList<>();

  public ArrayList<RulePriorityPair> getMember( ) {
    return member;
  }

  public void setMember( final ArrayList<RulePriorityPair> member ) {
    this.member = member;
  }
}
