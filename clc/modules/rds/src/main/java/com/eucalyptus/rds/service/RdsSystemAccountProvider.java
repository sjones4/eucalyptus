/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.service;

import com.eucalyptus.auth.principal.AccountIdentifiers;
import com.eucalyptus.auth.util.ClassPathSystemAccountProvider;
import com.google.common.collect.ImmutableList;

/**
 *
 */
public class RdsSystemAccountProvider  extends ClassPathSystemAccountProvider {

  public static final String RDS_SYSTEM_ACCOUNT = AccountIdentifiers.SYSTEM_ACCOUNT_PREFIX + "rds";;

  public RdsSystemAccountProvider( ) {
    super(
        RDS_SYSTEM_ACCOUNT,
        false,
        ImmutableList.<SystemAccountRole>of(
            newSystemAccountRole(
                "RdsServiceAdministrator",
                "/rds",
                ImmutableList.<AttachedPolicy>of(
                    newAttachedPolicy( "RdsServiceAdministrator" )
                )
            )
        )
    );
  }
}

