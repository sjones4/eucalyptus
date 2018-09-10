/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.loadbalancingv2.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;
import javax.annotation.Nonnull;
import com.eucalyptus.loadbalancingv2.common.Loadbalancingv2MessageValidation.FieldRange;
import com.eucalyptus.loadbalancingv2.common.Loadbalancingv2MessageValidation.FieldRegex;
import com.eucalyptus.loadbalancingv2.common.Loadbalancingv2MessageValidation.FieldRegexValue;


public class TargetHealthDescription extends EucalyptusData {

  private String healthCheckPort;
  private TargetDescription target;
  private TargetHealth targetHealth;

  public String getHealthCheckPort( ) {
    return healthCheckPort;
  }

  public void setHealthCheckPort( final String healthCheckPort ) {
    this.healthCheckPort = healthCheckPort;
  }

  public TargetDescription getTarget( ) {
    return target;
  }

  public void setTarget( final TargetDescription target ) {
    this.target = target;
  }

  public TargetHealth getTargetHealth( ) {
    return targetHealth;
  }

  public void setTargetHealth( final TargetHealth targetHealth ) {
    this.targetHealth = targetHealth;
  }

}
