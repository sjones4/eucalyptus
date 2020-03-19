/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.service.persist.entities;

import com.eucalyptus.auth.principal.OwnerFullName;
import com.eucalyptus.component.annotation.ComponentNamed;
import com.eucalyptus.rds.common.RdsMetadata.DBInstanceMetadata;
import com.eucalyptus.rds.service.persist.DBInstances;

/**
 *
 */
@ComponentNamed
public class PersistenceDBInstances extends RdsPersistenceSupport<DBInstanceMetadata, DBInstance> implements DBInstances {

  public PersistenceDBInstances() {
    super("db");
  }

  @Override
  protected DBInstance exampleWithName(final OwnerFullName ownerFullName, final String name) {
    return DBInstance.exampleWithName(ownerFullName, name);
  }

  @Override
  protected DBInstance exampleWithOwner(final OwnerFullName ownerFullName) {
    return DBInstance.exampleWithOwner(ownerFullName);
  }
}