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
public class PutLogEventsType extends CloudwatchlogsMessage {

  @Nonnull
  @FieldRange(min=1, max=10000)
  private java.util.ArrayList<InputLogEvent> logEvents;
  @Nonnull
  @FieldRange(min=1, max=512)
  private String logGroupName;
  @Nonnull
  @FieldRange(min=1, max=512)
  private String logStreamName;
  @FieldRange(min=1)
  private String sequenceToken;

  @com.fasterxml.jackson.annotation.JsonProperty("logEvents")
  public java.util.ArrayList<InputLogEvent> getLogEvents( ) {
    return logEvents;
  }

  public void setLogEvents( final java.util.ArrayList<InputLogEvent> logEvents ) {
    this.logEvents = logEvents;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("logGroupName")
  public String getLogGroupName( ) {
    return logGroupName;
  }

  public void setLogGroupName( final String logGroupName ) {
    this.logGroupName = logGroupName;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("logStreamName")
  public String getLogStreamName( ) {
    return logStreamName;
  }

  public void setLogStreamName( final String logStreamName ) {
    this.logStreamName = logStreamName;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("sequenceToken")
  public String getSequenceToken( ) {
    return sequenceToken;
  }

  public void setSequenceToken( final String sequenceToken ) {
    this.sequenceToken = sequenceToken;
  }

}
