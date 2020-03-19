/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common;

import com.eucalyptus.auth.policy.annotation.PolicyResourceType;
import com.eucalyptus.rds.common.policy.RdsResourceName;
import com.eucalyptus.system.Ats;
import com.eucalyptus.util.RestrictedTypes;


public class RdsMetadatas extends RestrictedTypes {

  public static String toArn(final RdsMetadata metadata) {
    return new RdsResourceName(
      "",
      metadata.getOwner().getAccountNumber(),
        Ats.inClassHierarchy(metadata).get(PolicyResourceType.class).value(),
      metadata.getDisplayName()
    ).toString();
  }
}
