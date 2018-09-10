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


public class DescribeSSLPoliciesResult extends EucalyptusData {

  private String nextMarker;
  private SslPolicies sslPolicies;

  public String getNextMarker( ) {
    return nextMarker;
  }

  public void setNextMarker( final String nextMarker ) {
    this.nextMarker = nextMarker;
  }

  public SslPolicies getSslPolicies( ) {
    return sslPolicies;
  }

  public void setSslPolicies( final SslPolicies sslPolicies ) {
    this.sslPolicies = sslPolicies;
  }

}
