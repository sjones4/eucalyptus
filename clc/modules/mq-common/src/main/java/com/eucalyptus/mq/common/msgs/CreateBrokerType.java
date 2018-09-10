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
import com.eucalyptus.binding.HttpNoContent;
import com.eucalyptus.binding.HttpHeaderMapping;
import com.eucalyptus.binding.HttpParameterMapping;
import com.eucalyptus.binding.HttpRequestMapping;
import com.eucalyptus.binding.HttpUriMapping;
import com.eucalyptus.mq.common.MqMessageValidation.FieldRange;
import com.eucalyptus.mq.common.MqMessageValidation.FieldRegex;
import com.eucalyptus.mq.common.MqMessageValidation.FieldRegexValue;



@HttpRequestMapping(method="POST", uri="/v1/brokers")
public class CreateBrokerType extends MqMessage {

  private Boolean autoMinorVersionUpgrade;
  private String brokerName;
  private ConfigurationId configuration;
  private String creatorRequestId;
  @FieldRegex(FieldRegexValue.ENUM_DEPLOYMENTMODE)
  private String deploymentMode;
  @FieldRegex(FieldRegexValue.ENUM_ENGINETYPE)
  private String engineType;
  private String engineVersion;
  private String hostInstanceType;
  private Logs logs;
  private WeeklyStartTime maintenanceWindowStartTime;
  private Boolean publiclyAccessible;
  private java.util.ArrayList<String> securityGroups;
  private java.util.ArrayList<String> subnetIds;
  private java.util.ArrayList<User> users;

  public Boolean getAutoMinorVersionUpgrade( ) {
    return autoMinorVersionUpgrade;
  }

  public void setAutoMinorVersionUpgrade( final Boolean autoMinorVersionUpgrade ) {
    this.autoMinorVersionUpgrade = autoMinorVersionUpgrade;
  }

  public String getBrokerName( ) {
    return brokerName;
  }

  public void setBrokerName( final String brokerName ) {
    this.brokerName = brokerName;
  }

  public ConfigurationId getConfiguration( ) {
    return configuration;
  }

  public void setConfiguration( final ConfigurationId configuration ) {
    this.configuration = configuration;
  }

  public String getCreatorRequestId( ) {
    return creatorRequestId;
  }

  public void setCreatorRequestId( final String creatorRequestId ) {
    this.creatorRequestId = creatorRequestId;
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

  public Logs getLogs( ) {
    return logs;
  }

  public void setLogs( final Logs logs ) {
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

  public java.util.ArrayList<User> getUsers( ) {
    return users;
  }

  public void setUsers( final java.util.ArrayList<User> users ) {
    this.users = users;
  }

}
