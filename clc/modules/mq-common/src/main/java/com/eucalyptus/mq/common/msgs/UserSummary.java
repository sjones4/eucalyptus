/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.mq.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;
import javax.annotation.Nonnull;
import com.eucalyptus.mq.common.MqMessageValidation.FieldRange;
import com.eucalyptus.mq.common.MqMessageValidation.FieldRegex;
import com.eucalyptus.mq.common.MqMessageValidation.FieldRegexValue;


public class UserSummary extends EucalyptusData {

  @FieldRegex(FieldRegexValue.ENUM_CHANGETYPE)
  private String pendingChange;
  private String username;

  public String getPendingChange( ) {
    return pendingChange;
  }

  public void setPendingChange( final String pendingChange ) {
    this.pendingChange = pendingChange;
  }

  public String getUsername( ) {
    return username;
  }

  public void setUsername( final String username ) {
    this.username = username;
  }

}
