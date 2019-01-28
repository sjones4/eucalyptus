/**
 * Copyright 2019 AppScale Systems, Inc
 *
 * SPDX-License-Identifier: BSD-2-Clause
 */
package com.eucalyptus.node;

import java.util.List;
import org.graalvm.nativeimage.c.CContext;
import org.graalvm.nativeimage.c.constant.CConstant;
import org.graalvm.nativeimage.c.function.CFunction;
import org.graalvm.nativeimage.c.struct.CField;
import org.graalvm.nativeimage.c.struct.CFieldAddress;
import org.graalvm.nativeimage.c.struct.CPointerTo;
import org.graalvm.nativeimage.c.struct.CStruct;
import org.graalvm.nativeimage.c.type.CCharPointer;
import org.graalvm.nativeimage.c.type.CCharPointerPointer;
import org.graalvm.nativeimage.c.type.CIntPointer;
import org.graalvm.word.PointerBase;
import com.eucalyptus.node.NodeInterface.NodeInterfaceDirectives;
import com.google.common.collect.Lists;

/**
 *
 */
@SuppressWarnings( "unused" )
@CContext( NodeInterfaceDirectives.class)
public class NodeInterface {

  static class NodeInterfaceDirectives implements CContext.Directives {

    @Override
    public List<String> getOptions( ) {
      return Lists.newArrayList(
          "-DHANDLERS_FANOUT"
      );
    }

    @Override
    public List<String> getHeaderFiles() {
      return Lists.newArrayList(
          "\"handlers.h\"", "\"eucalyptus-config.h\""
      );
    }

    @Override
    public List<String> getLibraries( ) {
      return Lists.newArrayList(
          "eucanode", "crypto", "curl", "dl", "m", "json-c", "virt", "ssl", "xml2", "xslt", "z"
      );
    }
  }

  @CStruct("serviceInfoType")
  interface ServiceInfoType extends PointerBase {

    @CFieldAddress("type")
    CCharPointer type();

    @CFieldAddress("name")
    CCharPointer name();

    @CFieldAddress("partition")
    CCharPointer partition();

    @CFieldAddress("uris")
    CCharPointerPointer uris();

    @CField("urisLen")
    int getUrisLen();

    @CField("urisLen")
    void setUrisLen(int urisLen);
  }

  @CPointerTo(ServiceInfoType.class)
  public interface ServiceInfoTypePointer extends PointerBase {

    ServiceInfoType read(int index);

    void write(int index, ServiceInfoType value);
  }

  @CStruct("ncMetadata")
  interface NcMetadata extends PointerBase {

    @CField("correlationId")
    CCharPointer getCorrelationId();

    @CField("correlationId")
    void setCorrelationId(CCharPointer correlationId);

    @CField("userId")
    CCharPointer getUserId();

    @CField("userId")
    void setUserId(CCharPointer userId);

    @CField("nodeName")
    CCharPointer getNodeName();

    @CField("nodeName")
    void setNodeName(CCharPointer nodeName);

    @CField("epoch")
    int getEpoch();

    @CField("epoch")
    void setEpoch(int epoch);

    @CFieldAddress("services")
    ServiceInfoTypePointer services();

    @CFieldAddress("disabledServices")
    ServiceInfoTypePointer disabledServices();

    @CFieldAddress("notreadyServices")
    ServiceInfoTypePointer notreadyServices();

    @CField("servicesLen")
    int getServicesLen();

    @CField("servicesLen")
    void setServicesLen(int servicesLen);

    @CField("disabledServicesLen")
    int getDisabledServicesLen();

    @CField("disabledServicesLen")
    void setDisabledServicesLen(int disabledServicesLen);

    @CField("notreadyServicesLen")
    int getNotreadyServicesLen();

    @CField("notreadyServicesLen")
    void setNotreadyServicesLen(int notreadyServicesLen);

    @CField("replyString")
    CCharPointer getReplyString();

    @CField("replyString")
    void getReplyString(CCharPointer replyString);
  }

  @CPointerTo(NcMetadata.class)
  public interface NcMetadataPointer extends PointerBase {

