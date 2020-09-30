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



public class DescribeLogStreamsResponseType extends CloudwatchlogsMessage {


  private java.util.ArrayList<LogStream> logStreams;
  @FieldRange(min=1)
  private String nextToken;

  @com.fasterxml.jackson.annotation.JsonProperty("logStreams")
  public java.util.ArrayList<LogStream> getLogStreams( ) {
    return logStreams;
  }

  public void setLogStreams( final java.util.ArrayList<LogStream> logStreams ) {
    this.logStreams = logStreams;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("nextToken")
  public String getNextToken( ) {
    return nextToken;
  }

  public void setNextToken( final String nextToken ) {
    this.nextToken = nextToken;
  }

}
