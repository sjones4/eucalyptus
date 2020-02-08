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
import com.eucalyptus.rds.service.persist.entities.DBInstance;

/**
 *
 */
@Immutable
public interface DBInstanceView {

  String getNaturalId();

  String getDisplayName();

  String getOwnerAccountNumber();

  DBInstance.Status getState();

  @Nullable
  Integer getAllocatedStorage();

  @Nullable
  String getAvailabilityZone();

  @Nullable
  Boolean getCopyTagsToSnapshot();

  @Nullable
  String getDbName();

  @Nullable
  Integer getDbPort();

  @Nullable
  String getInstanceClass();

  @Nullable
  String getEngine();

  @Nullable
  String getEngineVersion();

  @Nullable
  String getMasterUsername();

  @Nullable
  String getMasterUserPassword();

  @Nullable
  Boolean getPubliclyAccessible();

  List<String> getVpcSecurityGroups();
}
