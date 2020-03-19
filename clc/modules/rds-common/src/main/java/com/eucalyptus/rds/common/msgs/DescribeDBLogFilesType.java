/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import javax.annotation.Nonnull;


public class DescribeDBLogFilesType extends RdsMessage {

  @Nonnull
  private String dBInstanceIdentifier;

  private Long fileLastWritten;

  private Long fileSize;

  private String filenameContains;

  private FilterList filters;

  private String marker;

  private Integer maxRecords;

  public String getDBInstanceIdentifier() {
    return dBInstanceIdentifier;
  }

  public void setDBInstanceIdentifier(final String dBInstanceIdentifier) {
    this.dBInstanceIdentifier = dBInstanceIdentifier;
  }

  public Long getFileLastWritten() {
    return fileLastWritten;
  }

  public void setFileLastWritten(final Long fileLastWritten) {
    this.fileLastWritten = fileLastWritten;
  }

  public Long getFileSize() {
    return fileSize;
  }

  public void setFileSize(final Long fileSize) {
    this.fileSize = fileSize;
  }

  public String getFilenameContains() {
    return filenameContains;
  }

  public void setFilenameContains(final String filenameContains) {
    this.filenameContains = filenameContains;
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
