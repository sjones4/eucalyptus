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
public class LookupEventsType extends CloudtrailMessage {

  private java.util.Date endTime;
  private java.util.ArrayList<LookupAttribute> lookupAttributes;
  @FieldRange(min=1, max=50)
  private Integer maxResults;
  private String nextToken;
  private java.util.Date startTime;

  public java.util.Date getEndTime( ) {
    return endTime;
  }

  public void setEndTime( final java.util.Date endTime ) {
    this.endTime = endTime;
  }

  public java.util.ArrayList<LookupAttribute> getLookupAttributes( ) {
    return lookupAttributes;
  }

  public void setLookupAttributes( final java.util.ArrayList<LookupAttribute> lookupAttributes ) {
    this.lookupAttributes = lookupAttributes;
  }

  public Integer getMaxResults( ) {
    return maxResults;
  }

  public void setMaxResults( final Integer maxResults ) {
    this.maxResults = maxResults;
  }

  public String getNextToken( ) {
    return nextToken;
  }

  public void setNextToken( final String nextToken ) {
    this.nextToken = nextToken;
  }

  public java.util.Date getStartTime( ) {
    return startTime;
  }

  public void setStartTime( final java.util.Date startTime ) {
    this.startTime = startTime;
  }

}
