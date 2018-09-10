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


public class AvailabilityZone extends EucalyptusData {

  private LoadBalancerAddresses loadBalancerAddresses;
  private String subnetId;
  private String zoneName;

  public LoadBalancerAddresses getLoadBalancerAddresses( ) {
    return loadBalancerAddresses;
  }

  public void setLoadBalancerAddresses( final LoadBalancerAddresses loadBalancerAddresses ) {
    this.loadBalancerAddresses = loadBalancerAddresses;
  }

  public String getSubnetId( ) {
    return subnetId;
  }

  public void setSubnetId( final String subnetId ) {
    this.subnetId = subnetId;
  }

  public String getZoneName( ) {
    return zoneName;
  }

  public void setZoneName( final String zoneName ) {
    this.zoneName = zoneName;
  }

}
