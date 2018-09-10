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


public class CloudFrontOriginAccessIdentityList extends EucalyptusData {

  @Nonnull
  private Boolean isTruncated;
  private CloudFrontOriginAccessIdentitySummaryList items;
  @Nonnull
  private String marker;
  @Nonnull
  private Integer maxItems;
  private String nextMarker;
  @Nonnull
  private Integer quantity;

  public Boolean getIsTruncated( ) {
    return isTruncated;
  }

  public void setIsTruncated( final Boolean isTruncated ) {
    this.isTruncated = isTruncated;
  }

  public CloudFrontOriginAccessIdentitySummaryList getItems( ) {
    return items;
  }

  public void setItems( final CloudFrontOriginAccessIdentitySummaryList items ) {
    this.items = items;
  }

  public String getMarker( ) {
    return marker;
  }

  public void setMarker( final String marker ) {
    this.marker = marker;
  }

  public Integer getMaxItems( ) {
    return maxItems;
  }

  public void setMaxItems( final Integer maxItems ) {
    this.maxItems = maxItems;
  }

  public String getNextMarker( ) {
    return nextMarker;
  }

  public void setNextMarker( final String nextMarker ) {
    this.nextMarker = nextMarker;
  }

  public Integer getQuantity( ) {
    return quantity;
  }

  public void setQuantity( final Integer quantity ) {
    this.quantity = quantity;
  }

}
