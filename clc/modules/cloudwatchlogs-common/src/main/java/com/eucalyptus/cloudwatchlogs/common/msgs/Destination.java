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


public class Destination extends EucalyptusData {

  @FieldRange(min=1)
  private String accessPolicy;
  private String arn;
  @FieldRange()
  private Long creationTime;
  @FieldRange(min=1, max=512)
  private String destinationName;
  @FieldRange(min=1)
  private String roleArn;
  @FieldRange(min=1)
  private String targetArn;

  @com.fasterxml.jackson.annotation.JsonProperty("accessPolicy")
  public String getAccessPolicy( ) {
    return accessPolicy;
  }

  public void setAccessPolicy( final String accessPolicy ) {
    this.accessPolicy = accessPolicy;
  }

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

  @com.fasterxml.jackson.annotation.JsonProperty("destinationName")
  public String getDestinationName( ) {
    return destinationName;
  }

  public void setDestinationName( final String destinationName ) {
    this.destinationName = destinationName;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("roleArn")
  public String getRoleArn( ) {
    return roleArn;
  }

  public void setRoleArn( final String roleArn ) {
    this.roleArn = roleArn;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("targetArn")
  public String getTargetArn( ) {
    return targetArn;
  }

  public void setTargetArn( final String targetArn ) {
    this.targetArn = targetArn;
  }

}
