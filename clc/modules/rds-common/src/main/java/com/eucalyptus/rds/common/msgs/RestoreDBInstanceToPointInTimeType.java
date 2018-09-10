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



public class RestoreDBInstanceToPointInTimeType extends RdsMessage {

  private Boolean autoMinorVersionUpgrade;
  private String availabilityZone;
  private Boolean copyTagsToSnapshot;
  private String dBInstanceClass;
  private String dBName;
  private String dBSubnetGroupName;
  private String domain;
  private String domainIAMRoleName;
  private LogTypeList enableCloudwatchLogsExports;
  private Boolean enableIAMDatabaseAuthentication;
  private String engine;
  private Integer iops;
  private String licenseModel;
  private Boolean multiAZ;
  private String optionGroupName;
  private Integer port;
  private ProcessorFeatureList processorFeatures;
  private Boolean publiclyAccessible;
  private java.util.Date restoreTime;
  @Nonnull
  private String sourceDBInstanceIdentifier;
  private String storageType;
  private TagList tags;
  @Nonnull
  private String targetDBInstanceIdentifier;
  private String tdeCredentialArn;
  private String tdeCredentialPassword;
  private Boolean useDefaultProcessorFeatures;
  private Boolean useLatestRestorableTime;

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

  public String getDBName( ) {
    return dBName;
  }

  public void setDBName( final String dBName ) {
    this.dBName = dBName;
  }

  public String getDBSubnetGroupName( ) {
    return dBSubnetGroupName;
  }

  public void setDBSubnetGroupName( final String dBSubnetGroupName ) {
    this.dBSubnetGroupName = dBSubnetGroupName;
  }

  public String getDomain( ) {
    return domain;
  }

  public void setDomain( final String domain ) {
    this.domain = domain;
  }

  public String getDomainIAMRoleName( ) {
    return domainIAMRoleName;
  }

  public void setDomainIAMRoleName( final String domainIAMRoleName ) {
    this.domainIAMRoleName = domainIAMRoleName;
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

  public String getEngine( ) {
    return engine;
  }

  public void setEngine( final String engine ) {
    this.engine = engine;
  }

  public Integer getIops( ) {
    return iops;
  }

  public void setIops( final Integer iops ) {
    this.iops = iops;
  }

  public String getLicenseModel( ) {
    return licenseModel;
  }

  public void setLicenseModel( final String licenseModel ) {
    this.licenseModel = licenseModel;
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

  public Integer getPort( ) {
    return port;
  }

  public void setPort( final Integer port ) {
    this.port = port;
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

  public java.util.Date getRestoreTime( ) {
    return restoreTime;
  }

  public void setRestoreTime( final java.util.Date restoreTime ) {
    this.restoreTime = restoreTime;
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

  public String getTargetDBInstanceIdentifier( ) {
    return targetDBInstanceIdentifier;
  }

  public void setTargetDBInstanceIdentifier( final String targetDBInstanceIdentifier ) {
    this.targetDBInstanceIdentifier = targetDBInstanceIdentifier;
  }

  public String getTdeCredentialArn( ) {
    return tdeCredentialArn;
  }

  public void setTdeCredentialArn( final String tdeCredentialArn ) {
    this.tdeCredentialArn = tdeCredentialArn;
  }

  public String getTdeCredentialPassword( ) {
    return tdeCredentialPassword;
  }

  public void setTdeCredentialPassword( final String tdeCredentialPassword ) {
    this.tdeCredentialPassword = tdeCredentialPassword;
  }

  public Boolean getUseDefaultProcessorFeatures( ) {
    return useDefaultProcessorFeatures;
  }

  public void setUseDefaultProcessorFeatures( final Boolean useDefaultProcessorFeatures ) {
    this.useDefaultProcessorFeatures = useDefaultProcessorFeatures;
  }

  public Boolean getUseLatestRestorableTime( ) {
    return useLatestRestorableTime;
  }

  public void setUseLatestRestorableTime( final Boolean useLatestRestorableTime ) {
    this.useLatestRestorableTime = useLatestRestorableTime;
  }

}
