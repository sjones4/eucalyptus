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
public class DescribeLogGroupsType extends CloudwatchlogsMessage {

  @FieldRange(min=1, max=50)
  private Integer limit;
  @FieldRange(min=1, max=512)
  private String logGroupNamePrefix;
  @FieldRange(min=1)
  private String nextToken;

  @com.fasterxml.jackson.annotation.JsonProperty("limit")
  public Integer getLimit( ) {
    return limit;
  }

  public void setLimit( final Integer limit ) {
    this.limit = limit;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("logGroupNamePrefix")
  public String getLogGroupNamePrefix( ) {
    return logGroupNamePrefix;
  }

  public void setLogGroupNamePrefix( final String logGroupNamePrefix ) {
    this.logGroupNamePrefix = logGroupNamePrefix;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("nextToken")
  public String getNextToken( ) {
    return nextToken;
  }

  public void setNextToken( final String nextToken ) {
    this.nextToken = nextToken;
  }

}
