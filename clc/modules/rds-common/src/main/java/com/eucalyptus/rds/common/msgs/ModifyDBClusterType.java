/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import javax.annotation.Nonnull;
import com.eucalyptus.binding.HttpContent;
import com.eucalyptus.binding.HttpNoContent;
import com.eucalyptus.binding.HttpHeaderMapping;
import com.eucalyptus.binding.HttpParameterMapping;
import com.eucalyptus.binding.HttpRequestMapping;
import com.eucalyptus.binding.HttpUriMapping;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRange;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRegex;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRegexValue;



public class ModifyDBClusterType extends RdsMessage {

  private Boolean applyImmediately;
  private Long backtrackWindow;
  private Integer backupRetentionPeriod;
  private CloudwatchLogsExportConfiguration cloudwatchLogsExportConfiguration;
  @Nonnull
  private String dBClusterIdentifier;
  private String dBClusterParameterGroupName;
  private Boolean enableIAMDatabaseAuthentication;
  private String engineVersion;
  private String masterUserPassword;
  private String newDBClusterIdentifier;
  private String optionGroupName;
  private Integer port;
  private String preferredBackupWindow;
  private String preferredMaintenanceWindow;
  private ScalingConfiguration scalingConfiguration;
  private VpcSecurityGroupIdList vpcSecurityGroupIds;

  public Boolean getApplyImmediately( ) {
    return applyImmediately;
  }

  public void setApplyImmediately( final Boolean applyImmediately ) {
    this.applyImmediately = applyImmediately;
  }

  public Long getBacktrackWindow( ) {
    return backtrackWindow;
  }

  public void setBacktrackWindow( final Long backtrackWindow ) {
    this.backtrackWindow = backtrackWindow;
  }

  public Integer getBackupRetentionPeriod( ) {
    return backupRetentionPeriod;
  }

  public void setBackupRetentionPeriod( final Integer backupRetentionPeriod ) {
    this.backupRetentionPeriod = backupRetentionPeriod;
  }

  public CloudwatchLogsExportConfiguration getCloudwatchLogsExportConfiguration( ) {
    return cloudwatchLogsExportConfiguration;
  }

  public void setCloudwatchLogsExportConfiguration( final CloudwatchLogsExportConfiguration cloudwatchLogsExportConfiguration ) {
    this.cloudwatchLogsExportConfiguration = cloudwatchLogsExportConfiguration;
  }

  public String getDBClusterIdentifier( ) {
    return dBClusterIdentifier;
  }

  public void setDBClusterIdentifier( final String dBClusterIdentifier ) {
    this.dBClusterIdentifier = dBClusterIdentifier;
  }

  public String getDBClusterParameterGroupName( ) {
    return dBClusterParameterGroupName;
  }

  public void setDBClusterParameterGroupName( final String dBClusterParameterGroupName ) {
    this.dBClusterParameterGroupName = dBClusterParameterGroupName;
  }

  public Boolean getEnableIAMDatabaseAuthentication( ) {
    return enableIAMDatabaseAuthentication;
  }

  public void setEnableIAMDatabaseAuthentication( final Boolean enableIAMDatabaseAuthentication ) {
    this.enableIAMDatabaseAuthentication = enableIAMDatabaseAuthentication;
  }

  public String getEngineVersion( ) {
    return engineVersion;
  }

  public void setEngineVersion( final String engineVersion ) {
    this.engineVersion = engineVersion;
  }

  public String getMasterUserPassword( ) {
    return masterUserPassword;
  }

  public void setMasterUserPassword( final String masterUserPassword ) {
    this.masterUserPassword = masterUserPassword;
  }

  public String getNewDBClusterIdentifier( ) {
    return newDBClusterIdentifier;
  }

  public void setNewDBClusterIdentifier( final String newDBClusterIdentifier ) {
    this.newDBClusterIdentifier = newDBClusterIdentifier;
  }

  public String getOptionGroupName( ) {
    return optionGroupName;
  }

  public void setOptionGroupName( final String optionGroupName ) {
    this.optionGroupName = optionGroupName;
  }

  public Integer getPort( ) {
    return port;
  }

  public void setPort( final Integer port ) {
    this.port = port;
  }

  public String getPreferredBackupWindow( ) {
    return preferredBackupWindow;
  }

  public void setPreferredBackupWindow( final String preferredBackupWindow ) {
    this.preferredBackupWindow = preferredBackupWindow;
  }

  public String getPreferredMaintenanceWindow( ) {
    return preferredMaintenanceWindow;
  }

  public void setPreferredMaintenanceWindow( final String preferredMaintenanceWindow ) {
    this.preferredMaintenanceWindow = preferredMaintenanceWindow;
  }

  public ScalingConfiguration getScalingConfiguration( ) {
    return scalingConfiguration;
  }

  public void setScalingConfiguration( final ScalingConfiguration scalingConfiguration ) {
    this.scalingConfiguration = scalingConfiguration;
  }

  public VpcSecurityGroupIdList getVpcSecurityGroupIds( ) {
    return vpcSecurityGroupIds;
  }

  public void setVpcSecurityGroupIds( final VpcSecurityGroupIdList vpcSecurityGroupIds ) {
    this.vpcSecurityGroupIds = vpcSecurityGroupIds;
  }

}
