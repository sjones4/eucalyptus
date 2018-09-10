/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudfront.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;
import javax.annotation.Nonnull;
import com.eucalyptus.cloudfront.common.CloudfrontMessageValidation.FieldRange;
import com.eucalyptus.cloudfront.common.CloudfrontMessageValidation.FieldRegex;
import com.eucalyptus.cloudfront.common.CloudfrontMessageValidation.FieldRegexValue;


public class LambdaFunctionAssociation extends EucalyptusData {

  @Nonnull
  @FieldRegex(FieldRegexValue.ENUM_EVENTTYPE)
  private String eventType;
  private Boolean includeBody;
  @Nonnull
  private String lambdaFunctionARN;

  public String getEventType( ) {
    return eventType;
  }

  public void setEventType( final String eventType ) {
    this.eventType = eventType;
  }

  public Boolean getIncludeBody( ) {
    return includeBody;
  }

  public void setIncludeBody( final Boolean includeBody ) {
    this.includeBody = includeBody;
  }

  public String getLambdaFunctionARN( ) {
    return lambdaFunctionARN;
  }

  public void setLambdaFunctionARN( final String lambdaFunctionARN ) {
    this.lambdaFunctionARN = lambdaFunctionARN;
  }

}
