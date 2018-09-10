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


public class PublicKey extends EucalyptusData {

  @Nonnull
  private java.util.Date createdTime;
  @Nonnull
  private String id;
  @Nonnull
  private PublicKeyConfig publicKeyConfig;

  public java.util.Date getCreatedTime( ) {
    return createdTime;
  }

  public void setCreatedTime( final java.util.Date createdTime ) {
    this.createdTime = createdTime;
  }

  public String getId( ) {
    return id;
  }

  public void setId( final String id ) {
    this.id = id;
  }

  public PublicKeyConfig getPublicKeyConfig( ) {
    return publicKeyConfig;
  }

  public void setPublicKeyConfig( final PublicKeyConfig publicKeyConfig ) {
    this.publicKeyConfig = publicKeyConfig;
  }

}
