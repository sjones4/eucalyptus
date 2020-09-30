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
public class DescribeMetricFiltersType extends CloudwatchlogsMessage {

  @FieldRange(min=1, max=512)
  private String filterNamePrefix;
  @FieldRange(min=1, max=50)
  private Integer limit;
  @FieldRange(min=1, max=512)
  private String logGroupName;
  @FieldRange(max=255)
  private String metricName;
  @FieldRange(max=255)
  private String metricNamespace;
  @FieldRange(min=1)
  private String nextToken;

  @com.fasterxml.jackson.annotation.JsonProperty("filterNamePrefix")
  public String getFilterNamePrefix( ) {
    return filterNamePrefix;
  }

  public void setFilterNamePrefix( final String filterNamePrefix ) {
    this.filterNamePrefix = filterNamePrefix;
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

  @com.fasterxml.jackson.annotation.JsonProperty("metricName")
  public String getMetricName( ) {
    return metricName;
  }

  public void setMetricName( final String metricName ) {
    this.metricName = metricName;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("metricNamespace")
  public String getMetricNamespace( ) {
    return metricNamespace;
  }

  public void setMetricNamespace( final String metricNamespace ) {
    this.metricNamespace = metricNamespace;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("nextToken")
  public String getNextToken( ) {
    return nextToken;
  }

  public void setNextToken( final String nextToken ) {
    this.nextToken = nextToken;
  }

}
