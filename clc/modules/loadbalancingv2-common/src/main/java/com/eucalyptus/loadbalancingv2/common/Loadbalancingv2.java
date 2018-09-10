/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.loadbalancingv2.common;

import com.eucalyptus.component.ComponentId;
import com.eucalyptus.component.annotation.AwsServiceName;
import com.eucalyptus.component.annotation.Description;
import com.eucalyptus.component.annotation.Partition;
import com.eucalyptus.auth.policy.annotation.PolicyVendor;
import com.eucalyptus.component.annotation.PublicService;

/**
 *
 */
@PublicService
@AwsServiceName( "elasticloadbalancing" )
@PolicyVendor( "elasticloadbalancing" )
@Partition( value = Loadbalancingv2.class, manyToOne = true )
@Description( "Elastic Load Balancing v2 API service" )
public class Loadbalancingv2 extends ComponentId {
  private static final long serialVersionUID = 1L;
}
