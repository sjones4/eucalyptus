/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudfront.common.msgs;

import javax.annotation.Nonnull;
import com.eucalyptus.binding.HttpContent;
import com.eucalyptus.binding.HttpHeaderMapping;
import com.eucalyptus.binding.HttpNoContent;
import com.eucalyptus.cloudfront.common.CloudfrontMessageValidation.FieldRange;
import com.eucalyptus.cloudfront.common.CloudfrontMessageValidation.FieldRegex;
import com.eucalyptus.cloudfront.common.CloudfrontMessageValidation.FieldRegexValue;



@HttpContent(payload="publicKey")
public class CreatePublicKeyResponseType extends CloudfrontMessage {


  @HttpHeaderMapping(header="ETag")
  private String eTag;
  @HttpHeaderMapping(header="Location")
  private String location;
  private PublicKey publicKey = new PublicKey();

  public String getETag( ) {
    return eTag;
  }

  public void setETag( final String eTag ) {
    this.eTag = eTag;
  }

  public String getLocation( ) {
    return location;
  }

  public void setLocation( final String location ) {
    this.location = location;
  }

  public PublicKey getPublicKey( ) {
    return publicKey;
  }

  public void setPublicKey( final PublicKey publicKey ) {
    this.publicKey = publicKey;
  }

}
