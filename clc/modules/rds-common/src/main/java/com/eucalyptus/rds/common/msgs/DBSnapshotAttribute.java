/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;


public class DBSnapshotAttribute extends EucalyptusData {

  private String attributeName;

  private AttributeValueList attributeValues;

  public String getAttributeName() {
    return attributeName;
  }

  public void setAttributeName(final String attributeName) {
    this.attributeName = attributeName;
  }

  public AttributeValueList getAttributeValues() {
    return attributeValues;
  }

  public void setAttributeValues(final AttributeValueList attributeValues) {
    this.attributeValues = attributeValues;
  }

}
