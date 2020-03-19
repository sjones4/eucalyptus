/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import javax.annotation.Nonnull;


public class ModifyDBSnapshotAttributeType extends RdsMessage {

  @Nonnull
  private String attributeName;

  @Nonnull
  private String dBSnapshotIdentifier;

  private AttributeValueList valuesToAdd;

  private AttributeValueList valuesToRemove;

  public String getAttributeName() {
    return attributeName;
  }

  public void setAttributeName(final String attributeName) {
    this.attributeName = attributeName;
  }

  public String getDBSnapshotIdentifier() {
    return dBSnapshotIdentifier;
  }

  public void setDBSnapshotIdentifier(final String dBSnapshotIdentifier) {
    this.dBSnapshotIdentifier = dBSnapshotIdentifier;
  }

  public AttributeValueList getValuesToAdd() {
    return valuesToAdd;
  }

  public void setValuesToAdd(final AttributeValueList valuesToAdd) {
    this.valuesToAdd = valuesToAdd;
  }

  public AttributeValueList getValuesToRemove() {
    return valuesToRemove;
  }

  public void setValuesToRemove(final AttributeValueList valuesToRemove) {
    this.valuesToRemove = valuesToRemove;
  }

}
