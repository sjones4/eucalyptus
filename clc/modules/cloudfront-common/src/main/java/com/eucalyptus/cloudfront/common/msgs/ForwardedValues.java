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


public class ForwardedValues extends EucalyptusData {

  @Nonnull
  private CookiePreference cookies;
  private Headers headers;
  @Nonnull
  private Boolean queryString;
  private QueryStringCacheKeys queryStringCacheKeys;

  public CookiePreference getCookies( ) {
    return cookies;
  }

  public void setCookies( final CookiePreference cookies ) {
    this.cookies = cookies;
  }

  public Headers getHeaders( ) {
    return headers;
  }

  public void setHeaders( final Headers headers ) {
    this.headers = headers;
  }

  public Boolean getQueryString( ) {
    return queryString;
  }

  public void setQueryString( final Boolean queryString ) {
    this.queryString = queryString;
  }

  public QueryStringCacheKeys getQueryStringCacheKeys( ) {
    return queryStringCacheKeys;
  }

  public void setQueryStringCacheKeys( final QueryStringCacheKeys queryStringCacheKeys ) {
    this.queryStringCacheKeys = queryStringCacheKeys;
  }

}
