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


public class Origin extends EucalyptusData {

  private CustomHeaders customHeaders;
  private CustomOriginConfig customOriginConfig;
  @Nonnull
  private String domainName;
  @Nonnull
  private String id;
  private String originPath;
  private S3OriginConfig s3OriginConfig;

  public CustomHeaders getCustomHeaders( ) {
    return customHeaders;
  }

  public void setCustomHeaders( final CustomHeaders customHeaders ) {
    this.customHeaders = customHeaders;
  }

  public CustomOriginConfig getCustomOriginConfig( ) {
    return customOriginConfig;
  }

  public void setCustomOriginConfig( final CustomOriginConfig customOriginConfig ) {
    this.customOriginConfig = customOriginConfig;
  }

  public String getDomainName( ) {
    return domainName;
  }

  public void setDomainName( final String domainName ) {
    this.domainName = domainName;
  }

  public String getId( ) {
    return id;
  }

  public void setId( final String id ) {
    this.id = id;
  }

  public String getOriginPath( ) {
    return originPath;
  }

  public void setOriginPath( final String originPath ) {
    this.originPath = originPath;
  }

  public S3OriginConfig getS3OriginConfig( ) {
    return s3OriginConfig;
  }

  public void setS3OriginConfig( final S3OriginConfig s3OriginConfig ) {
    this.s3OriginConfig = s3OriginConfig;
  }

}
