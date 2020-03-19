/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.service.persist.views;

import org.immutables.value.Value.Immutable;
import com.eucalyptus.rds.service.persist.entities.DBSubnet.Status;

/**
 *
 */
@Immutable
public interface DBSubnetView {

  Status getStatus();

  String getSubnetId();

  String getAvailabilityZone();

}