    NcMetadata read(int index);

    void write(int index, NcMetadata value);
  }

  @CStruct("ncResource")
  interface NcResource extends PointerBase {

    @CFieldAddress( "nodeStatus" )
    CCharPointer nodeStatus();

    @CFieldAddress("iqn")
    CCharPointer iqn();

    @CField("migrationCapable")
    boolean getMigrationCapable();

    @CField("migrationCapable")
    void setMigrationCapable(boolean migrationCapable);

    @CField("memorySizeMax")
    int getMemorySizeMax();

    @CField("memorySizeMax")
    void setMemorySizeMax(int memorySizeMax);

    @CField("memorySizeAvailable")
    int getMemorySizeAvailable();

    @CField("memorySizeAvailable")
    void setMemorySizeAvailable(int memorySizeAvailable);

    @CField("diskSizeMax")
    int getDiskSizeMax();

    @CField("diskSizeMax")
    void setDiskSizeMax(int diskSizeMax);

    @CField("diskSizeAvailable")
    int getDiskSizeAvailable();

    @CField("diskSizeAvailable")
    void setDiskSizeAvailable(int diskSizeAvailable);

    @CField("numberOfCoresMax")
    int getNumberOfCoresMax();

    @CField("numberOfCoresMax")
    void setNumberOfCoresMax(int numberOfCoresMax);

    @CField("numberOfCoresAvailable")
    int getNumberOfCoresAvailable();

    @CField("numberOfCoresAvailable")
    void setNumberOfCoresAvailable(int numberOfCoresAvailable);

    @CFieldAddress("publicSubnets")
    CCharPointer publicSubnets();

    @CFieldAddress("hypervisor")
    CCharPointer hypervisor();
  }

  @CPointerTo(NcResource.class)
  interface NcResourcePointer extends PointerBase {

    NcResource read(int index);

    void write(int index, NcResource value);
  }

  @CStruct("sensorValue")
  interface SensorValue extends PointerBase {
//    long long timestampMs;             //!< in milliseconds

    @CField("value")
    double getValue();

    @CField("value")
    void setValue(double value);

//    char available;                    //!< if '1' then value is valid, otherwise it is not
  }

  @CStruct("sensorDimension")
  interface SensorDimension extends PointerBase {
    @CFieldAddress( "dimensionName" )
    CCharPointer dimensionName();

    @CFieldAddress( "dimensionAlias" )
    CCharPointer dimensionAlias();

//    long long sequenceNum;             //!< num of first value in values[], starts with 0 when sensor is reset
//    sensorValue values[MAX_SENSOR_VALUES];  //!< array of values (not pointers, to simplify shared-memory region use)
//    int valuesLen;                     //!< size of the array
//    int firstValueIndex;               //!< index into values[] of the first value (one that matches sequenceNum)
//    double shift_value;                // amount that should be added to all values at this dimension
  }

  @CStruct("sensorCounter")
  interface SensorCounter extends PointerBase {
//    sensorCounterType type;
//    long long collectionIntervalMs;    //!< the spacing of values, based on sensor's configuration
//    sensorDimension dimensions[MAX_SENSOR_DIMENSIONS];  //!< array of values (not pointers, to simplify shared-memory region use)

    @CField("dimensionsLen")
    int getDimensionsLen();

    @CField("dimensionsLen")
    void setDimensionsLen(int dimensionsLen);
  }

  @CStruct("sensorMetric")
  interface SensorMetric extends PointerBase {
    @CFieldAddress( "metricName" )
    CCharPointer metricName();

//    char [MAX_SENSOR_NAME_LEN];   //!< e.g. "CPUUtilization"
//    sensorCounter counters[MAX_SENSOR_COUNTERS];    //!< array of values (not pointers, to simplify shared-memory region use)
//    int countersLen;                   //!< size of the array
  }

  @CStruct("sensorResource")
  interface SensorResource extends PointerBase {
    @CFieldAddress( "resourceName" )
    CCharPointer resourceName();

    @CFieldAddress( "resourceAlias" )
    CCharPointer resourceAlias();

