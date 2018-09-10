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


public class GroupQuery extends EucalyptusData {

  @Nonnull
  @FieldRange(min=1, max=128)
  private String groupName;
  @Nonnull
  private ResourceQuery resourceQuery;

  public String getGroupName( ) {
    return groupName;
  }

  public void setGroupName( final String groupName ) {
    this.groupName = groupName;
  }

  public ResourceQuery getResourceQuery( ) {
    return resourceQuery;
  }

  public void setResourceQuery( final ResourceQuery resourceQuery ) {
    this.resourceQuery = resourceQuery;
  }

}
