/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudtrail.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;
import javax.annotation.Nonnull;
import com.eucalyptus.cloudtrail.common.CloudtrailMessageValidation.FieldRange;
import com.eucalyptus.cloudtrail.common.CloudtrailMessageValidation.FieldRegex;
import com.eucalyptus.cloudtrail.common.CloudtrailMessageValidation.FieldRegexValue;


public class LookupAttribute extends EucalyptusData {

  @Nonnull
  @FieldRegex(FieldRegexValue.ENUM_LOOKUPATTRIBUTEKEY)
  private String attributeKey;
  @Nonnull
  private String attributeValue;

  public String getAttributeKey( ) {
    return attributeKey;
  }

  public void setAttributeKey( final String attributeKey ) {
    this.attributeKey = attributeKey;
  }

  public String getAttributeValue( ) {
    return attributeValue;
  }

  public void setAttributeValue( final String attributeValue ) {
    this.attributeValue = attributeValue;
  }

}
