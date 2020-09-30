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
public class CreateExportTaskType extends CloudwatchlogsMessage {

  @Nonnull
  @FieldRange(min=1, max=512)
  private String destination;
  private String destinationPrefix;
  @Nonnull
  @FieldRange()
  private Long from;
  @Nonnull
  @FieldRange(min=1, max=512)
  private String logGroupName;
  @FieldRange(min=1, max=512)
  private String logStreamNamePrefix;
  @FieldRange(min=1, max=512)
  private String taskName;
  @Nonnull
  @FieldRange()
  private Long to;

  @com.fasterxml.jackson.annotation.JsonProperty("destination")
  public String getDestination( ) {
    return destination;
  }

  public void setDestination( final String destination ) {
    this.destination = destination;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("destinationPrefix")
  public String getDestinationPrefix( ) {
    return destinationPrefix;
  }

  public void setDestinationPrefix( final String destinationPrefix ) {
    this.destinationPrefix = destinationPrefix;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("from")
  public Long getFrom( ) {
    return from;
  }

  public void setFrom( final Long from ) {
    this.from = from;
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

  @com.fasterxml.jackson.annotation.JsonProperty("taskName")
  public String getTaskName( ) {
    return taskName;
  }

  public void setTaskName( final String taskName ) {
    this.taskName = taskName;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("to")
  public Long getTo( ) {
    return to;
  }

  public void setTo( final Long to ) {
    this.to = to;
  }

}
