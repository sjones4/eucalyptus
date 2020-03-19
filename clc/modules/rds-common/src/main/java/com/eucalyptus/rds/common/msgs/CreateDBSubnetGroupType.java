/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import javax.annotation.Nonnull;


public class CreateDBSubnetGroupType extends RdsMessage {

  @Nonnull
  private String dBSubnetGroupDescription;

  @Nonnull
  private String dBSubnetGroupName;

  @Nonnull
  private SubnetIdentifierList subnetIds;

  private TagList tags;

  public String getDBSubnetGroupDescription() {
    return dBSubnetGroupDescription;
  }

  public void setDBSubnetGroupDescription(final String dBSubnetGroupDescription) {
    this.dBSubnetGroupDescription = dBSubnetGroupDescription;
  }

  public String getDBSubnetGroupName() {
    return dBSubnetGroupName;
  }

  public void setDBSubnetGroupName(final String dBSubnetGroupName) {
    this.dBSubnetGroupName = dBSubnetGroupName;
  }

  public SubnetIdentifierList getSubnetIds() {
    return subnetIds;
  }

  public void setSubnetIds(final SubnetIdentifierList subnetIds) {
    this.subnetIds = subnetIds;
  }

  public TagList getTags() {
    return tags;
  }

  public void setTags(final TagList tags) {
    this.tags = tags;
  }

}
