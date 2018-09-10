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



@HttpRequestMapping(method="GET", uri="/2018-06-18/distributionsByWebACLId/{WebACLId}")
@HttpNoContent
public class ListDistributionsByWebACLIdType extends CloudfrontMessage {

  @HttpParameterMapping(parameter="Marker")
  private String marker;
  @HttpParameterMapping(parameter="MaxItems")
  private String maxItems;
  @Nonnull
  @HttpUriMapping(uri="WebACLId")
  private String webACLId;

  public String getMarker( ) {
    return marker;
  }

  public void setMarker( final String marker ) {
    this.marker = marker;
  }

  public String getMaxItems( ) {
    return maxItems;
  }

  public void setMaxItems( final String maxItems ) {
    this.maxItems = maxItems;
  }

  public String getWebACLId( ) {
    return webACLId;
  }

  public void setWebACLId( final String webACLId ) {
    this.webACLId = webACLId;
  }

}
