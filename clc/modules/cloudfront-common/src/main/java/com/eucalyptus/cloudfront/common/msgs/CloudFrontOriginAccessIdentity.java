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


public class CloudFrontOriginAccessIdentity extends EucalyptusData {

  private CloudFrontOriginAccessIdentityConfig cloudFrontOriginAccessIdentityConfig;
  @Nonnull
  private String id;
  @Nonnull
  private String s3CanonicalUserId;

  public CloudFrontOriginAccessIdentityConfig getCloudFrontOriginAccessIdentityConfig( ) {
    return cloudFrontOriginAccessIdentityConfig;
  }

  public void setCloudFrontOriginAccessIdentityConfig( final CloudFrontOriginAccessIdentityConfig cloudFrontOriginAccessIdentityConfig ) {
    this.cloudFrontOriginAccessIdentityConfig = cloudFrontOriginAccessIdentityConfig;
  }

  public String getId( ) {
    return id;
  }

  public void setId( final String id ) {
    this.id = id;
  }

  public String getS3CanonicalUserId( ) {
    return s3CanonicalUserId;
  }

  public void setS3CanonicalUserId( final String s3CanonicalUserId ) {
    this.s3CanonicalUserId = s3CanonicalUserId;
  }

}
