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
package com.eucalyptus.compute.common;

import com.eucalyptus.binding.HttpParameterMapping;

public class BundleInstanceType extends VmBundleMessage {

  private String instanceId;
  @HttpParameterMapping( parameter = "Storage.S3.Bucket" )
  private String bucket;
  @HttpParameterMapping( parameter = "Storage.S3.Prefix" )
  private String prefix;
  @HttpParameterMapping( parameter = "Storage.S3.AWSAccessKeyId" )
  private String awsAccessKeyId;
  @HttpParameterMapping( parameter = "Storage.S3.UploadPolicy" )
  private String uploadPolicy;
  @HttpParameterMapping( parameter = "Storage.S3.UploadPolicySignature" )
  private String uploadPolicySignature;

  public String getInstanceId( ) {
    return instanceId;
  }

  public void setInstanceId( String instanceId ) {
    this.instanceId = instanceId;
  }

  public String getBucket( ) {
    return bucket;
  }

  public void setBucket( String bucket ) {
    this.bucket = bucket;
  }

  public String getPrefix( ) {
    return prefix;
  }

  public void setPrefix( String prefix ) {
    this.prefix = prefix;
  }

  public String getAwsAccessKeyId( ) {
    return awsAccessKeyId;
  }

  public void setAwsAccessKeyId( String awsAccessKeyId ) {
    this.awsAccessKeyId = awsAccessKeyId;
  }

  public String getUploadPolicy( ) {
    return uploadPolicy;
  }

  public void setUploadPolicy( String uploadPolicy ) {
    this.uploadPolicy = uploadPolicy;
  }

  public String getUploadPolicySignature( ) {
    return uploadPolicySignature;
  }

  public void setUploadPolicySignature( String uploadPolicySignature ) {
    this.uploadPolicySignature = uploadPolicySignature;
  }
}
