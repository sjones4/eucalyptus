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
import com.eucalyptus.binding.HttpHeaderMapping;
import com.eucalyptus.binding.HttpNoContent;
import com.eucalyptus.cloudtrail.common.CloudtrailMessageValidation.FieldRange;
import com.eucalyptus.cloudtrail.common.CloudtrailMessageValidation.FieldRegex;
import com.eucalyptus.cloudtrail.common.CloudtrailMessageValidation.FieldRegexValue;



public class DescribeTrailsResponseType extends CloudtrailMessage {


  private java.util.ArrayList<Trail> trailList;

  @com.fasterxml.jackson.annotation.JsonProperty("trailList")
  public java.util.ArrayList<Trail> getTrailList( ) {
    return trailList;
  }

  public void setTrailList( final java.util.ArrayList<Trail> trailList ) {
    this.trailList = trailList;
  }

}
