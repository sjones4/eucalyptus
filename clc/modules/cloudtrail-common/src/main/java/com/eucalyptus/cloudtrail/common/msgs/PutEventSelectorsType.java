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
public class PutEventSelectorsType extends CloudtrailMessage {

  @Nonnull
  private java.util.ArrayList<EventSelector> eventSelectors;
  @Nonnull
  private String trailName;

  public java.util.ArrayList<EventSelector> getEventSelectors( ) {
    return eventSelectors;
  }

  public void setEventSelectors( final java.util.ArrayList<EventSelector> eventSelectors ) {
    this.eventSelectors = eventSelectors;
  }

  public String getTrailName( ) {
    return trailName;
  }

  public void setTrailName( final String trailName ) {
    this.trailName = trailName;
  }

}
