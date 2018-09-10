/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudtrail.common;

import com.eucalyptus.auth.policy.annotation.PolicyResourceType;
import com.eucalyptus.auth.policy.annotation.PolicyVendor;
import com.eucalyptus.auth.type.RestrictedType;
import com.eucalyptus.cloudtrail.common.policy.CloudtrailPolicySpec;

@PolicyVendor( CloudtrailPolicySpec.VENDOR_CLOUDTRAIL )
public interface CloudtrailMetadata extends RestrictedType {

  //TODO add policy resource types
  //@PolicyResourceType( "lower_case_name-here" )
  //interface XXXMetadata extends CloudtrailMetadata {}

}
