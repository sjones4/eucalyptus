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


public class MetricTransformation extends EucalyptusData {

  private Double defaultValue;
  @Nonnull
  @FieldRange(max=255)
  private String metricName;
  @Nonnull
  @FieldRange(max=255)
  private String metricNamespace;
  @Nonnull
  @FieldRange(max=100)
  private String metricValue;

  @com.fasterxml.jackson.annotation.JsonProperty("defaultValue")
  public Double getDefaultValue( ) {
    return defaultValue;
  }

  public void setDefaultValue( final Double defaultValue ) {
    this.defaultValue = defaultValue;
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

  @com.fasterxml.jackson.annotation.JsonProperty("metricValue")
  public String getMetricValue( ) {
    return metricValue;
  }

  public void setMetricValue( final String metricValue ) {
    this.metricValue = metricValue;
  }

}
