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


public class StreamingDistributionConfig extends EucalyptusData {

  private Aliases aliases;
  @Nonnull
  private String callerReference;
  @Nonnull
  private String comment;
  @Nonnull
  private Boolean enabled;
  private StreamingLoggingConfig logging;
  @FieldRegex(FieldRegexValue.ENUM_PRICECLASS)
  private String priceClass;
  @Nonnull
  private S3Origin s3Origin;
  @Nonnull
  private TrustedSigners trustedSigners;

  public Aliases getAliases( ) {
    return aliases;
  }

  public void setAliases( final Aliases aliases ) {
    this.aliases = aliases;
  }

  public String getCallerReference( ) {
    return callerReference;
  }

  public void setCallerReference( final String callerReference ) {
    this.callerReference = callerReference;
  }

  public String getComment( ) {
    return comment;
  }

  public void setComment( final String comment ) {
    this.comment = comment;
  }

  public Boolean getEnabled( ) {
    return enabled;
  }

  public void setEnabled( final Boolean enabled ) {
    this.enabled = enabled;
  }

  public StreamingLoggingConfig getLogging( ) {
    return logging;
  }

  public void setLogging( final StreamingLoggingConfig logging ) {
    this.logging = logging;
  }

  public String getPriceClass( ) {
    return priceClass;
  }

  public void setPriceClass( final String priceClass ) {
    this.priceClass = priceClass;
  }

  public S3Origin getS3Origin( ) {
    return s3Origin;
  }

  public void setS3Origin( final S3Origin s3Origin ) {
    this.s3Origin = s3Origin;
  }

  public TrustedSigners getTrustedSigners( ) {
    return trustedSigners;
  }

  public void setTrustedSigners( final TrustedSigners trustedSigners ) {
    this.trustedSigners = trustedSigners;
  }

}
