/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudtrail.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;
import javax.annotation.Nonnull;
import com.eucalyptus.cloudtrail.common.CloudtrailMessageValidation.FieldRange;
import com.eucalyptus.cloudtrail.common.CloudtrailMessageValidation.FieldRegex;
import com.eucalyptus.cloudtrail.common.CloudtrailMessageValidation.FieldRegexValue;


public class PublicKey extends EucalyptusData {

  private String fingerprint;
  private java.util.Date validityEndTime;
  private java.util.Date validityStartTime;
  private java.lang.String value;

  public String getFingerprint( ) {
    return fingerprint;
  }

  public void setFingerprint( final String fingerprint ) {
    this.fingerprint = fingerprint;
  }

  public java.util.Date getValidityEndTime( ) {
    return validityEndTime;
  }

  public void setValidityEndTime( final java.util.Date validityEndTime ) {
    this.validityEndTime = validityEndTime;
  }

  public java.util.Date getValidityStartTime( ) {
    return validityStartTime;
  }

  public void setValidityStartTime( final java.util.Date validityStartTime ) {
    this.validityStartTime = validityStartTime;
  }

  public java.lang.String getValue( ) {
    return value;
  }

  public void setValue( final java.lang.String value ) {
    this.value = value;
  }

}