    @CFieldAddress( "resourceType" )
    CCharPointer resourceType();

    @CFieldAddress( "resourceUuid" )
    CCharPointer resourceUuid();

    //TODO
    //sensorMetric metrics[MAX_SENSOR_METRICS];   //!< array of values (not pointers, to simplify shared-memory region use)

    @CField("metricsLen")
    int getMetricsLen();

    @CField("metricsLen")
    void setMetricsLen(int metricsLen);

    @CField("timestamp")
    int getTimestamp();

    @CField("timestamp")
    void setTimestamp(int timestamp);
  }

  @CPointerTo(SensorResource.class)
  interface SensorResourcePointer extends PointerBase {
    SensorResource read(int index);
    void write(int index, SensorResource value);
  }

  @CPointerTo(SensorResourcePointer.class)
  interface SensorResourcePointerPointer extends PointerBase {
    SensorResourcePointer read(int index);
    void write(int index, SensorResourcePointer value);
  }

  @CStruct("virtualBootRecord")
  interface NcVirtualBootRecord extends PointerBase {
    @CFieldAddress("resourceLocation")
    CCharPointer resourceLocation();

    @CFieldAddress("guestDeviceName")
    CCharPointer guestDeviceName();

    @CField("sizeBytes") // long long
    long getSizeBytes();

    @CField("sizeBytes")
    void setSizeBytes(long sizeBytes);

    @CFieldAddress("formatName")
    CCharPointer formatName();

    @CFieldAddress("id")
    CCharPointer id();

    @CFieldAddress("typeName")
    CCharPointer typeName();

//    // Set by NC
//    ncResourceType type;               //!< NC_RESOURCE_{IMAGE|RAMDISK|...}
//    ncResourceLocationType locationType;    //!< NC_LOCATION_{URL|OBJECT_STORAGE...}
//    ncResourceFormatType format;       //!< NC_FORMAT_{NONE|EXT2|EXT3|SWAP}
//    int diskNumber;                    //!< 0 = [sh]da or fd0, 1 = [sh]db or fd1, etc.
//    int partitionNumber;               //!< 0 = whole disk, 1 = partition 1, etc.
//    libvirtDevType guestDeviceType;    //!< DEV_TYPE_{DISK|FLOPPY|CDROM}
//    libvirtBusType guestDeviceBus;     //!< BUS_TYPE_{IDE|SCSI|VIRTIO|XEN}
//    libvirtSourceType backingType;     //!< SOURCE_TYPE_{FILE|BLOCK}
//    char backingPath[VERY_BIG_CHAR_BUFFER_SIZE];    //!< XML for describing the disk to libvirt
//    char preparedResourceLocation[VERY_BIG_CHAR_BUFFER_SIZE];   //!< e.g., URL + resourceLocation for Walrus downloads, sc url for ebs volumes prior to SC call, then connection string for ebs volumes returned from SC

    @CFieldAddress("guestDeviceSerialId")
    CCharPointer guestDeviceSerialId();
  }

  @CPointerTo(NcVirtualBootRecord.class)
  public interface NcVirtualBootRecordPointer extends PointerBase {
    NcVirtualBootRecord read(int index);
    void write(int index, NcVirtualBootRecord value);
  }

  @CStruct("virtualMachine")
  interface NcVirtualMachine extends PointerBase {
    @CField("mem")
    int getMem();

    @CField("mem")
    void setMem(int mem);

    @CField("cores")
    int getCores();

    @CField("cores")
    void setCores(int cores);

    @CField("disk")
    int getDisk();

    @CField("disk")
    void setDisk(int disk);

    @CFieldAddress("name")
    CCharPointer name();

    @CField("root") // root boot record information
    NcVirtualBootRecordPointer getRoot();

    @CField("root")
    void setRoot(NcVirtualBootRecordPointer root);

    @CField("kernel")
    NcVirtualBootRecordPointer getKernel();

    @CField("kernel")
    void setKernel(NcVirtualBootRecordPointer kernel);

