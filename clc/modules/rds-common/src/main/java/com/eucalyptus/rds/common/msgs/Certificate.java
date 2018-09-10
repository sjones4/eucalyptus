/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;
import javax.annotation.Nonnull;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRange;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRegex;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRegexValue;


public class Certificate extends EucalyptusData {

  private String certificateArn;
  private String certificateIdentifier;
  private String certificateType;
  private String thumbprint;
  private java.util.Date validFrom;
  private java.util.Date validTill;

  public String getCertificateArn( ) {
    return certificateArn;
  }

  public void setCertificateArn( final String certificateArn ) {
    this.certificateArn = certificateArn;
  }

  public String getCertificateIdentifier( ) {
    return certificateIdentifier;
  }

  public void setCertificateIdentifier( final String certificateIdentifier ) {
    this.certificateIdentifier = certificateIdentifier;
  }

  public String getCertificateType( ) {
    return certificateType;
  }

  public void setCertificateType( final String certificateType ) {
    this.certificateType = certificateType;
  }

  public String getThumbprint( ) {
    return thumbprint;
  }

  public void setThumbprint( final String thumbprint ) {
    this.thumbprint = thumbprint;
  }

  public java.util.Date getValidFrom( ) {
    return validFrom;
  }

  public void setValidFrom( final java.util.Date validFrom ) {
    this.validFrom = validFrom;
  }

  public java.util.Date getValidTill( ) {
    return validTill;
  }

  public void setValidTill( final java.util.Date validTill ) {
    this.validTill = validTill;
  }

}
