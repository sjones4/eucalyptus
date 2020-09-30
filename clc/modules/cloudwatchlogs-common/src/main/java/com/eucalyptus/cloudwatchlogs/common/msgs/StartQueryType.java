/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudwatchlogs.common.msgs;

import javax.annotation.Nonnull;
import com.eucalyptus.binding.HttpContent;
import com.eucalyptus.binding.HttpNoContent;
import com.eucalyptus.binding.HttpHeaderMapping;
import com.eucalyptus.binding.HttpParameterMapping;
import com.eucalyptus.binding.HttpRequestMapping;
import com.eucalyptus.binding.HttpUriMapping;
import com.eucalyptus.cloudwatchlogs.common.CloudwatchlogsMessageValidation.FieldRange;
import com.eucalyptus.cloudwatchlogs.common.CloudwatchlogsMessageValidation.FieldRegex;
import com.eucalyptus.cloudwatchlogs.common.CloudwatchlogsMessageValidation.FieldRegexValue;



@HttpRequestMapping(method="POST", uri="/")
public class StartQueryType extends CloudwatchlogsMessage {

  @Nonnull
  @FieldRange()
  private Long endTime;
  @FieldRange(min=1, max=10000)
  private Integer limit;
  @FieldRange(min=1, max=512)
  private String logGroupName;
  private java.util.ArrayList<String> logGroupNames;
  @Nonnull
  @FieldRange(max=10000)
  private String queryString;
  @Nonnull
  @FieldRange()
  private Long startTime;

  @com.fasterxml.jackson.annotation.JsonProperty("endTime")
  public Long getEndTime( ) {
    return endTime;
  }

  public void setEndTime( final Long endTime ) {
    this.endTime = endTime;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("limit")
  public Integer getLimit( ) {
    return limit;
  }

  public void setLimit( final Integer limit ) {
    this.limit = limit;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("logGroupName")
  public String getLogGroupName( ) {
    return logGroupName;
  }

  public void setLogGroupName( final String logGroupName ) {
    this.logGroupName = logGroupName;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("logGroupNames")
  public java.util.ArrayList<String> getLogGroupNames( ) {
    return logGroupNames;
  }

  public void setLogGroupNames( final java.util.ArrayList<String> logGroupNames ) {
    this.logGroupNames = logGroupNames;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("queryString")
  public String getQueryString( ) {
    return queryString;
  }

  public void setQueryString( final String queryString ) {
    this.queryString = queryString;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("startTime")
  public Long getStartTime( ) {
    return startTime;
  }

  public void setStartTime( final Long startTime ) {
    this.startTime = startTime;
  }

}
