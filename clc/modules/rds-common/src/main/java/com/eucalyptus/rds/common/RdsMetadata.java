/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common;

import com.eucalyptus.auth.policy.annotation.PolicyResourceType;
import com.eucalyptus.auth.policy.annotation.PolicyVendor;
import com.eucalyptus.auth.type.RestrictedType;
import com.eucalyptus.rds.common.policy.RdsPolicySpec;

@PolicyVendor(RdsPolicySpec.VENDOR_RDS)
public interface RdsMetadata extends RestrictedType {

  @PolicyResourceType( "db" )
  interface DBInstanceMetadata extends RdsMetadata {}

  @PolicyResourceType( "pg" )
  interface DBParameterGroupMetadata extends RdsMetadata {}

  @PolicyResourceType( "secgrp" )
  interface DBSecurityGroupMetadata extends RdsMetadata {}

  @PolicyResourceType( "subgrp" )
  interface DBSubnetGroupMetadata extends RdsMetadata {}

  @PolicyResourceType( "es" )
  interface EventSubscriptionMetadata extends RdsMetadata {}

  @PolicyResourceType( "og" )
  interface OptionGroupMetadata extends RdsMetadata {}

  @PolicyResourceType( "ri" )
  interface ReservedDBInstanceMetadata extends RdsMetadata {}
}
