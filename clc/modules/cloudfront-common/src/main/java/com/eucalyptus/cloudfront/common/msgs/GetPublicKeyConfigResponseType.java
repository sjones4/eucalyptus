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



@HttpContent(payload="publicKeyConfig")
public class GetPublicKeyConfigResponseType extends CloudfrontMessage {


  @HttpHeaderMapping(header="ETag")
  private String eTag;
  private PublicKeyConfig publicKeyConfig = new PublicKeyConfig();

  public String getETag( ) {
    return eTag;
  }

  public void setETag( final String eTag ) {
    this.eTag = eTag;
  }

  public PublicKeyConfig getPublicKeyConfig( ) {
    return publicKeyConfig;
  }

  public void setPublicKeyConfig( final PublicKeyConfig publicKeyConfig ) {
    this.publicKeyConfig = publicKeyConfig;
  }

}
