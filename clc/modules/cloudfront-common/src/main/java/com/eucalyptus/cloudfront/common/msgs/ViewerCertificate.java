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


public class ViewerCertificate extends EucalyptusData {

  private String aCMCertificateArn;
  private String certificate;
  @FieldRegex(FieldRegexValue.ENUM_CERTIFICATESOURCE)
  private String certificateSource;
  private Boolean cloudFrontDefaultCertificate;
  private String iAMCertificateId;
  @FieldRegex(FieldRegexValue.ENUM_MINIMUMPROTOCOLVERSION)
  private String minimumProtocolVersion;
  @FieldRegex(FieldRegexValue.ENUM_SSLSUPPORTMETHOD)
  private String sSLSupportMethod;

  public String getACMCertificateArn( ) {
    return aCMCertificateArn;
  }

  public void setACMCertificateArn( final String aCMCertificateArn ) {
    this.aCMCertificateArn = aCMCertificateArn;
  }

  public String getCertificate( ) {
    return certificate;
  }

  public void setCertificate( final String certificate ) {
    this.certificate = certificate;
  }

  public String getCertificateSource( ) {
    return certificateSource;
  }

  public void setCertificateSource( final String certificateSource ) {
    this.certificateSource = certificateSource;
  }

  public Boolean getCloudFrontDefaultCertificate( ) {
    return cloudFrontDefaultCertificate;
  }

  public void setCloudFrontDefaultCertificate( final Boolean cloudFrontDefaultCertificate ) {
    this.cloudFrontDefaultCertificate = cloudFrontDefaultCertificate;
  }

  public String getIAMCertificateId( ) {
    return iAMCertificateId;
  }

  public void setIAMCertificateId( final String iAMCertificateId ) {
    this.iAMCertificateId = iAMCertificateId;
  }

  public String getMinimumProtocolVersion( ) {
    return minimumProtocolVersion;
  }

  public void setMinimumProtocolVersion( final String minimumProtocolVersion ) {
    this.minimumProtocolVersion = minimumProtocolVersion;
  }

  public String getSSLSupportMethod( ) {
    return sSLSupportMethod;
  }

  public void setSSLSupportMethod( final String sSLSupportMethod ) {
    this.sSLSupportMethod = sSLSupportMethod;
  }

}
