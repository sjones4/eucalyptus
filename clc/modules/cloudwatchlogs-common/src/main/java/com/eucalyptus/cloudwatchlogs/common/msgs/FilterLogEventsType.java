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
public class FilterLogEventsType extends CloudwatchlogsMessage {

  @FieldRange()
  private Long endTime;
  @FieldRange(max=1024)
  private String filterPattern;
  private Boolean interleaved;
  @FieldRange(min=1, max=10000)
  private Integer limit;
  @Nonnull
  @FieldRange(min=1, max=512)
  private String logGroupName;
  @FieldRange(min=1, max=512)
  private String logStreamNamePrefix;
  @FieldRange(min=1, max=100)
  private java.util.ArrayList<String> logStreamNames;
  @FieldRange(min=1)
  private String nextToken;
  @FieldRange()
  private Long startTime;

  @com.fasterxml.jackson.annotation.JsonProperty("endTime")
  public Long getEndTime( ) {
    return endTime;
  }

  public void setEndTime( final Long endTime ) {
    this.endTime = endTime;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("filterPattern")
  public String getFilterPattern( ) {
    return filterPattern;
  }

  public void setFilterPattern( final String filterPattern ) {
    this.filterPattern = filterPattern;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("interleaved")
  public Boolean getInterleaved( ) {
    return interleaved;
  }

  public void setInterleaved( final Boolean interleaved ) {
    this.interleaved = interleaved;
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

  @com.fasterxml.jackson.annotation.JsonProperty("logStreamNamePrefix")
  public String getLogStreamNamePrefix( ) {
    return logStreamNamePrefix;
  }

  public void setLogStreamNamePrefix( final String logStreamNamePrefix ) {
    this.logStreamNamePrefix = logStreamNamePrefix;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("logStreamNames")
  public java.util.ArrayList<String> getLogStreamNames( ) {
    return logStreamNames;
  }

  public void setLogStreamNames( final java.util.ArrayList<String> logStreamNames ) {
    this.logStreamNames = logStreamNames;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("nextToken")
  public String getNextToken( ) {
    return nextToken;
  }

  public void setNextToken( final String nextToken ) {
    this.nextToken = nextToken;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("startTime")
  public Long getStartTime( ) {
    return startTime;
  }

  public void setStartTime( final Long startTime ) {
    this.startTime = startTime;
  }

}
