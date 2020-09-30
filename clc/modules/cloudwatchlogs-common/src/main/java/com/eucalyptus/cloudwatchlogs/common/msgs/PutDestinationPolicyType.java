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
public class PutDestinationPolicyType extends CloudwatchlogsMessage {

  @Nonnull
  @FieldRange(min=1)
  private String accessPolicy;
  @Nonnull
  @FieldRange(min=1, max=512)
  private String destinationName;

  @com.fasterxml.jackson.annotation.JsonProperty("accessPolicy")
  public String getAccessPolicy( ) {
    return accessPolicy;
  }

  public void setAccessPolicy( final String accessPolicy ) {
    this.accessPolicy = accessPolicy;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("destinationName")
  public String getDestinationName( ) {
    return destinationName;
  }

  public void setDestinationName( final String destinationName ) {
    this.destinationName = destinationName;
  }

}
