/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudtrail.common.msgs;

import javax.annotation.Nonnull;
import com.eucalyptus.binding.HttpContent;
import com.eucalyptus.binding.HttpNoContent;
import com.eucalyptus.binding.HttpHeaderMapping;
import com.eucalyptus.binding.HttpParameterMapping;
import com.eucalyptus.binding.HttpRequestMapping;
import com.eucalyptus.binding.HttpUriMapping;
import com.eucalyptus.cloudtrail.common.CloudtrailMessageValidation.FieldRange;
import com.eucalyptus.cloudtrail.common.CloudtrailMessageValidation.FieldRegex;
import com.eucalyptus.cloudtrail.common.CloudtrailMessageValidation.FieldRegexValue;



@HttpRequestMapping(method="POST", uri="/")
public class DescribeTrailsType extends CloudtrailMessage {

  private Boolean includeShadowTrails;
  private java.util.ArrayList<String> trailNameList;

  @com.fasterxml.jackson.annotation.JsonProperty("includeShadowTrails")
  public Boolean getIncludeShadowTrails( ) {
    return includeShadowTrails;
  }

  public void setIncludeShadowTrails( final Boolean includeShadowTrails ) {
    this.includeShadowTrails = includeShadowTrails;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("trailNameList")
  public java.util.ArrayList<String> getTrailNameList( ) {
    return trailNameList;
  }

  public void setTrailNameList( final java.util.ArrayList<String> trailNameList ) {
    this.trailNameList = trailNameList;
  }

}
