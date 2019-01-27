/**
 * Copyright 2019 AppScale Systems, Inc
 *
 * SPDX-License-Identifier: BSD-2-Clause
 */
package com.eucalyptus.node;

import java.util.ArrayList;
import java.util.List;
import org.graalvm.nativeimage.StackValue;
import org.graalvm.nativeimage.c.type.CIntPointer;
import org.graalvm.nativeimage.c.type.CTypeConversion;
import org.graalvm.nativeimage.c.type.CTypeConversion.CCharPointerHolder;
import org.graalvm.nativeimage.c.type.CTypeConversion.CCharPointerPointerHolder;
import com.eucalyptus.cluster.common.msgs.InstanceType;
import com.eucalyptus.cluster.common.msgs.NcAttachVolumeResponseType;
import com.eucalyptus.cluster.common.msgs.NcAttachVolumeType;
import com.eucalyptus.cluster.common.msgs.NcBroadcastNetworkInfoResponseType;
import com.eucalyptus.cluster.common.msgs.NcBroadcastNetworkInfoType;
import com.eucalyptus.cluster.common.msgs.NcBundleInstanceResponseType;
import com.eucalyptus.cluster.common.msgs.NcBundleInstanceType;
import com.eucalyptus.cluster.common.msgs.NcBundleRestartInstanceResponseType;
import com.eucalyptus.cluster.common.msgs.NcBundleRestartInstanceType;
import com.eucalyptus.cluster.common.msgs.NcCancelBundleTaskResponseType;
import com.eucalyptus.cluster.common.msgs.NcCancelBundleTaskType;
import com.eucalyptus.cluster.common.msgs.NcDescribeInstancesResponseType;
import com.eucalyptus.cluster.common.msgs.NcDescribeInstancesType;
import com.eucalyptus.cluster.common.msgs.NcDescribeResourceResponseType;
import com.eucalyptus.cluster.common.msgs.NcDescribeResourceType;
import com.eucalyptus.cluster.common.msgs.NcDescribeSensorsResponseType;
import com.eucalyptus.cluster.common.msgs.NcDescribeSensorsType;
import com.eucalyptus.cluster.common.msgs.NcDetachVolumeResponseType;
import com.eucalyptus.cluster.common.msgs.NcDetachVolumeType;
import com.eucalyptus.cluster.common.msgs.NcGetConsoleOutputResponseType;
import com.eucalyptus.cluster.common.msgs.NcGetConsoleOutputType;
import com.eucalyptus.cluster.common.msgs.NcMigrateInstancesResponseType;
import com.eucalyptus.cluster.common.msgs.NcMigrateInstancesType;
import com.eucalyptus.cluster.common.msgs.NcModifyNodeResponseType;
import com.eucalyptus.cluster.common.msgs.NcModifyNodeType;
import com.eucalyptus.cluster.common.msgs.NcRebootInstanceResponseType;
import com.eucalyptus.cluster.common.msgs.NcRebootInstanceType;
import com.eucalyptus.cluster.common.msgs.NcRunInstanceResponseType;
import com.eucalyptus.cluster.common.msgs.NcRunInstanceType;
import com.eucalyptus.cluster.common.msgs.NcStartInstanceResponseType;
import com.eucalyptus.cluster.common.msgs.NcStartInstanceType;
import com.eucalyptus.cluster.common.msgs.NcStopInstanceResponseType;
import com.eucalyptus.cluster.common.msgs.NcStopInstanceType;
import com.eucalyptus.cluster.common.msgs.NcTerminateInstanceResponseType;
import com.eucalyptus.cluster.common.msgs.NcTerminateInstanceType;
import com.eucalyptus.node.NodeInterface.NcInstancePointerPointer;
import com.eucalyptus.node.NodeInterface.NcMetadata;
import com.google.common.collect.Lists;

/**
 *
 */
public class NodeServiceImpl {

  public NcDescribeInstancesResponseType describeInstances(final NcDescribeInstancesType request) {
    final NcDescribeInstancesResponseType response = request.getReply();
    final NcMetadata meta = StackValue.get(NcMetadata.class);
    meta.setServicesLen(0);
    meta.setDisabledServicesLen(0);
    meta.setNotreadyServicesLen(0);
    final NcInstancePointerPointer instancePointerPointer = StackValue.get(NcInstancePointerPointer.class);
    final CIntPointer instanceCount = StackValue.get(CIntPointer.class);
//    long long call_time = time_ms();
//    pthread_mutex_lock(&ncHandlerLock);
    final List<String> requestInstanceIds = request.getInstanceIds();
    final String[] requestIdsArray = requestInstanceIds==null ?
        new String[0] : requestInstanceIds.toArray(new String[0]);
    try (final CCharPointerPointerHolder instanceIds = CTypeConversion.toCStrings(requestIdsArray);
         final CCharPointerHolder userId = CTypeConversion.toCString("eucalyptus")){
      // EUCA_MESSAGE_UNMARSHAL request -> meta
      //threadCorrelationId *corr_id = set_corrid(meta.correlationId);
      meta.setUserId(userId.get());
      NodeInterface.doDescribeInstances(
          meta,
          instanceIds.get(),
          requestIdsArray.length,
          instancePointerPointer, //TODO:STEVE: need to free these?
          instanceCount);
      //unset_corrid(corr_id);

      ArrayList<InstanceType> responseInstances = Lists.newArrayList();
      for (int i=0; i<instanceCount.read(); i++) {
        final InstanceType instanceType = new InstanceType();
        instanceType.setInstanceId(CTypeConversion.toJavaString(instancePointerPointer.read(0).read(i).instanceId()));
        instanceType.setImageId(CTypeConversion.toJavaString(instancePointerPointer.read(0).read(i).imageId()));
        responseInstances.add(instanceType);
      }
      response.setInstances(responseInstances);
    }
//    pthread_mutex_unlock(&ncHandlerLock);
//    nc_update_message_stats("BroadcastNetworkInfo", (long)(time_ms() - call_time), error);
    return response;
  }

