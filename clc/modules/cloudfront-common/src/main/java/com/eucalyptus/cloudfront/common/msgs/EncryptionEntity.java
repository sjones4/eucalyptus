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


public class EncryptionEntity extends EucalyptusData {

  @Nonnull
  private FieldPatterns fieldPatterns;
  @Nonnull
  private String providerId;
  @Nonnull
  private String publicKeyId;

  public FieldPatterns getFieldPatterns( ) {
    return fieldPatterns;
  }

  public void setFieldPatterns( final FieldPatterns fieldPatterns ) {
    this.fieldPatterns = fieldPatterns;
  }

  public String getProviderId( ) {
    return providerId;
  }

  public void setProviderId( final String providerId ) {
    this.providerId = providerId;
  }

  public String getPublicKeyId( ) {
    return publicKeyId;
  }

  public void setPublicKeyId( final String publicKeyId ) {
    this.publicKeyId = publicKeyId;
  }

}
