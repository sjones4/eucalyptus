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


public class Aliases extends EucalyptusData {

  private AliasList items;
  @Nonnull
  private Integer quantity;

  public AliasList getItems( ) {
    return items;
  }

  public void setItems( final AliasList items ) {
    this.items = items;
  }

  public Integer getQuantity( ) {
    return quantity;
  }

  public void setQuantity( final Integer quantity ) {
    this.quantity = quantity;
  }

}
