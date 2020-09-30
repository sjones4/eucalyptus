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
public class CreateLogGroupType extends CloudwatchlogsMessage {

  @FieldRange(max=256)
  private String kmsKeyId;
  @Nonnull
  @FieldRange(min=1, max=512)
  private String logGroupName;
  @FieldRange(min=1, max=50)
  private Tags tags;

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

  @com.fasterxml.jackson.annotation.JsonProperty("tags")
  public Tags getTags( ) {
    return tags;
  }

  public void setTags( final Tags tags ) {
    this.tags = tags;
  }

}
