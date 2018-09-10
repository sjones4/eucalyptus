/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;
import java.util.ArrayList;


public class ParametersList extends EucalyptusData {

  private ArrayList<Parameter> member = new ArrayList<>();

  public ArrayList<Parameter> getMember( ) {
    return member;
  }

  public void setMember( final ArrayList<Parameter> member ) {
    this.member = member;
  }
}
