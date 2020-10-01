/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudwatchlogs.common.policy;

import com.eucalyptus.auth.policy.ern.ResourceNameSupport;

/**
 *
 */
public class CloudwatchlogsResourceName extends ResourceNameSupport {

  public CloudwatchlogsResourceName( String region, String account, String type, String id ) {
    super( CloudwatchlogsPolicySpec.VENDOR_CLOUDWATCHLOGS, region, account, type, id );
  }
}
