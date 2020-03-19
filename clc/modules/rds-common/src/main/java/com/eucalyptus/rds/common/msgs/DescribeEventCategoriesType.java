/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

public class DescribeEventCategoriesType extends RdsMessage {

  private FilterList filters;

  private String sourceType;

  public FilterList getFilters() {
    return filters;
  }

  public void setFilters(final FilterList filters) {
    this.filters = filters;
  }

  public String getSourceType() {
    return sourceType;
  }

  public void setSourceType(final String sourceType) {
    this.sourceType = sourceType;
  }

}
