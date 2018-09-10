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


public class UserPendingChanges extends EucalyptusData {

  private Boolean consoleAccess;
  private java.util.ArrayList<String> groups;
  @FieldRegex(FieldRegexValue.ENUM_CHANGETYPE)
  private String pendingChange;

  public Boolean getConsoleAccess( ) {
    return consoleAccess;
  }

  public void setConsoleAccess( final Boolean consoleAccess ) {
    this.consoleAccess = consoleAccess;
  }

  public java.util.ArrayList<String> getGroups( ) {
    return groups;
  }

  public void setGroups( final java.util.ArrayList<String> groups ) {
    this.groups = groups;
  }

  public String getPendingChange( ) {
    return pendingChange;
  }

  public void setPendingChange( final String pendingChange ) {
    this.pendingChange = pendingChange;
  }

}
