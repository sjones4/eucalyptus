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


public class CloudFrontOriginAccessIdentitySummary extends EucalyptusData {

  @Nonnull
  private String comment;
  @Nonnull
  private String id;
  @Nonnull
  private String s3CanonicalUserId;

  public String getComment( ) {
    return comment;
  }

  public void setComment( final String comment ) {
    this.comment = comment;
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
