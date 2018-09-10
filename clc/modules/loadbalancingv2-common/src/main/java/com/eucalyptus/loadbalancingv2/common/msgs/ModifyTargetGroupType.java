/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.loadbalancingv2.common.msgs;

import javax.annotation.Nonnull;
import com.eucalyptus.binding.HttpContent;
import com.eucalyptus.binding.HttpNoContent;
import com.eucalyptus.binding.HttpHeaderMapping;
import com.eucalyptus.binding.HttpParameterMapping;
import com.eucalyptus.binding.HttpRequestMapping;
import com.eucalyptus.binding.HttpUriMapping;
import com.eucalyptus.loadbalancingv2.common.Loadbalancingv2MessageValidation.FieldRange;
import com.eucalyptus.loadbalancingv2.common.Loadbalancingv2MessageValidation.FieldRegex;
import com.eucalyptus.loadbalancingv2.common.Loadbalancingv2MessageValidation.FieldRegexValue;



public class ModifyTargetGroupType extends Loadbalancingv2Message {

  @FieldRange(min=5, max=300)
  private Integer healthCheckIntervalSeconds;
  @FieldRange(min=1, max=1024)
  private String healthCheckPath;
  private String healthCheckPort;
  @FieldRegex(FieldRegexValue.ENUM_PROTOCOLENUM)
  private String healthCheckProtocol;
  @FieldRange(min=2, max=60)
  private Integer healthCheckTimeoutSeconds;
  @FieldRange(min=2, max=10)
  private Integer healthyThresholdCount;
  private Matcher matcher;
  @Nonnull
  private String targetGroupArn;
  @FieldRange(min=2, max=10)
  private Integer unhealthyThresholdCount;

  public Integer getHealthCheckIntervalSeconds( ) {
    return healthCheckIntervalSeconds;
  }

  public void setHealthCheckIntervalSeconds( final Integer healthCheckIntervalSeconds ) {
    this.healthCheckIntervalSeconds = healthCheckIntervalSeconds;
  }

  public String getHealthCheckPath( ) {
    return healthCheckPath;
  }

  public void setHealthCheckPath( final String healthCheckPath ) {
    this.healthCheckPath = healthCheckPath;
  }

  public String getHealthCheckPort( ) {
    return healthCheckPort;
  }

  public void setHealthCheckPort( final String healthCheckPort ) {
    this.healthCheckPort = healthCheckPort;
  }

  public String getHealthCheckProtocol( ) {
    return healthCheckProtocol;
  }

  public void setHealthCheckProtocol( final String healthCheckProtocol ) {
    this.healthCheckProtocol = healthCheckProtocol;
  }

  public Integer getHealthCheckTimeoutSeconds( ) {
    return healthCheckTimeoutSeconds;
  }

  public void setHealthCheckTimeoutSeconds( final Integer healthCheckTimeoutSeconds ) {
    this.healthCheckTimeoutSeconds = healthCheckTimeoutSeconds;
  }

  public Integer getHealthyThresholdCount( ) {
    return healthyThresholdCount;
  }

  public void setHealthyThresholdCount( final Integer healthyThresholdCount ) {
    this.healthyThresholdCount = healthyThresholdCount;
  }

  public Matcher getMatcher( ) {
    return matcher;
  }

  public void setMatcher( final Matcher matcher ) {
    this.matcher = matcher;
  }

  public String getTargetGroupArn( ) {
    return targetGroupArn;
  }

  public void setTargetGroupArn( final String targetGroupArn ) {
    this.targetGroupArn = targetGroupArn;
  }

  public Integer getUnhealthyThresholdCount( ) {
    return unhealthyThresholdCount;
  }

  public void setUnhealthyThresholdCount( final Integer unhealthyThresholdCount ) {
    this.unhealthyThresholdCount = unhealthyThresholdCount;
  }

}
