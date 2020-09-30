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


public class LogStream extends EucalyptusData {

  private String arn;
  @FieldRange()
  private Long creationTime;
  @FieldRange()
  private Long firstEventTimestamp;
  @FieldRange()
  private Long lastEventTimestamp;
  @FieldRange()
  private Long lastIngestionTime;
  @FieldRange(min=1, max=512)
  private String logStreamName;
  @FieldRange()
  private Long storedBytes;
  @FieldRange(min=1)
  private String uploadSequenceToken;

  @com.fasterxml.jackson.annotation.JsonProperty("arn")
  public String getArn( ) {
    return arn;
  }

  public void setArn( final String arn ) {
    this.arn = arn;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("creationTime")
  public Long getCreationTime( ) {
    return creationTime;
  }

  public void setCreationTime( final Long creationTime ) {
    this.creationTime = creationTime;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("firstEventTimestamp")
  public Long getFirstEventTimestamp( ) {
    return firstEventTimestamp;
  }

  public void setFirstEventTimestamp( final Long firstEventTimestamp ) {
    this.firstEventTimestamp = firstEventTimestamp;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("lastEventTimestamp")
  public Long getLastEventTimestamp( ) {
    return lastEventTimestamp;
  }

  public void setLastEventTimestamp( final Long lastEventTimestamp ) {
    this.lastEventTimestamp = lastEventTimestamp;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("lastIngestionTime")
  public Long getLastIngestionTime( ) {
    return lastIngestionTime;
  }

  public void setLastIngestionTime( final Long lastIngestionTime ) {
    this.lastIngestionTime = lastIngestionTime;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("logStreamName")
  public String getLogStreamName( ) {
    return logStreamName;
  }

  public void setLogStreamName( final String logStreamName ) {
    this.logStreamName = logStreamName;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("storedBytes")
  public Long getStoredBytes( ) {
    return storedBytes;
  }

  public void setStoredBytes( final Long storedBytes ) {
    this.storedBytes = storedBytes;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("uploadSequenceToken")
  public String getUploadSequenceToken( ) {
    return uploadSequenceToken;
  }

  public void setUploadSequenceToken( final String uploadSequenceToken ) {
    this.uploadSequenceToken = uploadSequenceToken;
  }

}
