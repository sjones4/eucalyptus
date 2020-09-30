/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudwatchlogs.common;

import com.eucalyptus.auth.policy.annotation.PolicyResourceType;
import com.eucalyptus.auth.policy.annotation.PolicyVendor;
import com.eucalyptus.auth.type.RestrictedType;
import com.eucalyptus.cloudwatchlogs.common.policy.CloudwatchlogsPolicySpec;

@PolicyVendor( CloudwatchlogsPolicySpec.VENDOR_CLOUDWATCHLOGS )
public interface CloudwatchlogsMetadata extends RestrictedType {

  @PolicyResourceType( "log-group" )
  interface LogGroupMetadata extends CloudwatchlogsMetadata {}

  @PolicyResourceType( "log-stream" )
  interface LogStreamMetadata extends CloudwatchlogsMetadata {}

}
