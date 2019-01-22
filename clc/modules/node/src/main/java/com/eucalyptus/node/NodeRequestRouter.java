/**
 * Copyright 2019 AppScale Systems, Inc
 *
 * SPDX-License-Identifier: BSD-2-Clause
 */
package com.eucalyptus.node;

import java.util.Map;
import java.util.function.Function;
import com.eucalyptus.cluster.common.msgs.CloudNodeMessage;
import com.eucalyptus.cluster.common.msgs.NcAttachVolumeType;
import com.eucalyptus.cluster.common.msgs.NcBroadcastNetworkInfoType;
import com.eucalyptus.cluster.common.msgs.NcBundleInstanceType;
import com.eucalyptus.cluster.common.msgs.NcBundleRestartInstanceType;
import com.eucalyptus.cluster.common.msgs.NcCancelBundleTaskType;
import com.eucalyptus.cluster.common.msgs.NcDescribeInstancesType;
import com.eucalyptus.cluster.common.msgs.NcDescribeResourceType;
import com.eucalyptus.cluster.common.msgs.NcDescribeSensorsType;
import com.eucalyptus.cluster.common.msgs.NcDetachVolumeType;
import com.eucalyptus.cluster.common.msgs.NcGetConsoleOutputType;
import com.eucalyptus.cluster.common.msgs.NcMigrateInstancesType;
import com.eucalyptus.cluster.common.msgs.NcModifyNodeType;
import com.eucalyptus.cluster.common.msgs.NcRebootInstanceType;
import com.eucalyptus.cluster.common.msgs.NcRunInstanceType;
import com.eucalyptus.cluster.common.msgs.NcStartInstanceType;
import com.eucalyptus.cluster.common.msgs.NcStopInstanceType;
import com.eucalyptus.cluster.common.msgs.NcTerminateInstanceType;
import com.eucalyptus.util.FUtils;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

/**
 *
 */
public class NodeRequestRouter {
  private final Map<Class<?>, Function<CloudNodeMessage,CloudNodeMessage>> handlers;

  public NodeRequestRouter( final NodeServiceImpl nodeService ) {
    this.handlers = buildHandlers(nodeService);
  }

  private Map<Class<?>, Function<CloudNodeMessage, CloudNodeMessage>> buildHandlers(
      final NodeServiceImpl nodeService
  ) {
    final Map<Class<?>, Function<CloudNodeMessage, CloudNodeMessage>> handlers = Maps.newHashMap( );
    handlers.put(NcDescribeResourceType.class, FUtils.chain(NcDescribeResourceType.class::cast, nodeService::describeResource));
    handlers.put(NcDescribeSensorsType.class, FUtils.chain(NcDescribeSensorsType.class::cast, nodeService::describeSensors));
    handlers.put(NcBroadcastNetworkInfoType.class, FUtils.chain(NcBroadcastNetworkInfoType.class::cast, nodeService::broadcastNetworkInfo));
    handlers.put(NcModifyNodeType.class, FUtils.chain(NcModifyNodeType.class::cast, nodeService::modifyNode));
    handlers.put(NcDescribeInstancesType.class, FUtils.chain(NcDescribeInstancesType.class::cast, nodeService::describeInstances));
    handlers.put(NcMigrateInstancesType.class, FUtils.chain(NcMigrateInstancesType.class::cast, nodeService::migrateInstances));
    handlers.put(NcRunInstanceType.class, FUtils.chain(NcRunInstanceType.class::cast, nodeService::runInstance));
    handlers.put(NcStartInstanceType.class, FUtils.chain(NcStartInstanceType.class::cast, nodeService::startInstance));
    handlers.put(NcStopInstanceType.class, FUtils.chain(NcStopInstanceType.class::cast, nodeService::stopInstance));
    handlers.put(NcRebootInstanceType.class, FUtils.chain(NcRebootInstanceType.class::cast, nodeService::rebootInstance));
    handlers.put(NcTerminateInstanceType.class, FUtils.chain(NcTerminateInstanceType.class::cast, nodeService::terminateInstance));
    handlers.put(NcGetConsoleOutputType.class, FUtils.chain(NcGetConsoleOutputType.class::cast, nodeService::getConsoleOutput));
    handlers.put(NcBundleInstanceType.class, FUtils.chain(NcBundleInstanceType.class::cast, nodeService::bundleInstance));
    handlers.put(NcBundleRestartInstanceType.class, FUtils.chain(NcBundleRestartInstanceType.class::cast, nodeService::bundleRestartInstance));
    handlers.put(NcCancelBundleTaskType.class, FUtils.chain(NcCancelBundleTaskType.class::cast, nodeService::cancelBundleTask));
    handlers.put(NcAttachVolumeType.class, FUtils.chain(NcAttachVolumeType.class::cast, nodeService::attachVolume));
    handlers.put(NcDetachVolumeType.class, FUtils.chain(NcDetachVolumeType.class::cast, nodeService::detachVolume));
    return ImmutableMap.copyOf(handlers);
  }

  public CloudNodeMessage handle(final CloudNodeMessage request) {
    return handlers.get(request.getClass()).apply(request);
  }
}
