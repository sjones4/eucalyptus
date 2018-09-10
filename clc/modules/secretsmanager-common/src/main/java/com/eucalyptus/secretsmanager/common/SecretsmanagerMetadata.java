/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.secretsmanager.common;

import com.eucalyptus.auth.policy.annotation.PolicyResourceType;
import com.eucalyptus.auth.policy.annotation.PolicyVendor;
import com.eucalyptus.auth.type.RestrictedType;
import com.eucalyptus.secretsmanager.common.policy.SecretsmanagerPolicySpec;

@PolicyVendor( SecretsmanagerPolicySpec.VENDOR_SECRETSMANAGER )
public interface SecretsmanagerMetadata extends RestrictedType {

  //TODO add policy resource types
  //@PolicyResourceType( "lower_case_name-here" )
  //interface XXXMetadata extends SecretsmanagerMetadata {}

}
