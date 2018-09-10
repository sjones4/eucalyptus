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


public class CustomOriginConfig extends EucalyptusData {

  @Nonnull
  private Integer hTTPPort;
  @Nonnull
  private Integer hTTPSPort;
  private Integer originKeepaliveTimeout;
  @Nonnull
  @FieldRegex(FieldRegexValue.ENUM_ORIGINPROTOCOLPOLICY)
  private String originProtocolPolicy;
  private Integer originReadTimeout;
  private OriginSslProtocols originSslProtocols;

  public Integer getHTTPPort( ) {
    return hTTPPort;
  }

  public void setHTTPPort( final Integer hTTPPort ) {
    this.hTTPPort = hTTPPort;
  }

  public Integer getHTTPSPort( ) {
    return hTTPSPort;
  }

  public void setHTTPSPort( final Integer hTTPSPort ) {
    this.hTTPSPort = hTTPSPort;
  }

  public Integer getOriginKeepaliveTimeout( ) {
    return originKeepaliveTimeout;
  }

  public void setOriginKeepaliveTimeout( final Integer originKeepaliveTimeout ) {
    this.originKeepaliveTimeout = originKeepaliveTimeout;
  }

  public String getOriginProtocolPolicy( ) {
    return originProtocolPolicy;
  }

  public void setOriginProtocolPolicy( final String originProtocolPolicy ) {
    this.originProtocolPolicy = originProtocolPolicy;
  }

  public Integer getOriginReadTimeout( ) {
    return originReadTimeout;
  }

  public void setOriginReadTimeout( final Integer originReadTimeout ) {
    this.originReadTimeout = originReadTimeout;
  }

  public OriginSslProtocols getOriginSslProtocols( ) {
    return originSslProtocols;
  }

  public void setOriginSslProtocols( final OriginSslProtocols originSslProtocols ) {
    this.originSslProtocols = originSslProtocols;
  }

}
