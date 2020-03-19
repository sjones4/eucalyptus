/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

public class DescribeExportTasksType extends RdsMessage {

  private String exportTaskIdentifier;

  private FilterList filters;

  private String marker;

  private String maxRecords;

  private String sourceArn;

  public String getExportTaskIdentifier() {
    return exportTaskIdentifier;
  }

  public void setExportTaskIdentifier(final String exportTaskIdentifier) {
    this.exportTaskIdentifier = exportTaskIdentifier;
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

  public String getMaxRecords() {
    return maxRecords;
  }

  public void setMaxRecords(final String maxRecords) {
    this.maxRecords = maxRecords;
  }

  public String getSourceArn() {
    return sourceArn;
  }

  public void setSourceArn(final String sourceArn) {
    this.sourceArn = sourceArn;
  }

}
