/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudtrail.common;

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
@AwsServiceName( "cloudtrail" )
@PolicyVendor( "cloudtrail" )
@Partition( value = Cloudtrail.class, manyToOne = true )
@Description( "CloudTrail API service" )
public class Cloudtrail extends ComponentId {
  private static final long serialVersionUID = 1L;
}
