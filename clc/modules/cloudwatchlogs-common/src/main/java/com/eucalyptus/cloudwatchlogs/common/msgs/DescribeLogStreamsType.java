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
public class DescribeLogStreamsType extends CloudwatchlogsMessage {

  private Boolean descending;
  @FieldRange(min=1, max=50)
  private Integer limit;
  @Nonnull
  @FieldRange(min=1, max=512)
  private String logGroupName;
  @FieldRange(min=1, max=512)
  private String logStreamNamePrefix;
  @FieldRange(min=1)
  private String nextToken;
  @FieldRegex(FieldRegexValue.ENUM_ORDERBY)
  private String orderBy;

  @com.fasterxml.jackson.annotation.JsonProperty("descending")
  public Boolean getDescending( ) {
    return descending;
  }

  public void setDescending( final Boolean descending ) {
    this.descending = descending;
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

  @com.fasterxml.jackson.annotation.JsonProperty("nextToken")
  public String getNextToken( ) {
    return nextToken;
  }

  public void setNextToken( final String nextToken ) {
    this.nextToken = nextToken;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("orderBy")
  public String getOrderBy( ) {
    return orderBy;
  }

  public void setOrderBy( final String orderBy ) {
    this.orderBy = orderBy;
  }

}
