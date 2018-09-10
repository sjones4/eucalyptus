/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.mq.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;
import javax.annotation.Nonnull;
import com.eucalyptus.mq.common.MqMessageValidation.FieldRange;
import com.eucalyptus.mq.common.MqMessageValidation.FieldRegex;
import com.eucalyptus.mq.common.MqMessageValidation.FieldRegexValue;


public class BrokerSummary extends EucalyptusData {

  private String brokerArn;
  private String brokerId;
  private String brokerName;
  @FieldRegex(FieldRegexValue.ENUM_BROKERSTATE)
  private String brokerState;
  private java.util.Date created;
  @FieldRegex(FieldRegexValue.ENUM_DEPLOYMENTMODE)
  private String deploymentMode;
  private String hostInstanceType;

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

  public String getHostInstanceType( ) {
    return hostInstanceType;
  }

  public void setHostInstanceType( final String hostInstanceType ) {
    this.hostInstanceType = hostInstanceType;
  }

}
