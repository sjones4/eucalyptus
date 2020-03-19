/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.service.persist.views;

import java.util.List;
import javax.annotation.Nullable;
import org.immutables.value.Value.Immutable;

/**
 *
 */
@Immutable
public interface DBInstanceComposite {

  DBInstanceView getInstance();

  DBInstanceRuntimeView getRuntime();

  @Nullable
  DBSubnetGroupView getSubnetGroup();

  List<DBSubnetView> getSubnets();
}
