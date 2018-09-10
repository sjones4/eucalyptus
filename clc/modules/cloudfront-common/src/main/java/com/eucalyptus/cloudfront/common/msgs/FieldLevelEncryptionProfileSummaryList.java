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


public class FieldLevelEncryptionProfileSummaryList extends EucalyptusData {

  private ArrayList<FieldLevelEncryptionProfileSummary> member = new ArrayList<>();

  public ArrayList<FieldLevelEncryptionProfileSummary> getMember( ) {
    return member;
  }

  public void setMember( final ArrayList<FieldLevelEncryptionProfileSummary> member ) {
    this.member = member;
  }
}
