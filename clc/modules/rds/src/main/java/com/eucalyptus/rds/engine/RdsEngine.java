/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.engine;

/**
 *
 */
public enum RdsEngine {
  postgres("PostgreSQL", 5432, "11.5"),
  ;

  private final String descName;
  private final int port;
  private final String version;

  RdsEngine(
      final String descName,
      final int port,
      final String version
  ) {
    this.descName = descName;
    this.port = port;
    this.version = version;
  }

  public String getDescription() {
    return descName;
  }

  public String getDefaultDatabaseName() {
    return name();
  }

  public int getDefaultDatabasePort() {
    return port;
  }

  public String getDefaultDatabaseVersion() {
    return version;
  }

  public String getDefaultDatabaseVersionDescription() {
    return descName + " " + version;
  }
}
