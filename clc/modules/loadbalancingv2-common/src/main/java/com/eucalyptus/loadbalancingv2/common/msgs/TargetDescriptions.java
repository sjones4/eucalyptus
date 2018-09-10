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


public class TargetDescriptions extends EucalyptusData {

  private ArrayList<TargetDescription> member = new ArrayList<>();

  public ArrayList<TargetDescription> getMember( ) {
    return member;
  }

  public void setMember( final ArrayList<TargetDescription> member ) {
    this.member = member;
  }
}