  public NcDescribeResourceResponseType describeResource(final NcDescribeResourceType request) {
    return request.getReply();
  }

  public NcDescribeSensorsResponseType describeSensors(final NcDescribeSensorsType request) {
    return request.getReply();
  }

  public NcBroadcastNetworkInfoResponseType broadcastNetworkInfo(
      final NcBroadcastNetworkInfoType request
  ) {
    final NcMetadata meta = StackValue.get(NcMetadata.class);
//    long long call_time = time_ms();
//    pthread_mutex_lock(&ncHandlerLock);
    try (final CCharPointerHolder networkInfo = CTypeConversion.toCString(request.getNetworkInfo())){
      // EUCA_MESSAGE_UNMARSHAL request -> meta
      //threadCorrelationId *corr_id = set_corrid(meta.correlationId);
      NodeInterface.doBroadcastNetworkInfo(meta, networkInfo.get());
      //unset_corrid(corr_id);
    }
//    pthread_mutex_unlock(&ncHandlerLock);
//    nc_update_message_stats("BroadcastNetworkInfo", (long)(time_ms() - call_time), error);
    return request.getReply();
  }

  public NcMigrateInstancesResponseType migrateInstances(final NcMigrateInstancesType request) {
    return request.getReply();
  }

  public NcModifyNodeResponseType modifyNode(final NcModifyNodeType request) {
    final NcMetadata meta = StackValue.get(NcMetadata.class);
//    long long call_time = time_ms();
//    pthread_mutex_lock(&ncHandlerLock);
//    eventlog("NC", userId, correlationId, "ModifyNode", "begin");
    try (final CCharPointerHolder stateName = CTypeConversion.toCString(request.getStateName())) {
//      correlationId = adb_ncModifyNodeType_get_correlationId(input, env);
//      userId = adb_ncModifyNodeType_get_userId(input, env);
//      threadCorrelationId *corr_id = set_corrid(meta.correlationId);
      NodeInterface.doModifyNode(meta, stateName.get());
//      unset_corrid(corr_id);
//      if (error != EUCA_OK) {
//        LOGERROR("failed error=%d\n", error);
//        adb_ncModifyNodeResponseType_set_return(output, env, AXIS2_FALSE);
    }
//    pthread_mutex_unlock(&ncHandlerLock);
//    eventlog("NC", userId, correlationId, "ModifyNode", "end");
//    nc_update_message_stats("ModifyNode", (long)(time_ms() - call_time), error);
    return request.getReply();
  }

  public NcRunInstanceResponseType runInstance(final NcRunInstanceType request) {
    return request.getReply();
  }

  public NcStartInstanceResponseType startInstance(final NcStartInstanceType request) {
    return request.getReply();
  }

  public NcStopInstanceResponseType stopInstance(final NcStopInstanceType request) {
    return request.getReply();
  }

  public NcRebootInstanceResponseType rebootInstance(final NcRebootInstanceType request) {
    return request.getReply();
  }

  public NcTerminateInstanceResponseType terminateInstance(final NcTerminateInstanceType request) {
    return request.getReply();
  }

  public NcGetConsoleOutputResponseType getConsoleOutput(final NcGetConsoleOutputType request) {
    return request.getReply();
  }

  public NcBundleInstanceResponseType bundleInstance(final NcBundleInstanceType request) {
    return request.getReply();
  }

  public NcBundleRestartInstanceResponseType bundleRestartInstance(final NcBundleRestartInstanceType request) {
    return request.getReply();
  }

  public NcCancelBundleTaskResponseType cancelBundleTask(final NcCancelBundleTaskType request) {
    return request.getReply();
  }

  public NcAttachVolumeResponseType attachVolume(final NcAttachVolumeType request) {
    return request.getReply();
  }

  public NcDetachVolumeResponseType detachVolume(final NcDetachVolumeType request) {
    return request.getReply();
  }
}
