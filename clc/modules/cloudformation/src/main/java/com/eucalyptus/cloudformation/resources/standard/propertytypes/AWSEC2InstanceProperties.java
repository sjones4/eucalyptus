/*************************************************************************
 * (c) Copyright 2017 Hewlett Packard Enterprise Development Company LP
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; version 3 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses/.
 ************************************************************************/
package com.eucalyptus.cloudformation.resources.standard.propertytypes;

import java.util.ArrayList;
import com.eucalyptus.cloudformation.resources.ResourceProperties;
import com.eucalyptus.cloudformation.resources.annotations.Property;
import com.eucalyptus.cloudformation.resources.annotations.Required;
import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;

public class AWSEC2InstanceProperties implements ResourceProperties {

  @Property
  private String additionalInfo;

  @Property
  private String availabilityZone;

  @Property
  private ArrayList<EC2BlockDeviceMapping> blockDeviceMappings = Lists.newArrayList( );

  @Property
  private Boolean disableApiTermination;

  @Property
  private Boolean ebsOptimized;

  @Property
  private String iamInstanceProfile;

  @Property
  @Required
  private String imageId;

  @Property
  private String instanceInitiatedShutdownBehavior;

  @Property
  private String instanceType;

  @Property
  private String kernelId;

  @Property
  private String keyName;

  @Property
  private Boolean monitoring;

  @Property
  private ArrayList<EC2NetworkInterface> networkInterfaces = Lists.newArrayList( );

  @Property
  private String placementGroupName;

  @Property
  private String privateIpAddress;

  @Property
  private String ramdiskId;

  @Property
  private ArrayList<String> securityGroupIds = Lists.newArrayList( );

  @Property
  private ArrayList<String> securityGroups = Lists.newArrayList( );

  @Property
  private Boolean sourceDestCheck;

  @Property
  private String subnetId;

  @Property
  private ArrayList<EC2Tag> tags = Lists.newArrayList( );

  @Property
  private String tenancy;

  @Property
  private String userData;

  @Property
  private ArrayList<EC2MountPoint> volumes = Lists.newArrayList( );

  public String getAdditionalInfo( ) {
    return additionalInfo;
  }

  public void setAdditionalInfo( String additionalInfo ) {
    this.additionalInfo = additionalInfo;
  }

  public String getAvailabilityZone( ) {
    return availabilityZone;
  }

  public void setAvailabilityZone( String availabilityZone ) {
    this.availabilityZone = availabilityZone;
  }

  public ArrayList<EC2BlockDeviceMapping> getBlockDeviceMappings( ) {
    return blockDeviceMappings;
  }

  public void setBlockDeviceMappings( ArrayList<EC2BlockDeviceMapping> blockDeviceMappings ) {
    this.blockDeviceMappings = blockDeviceMappings;
  }

  public Boolean getDisableApiTermination( ) {
    return disableApiTermination;
  }

  public void setDisableApiTermination( Boolean disableApiTermination ) {
    this.disableApiTermination = disableApiTermination;
  }

  public Boolean getEbsOptimized( ) {
    return ebsOptimized;
  }

  public void setEbsOptimized( Boolean ebsOptimized ) {
    this.ebsOptimized = ebsOptimized;
  }

  public String getIamInstanceProfile( ) {
    return iamInstanceProfile;
  }

  public void setIamInstanceProfile( String iamInstanceProfile ) {
    this.iamInstanceProfile = iamInstanceProfile;
  }

  public String getImageId( ) {
    return imageId;
  }

  public void setImageId( String imageId ) {
    this.imageId = imageId;
  }

  public String getInstanceInitiatedShutdownBehavior( ) {
    return instanceInitiatedShutdownBehavior;
  }

  public void setInstanceInitiatedShutdownBehavior( String instanceInitiatedShutdownBehavior ) {
    this.instanceInitiatedShutdownBehavior = instanceInitiatedShutdownBehavior;
  }

  public String getInstanceType( ) {
    return instanceType;
  }

  public void setInstanceType( String instanceType ) {
    this.instanceType = instanceType;
  }

