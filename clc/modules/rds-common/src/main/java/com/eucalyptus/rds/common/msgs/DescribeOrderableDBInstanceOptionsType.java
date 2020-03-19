/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import javax.annotation.Nonnull;


public class DescribeOrderableDBInstanceOptionsType extends RdsMessage {

  private String dBInstanceClass;

  @Nonnull
  private String engine;

  private String engineVersion;

  private FilterList filters;

  private String licenseModel;

  private String marker;

  private Integer maxRecords;

  private Boolean vpc;

  public String getDBInstanceClass() {
    return dBInstanceClass;
  }

  public void setDBInstanceClass(final String dBInstanceClass) {
    this.dBInstanceClass = dBInstanceClass;
  }

  public String getEngine() {
    return engine;
  }

  public void setEngine(final String engine) {
    this.engine = engine;
  }

  public String getEngineVersion() {
    return engineVersion;
  }

  public void setEngineVersion(final String engineVersion) {
    this.engineVersion = engineVersion;
  }

  public FilterList getFilters() {
    return filters;
  }

  public void setFilters(final FilterList filters) {
    this.filters = filters;
  }

  public String getLicenseModel() {
    return licenseModel;
  }

  public void setLicenseModel(final String licenseModel) {
    this.licenseModel = licenseModel;
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

  public Boolean getVpc() {
    return vpc;
  }

  public void setVpc(final Boolean vpc) {
    this.vpc = vpc;
  }

}
