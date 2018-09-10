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



@HttpRequestMapping(method="POST", uri="/groups/{GroupName}/resource-identifiers-list")
public class ListGroupResourcesType extends ResourcegroupsMessage {

  private java.util.ArrayList<ResourceFilter> filters;
  @Nonnull
  @HttpUriMapping(uri="GroupName")
  @FieldRange(min=1, max=128)
  private String groupName;
  @HttpParameterMapping(parameter="maxResults")
  @FieldRange(min=1, max=50)
  private Integer maxResults;
  @HttpParameterMapping(parameter="nextToken")
  private String nextToken;

  public java.util.ArrayList<ResourceFilter> getFilters( ) {
    return filters;
  }

  public void setFilters( final java.util.ArrayList<ResourceFilter> filters ) {
    this.filters = filters;
  }

  public String getGroupName( ) {
    return groupName;
  }

  public void setGroupName( final String groupName ) {
    this.groupName = groupName;
  }

  public Integer getMaxResults( ) {
    return maxResults;
  }

  public void setMaxResults( final Integer maxResults ) {
    this.maxResults = maxResults;
  }

  public String getNextToken( ) {
    return nextToken;
  }

  public void setNextToken( final String nextToken ) {
    this.nextToken = nextToken;
  }

}