  public String getKernelId( ) {
    return kernelId;
  }

  public void setKernelId( String kernelId ) {
    this.kernelId = kernelId;
  }

  public String getKeyName( ) {
    return keyName;
  }

  public void setKeyName( String keyName ) {
    this.keyName = keyName;
  }

  public Boolean getMonitoring( ) {
    return monitoring;
  }

  public void setMonitoring( Boolean monitoring ) {
    this.monitoring = monitoring;
  }

  public ArrayList<EC2NetworkInterface> getNetworkInterfaces( ) {
    return networkInterfaces;
  }

  public void setNetworkInterfaces( ArrayList<EC2NetworkInterface> networkInterfaces ) {
    this.networkInterfaces = networkInterfaces;
  }

  public String getPlacementGroupName( ) {
    return placementGroupName;
  }

  public void setPlacementGroupName( String placementGroupName ) {
    this.placementGroupName = placementGroupName;
  }

  public String getPrivateIpAddress( ) {
    return privateIpAddress;
  }

  public void setPrivateIpAddress( String privateIpAddress ) {
    this.privateIpAddress = privateIpAddress;
  }

  public String getRamdiskId( ) {
    return ramdiskId;
  }

  public void setRamdiskId( String ramdiskId ) {
    this.ramdiskId = ramdiskId;
  }

  public ArrayList<String> getSecurityGroupIds( ) {
    return securityGroupIds;
  }

  public void setSecurityGroupIds( ArrayList<String> securityGroupIds ) {
    this.securityGroupIds = securityGroupIds;
  }

  public ArrayList<String> getSecurityGroups( ) {
    return securityGroups;
  }

  public void setSecurityGroups( ArrayList<String> securityGroups ) {
    this.securityGroups = securityGroups;
  }

  public Boolean getSourceDestCheck( ) {
    return sourceDestCheck;
  }

  public void setSourceDestCheck( Boolean sourceDestCheck ) {
    this.sourceDestCheck = sourceDestCheck;
  }

  public String getSubnetId( ) {
    return subnetId;
  }

  public void setSubnetId( String subnetId ) {
    this.subnetId = subnetId;
  }

  public ArrayList<EC2Tag> getTags( ) {
    return tags;
  }

  public void setTags( ArrayList<EC2Tag> tags ) {
    this.tags = tags;
  }

  public String getTenancy( ) {
    return tenancy;
  }

  public void setTenancy( String tenancy ) {
    this.tenancy = tenancy;
  }

  public String getUserData( ) {
    return userData;
  }

  public void setUserData( String userData ) {
    this.userData = userData;
  }

  public ArrayList<EC2MountPoint> getVolumes( ) {
    return volumes;
  }

  public void setVolumes( ArrayList<EC2MountPoint> volumes ) {
    this.volumes = volumes;
  }

  @Override
  public String toString( ) {
    return MoreObjects.toStringHelper( this )
        .add( "additionalInfo", additionalInfo )
        .add( "availabilityZone", availabilityZone )
        .add( "blockDeviceMappings", blockDeviceMappings )
        .add( "disableApiTermination", disableApiTermination )
        .add( "ebsOptimized", ebsOptimized )
        .add( "iamInstanceProfile", iamInstanceProfile )
        .add( "imageId", imageId )
        .add( "instanceInitiatedShutdownBehavior", instanceInitiatedShutdownBehavior )
        .add( "instanceType", instanceType )
        .add( "kernelId", kernelId )
        .add( "keyName", keyName )
        .add( "monitoring", monitoring )
        .add( "networkInterfaces", networkInterfaces )
        .add( "placementGroupName", placementGroupName )
        .add( "privateIpAddress", privateIpAddress )
        .add( "ramdiskId", ramdiskId )
        .add( "securityGroupIds", securityGroupIds )
        .add( "securityGroups", securityGroups )
        .add( "sourceDestCheck", sourceDestCheck )
        .add( "subnetId", subnetId )
        .add( "tags", tags )
        .add( "tenancy", tenancy )
        .add( "userData", userData )
        .add( "volumes", volumes )
        .toString( );
  }
}
