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


public class Distribution extends EucalyptusData {

  @Nonnull
  private String aRN;
  @Nonnull
  private ActiveTrustedSigners activeTrustedSigners;
  @Nonnull
  private DistributionConfig distributionConfig;
  @Nonnull
  private String domainName;
  @Nonnull
  private String id;
  @Nonnull
  private Integer inProgressInvalidationBatches;
  @Nonnull
  private java.util.Date lastModifiedTime;
  @Nonnull
  private String status;

  public String getARN( ) {
    return aRN;
  }

  public void setARN( final String aRN ) {
    this.aRN = aRN;
  }

  public ActiveTrustedSigners getActiveTrustedSigners( ) {
    return activeTrustedSigners;
  }

  public void setActiveTrustedSigners( final ActiveTrustedSigners activeTrustedSigners ) {
    this.activeTrustedSigners = activeTrustedSigners;
  }

  public DistributionConfig getDistributionConfig( ) {
    return distributionConfig;
  }

  public void setDistributionConfig( final DistributionConfig distributionConfig ) {
    this.distributionConfig = distributionConfig;
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

  public Integer getInProgressInvalidationBatches( ) {
    return inProgressInvalidationBatches;
  }

  public void setInProgressInvalidationBatches( final Integer inProgressInvalidationBatches ) {
    this.inProgressInvalidationBatches = inProgressInvalidationBatches;
  }

  public java.util.Date getLastModifiedTime( ) {
    return lastModifiedTime;
  }

  public void setLastModifiedTime( final java.util.Date lastModifiedTime ) {
    this.lastModifiedTime = lastModifiedTime;
  }

  public String getStatus( ) {
    return status;
  }

  public void setStatus( final String status ) {
    this.status = status;
  }

}
