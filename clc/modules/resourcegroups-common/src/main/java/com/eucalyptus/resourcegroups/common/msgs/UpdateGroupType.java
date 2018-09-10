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
import com.eucalyptus.binding.HttpNoContent;
import com.eucalyptus.binding.HttpHeaderMapping;
import com.eucalyptus.binding.HttpParameterMapping;
import com.eucalyptus.binding.HttpRequestMapping;
import com.eucalyptus.binding.HttpUriMapping;
import com.eucalyptus.resourcegroups.common.ResourcegroupsMessageValidation.FieldRange;
import com.eucalyptus.resourcegroups.common.ResourcegroupsMessageValidation.FieldRegex;
import com.eucalyptus.resourcegroups.common.ResourcegroupsMessageValidation.FieldRegexValue;



@HttpRequestMapping(method="PUT", uri="/groups/{GroupName}")
public class UpdateGroupType extends ResourcegroupsMessage {

  @FieldRange(max=512)
  private String description;
  @Nonnull
  @HttpUriMapping(uri="GroupName")
  @FieldRange(min=1, max=128)
  private String groupName;

  public String getDescription( ) {
    return description;
  }

  public void setDescription( final String description ) {
    this.description = description;
  }

  public String getGroupName( ) {
    return groupName;
  }

  public void setGroupName( final String groupName ) {
    this.groupName = groupName;
  }

}
