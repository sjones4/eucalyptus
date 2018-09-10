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


public class PublicKeyConfig extends EucalyptusData {

  @Nonnull
  private String callerReference;
  private String comment;
  @Nonnull
  private String encodedKey;
  @Nonnull
  private String name;

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

  public String getEncodedKey( ) {
    return encodedKey;
  }

  public void setEncodedKey( final String encodedKey ) {
    this.encodedKey = encodedKey;
  }

  public String getName( ) {
    return name;
  }

  public void setName( final String name ) {
    this.name = name;
  }

}
