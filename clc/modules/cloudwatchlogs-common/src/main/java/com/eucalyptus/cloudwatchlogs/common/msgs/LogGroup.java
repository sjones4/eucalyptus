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


public class LogGroup extends EucalyptusData {

  private String arn;
  @FieldRange()
  private Long creationTime;
  @FieldRange(max=256)
  private String kmsKeyId;
  @FieldRange(min=1, max=512)
  private String logGroupName;
  private Integer metricFilterCount;
  private Integer retentionInDays;
  @FieldRange()
  private Long storedBytes;

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

  @com.fasterxml.jackson.annotation.JsonProperty("kmsKeyId")
  public String getKmsKeyId( ) {
    return kmsKeyId;
  }

  public void setKmsKeyId( final String kmsKeyId ) {
    this.kmsKeyId = kmsKeyId;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("logGroupName")
  public String getLogGroupName( ) {
    return logGroupName;
  }

  public void setLogGroupName( final String logGroupName ) {
    this.logGroupName = logGroupName;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("metricFilterCount")
  public Integer getMetricFilterCount( ) {
    return metricFilterCount;
  }

  public void setMetricFilterCount( final Integer metricFilterCount ) {
    this.metricFilterCount = metricFilterCount;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("retentionInDays")
  public Integer getRetentionInDays( ) {
    return retentionInDays;
  }

  public void setRetentionInDays( final Integer retentionInDays ) {
    this.retentionInDays = retentionInDays;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("storedBytes")
  public Long getStoredBytes( ) {
    return storedBytes;
  }

  public void setStoredBytes( final Long storedBytes ) {
    this.storedBytes = storedBytes;
  }

}
