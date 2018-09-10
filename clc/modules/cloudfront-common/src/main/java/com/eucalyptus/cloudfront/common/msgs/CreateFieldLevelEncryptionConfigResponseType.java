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



@HttpContent(payload="fieldLevelEncryption")
public class CreateFieldLevelEncryptionConfigResponseType extends CloudfrontMessage {


  @HttpHeaderMapping(header="ETag")
  private String eTag;
  private FieldLevelEncryption fieldLevelEncryption = new FieldLevelEncryption();
  @HttpHeaderMapping(header="Location")
  private String location;

  public String getETag( ) {
    return eTag;
  }

  public void setETag( final String eTag ) {
    this.eTag = eTag;
  }

  public FieldLevelEncryption getFieldLevelEncryption( ) {
    return fieldLevelEncryption;
  }

  public void setFieldLevelEncryption( final FieldLevelEncryption fieldLevelEncryption ) {
    this.fieldLevelEncryption = fieldLevelEncryption;
  }

  public String getLocation( ) {
    return location;
  }

  public void setLocation( final String location ) {
    this.location = location;
  }

}
