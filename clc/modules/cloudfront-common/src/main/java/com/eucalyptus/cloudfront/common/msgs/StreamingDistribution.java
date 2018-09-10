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


public class StreamingDistribution extends EucalyptusData {

  @Nonnull
  private String aRN;
  @Nonnull
  private ActiveTrustedSigners activeTrustedSigners;
  @Nonnull
  private String domainName;
  @Nonnull
  private String id;
  private java.util.Date lastModifiedTime;
  @Nonnull
  private String status;
  @Nonnull
  private StreamingDistributionConfig streamingDistributionConfig;

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

  public StreamingDistributionConfig getStreamingDistributionConfig( ) {
    return streamingDistributionConfig;
  }

  public void setStreamingDistributionConfig( final StreamingDistributionConfig streamingDistributionConfig ) {
    this.streamingDistributionConfig = streamingDistributionConfig;
  }

}
