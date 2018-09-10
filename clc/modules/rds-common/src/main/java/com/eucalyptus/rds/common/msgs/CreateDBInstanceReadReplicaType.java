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



public class CreateDBInstanceReadReplicaType extends RdsMessage {

  private Boolean autoMinorVersionUpgrade;
  private String availabilityZone;
  private Boolean copyTagsToSnapshot;
  private String dBInstanceClass;
  @Nonnull
  private String dBInstanceIdentifier;
  private String dBSubnetGroupName;
  private LogTypeList enableCloudwatchLogsExports;
  private Boolean enableIAMDatabaseAuthentication;
  private Boolean enablePerformanceInsights;
  private Integer iops;
  private String kmsKeyId;
  private Integer monitoringInterval;
  private String monitoringRoleArn;
  private Boolean multiAZ;
  private String optionGroupName;
  private String performanceInsightsKMSKeyId;
  private Integer performanceInsightsRetentionPeriod;
  private Integer port;
  private String preSignedUrl;
  private ProcessorFeatureList processorFeatures;
  private Boolean publiclyAccessible;
  @Nonnull
  private String sourceDBInstanceIdentifier;
  private String storageType;
  private TagList tags;
  private Boolean useDefaultProcessorFeatures;

  public Boolean getAutoMinorVersionUpgrade( ) {
    return autoMinorVersionUpgrade;
  }

  public void setAutoMinorVersionUpgrade( final Boolean autoMinorVersionUpgrade ) {
    this.autoMinorVersionUpgrade = autoMinorVersionUpgrade;
  }

  public String getAvailabilityZone( ) {
    return availabilityZone;
  }

  public void setAvailabilityZone( final String availabilityZone ) {
    this.availabilityZone = availabilityZone;
  }

  public Boolean getCopyTagsToSnapshot( ) {
    return copyTagsToSnapshot;
  }

  public void setCopyTagsToSnapshot( final Boolean copyTagsToSnapshot ) {
    this.copyTagsToSnapshot = copyTagsToSnapshot;
  }

  public String getDBInstanceClass( ) {
    return dBInstanceClass;
  }

  public void setDBInstanceClass( final String dBInstanceClass ) {
    this.dBInstanceClass = dBInstanceClass;
  }

  public String getDBInstanceIdentifier( ) {
    return dBInstanceIdentifier;
  }

  public void setDBInstanceIdentifier( final String dBInstanceIdentifier ) {
    this.dBInstanceIdentifier = dBInstanceIdentifier;
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

  public Boolean getEnablePerformanceInsights( ) {
    return enablePerformanceInsights;
  }

  public void setEnablePerformanceInsights( final Boolean enablePerformanceInsights ) {
    this.enablePerformanceInsights = enablePerformanceInsights;
  }

  public Integer getIops( ) {
    return iops;
  }

  public void setIops( final Integer iops ) {
    this.iops = iops;
  }

  public String getKmsKeyId( ) {
    return kmsKeyId;
  }

  public void setKmsKeyId( final String kmsKeyId ) {
    this.kmsKeyId = kmsKeyId;
  }

  public Integer getMonitoringInterval( ) {
    return monitoringInterval;
  }

  public void setMonitoringInterval( final Integer monitoringInterval ) {
    this.monitoringInterval = monitoringInterval;
  }

  public String getMonitoringRoleArn( ) {
    return monitoringRoleArn;
  }

  public void setMonitoringRoleArn( final String monitoringRoleArn ) {
    this.monitoringRoleArn = monitoringRoleArn;
  }

  public Boolean getMultiAZ( ) {
    return multiAZ;
  }

  public void setMultiAZ( final Boolean multiAZ ) {
    this.multiAZ = multiAZ;
  }

  public String getOptionGroupName( ) {
    return optionGroupName;
  }

  public void setOptionGroupName( final String optionGroupName ) {
    this.optionGroupName = optionGroupName;
  }

  public String getPerformanceInsightsKMSKeyId( ) {
    return performanceInsightsKMSKeyId;
  }

  public void setPerformanceInsightsKMSKeyId( final String performanceInsightsKMSKeyId ) {
    this.performanceInsightsKMSKeyId = performanceInsightsKMSKeyId;
  }

  public Integer getPerformanceInsightsRetentionPeriod( ) {
    return performanceInsightsRetentionPeriod;
  }

  public void setPerformanceInsightsRetentionPeriod( final Integer performanceInsightsRetentionPeriod ) {
    this.performanceInsightsRetentionPeriod = performanceInsightsRetentionPeriod;
  }

  public Integer getPort( ) {
    return port;
  }

  public void setPort( final Integer port ) {
    this.port = port;
  }

  public String getPreSignedUrl( ) {
    return preSignedUrl;
  }

  public void setPreSignedUrl( final String preSignedUrl ) {
    this.preSignedUrl = preSignedUrl;
  }

  public ProcessorFeatureList getProcessorFeatures( ) {
    return processorFeatures;
  }

  public void setProcessorFeatures( final ProcessorFeatureList processorFeatures ) {
    this.processorFeatures = processorFeatures;
  }

  public Boolean getPubliclyAccessible( ) {
    return publiclyAccessible;
  }

  public void setPubliclyAccessible( final Boolean publiclyAccessible ) {
    this.publiclyAccessible = publiclyAccessible;
  }

  public String getSourceDBInstanceIdentifier( ) {
    return sourceDBInstanceIdentifier;
  }

  public void setSourceDBInstanceIdentifier( final String sourceDBInstanceIdentifier ) {
    this.sourceDBInstanceIdentifier = sourceDBInstanceIdentifier;
  }

  public String getStorageType( ) {
    return storageType;
  }

  public void setStorageType( final String storageType ) {
    this.storageType = storageType;
  }

  public TagList getTags( ) {
    return tags;
  }

  public void setTags( final TagList tags ) {
    this.tags = tags;
  }

  public Boolean getUseDefaultProcessorFeatures( ) {
    return useDefaultProcessorFeatures;
  }

  public void setUseDefaultProcessorFeatures( final Boolean useDefaultProcessorFeatures ) {
    this.useDefaultProcessorFeatures = useDefaultProcessorFeatures;
  }

}