    @CField("ramdisk")
    NcVirtualBootRecordPointer getRamdisk();

    @CField("ramdisk")
    void setRamdisk(NcVirtualBootRecordPointer ramdisk);

    @CField("swap")
    NcVirtualBootRecordPointer getSwap();

    @CField("swap")
    void setSwap(NcVirtualBootRecordPointer swap);

    @CField("ephemeral0")
    NcVirtualBootRecordPointer getEphemeral0();

    @CField("ephemeral0")
    void setEphemeral0(NcVirtualBootRecordPointer ephemeral0);

    @CField("boot")
    NcVirtualBootRecordPointer getBoot();

    @CField("boot")
    void setBoot(NcVirtualBootRecordPointer boot);

    @CFieldAddress("virtualBootRecord")
    NcVirtualBootRecordPointer getVirtualBootRecord();

    @CField("virtualBootRecordLen")
    int getVirtualBootRecordLen();

    @CField("virtualBootRecordLen")
    void setVirtualBootRecordLen(int virtualBootRecordLen);

//    libvirtNicType nicType;            //!< Defines the virtual machine NIC type

    @CFieldAddress( "guestNicDeviceName" )
    CCharPointer guestNicDeviceName();
  }

  @CStruct("netConfig")
  interface NcNetConfig extends PointerBase {
    NcNetConfig addressOf(int index);

    @CField("vlan")
    int getVlan();

    @CField("vlan")
    void setVlan(int vlan);

    @CField("networkIndex")
    int getNetworkIndex();

    @CField("networkIndex")
    void setNetworkIndex(int networkIndex);

    @CFieldAddress( "privateMac" )
    CCharPointer privateMac();

    @CFieldAddress( "publicIp" )
    CCharPointer publicIp();

    @CFieldAddress( "privateIp" )
    CCharPointer privateIp();

    @CField("device")
    int getDevice();

    @CField("device")
    void setDevice(int device);

    @CFieldAddress( "interfaceId" )
    CCharPointer interfaceId();

    @CFieldAddress( "stateName" )
    CCharPointer stateName();

    @CFieldAddress( "attachmentId" )
    CCharPointer attachmentId();
  }

  @CStruct("ncVolume")
  interface NcVolume extends PointerBase {
    NcVolume addressOf(int index);

    @CFieldAddress( "volumeId" )
    CCharPointer volumeId();

    @CFieldAddress( "attachmentToken" )
    CCharPointer attachmentToken();

    @CFieldAddress( "devName" )
    CCharPointer devName();

    @CFieldAddress( "stateName" )
    CCharPointer stateName();

    @CFieldAddress( "connectionString" )
    CCharPointer connectionString();

    @CFieldAddress( "volLibvirtXml" )
    CCharPointer volLibvirtXml();
  }

  @CStruct("ncInstance")
  interface NcInstance extends PointerBase {
    @CFieldAddress("uuid")
    CCharPointer uuid();

    @CFieldAddress("instanceId")
    CCharPointer instanceId();

    @CFieldAddress("reservationId")
    CCharPointer reservationId();

    @CFieldAddress("userId")
    CCharPointer userId();

    @CFieldAddress("ownerId")
    CCharPointer ownerId();

    @CFieldAddress("accountId")
    CCharPointer accountId();

    @CFieldAddress("imageId")
    CCharPointer imageId();

    @CFieldAddress("kernelId")
    CCharPointer kernelId();

    @CFieldAddress("ramdiskId")
    CCharPointer ramdiskId();

    @CField("retries")
    int getRetries();

    @CField("retries")
    void setRetries(int retries);

    @CFieldAddress("stateName")
    CCharPointer stateName();

    @CFieldAddress("bundleTaskStateName")
    CCharPointer bundleTaskStateName();

    @CField("bundleTaskProgress")
    double getBundleTaskProgress();

    @CField("bundleTaskProgress")
    void setBundleTaskProgress(double bundleTaskProgress);

    @CFieldAddress("createImageTaskStateName")
    CCharPointer createImageTaskStateName();

    @CField("stateCode")
    int getStateCode();

