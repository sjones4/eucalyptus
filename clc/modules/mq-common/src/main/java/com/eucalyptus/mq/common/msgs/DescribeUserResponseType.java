/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.mq.common.msgs;

import javax.annotation.Nonnull;
import com.eucalyptus.binding.HttpContent;
import com.eucalyptus.binding.HttpHeaderMapping;
import com.eucalyptus.binding.HttpNoContent;
import com.eucalyptus.mq.common.MqMessageValidation.FieldRange;
import com.eucalyptus.mq.common.MqMessageValidation.FieldRegex;
import com.eucalyptus.mq.common.MqMessageValidation.FieldRegexValue;



public class DescribeUserResponseType extends MqMessage {


  private String brokerId;
  private Boolean consoleAccess;
  private java.util.ArrayList<String> groups;
  private UserPendingChanges pending;
  private String username;

  public String getBrokerId( ) {
    return brokerId;
  }

  public void setBrokerId( final String brokerId ) {
    this.brokerId = brokerId;
  }

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

  public UserPendingChanges getPending( ) {
    return pending;
  }

  public void setPending( final UserPendingChanges pending ) {
    this.pending = pending;
  }

  public String getUsername( ) {
    return username;
  }

  public void setUsername( final String username ) {
    this.username = username;
  }

}
