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


public class DistributionConfig extends EucalyptusData {

  private Aliases aliases;
  private CacheBehaviors cacheBehaviors;
  @Nonnull
  private String callerReference;
  @Nonnull
  private String comment;
  private CustomErrorResponses customErrorResponses;
  @Nonnull
  private DefaultCacheBehavior defaultCacheBehavior;
  private String defaultRootObject;
  @Nonnull
  private Boolean enabled;
  @FieldRegex(FieldRegexValue.ENUM_HTTPVERSION)
  private String httpVersion;
  private Boolean isIPV6Enabled;
  private LoggingConfig logging;
  @Nonnull
  private Origins origins;
  @FieldRegex(FieldRegexValue.ENUM_PRICECLASS)
  private String priceClass;
  private Restrictions restrictions;
  private ViewerCertificate viewerCertificate;
  private String webACLId;

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

  public String getDefaultRootObject( ) {
    return defaultRootObject;
  }

  public void setDefaultRootObject( final String defaultRootObject ) {
    this.defaultRootObject = defaultRootObject;
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

  public Boolean getIsIPV6Enabled( ) {
    return isIPV6Enabled;
  }

  public void setIsIPV6Enabled( final Boolean isIPV6Enabled ) {
    this.isIPV6Enabled = isIPV6Enabled;
  }

  public LoggingConfig getLogging( ) {
    return logging;
  }

  public void setLogging( final LoggingConfig logging ) {
    this.logging = logging;
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
