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



public class FilterLogEventsResponseType extends CloudwatchlogsMessage {


  private java.util.ArrayList<FilteredLogEvent> events;
  @FieldRange(min=1)
  private String nextToken;
  private java.util.ArrayList<SearchedLogStream> searchedLogStreams;

  @com.fasterxml.jackson.annotation.JsonProperty("events")
  public java.util.ArrayList<FilteredLogEvent> getEvents( ) {
    return events;
  }

  public void setEvents( final java.util.ArrayList<FilteredLogEvent> events ) {
    this.events = events;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("nextToken")
  public String getNextToken( ) {
    return nextToken;
  }

  public void setNextToken( final String nextToken ) {
    this.nextToken = nextToken;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("searchedLogStreams")
  public java.util.ArrayList<SearchedLogStream> getSearchedLogStreams( ) {
    return searchedLogStreams;
  }

  public void setSearchedLogStreams( final java.util.ArrayList<SearchedLogStream> searchedLogStreams ) {
    this.searchedLogStreams = searchedLogStreams;
  }

}