    @CField("stateCode")
    void setStateCode(int stateCode);

//TODO
//    instance_states state;             //!< Instance state
//    bundling_progress bundleTaskState; //!< Bundling task progress state

    @CField("bundleBucketExists")
    int getBundleBucketExists();

    @CField("bundleBucketExists")
    void setBundleBucketExists(int bundleBucketExists);

    @CField("bundleCanceled")
    int getBundleCanceled();

    @CField("bundleCanceled")
    void setBundleCanceled(int bundleCanceled);

//TODO
//    createImage_progress createImageTaskState;  //!< Image creation task progress state

    @CField("createImagePid")
    int getCreateImagePid();

    @CField("createImagePid")
    void setCreateImagePid(int createImagePid);

    @CField("createImageCanceled")
    int getCreateImageCanceled();

    @CField("createImageCanceled")
    void setCreateImageCanceled(int createImageCanceled);

//TODO
//    migration_states migration_state;  //!< Migration state

    @CFieldAddress("migration_src")
    CCharPointer migrationSrc();

    @CFieldAddress("migration_dst")
    CCharPointer migrationDst();

    @CFieldAddress("migration_credentials")
    CCharPointer migrationCredentials();

    @CFieldAddress("keyName")
    CCharPointer keyName();

    @CFieldAddress("privateDnsName")
    CCharPointer privateDnsName();

    @CFieldAddress("dnsName")
    CCharPointer dnsName();

    @CField("launchTime")
    int getLaunchTime();

    @CField("launchTime")
    void setLaunchTime(int launchTime);

    @CField("expiryTime")
    int getExpiryTime();

    @CField("expiryTime")
    void setExpiryTime(int expiryTime);

    @CField("bootTime")
    int getBootTime();

    @CField("bootTime")
    void setBootTime(int bootTime);

    @CField("rebootTime")
    int getRebootTime();

    @CField("rebootTime")
    void setRebootTime(int rebootTime);

    @CField("bundlingTime")
    int getBundlingTime();

    @CField("bundlingTime")
    void setBundlingTime(int bundlingTime);

    @CField("createImageTime")
    int getCreateImageTime();

    @CField("createImageTime")
    void setCreateImageTime(int createImageTime);

    @CField("terminationRequestedTime")
    int getTerminationRequestedTime();

    @CField("terminationRequestedTime")
    void setTerminationRequestedTime(int terminationRequestedTime);

    @CField("terminationTime")
    int getTerminationTime();

    @CField("terminationTime")
    void setTerminationTime(int terminationTime);

    @CField("migrationTime")
    int getMigrationTime();

    @CField("migrationTime")
    void setMigrationTime(int migrationTime);

    @CFieldAddress("params")
    NcVirtualMachine params();

    @CFieldAddress("ncnet")
    NcNetConfig ncnet();

//TODO
//    pthread_t tcb;                     //!< Instance thread

    @CFieldAddress("instancePath")
    CCharPointer instancePath();

    @CFieldAddress("xmlFilePath")
    CCharPointer xmlFilePath();

    @CFieldAddress("libvirtFilePath")
    CCharPointer libvirtFilePath();

    @CFieldAddress("consoleFilePath")
    CCharPointer consoleFilePath();

    @CFieldAddress("floppyFilePath")
    CCharPointer floppyFilePath();

    @CFieldAddress("hypervisorType")
    CCharPointer hypervisorType();

//TODO
//    hypervisorCapabilityType hypervisorCapability;  //!< What is the hypervisor capable of for this instance

    @CField("hypervisorBitness")
    int getHypervisorBitness();

    @CField("hypervisorBitness")
    void setHypervisorBitness(int hypervisorBitness);

    @CField("combinePartitions")
    boolean getCombinePartitions();

    @CField("combinePartitions")
    void setCombinePartitions(boolean combinePartitions);

    @CField("do_inject_key")
    boolean getDoInjectKey();

    @CField("do_inject_key")
    void setDoInjectKey(boolean doInjectKey);

    @CFieldAddress("userData")
    CCharPointer userData();

