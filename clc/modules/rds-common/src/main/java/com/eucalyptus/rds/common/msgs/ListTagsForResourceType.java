/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import javax.annotation.Nonnull;


public class ListTagsForResourceType extends RdsMessage {

  private FilterList filters;

  @Nonnull
  private String resourceName;

  public FilterList getFilters() {
    return filters;
  }

  public void setFilters(final FilterList filters) {
    this.filters = filters;
  }

  public String getResourceName() {
    return resourceName;
  }

  public void setResourceName(final String resourceName) {
    this.resourceName = resourceName;
  }

}
