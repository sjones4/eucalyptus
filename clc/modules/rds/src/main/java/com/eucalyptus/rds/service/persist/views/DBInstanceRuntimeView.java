/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.service.persist.views;

import javax.annotation.Nullable;
import org.immutables.value.Value.Immutable;

/**
 *
 */
@Immutable
public interface DBInstanceRuntimeView {

  @Nullable
  String getSystemSubnetId();

  @Nullable
  String getSystemVpcId();

  @Nullable
  String getSystemVolumeId();

  @Nullable
  String getSystemInstanceId();

  @Nullable
  String getStackId();

  @Nullable
  String getUserSubnetId();

  @Nullable
  String getUserNetworkInterfaceId();

  @Nullable
  String getPublicIp();

  @Nullable
  String getPrivateIp();
}
