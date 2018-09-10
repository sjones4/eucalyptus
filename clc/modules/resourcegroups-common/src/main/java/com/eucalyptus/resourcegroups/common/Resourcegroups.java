/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.resourcegroups.common;

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
@AwsServiceName( "resource-groups" )
@PolicyVendor( "resource-groups" )
@Partition( value = Resourcegroups.class, manyToOne = true )
@Description( "Resource Groups API service" )
public class Resourcegroups extends ComponentId {
  private static final long serialVersionUID = 1L;
}
