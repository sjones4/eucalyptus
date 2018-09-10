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
import com.eucalyptus.binding.HttpNoContent;
import com.eucalyptus.binding.HttpHeaderMapping;
import com.eucalyptus.binding.HttpParameterMapping;
import com.eucalyptus.binding.HttpRequestMapping;
import com.eucalyptus.binding.HttpUriMapping;
import com.eucalyptus.cloudfront.common.CloudfrontMessageValidation.FieldRange;
import com.eucalyptus.cloudfront.common.CloudfrontMessageValidation.FieldRegex;
import com.eucalyptus.cloudfront.common.CloudfrontMessageValidation.FieldRegexValue;



@HttpRequestMapping(method="POST", uri="/2018-06-18/tagging?Operation=Untag")
@HttpContent(payload="tagKeys")
public class UntagResourceType extends CloudfrontMessage {

  @Nonnull
  @HttpParameterMapping(parameter="Resource")
  private String resource;
  @Nonnull
  private TagKeys tagKeys = new TagKeys();

  public String getResource( ) {
    return resource;
  }

  public void setResource( final String resource ) {
    this.resource = resource;
  }

  public TagKeys getTagKeys( ) {
    return tagKeys;
  }

  public void setTagKeys( final TagKeys tagKeys ) {
    this.tagKeys = tagKeys;
  }

}
