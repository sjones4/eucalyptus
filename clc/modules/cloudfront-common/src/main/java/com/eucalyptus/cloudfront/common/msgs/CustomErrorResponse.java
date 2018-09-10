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


public class CustomErrorResponse extends EucalyptusData {

  private Long errorCachingMinTTL;
  @Nonnull
  private Integer errorCode;
  private String responseCode;
  private String responsePagePath;

  public Long getErrorCachingMinTTL( ) {
    return errorCachingMinTTL;
  }

  public void setErrorCachingMinTTL( final Long errorCachingMinTTL ) {
    this.errorCachingMinTTL = errorCachingMinTTL;
  }

  public Integer getErrorCode( ) {
    return errorCode;
  }

  public void setErrorCode( final Integer errorCode ) {
    this.errorCode = errorCode;
  }

  public String getResponseCode( ) {
    return responseCode;
  }

  public void setResponseCode( final String responseCode ) {
    this.responseCode = responseCode;
  }

  public String getResponsePagePath( ) {
    return responsePagePath;
  }

  public void setResponsePagePath( final String responsePagePath ) {
    this.responsePagePath = responsePagePath;
  }

}
