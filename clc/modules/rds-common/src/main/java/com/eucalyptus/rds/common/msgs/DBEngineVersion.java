/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;
import javax.annotation.Nonnull;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRange;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRegex;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRegexValue;


public class DBEngineVersion extends EucalyptusData {

  private String dBEngineDescription;
  private String dBEngineVersionDescription;
  private String dBParameterGroupFamily;
  private CharacterSet defaultCharacterSet;
  private String engine;
  private String engineVersion;
  private LogTypeList exportableLogTypes;
  private SupportedCharacterSetsList supportedCharacterSets;
  private EngineModeList supportedEngineModes;
  private SupportedTimezonesList supportedTimezones;
  private Boolean supportsLogExportsToCloudwatchLogs;
  private Boolean supportsReadReplica;
  private ValidUpgradeTargetList validUpgradeTarget;

  public String getDBEngineDescription( ) {
    return dBEngineDescription;
  }

  public void setDBEngineDescription( final String dBEngineDescription ) {
    this.dBEngineDescription = dBEngineDescription;
  }

  public String getDBEngineVersionDescription( ) {
    return dBEngineVersionDescription;
  }

  public void setDBEngineVersionDescription( final String dBEngineVersionDescription ) {
    this.dBEngineVersionDescription = dBEngineVersionDescription;
  }

  public String getDBParameterGroupFamily( ) {
    return dBParameterGroupFamily;
  }

  public void setDBParameterGroupFamily( final String dBParameterGroupFamily ) {
    this.dBParameterGroupFamily = dBParameterGroupFamily;
  }

  public CharacterSet getDefaultCharacterSet( ) {
    return defaultCharacterSet;
  }

  public void setDefaultCharacterSet( final CharacterSet defaultCharacterSet ) {
    this.defaultCharacterSet = defaultCharacterSet;
  }

  public String getEngine( ) {
    return engine;
  }

  public void setEngine( final String engine ) {
    this.engine = engine;
  }

  public String getEngineVersion( ) {
    return engineVersion;
  }

  public void setEngineVersion( final String engineVersion ) {
    this.engineVersion = engineVersion;
  }

  public LogTypeList getExportableLogTypes( ) {
    return exportableLogTypes;
  }

  public void setExportableLogTypes( final LogTypeList exportableLogTypes ) {
    this.exportableLogTypes = exportableLogTypes;
  }

  public SupportedCharacterSetsList getSupportedCharacterSets( ) {
    return supportedCharacterSets;
  }

  public void setSupportedCharacterSets( final SupportedCharacterSetsList supportedCharacterSets ) {
    this.supportedCharacterSets = supportedCharacterSets;
  }

  public EngineModeList getSupportedEngineModes( ) {
    return supportedEngineModes;
  }

  public void setSupportedEngineModes( final EngineModeList supportedEngineModes ) {
    this.supportedEngineModes = supportedEngineModes;
  }

  public SupportedTimezonesList getSupportedTimezones( ) {
    return supportedTimezones;
  }

  public void setSupportedTimezones( final SupportedTimezonesList supportedTimezones ) {
    this.supportedTimezones = supportedTimezones;
  }

  public Boolean getSupportsLogExportsToCloudwatchLogs( ) {
    return supportsLogExportsToCloudwatchLogs;
  }

  public void setSupportsLogExportsToCloudwatchLogs( final Boolean supportsLogExportsToCloudwatchLogs ) {
    this.supportsLogExportsToCloudwatchLogs = supportsLogExportsToCloudwatchLogs;
  }

  public Boolean getSupportsReadReplica( ) {
    return supportsReadReplica;
  }

  public void setSupportsReadReplica( final Boolean supportsReadReplica ) {
    this.supportsReadReplica = supportsReadReplica;
  }

  public ValidUpgradeTargetList getValidUpgradeTarget( ) {
    return validUpgradeTarget;
  }

  public void setValidUpgradeTarget( final ValidUpgradeTargetList validUpgradeTarget ) {
    this.validUpgradeTarget = validUpgradeTarget;
  }

}
