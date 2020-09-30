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


public class ExportTask extends EucalyptusData {

  @FieldRange(min=1, max=512)
  private String destination;
  private String destinationPrefix;
  private ExportTaskExecutionInfo executionInfo;
  @FieldRange()
  private Long from;
  @FieldRange(min=1, max=512)
  private String logGroupName;
  private ExportTaskStatus status;
  @FieldRange(min=1, max=512)
  private String taskId;
  @FieldRange(min=1, max=512)
  private String taskName;
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

  @com.fasterxml.jackson.annotation.JsonProperty("executionInfo")
  public ExportTaskExecutionInfo getExecutionInfo( ) {
    return executionInfo;
  }

  public void setExecutionInfo( final ExportTaskExecutionInfo executionInfo ) {
    this.executionInfo = executionInfo;
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

  @com.fasterxml.jackson.annotation.JsonProperty("status")
  public ExportTaskStatus getStatus( ) {
    return status;
  }

  public void setStatus( final ExportTaskStatus status ) {
    this.status = status;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("taskId")
  public String getTaskId( ) {
    return taskId;
  }

  public void setTaskId( final String taskId ) {
    this.taskId = taskId;
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
