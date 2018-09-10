/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.resourcegroups.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;
import javax.annotation.Nonnull;
import com.eucalyptus.resourcegroups.common.ResourcegroupsMessageValidation.FieldRange;
import com.eucalyptus.resourcegroups.common.ResourcegroupsMessageValidation.FieldRegex;
import com.eucalyptus.resourcegroups.common.ResourcegroupsMessageValidation.FieldRegexValue;


public class Group extends EucalyptusData {

  @FieldRange(max=512)
  private String description;
  @Nonnull
  private String groupArn;
  @Nonnull
  @FieldRange(min=1, max=128)
  private String name;

  public String getDescription( ) {
    return description;
  }

  public void setDescription( final String description ) {
    this.description = description;
  }

  public String getGroupArn( ) {
    return groupArn;
  }

  public void setGroupArn( final String groupArn ) {
    this.groupArn = groupArn;
  }

  public String getName( ) {
    return name;
  }

  public void setName( final String name ) {
    this.name = name;
  }

}
