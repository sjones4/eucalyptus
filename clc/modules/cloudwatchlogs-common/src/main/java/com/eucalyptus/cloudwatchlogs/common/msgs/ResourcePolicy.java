/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudwatchlogs.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;
import javax.annotation.Nonnull;
import com.eucalyptus.cloudwatchlogs.common.CloudwatchlogsMessageValidation.FieldRange;
import com.eucalyptus.cloudwatchlogs.common.CloudwatchlogsMessageValidation.FieldRegex;
import com.eucalyptus.cloudwatchlogs.common.CloudwatchlogsMessageValidation.FieldRegexValue;


public class ResourcePolicy extends EucalyptusData {

  @FieldRange()
  private Long lastUpdatedTime;
  @FieldRange(min=1, max=5120)
  private String policyDocument;
  private String policyName;

  @com.fasterxml.jackson.annotation.JsonProperty("lastUpdatedTime")
  public Long getLastUpdatedTime( ) {
    return lastUpdatedTime;
  }

  public void setLastUpdatedTime( final Long lastUpdatedTime ) {
    this.lastUpdatedTime = lastUpdatedTime;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("policyDocument")
  public String getPolicyDocument( ) {
    return policyDocument;
  }

  public void setPolicyDocument( final String policyDocument ) {
    this.policyDocument = policyDocument;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("policyName")
  public String getPolicyName( ) {
    return policyName;
  }

  public void setPolicyName( final String policyName ) {
    this.policyName = policyName;
  }

}
