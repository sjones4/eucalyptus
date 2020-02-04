/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.policy;

import com.eucalyptus.auth.policy.ern.ResourceNameSupport;

/**
 *
 */
public class RdsResourceName extends ResourceNameSupport {

  public RdsResourceName(
      final String region,
      final String account,
      final String resourceType,
      final String resourceName
  ) {
    super( RdsPolicySpec.VENDOR_RDS, region, account, resourceType, resourceName );
  }

}
