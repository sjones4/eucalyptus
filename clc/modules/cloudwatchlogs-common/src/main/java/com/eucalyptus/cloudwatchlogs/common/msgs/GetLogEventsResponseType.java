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
import com.eucalyptus.binding.HttpHeaderMapping;
import com.eucalyptus.binding.HttpNoContent;
import com.eucalyptus.cloudwatchlogs.common.CloudwatchlogsMessageValidation.FieldRange;
import com.eucalyptus.cloudwatchlogs.common.CloudwatchlogsMessageValidation.FieldRegex;
import com.eucalyptus.cloudwatchlogs.common.CloudwatchlogsMessageValidation.FieldRegexValue;



public class GetLogEventsResponseType extends CloudwatchlogsMessage {


  private java.util.ArrayList<OutputLogEvent> events;
  @FieldRange(min=1)
  private String nextBackwardToken;
  @FieldRange(min=1)
  private String nextForwardToken;

  @com.fasterxml.jackson.annotation.JsonProperty("events")
  public java.util.ArrayList<OutputLogEvent> getEvents( ) {
    return events;
  }

  public void setEvents( final java.util.ArrayList<OutputLogEvent> events ) {
    this.events = events;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("nextBackwardToken")
  public String getNextBackwardToken( ) {
    return nextBackwardToken;
  }

  public void setNextBackwardToken( final String nextBackwardToken ) {
    this.nextBackwardToken = nextBackwardToken;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("nextForwardToken")
  public String getNextForwardToken( ) {
    return nextForwardToken;
  }

  public void setNextForwardToken( final String nextForwardToken ) {
    this.nextForwardToken = nextForwardToken;
  }

}
