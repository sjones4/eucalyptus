/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.resourcegroups.common.msgs;

import javax.annotation.Nonnull;
import com.eucalyptus.binding.HttpContent;
import com.eucalyptus.binding.HttpHeaderMapping;
import com.eucalyptus.binding.HttpNoContent;
import com.eucalyptus.resourcegroups.common.ResourcegroupsMessageValidation.FieldRange;
import com.eucalyptus.resourcegroups.common.ResourcegroupsMessageValidation.FieldRegex;
import com.eucalyptus.resourcegroups.common.ResourcegroupsMessageValidation.FieldRegexValue;



public class SearchResourcesResponseType extends ResourcegroupsMessage {


  private String nextToken;
  private java.util.ArrayList<ResourceIdentifier> resourceIdentifiers;

  public String getNextToken( ) {
    return nextToken;
  }

  public void setNextToken( final String nextToken ) {
    this.nextToken = nextToken;
  }

  public java.util.ArrayList<ResourceIdentifier> getResourceIdentifiers( ) {
    return resourceIdentifiers;
  }

  public void setResourceIdentifiers( final java.util.ArrayList<ResourceIdentifier> resourceIdentifiers ) {
    this.resourceIdentifiers = resourceIdentifiers;
  }

}
