/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudfront.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;
import java.util.ArrayList;


public class ContentTypeProfileList extends EucalyptusData {

  private ArrayList<ContentTypeProfile> member = new ArrayList<>();

  public ArrayList<ContentTypeProfile> getMember( ) {
    return member;
  }

  public void setMember( final ArrayList<ContentTypeProfile> member ) {
    this.member = member;
  }
}
