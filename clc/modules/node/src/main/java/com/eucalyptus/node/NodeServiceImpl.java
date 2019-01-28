/**
 * Copyright 2019 AppScale Systems, Inc
 *
 * SPDX-License-Identifier: BSD-2-Clause
 */
package com.eucalyptus.node;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.graalvm.nativeimage.StackValue;
import org.graalvm.nativeimage.c.struct.SizeOf;
import org.graalvm.nativeimage.c.type.CCharPointer;
import org.graalvm.nativeimage.c.type.CCharPointerPointer;
import org.graalvm.nativeimage.c.type.CIntPointer;
import org.graalvm.nativeimage.c.type.CTypeConversion;
import org.graalvm.nativeimage.c.type.CTypeConversion.CCharPointerHolder;
import org.graalvm.nativeimage.c.type.CTypeConversion.CCharPointerPointerHolder;
import org.graalvm.word.PointerBase;
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
import com.eucalyptus.cluster.common.msgs.NetConfigType;
import com.eucalyptus.cluster.common.msgs.VirtualMachineType;
import com.eucalyptus.cluster.common.msgs.VolumeType;
import com.eucalyptus.node.NodeInterface.NcInstance;
import com.eucalyptus.node.NodeInterface.NcInstancePointerPointer;
import com.eucalyptus.node.NodeInterface.NcMetadata;
import com.eucalyptus.node.NodeInterface.NcNetConfig;
import com.eucalyptus.node.NodeInterface.NcVirtualMachine;
import com.eucalyptus.node.NodeInterface.NcVolume;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import edu.ucsb.eucalyptus.msgs.BaseMessage;

/**
 *
 */
public class NodeServiceImpl {

  private static String nej_s(final CCharPointer cCharPointer) {
    final String value = j_s(cCharPointer);
    return value==null || value.isEmpty() ? null : value;
  }

  private static String j_s(final CCharPointer cCharPointer) {
    return cCharPointer.isNull() ?
        null :
        CTypeConversion.toJavaString(cCharPointer);
  }

  /**
   * String list from char[][size]
   */
  private static ArrayList<String> j_sl(final int length, final int size, final CCharPointer cCharPointer) {
    final ArrayList<String> values = Lists.newArrayList();
    if (cCharPointer.isNonNull()) {
      for ( int i = 0; i < length; i++ ) {
        values.add(j_s(cCharPointer.addressOf(i*size)));
      }
    }
    return values;
  }

  private void setFrom(final VirtualMachineType vmType, final NcVirtualMachine params) {
    vmType.setMemory(params.getMem());
    vmType.setCores(params.getCores());
    vmType.setDisk(params.getDisk());
    vmType.setName(j_s(params.name()));

//TODO implement
//        for (i = 0; ((i < EUCA_MAX_VBRS) && (i < params->virtualBootRecordLen)); i++) {
//          vbr = &params->virtualBootRecord[i];
//          if (strlen(vbr->resourceLocation) > 0) {
//            if ((vbr_type = adb_virtualBootRecordType_create(env)) != NULL) {
//              adb_virtualBootRecordType_set_resourceLocation(vbr_type, env, vbr->resourceLocation);
//              adb_virtualBootRecordType_set_guestDeviceName(vbr_type, env, vbr->guestDeviceName);
//              adb_virtualBootRecordType_set_size(vbr_type, env, (int64_t) vbr->sizeBytes);
//              adb_virtualBootRecordType_set_format(vbr_type, env, vbr->formatName);
//              adb_virtualBootRecordType_set_id(vbr_type, env, vbr->id);
//              adb_virtualBootRecordType_set_type(vbr_type, env, vbr->typeName);
//              adb_virtualMachineType_add_virtualBootRecord(vm_type, env, vbr_type);
  }


  private void setFrom( final NetConfigType netConfigType, final NcNetConfig ncNetConfig) {
    netConfigType.setInterfaceId(j_s(ncNetConfig.interfaceId()));
    netConfigType.setDevice(ncNetConfig.getDevice());
    netConfigType.setPrivateMacAddress(j_s(ncNetConfig.privateMac()));
    netConfigType.setPrivateIp(j_s(ncNetConfig.privateIp()));
    netConfigType.setPublicIp(j_s(ncNetConfig.publicIp()));
    netConfigType.setVlan(ncNetConfig.getVlan());
    netConfigType.setNetworkIndex(ncNetConfig.getNetworkIndex());
    netConfigType.setAttachmentId(nej_s(ncNetConfig.attachmentId()));
  }

  private void setFrom(final VolumeType volumeType, final NcVolume ncVolume) {
    volumeType.setVolumeId(j_s(ncVolume.volumeId()));
    volumeType.setRemoteDev(j_s(ncVolume.attachmentToken()));
    volumeType.setLocalDev(j_s(ncVolume.devName()));
    volumeType.setState(j_s(ncVolume.stateName()));
  }

