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
public class PutDestinationType extends CloudwatchlogsMessage {

  @Nonnull
  @FieldRange(min=1, max=512)
  private String destinationName;
  @Nonnull
  @FieldRange(min=1)
  private String roleArn;
  @Nonnull
  @FieldRange(min=1)
  private String targetArn;

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