    @CFieldAddress("launchIndex")
    CCharPointer launchIndex();

    @CFieldAddress("platform")
    CCharPointer platform();

    @CFieldAddress("groupNames")
    CCharPointer groupNames();

    @CField("groupNamesSize")
    int getGroupNamesSize();

    @CField("groupNamesSize")
    void setGroupNamesSize(int groupNamesSize);

    @CFieldAddress("groupIds")
    CCharPointer groupIds();

    @CField("groupIdsSize")
    int getGroupIdsSize();

    @CField("groupIdsSize")
    void setGroupIdsSize(int groupIdsSize);

    @CFieldAddress("volumes")
    NcVolume volumes();

    @CField("blkbytes") // long long
    long getBlkbytes();

    @CField("blkbytes")
    void setBlkbytes(long blkbytes);

    @CField("netbytes")
    long getNetbytes();

    @CField("netbytes")
    void setNetbytes(long netbytes);

//TODO
//    time_t last_stat;                  //!< Last time these statistics were updated

    @CFieldAddress("guestStateName")
    CCharPointer guestStateName();

    @CField("stop_requested")
    boolean getStopRequested();

    @CField("stop_requested")
    void setStopRequested(boolean stopRequested);

    @CFieldAddress("credential")
    CCharPointer credential();

    @CField("hasFloppy")
    boolean getHasFloppy();

    @CField("hasFloppy")
    void setHasFloppy(boolean hasFloppy);

    @CField("bail_flag")
    boolean getBailFlag();

    @CField("bail_flag")
    void setBailFlag(boolean bailFlag);

    @CFieldAddress("rootDirective")
    CCharPointer rootDirective();

    @CFieldAddress("secNetCfgs")
    NcNetConfig secNetCfgs();
  }

  @CPointerTo(NcInstance.class)
  public interface NcInstancePointer extends PointerBase {
    NcInstance read(int index);
    void write(int index, NcInstance value);
  }

  @CPointerTo(NcInstancePointer.class)
  public interface NcInstancePointerPointer extends PointerBase {
    NcInstancePointer read(int index);
    void write(int index, NcInstancePointer value);
  }

  @CPointerTo(NcInstancePointerPointer.class)
  public interface NcInstancePointerPointerPointer extends PointerBase {
    NcInstancePointerPointer read(int index);
    void write(int index, NcInstancePointerPointer value);
  }

  @CConstant("EUCA_VERSION")
  public static native String getEucaVersion();

  @CConstant("EUCA_MAX_NICS")
  public static native int getEucaMaxNics();

  @CConstant("EUCA_MAX_VOLUMES")
  public static native int getEucaMaxVolumes();

  @CFunction("doInitNC")
  public static native void doInitNC();

  @CFunction("doDescribeResource")
  public static native int doDescribeResource(
      NcMetadata ncMetadata,
      CCharPointer resourceType,
      NcResourcePointer outRes);

  @CFunction("doDescribeSensors")
  public static native int doDescribeSensors(
      NcMetadata ncMetadata,
      int historySize,
      long collectionIntervalTimeMs,
      CCharPointerPointer instIds,
      int instIdsLen,
      CCharPointerPointer sensorIds,
      int sensorIdsLen,
      SensorResourcePointerPointer outResources,
      CIntPointer outResourcesLen);

  @CFunction("doDescribeInstances")
  public static native int doDescribeInstances(
      NcMetadata ncMetadata,
      CCharPointerPointer instIds,
      int instIdsLen,
      NcInstancePointerPointer outInsts,
      CIntPointer outInstsLen);

  @CFunction("doBroadcastNetworkInfo")
  public static native int doBroadcastNetworkInfo(
      NcMetadata ncMetadata,
      CCharPointer networkInfo);

  @CFunction("doModifyNode")
  public static native int doModifyNode(
      NcMetadata ncMetadata,
      CCharPointer stateName);

  @CFunction("doGetConsoleOutput")
  public static native int doGetConsoleOutput(
      NcMetadata ncMetadata,
      CCharPointer instanceId,
      CCharPointerPointer consoleOutput);
}
