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


public class MetricFilter extends EucalyptusData {

  @FieldRange()
  private Long creationTime;
  @FieldRange(min=1, max=512)
  private String filterName;
  @FieldRange(max=1024)
  private String filterPattern;
  @FieldRange(min=1, max=512)
  private String logGroupName;
  @FieldRange(min=1, max=1)
  private java.util.ArrayList<MetricTransformation> metricTransformations;

  @com.fasterxml.jackson.annotation.JsonProperty("creationTime")
  public Long getCreationTime( ) {
    return creationTime;
  }

  public void setCreationTime( final Long creationTime ) {
    this.creationTime = creationTime;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("filterName")
  public String getFilterName( ) {
    return filterName;
  }

  public void setFilterName( final String filterName ) {
    this.filterName = filterName;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("filterPattern")
  public String getFilterPattern( ) {
    return filterPattern;
  }

  public void setFilterPattern( final String filterPattern ) {
    this.filterPattern = filterPattern;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("logGroupName")
  public String getLogGroupName( ) {
    return logGroupName;
  }

  public void setLogGroupName( final String logGroupName ) {
    this.logGroupName = logGroupName;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("metricTransformations")
  public java.util.ArrayList<MetricTransformation> getMetricTransformations( ) {
    return metricTransformations;
  }

  public void setMetricTransformations( final java.util.ArrayList<MetricTransformation> metricTransformations ) {
    this.metricTransformations = metricTransformations;
  }

}
