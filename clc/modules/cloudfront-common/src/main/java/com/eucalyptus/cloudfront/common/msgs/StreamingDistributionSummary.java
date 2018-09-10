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


public class StreamingDistributionSummary extends EucalyptusData {

  @Nonnull
  private String aRN;
  @Nonnull
  private Aliases aliases;
  @Nonnull
  private String comment;
  @Nonnull
  private String domainName;
  @Nonnull
  private Boolean enabled;
  @Nonnull
  private String id;
  @Nonnull
  private java.util.Date lastModifiedTime;
  @Nonnull
  @FieldRegex(FieldRegexValue.ENUM_PRICECLASS)
  private String priceClass;
  @Nonnull
  private S3Origin s3Origin;
  @Nonnull
  private String status;
  @Nonnull
  private TrustedSigners trustedSigners;

  public String getARN( ) {
    return aRN;
  }

  public void setARN( final String aRN ) {
    this.aRN = aRN;
  }

  public Aliases getAliases( ) {
    return aliases;
  }

  public void setAliases( final Aliases aliases ) {
    this.aliases = aliases;
  }

  public String getComment( ) {
    return comment;
  }

  public void setComment( final String comment ) {
    this.comment = comment;
  }

  public String getDomainName( ) {
    return domainName;
  }

  public void setDomainName( final String domainName ) {
    this.domainName = domainName;
  }

  public Boolean getEnabled( ) {
    return enabled;
  }

  public void setEnabled( final Boolean enabled ) {
    this.enabled = enabled;
  }

  public String getId( ) {
    return id;
  }

  public void setId( final String id ) {
    this.id = id;
  }

  public java.util.Date getLastModifiedTime( ) {
    return lastModifiedTime;
  }

  public void setLastModifiedTime( final java.util.Date lastModifiedTime ) {
    this.lastModifiedTime = lastModifiedTime;
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

  public String getStatus( ) {
    return status;
  }

  public void setStatus( final String status ) {
    this.status = status;
  }

  public TrustedSigners getTrustedSigners( ) {
    return trustedSigners;
  }

  public void setTrustedSigners( final TrustedSigners trustedSigners ) {
    this.trustedSigners = trustedSigners;
  }

}