  private void setFrom(final InstanceType instanceType, final NcInstance outInst) {
    instanceType.setUuid(j_s(outInst.uuid()));
    instanceType.setReservationId(j_s(outInst.reservationId()));
    instanceType.setInstanceId(j_s(outInst.instanceId()));
    instanceType.setImageId(j_s(outInst.imageId()));
    instanceType.setKernelId(j_s(outInst.kernelId()));
    instanceType.setRamdiskId(j_s(outInst.ramdiskId()));
    instanceType.setUserId(j_s(outInst.userId()));
    instanceType.setOwnerId(j_s(outInst.ownerId()));
    instanceType.setAccountId(j_s(outInst.accountId()));
    instanceType.setKeyName(j_s(outInst.keyName()));

    final VirtualMachineType virtualMachineType = new VirtualMachineType();
    setFrom(virtualMachineType, outInst.params());
    instanceType.setInstanceType(virtualMachineType);

    final NetConfigType netConfigType = new NetConfigType();
    setFrom(netConfigType, outInst.ncnet());
    instanceType.setNetParams(netConfigType);

    final ArrayList<NetConfigType> secondaryNetConfig = Lists.newArrayList();
    for (int i=0; i<NodeInterface.getEucaMaxNics(); i++) {
      final NcNetConfig secNetConfig = outInst.secNetCfgs().addressOf(i);
      if (!Strings.isNullOrEmpty(j_s(secNetConfig.interfaceId())) &&
          "attached".equals(j_s(secNetConfig.stateName()))) {
        final NetConfigType secNetConfigType = new NetConfigType();
        setFrom(secNetConfigType, secNetConfig);
        secondaryNetConfig.add(secNetConfigType);
      }
    }
    instanceType.setSecondaryNetConfig(secondaryNetConfig);

    // reported by NC
    instanceType.setStateName(j_s(outInst.stateName()));
    instanceType.setGuestStateName(j_s(outInst.guestStateName()));
    instanceType.setBundleTaskStateName(j_s(outInst.bundleTaskStateName()));
    instanceType.setBundleTaskProgress(outInst.getBundleTaskProgress());
    instanceType.setCreateImageStateName(j_s(outInst.createImageTaskStateName()));

//TODO implement
//    axutil_date_time_t *dt = NULL;
//    dt = axutil_date_time_create_with_offset(env, outInst->launchTime - time(NULL));
//    instanceType.setLaunchTime(instance, env, dt);
    instanceType.setBlkbytes((int)outInst.getBlkbytes());
    instanceType.setNetbytes((int)outInst.getNetbytes());
//TODO implement
//    instanceType.setMigrationStateName(instance, env, migration_state_names[outInst->migration_state]);
    instanceType.setMigrationSource(j_s(outInst.migrationSrc()));
    instanceType.setMigrationDestination(j_s(outInst.migrationDst()));

    // passed into RunInstances for safekeeping by NC
    instanceType.setUserData(j_s(outInst.userData()));
    instanceType.setLaunchIndex(j_s(outInst.launchIndex()));
    instanceType.setPlatform(j_s(outInst.platform()));

    instanceType.setGroupNames(j_sl(outInst.getGroupNamesSize(), 512, outInst.groupNames())); //TODO CHAR_BUFFER_SIZE 512
    instanceType.setGroupIds(j_sl(outInst.getGroupIdsSize(), 512, outInst.groupIds()));       //TODO CHAR_BUFFER_SIZE 512

    // updated by NC upon Attach/DetachVolume
    final ArrayList<VolumeType> volumes = Lists.newArrayList();
    for (int i=0; i<NodeInterface.getEucaMaxVolumes(); i++) {
      final NcVolume ncVolume = outInst.volumes().addressOf(i);
      if (!Strings.isNullOrEmpty(j_s(ncVolume.volumeId()))) {
        final VolumeType volumeType = new VolumeType();
        setFrom(volumeType, ncVolume);
        volumes.add(volumeType);
      }
    }
    instanceType.setVolumes(volumes);

    // NOTE: serviceTag seen in the WSDL is unused in NC, used by CC
    instanceType.setHasFloopy(outInst.getHasFloppy()?1:0);
  }

  private <T extends PointerBase> T zero(final T t, final int sizeOf) {
    final ByteBuffer buffer = CTypeConversion.asByteBuffer(t, sizeOf);
    for (int i=0; i<buffer.limit(); i++) {
      buffer.put(i, (byte)0);
    }
    return t;
  }

  private <T extends BaseMessage> T success(final T response, final NcMetadata meta) {
    response.markWinning();
    response.setCorrelationId(CTypeConversion.toJavaString(meta.getCorrelationId()));
    response.setUserId(CTypeConversion.toJavaString(meta.getUserId()));
    return response;
  }

  public NcDescribeInstancesResponseType describeInstances(final NcDescribeInstancesType request) {
    final NcDescribeInstancesResponseType response = request.getReply();
    final NcMetadata meta = zero(StackValue.get(NcMetadata.class), SizeOf.get(NcMetadata.class));
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
        setFrom(instanceType, instancePointerPointer.read(0).read(i));
        responseInstances.add(instanceType);
      }
      response.setInstances(responseInstances);
    }
//    pthread_mutex_unlock(&ncHandlerLock);
//    nc_update_message_stats("BroadcastNetworkInfo", (long)(time_ms() - call_time), error);
    return success(response, meta);
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
    final NcGetConsoleOutputResponseType response = request.getReply();
    final NcMetadata meta = zero(StackValue.get(NcMetadata.class), SizeOf.get(NcMetadata.class));
    try (final CCharPointerHolder instanceId = CTypeConversion.toCString(request.getInstanceId())) {
      final CCharPointerPointer consoleOutput = StackValue.get(CCharPointerPointer.class);
      NodeInterface.doGetConsoleOutput(meta, instanceId.get(), consoleOutput);
      response.setConsoleOutput(j_s(consoleOutput.read()));
    }
    return success(response, meta);
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
