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


public class DefaultCacheBehavior extends EucalyptusData {

  private AllowedMethods allowedMethods;
  private Boolean compress;
  private Long defaultTTL;
  private String fieldLevelEncryptionId;
  @Nonnull
  private ForwardedValues forwardedValues;
  private LambdaFunctionAssociations lambdaFunctionAssociations;
  private Long maxTTL;
  @Nonnull
  private Long minTTL;
  private Boolean smoothStreaming;
  @Nonnull
  private String targetOriginId;
  @Nonnull
  private TrustedSigners trustedSigners;
  @Nonnull
  @FieldRegex(FieldRegexValue.ENUM_VIEWERPROTOCOLPOLICY)
  private String viewerProtocolPolicy;

  public AllowedMethods getAllowedMethods( ) {
    return allowedMethods;
  }

  public void setAllowedMethods( final AllowedMethods allowedMethods ) {
    this.allowedMethods = allowedMethods;
  }

  public Boolean getCompress( ) {
    return compress;
  }

  public void setCompress( final Boolean compress ) {
    this.compress = compress;
  }

  public Long getDefaultTTL( ) {
    return defaultTTL;
  }

  public void setDefaultTTL( final Long defaultTTL ) {
    this.defaultTTL = defaultTTL;
  }

  public String getFieldLevelEncryptionId( ) {
    return fieldLevelEncryptionId;
  }

  public void setFieldLevelEncryptionId( final String fieldLevelEncryptionId ) {
    this.fieldLevelEncryptionId = fieldLevelEncryptionId;
  }

  public ForwardedValues getForwardedValues( ) {
    return forwardedValues;
  }

  public void setForwardedValues( final ForwardedValues forwardedValues ) {
    this.forwardedValues = forwardedValues;
  }

  public LambdaFunctionAssociations getLambdaFunctionAssociations( ) {
    return lambdaFunctionAssociations;
  }

  public void setLambdaFunctionAssociations( final LambdaFunctionAssociations lambdaFunctionAssociations ) {
    this.lambdaFunctionAssociations = lambdaFunctionAssociations;
  }

  public Long getMaxTTL( ) {
    return maxTTL;
  }

  public void setMaxTTL( final Long maxTTL ) {
    this.maxTTL = maxTTL;
  }

  public Long getMinTTL( ) {
    return minTTL;
  }

  public void setMinTTL( final Long minTTL ) {
    this.minTTL = minTTL;
  }

  public Boolean getSmoothStreaming( ) {
    return smoothStreaming;
  }

  public void setSmoothStreaming( final Boolean smoothStreaming ) {
    this.smoothStreaming = smoothStreaming;
  }

  public String getTargetOriginId( ) {
    return targetOriginId;
  }

  public void setTargetOriginId( final String targetOriginId ) {
    this.targetOriginId = targetOriginId;
  }

  public TrustedSigners getTrustedSigners( ) {
    return trustedSigners;
  }

  public void setTrustedSigners( final TrustedSigners trustedSigners ) {
    this.trustedSigners = trustedSigners;
  }

  public String getViewerProtocolPolicy( ) {
    return viewerProtocolPolicy;
  }

  public void setViewerProtocolPolicy( final String viewerProtocolPolicy ) {
    this.viewerProtocolPolicy = viewerProtocolPolicy;
  }

}
