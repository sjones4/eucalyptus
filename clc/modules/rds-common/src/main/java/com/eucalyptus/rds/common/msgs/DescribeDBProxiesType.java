/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import com.eucalyptus.rds.common.RdsMessageValidation.FieldRange;


public class DescribeDBProxiesType extends RdsMessage {

  private String dBProxyName;

  private FilterList filters;

  private String marker;

  @FieldRange(min = 20, max = 100)
  private Integer maxRecords;

  public String getDBProxyName() {
    return dBProxyName;
  }

  public void setDBProxyName(final String dBProxyName) {
    this.dBProxyName = dBProxyName;
  }

  public FilterList getFilters() {
    return filters;
  }

  public void setFilters(final FilterList filters) {
    this.filters = filters;
  }

  public String getMarker() {
    return marker;
  }

  public void setMarker(final String marker) {
    this.marker = marker;
  }

  public Integer getMaxRecords() {
    return maxRecords;
  }

  public void setMaxRecords(final Integer maxRecords) {
    this.maxRecords = maxRecords;
  }

}
