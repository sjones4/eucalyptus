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



public class RestoreDBClusterToPointInTimeType extends RdsMessage {

  private Long backtrackWindow;
  @Nonnull
  private String dBClusterIdentifier;
  private String dBSubnetGroupName;
  private LogTypeList enableCloudwatchLogsExports;
  private Boolean enableIAMDatabaseAuthentication;
  private String kmsKeyId;
  private String optionGroupName;
  private Integer port;
  private java.util.Date restoreToTime;
  private String restoreType;
  @Nonnull
  private String sourceDBClusterIdentifier;
  private TagList tags;
  private Boolean useLatestRestorableTime;
  private VpcSecurityGroupIdList vpcSecurityGroupIds;

  public Long getBacktrackWindow( ) {
    return backtrackWindow;
  }

  public void setBacktrackWindow( final Long backtrackWindow ) {
    this.backtrackWindow = backtrackWindow;
  }

  public String getDBClusterIdentifier( ) {
    return dBClusterIdentifier;
  }

  public void setDBClusterIdentifier( final String dBClusterIdentifier ) {
    this.dBClusterIdentifier = dBClusterIdentifier;
  }

  public String getDBSubnetGroupName( ) {
    return dBSubnetGroupName;
  }

  public void setDBSubnetGroupName( final String dBSubnetGroupName ) {
    this.dBSubnetGroupName = dBSubnetGroupName;
  }

  public LogTypeList getEnableCloudwatchLogsExports( ) {
    return enableCloudwatchLogsExports;
  }

  public void setEnableCloudwatchLogsExports( final LogTypeList enableCloudwatchLogsExports ) {
    this.enableCloudwatchLogsExports = enableCloudwatchLogsExports;
  }

  public Boolean getEnableIAMDatabaseAuthentication( ) {
    return enableIAMDatabaseAuthentication;
  }

  public void setEnableIAMDatabaseAuthentication( final Boolean enableIAMDatabaseAuthentication ) {
    this.enableIAMDatabaseAuthentication = enableIAMDatabaseAuthentication;
  }

  public String getKmsKeyId( ) {
    return kmsKeyId;
  }

  public void setKmsKeyId( final String kmsKeyId ) {
    this.kmsKeyId = kmsKeyId;
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

  public java.util.Date getRestoreToTime( ) {
    return restoreToTime;
  }

  public void setRestoreToTime( final java.util.Date restoreToTime ) {
    this.restoreToTime = restoreToTime;
  }

  public String getRestoreType( ) {
    return restoreType;
  }

  public void setRestoreType( final String restoreType ) {
    this.restoreType = restoreType;
  }

  public String getSourceDBClusterIdentifier( ) {
    return sourceDBClusterIdentifier;
  }

  public void setSourceDBClusterIdentifier( final String sourceDBClusterIdentifier ) {
    this.sourceDBClusterIdentifier = sourceDBClusterIdentifier;
  }

  public TagList getTags( ) {
    return tags;
  }

  public void setTags( final TagList tags ) {
    this.tags = tags;
  }

  public Boolean getUseLatestRestorableTime( ) {
    return useLatestRestorableTime;
  }

  public void setUseLatestRestorableTime( final Boolean useLatestRestorableTime ) {
    this.useLatestRestorableTime = useLatestRestorableTime;
  }

  public VpcSecurityGroupIdList getVpcSecurityGroupIds( ) {
    return vpcSecurityGroupIds;
  }

  public void setVpcSecurityGroupIds( final VpcSecurityGroupIdList vpcSecurityGroupIds ) {
    this.vpcSecurityGroupIds = vpcSecurityGroupIds;
  }

}
