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
public class TestMetricFilterType extends CloudwatchlogsMessage {

  @Nonnull
  @FieldRange(max=1024)
  private String filterPattern;
  @Nonnull
  @FieldRange(min=1, max=50)
  private java.util.ArrayList<String> logEventMessages;

  @com.fasterxml.jackson.annotation.JsonProperty("filterPattern")
  public String getFilterPattern( ) {
    return filterPattern;
  }

  public void setFilterPattern( final String filterPattern ) {
    this.filterPattern = filterPattern;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("logEventMessages")
  public java.util.ArrayList<String> getLogEventMessages( ) {
    return logEventMessages;
  }

  public void setLogEventMessages( final java.util.ArrayList<String> logEventMessages ) {
    this.logEventMessages = logEventMessages;
  }

}
