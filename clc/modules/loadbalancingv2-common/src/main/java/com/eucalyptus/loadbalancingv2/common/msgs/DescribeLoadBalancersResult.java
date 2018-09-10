/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.loadbalancingv2.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;
import com.eucalyptus.loadbalancingv2.common.Loadbalancingv2MessageValidation.FieldRange;
import com.eucalyptus.loadbalancingv2.common.Loadbalancingv2MessageValidation.FieldRegex;
import com.eucalyptus.loadbalancingv2.common.Loadbalancingv2MessageValidation.FieldRegexValue;


public class DescribeLoadBalancersResult extends EucalyptusData {

  private LoadBalancers loadBalancers;
  private String nextMarker;

  public LoadBalancers getLoadBalancers( ) {
    return loadBalancers;
  }

  public void setLoadBalancers( final LoadBalancers loadBalancers ) {
    this.loadBalancers = loadBalancers;
  }

  public String getNextMarker( ) {
    return nextMarker;
  }

  public void setNextMarker( final String nextMarker ) {
    this.nextMarker = nextMarker;
  }

}
