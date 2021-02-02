/*
 * Copyright 2021 AppScale Systems, Inc
 *
 * SPDX-License-Identifier: BSD-2-Clause
 */
package com.eucalyptus.loadbalancing.service.persist.views;

import java.util.Date;
import org.immutables.value.Value.Immutable;

@Immutable
public interface LoadBalancerView {

  String getDisplayName();

  String getOwnerAccountNumber();

  Date getCreationTimestamp();
}
