/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudtrail.common.msgs;

import javax.annotation.Nonnull;
import com.eucalyptus.binding.HttpContent;
import com.eucalyptus.binding.HttpNoContent;
import com.eucalyptus.binding.HttpHeaderMapping;
import com.eucalyptus.binding.HttpParameterMapping;
import com.eucalyptus.binding.HttpRequestMapping;
import com.eucalyptus.binding.HttpUriMapping;
import com.eucalyptus.cloudtrail.common.CloudtrailMessageValidation.FieldRange;
import com.eucalyptus.cloudtrail.common.CloudtrailMessageValidation.FieldRegex;
import com.eucalyptus.cloudtrail.common.CloudtrailMessageValidation.FieldRegexValue;



@HttpRequestMapping(method="POST", uri="/")
public class ListTagsType extends CloudtrailMessage {

  private String nextToken;
  @Nonnull
  private java.util.ArrayList<String> resourceIdList;

  public String getNextToken( ) {
    return nextToken;
  }

  public void setNextToken( final String nextToken ) {
    this.nextToken = nextToken;
  }

  public java.util.ArrayList<String> getResourceIdList( ) {
    return resourceIdList;
  }

  public void setResourceIdList( final java.util.ArrayList<String> resourceIdList ) {
    this.resourceIdList = resourceIdList;
  }

}
