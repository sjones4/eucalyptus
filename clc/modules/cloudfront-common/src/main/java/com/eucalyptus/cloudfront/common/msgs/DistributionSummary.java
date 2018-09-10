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


public class DistributionSummary extends EucalyptusData {

  @Nonnull
  private String aRN;
  @Nonnull
  private Aliases aliases;
  @Nonnull
  private CacheBehaviors cacheBehaviors;
  @Nonnull
  private String comment;
  @Nonnull
  private CustomErrorResponses customErrorResponses;
  @Nonnull
  private DefaultCacheBehavior defaultCacheBehavior;
  @Nonnull
  private String domainName;
  @Nonnull
  private Boolean enabled;
  @Nonnull
  @FieldRegex(FieldRegexValue.ENUM_HTTPVERSION)
  private String httpVersion;
  @Nonnull
  private String id;
  @Nonnull
  private Boolean isIPV6Enabled;
  @Nonnull
  private java.util.Date lastModifiedTime;
  @Nonnull
  private Origins origins;
  @Nonnull
  @FieldRegex(FieldRegexValue.ENUM_PRICECLASS)
  private String priceClass;
  @Nonnull
  private Restrictions restrictions;
  @Nonnull
  private String status;
  @Nonnull
  private ViewerCertificate viewerCertificate;
  @Nonnull
  private String webACLId;

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

  public CacheBehaviors getCacheBehaviors( ) {
    return cacheBehaviors;
  }

  public void setCacheBehaviors( final CacheBehaviors cacheBehaviors ) {
    this.cacheBehaviors = cacheBehaviors;
  }

  public String getComment( ) {
    return comment;
  }

  public void setComment( final String comment ) {
    this.comment = comment;
  }

  public CustomErrorResponses getCustomErrorResponses( ) {
    return customErrorResponses;
  }

  public void setCustomErrorResponses( final CustomErrorResponses customErrorResponses ) {
    this.customErrorResponses = customErrorResponses;
  }

  public DefaultCacheBehavior getDefaultCacheBehavior( ) {
    return defaultCacheBehavior;
  }

  public void setDefaultCacheBehavior( final DefaultCacheBehavior defaultCacheBehavior ) {
    this.defaultCacheBehavior = defaultCacheBehavior;
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

  public String getHttpVersion( ) {
    return httpVersion;
  }

  public void setHttpVersion( final String httpVersion ) {
    this.httpVersion = httpVersion;
  }

  public String getId( ) {
    return id;
  }

  public void setId( final String id ) {
    this.id = id;
  }

  public Boolean getIsIPV6Enabled( ) {
    return isIPV6Enabled;
  }

  public void setIsIPV6Enabled( final Boolean isIPV6Enabled ) {
    this.isIPV6Enabled = isIPV6Enabled;
  }

  public java.util.Date getLastModifiedTime( ) {
    return lastModifiedTime;
  }

  public void setLastModifiedTime( final java.util.Date lastModifiedTime ) {
    this.lastModifiedTime = lastModifiedTime;
  }

  public Origins getOrigins( ) {
    return origins;
  }

  public void setOrigins( final Origins origins ) {
    this.origins = origins;
  }

  public String getPriceClass( ) {
    return priceClass;
  }

  public void setPriceClass( final String priceClass ) {
    this.priceClass = priceClass;
  }

  public Restrictions getRestrictions( ) {
    return restrictions;
  }

  public void setRestrictions( final Restrictions restrictions ) {
    this.restrictions = restrictions;
  }

  public String getStatus( ) {
    return status;
  }

  public void setStatus( final String status ) {
    this.status = status;
  }

  public ViewerCertificate getViewerCertificate( ) {
    return viewerCertificate;
  }

  public void setViewerCertificate( final ViewerCertificate viewerCertificate ) {
    this.viewerCertificate = viewerCertificate;
  }

  public String getWebACLId( ) {
    return webACLId;
  }

  public void setWebACLId( final String webACLId ) {
    this.webACLId = webACLId;
  }

}
