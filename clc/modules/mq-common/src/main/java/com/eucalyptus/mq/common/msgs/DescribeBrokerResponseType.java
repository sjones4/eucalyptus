/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.mq.common.msgs;

import javax.annotation.Nonnull;
import com.eucalyptus.binding.HttpContent;
import com.eucalyptus.binding.HttpHeaderMapping;
import com.eucalyptus.binding.HttpNoContent;
import com.eucalyptus.mq.common.MqMessageValidation.FieldRange;
import com.eucalyptus.mq.common.MqMessageValidation.FieldRegex;
import com.eucalyptus.mq.common.MqMessageValidation.FieldRegexValue;



public class DescribeBrokerResponseType extends MqMessage {


  private Boolean autoMinorVersionUpgrade;
  private String brokerArn;
  private String brokerId;
  private java.util.ArrayList<BrokerInstance> brokerInstances;
  private String brokerName;
  @FieldRegex(FieldRegexValue.ENUM_BROKERSTATE)
  private String brokerState;
  private Configurations configurations;
  private java.util.Date created;
  @FieldRegex(FieldRegexValue.ENUM_DEPLOYMENTMODE)
  private String deploymentMode;
  @FieldRegex(FieldRegexValue.ENUM_ENGINETYPE)
  private String engineType;
  private String engineVersion;
  private String hostInstanceType;
  private LogsSummary logs;
  private WeeklyStartTime maintenanceWindowStartTime;
  private Boolean publiclyAccessible;
  private java.util.ArrayList<String> securityGroups;
  private java.util.ArrayList<String> subnetIds;
  private java.util.ArrayList<UserSummary> users;

  public Boolean getAutoMinorVersionUpgrade( ) {
    return autoMinorVersionUpgrade;
  }

  public void setAutoMinorVersionUpgrade( final Boolean autoMinorVersionUpgrade ) {
    this.autoMinorVersionUpgrade = autoMinorVersionUpgrade;
  }

  public String getBrokerArn( ) {
    return brokerArn;
  }

  public void setBrokerArn( final String brokerArn ) {
    this.brokerArn = brokerArn;
  }

  public String getBrokerId( ) {
    return brokerId;
  }

  public void setBrokerId( final String brokerId ) {
    this.brokerId = brokerId;
  }

  public java.util.ArrayList<BrokerInstance> getBrokerInstances( ) {
    return brokerInstances;
  }

  public void setBrokerInstances( final java.util.ArrayList<BrokerInstance> brokerInstances ) {
    this.brokerInstances = brokerInstances;
  }

  public String getBrokerName( ) {
    return brokerName;
  }

  public void setBrokerName( final String brokerName ) {
    this.brokerName = brokerName;
  }

  public String getBrokerState( ) {
    return brokerState;
  }

  public void setBrokerState( final String brokerState ) {
    this.brokerState = brokerState;
  }

  public Configurations getConfigurations( ) {
    return configurations;
  }

  public void setConfigurations( final Configurations configurations ) {
    this.configurations = configurations;
  }

  public java.util.Date getCreated( ) {
    return created;
  }

  public void setCreated( final java.util.Date created ) {
    this.created = created;
  }

  public String getDeploymentMode( ) {
    return deploymentMode;
  }

  public void setDeploymentMode( final String deploymentMode ) {
    this.deploymentMode = deploymentMode;
  }

  public String getEngineType( ) {
    return engineType;
  }

  public void setEngineType( final String engineType ) {
    this.engineType = engineType;
  }

  public String getEngineVersion( ) {
    return engineVersion;
  }

  public void setEngineVersion( final String engineVersion ) {
    this.engineVersion = engineVersion;
  }

  public String getHostInstanceType( ) {
    return hostInstanceType;
  }

  public void setHostInstanceType( final String hostInstanceType ) {
    this.hostInstanceType = hostInstanceType;
  }

  public LogsSummary getLogs( ) {
    return logs;
  }

  public void setLogs( final LogsSummary logs ) {
    this.logs = logs;
  }

  public WeeklyStartTime getMaintenanceWindowStartTime( ) {
    return maintenanceWindowStartTime;
  }

  public void setMaintenanceWindowStartTime( final WeeklyStartTime maintenanceWindowStartTime ) {
    this.maintenanceWindowStartTime = maintenanceWindowStartTime;
  }

  public Boolean getPubliclyAccessible( ) {
    return publiclyAccessible;
  }

  public void setPubliclyAccessible( final Boolean publiclyAccessible ) {
    this.publiclyAccessible = publiclyAccessible;
  }

  public java.util.ArrayList<String> getSecurityGroups( ) {
    return securityGroups;
  }

  public void setSecurityGroups( final java.util.ArrayList<String> securityGroups ) {
    this.securityGroups = securityGroups;
  }

  public java.util.ArrayList<String> getSubnetIds( ) {
    return subnetIds;
  }

  public void setSubnetIds( final java.util.ArrayList<String> subnetIds ) {
    this.subnetIds = subnetIds;
  }

  public java.util.ArrayList<UserSummary> getUsers( ) {
    return users;
  }

  public void setUsers( final java.util.ArrayList<UserSummary> users ) {
    this.users = users;
  }

}
