/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudtrail.common.msgs;

import javax.annotation.Nonnull;
import com.eucalyptus.binding.HttpContent;
import com.eucalyptus.binding.HttpHeaderMapping;
import com.eucalyptus.binding.HttpNoContent;
import com.eucalyptus.cloudtrail.common.CloudtrailMessageValidation.FieldRange;
import com.eucalyptus.cloudtrail.common.CloudtrailMessageValidation.FieldRegex;
import com.eucalyptus.cloudtrail.common.CloudtrailMessageValidation.FieldRegexValue;



public class CreateTrailResponseType extends CloudtrailMessage {


  private String cloudWatchLogsLogGroupArn;
  private String cloudWatchLogsRoleArn;
  private Boolean includeGlobalServiceEvents;
  private Boolean isMultiRegionTrail;
  private String kmsKeyId;
  private Boolean logFileValidationEnabled;
  private String name;
  private String s3BucketName;
  private String s3KeyPrefix;
  private String snsTopicARN;
  private String snsTopicName;
  private String trailARN;

  public String getCloudWatchLogsLogGroupArn( ) {
    return cloudWatchLogsLogGroupArn;
  }

  public void setCloudWatchLogsLogGroupArn( final String cloudWatchLogsLogGroupArn ) {
    this.cloudWatchLogsLogGroupArn = cloudWatchLogsLogGroupArn;
  }

  public String getCloudWatchLogsRoleArn( ) {
    return cloudWatchLogsRoleArn;
  }

  public void setCloudWatchLogsRoleArn( final String cloudWatchLogsRoleArn ) {
    this.cloudWatchLogsRoleArn = cloudWatchLogsRoleArn;
  }

  public Boolean getIncludeGlobalServiceEvents( ) {
    return includeGlobalServiceEvents;
  }

  public void setIncludeGlobalServiceEvents( final Boolean includeGlobalServiceEvents ) {
    this.includeGlobalServiceEvents = includeGlobalServiceEvents;
  }

  public Boolean getIsMultiRegionTrail( ) {
    return isMultiRegionTrail;
  }

  public void setIsMultiRegionTrail( final Boolean isMultiRegionTrail ) {
    this.isMultiRegionTrail = isMultiRegionTrail;
  }

  public String getKmsKeyId( ) {
    return kmsKeyId;
  }

  public void setKmsKeyId( final String kmsKeyId ) {
    this.kmsKeyId = kmsKeyId;
  }

  public Boolean getLogFileValidationEnabled( ) {
    return logFileValidationEnabled;
  }

  public void setLogFileValidationEnabled( final Boolean logFileValidationEnabled ) {
    this.logFileValidationEnabled = logFileValidationEnabled;
  }

  public String getName( ) {
    return name;
  }

  public void setName( final String name ) {
    this.name = name;
  }

  public String getS3BucketName( ) {
    return s3BucketName;
  }

  public void setS3BucketName( final String s3BucketName ) {
    this.s3BucketName = s3BucketName;
  }

  public String getS3KeyPrefix( ) {
    return s3KeyPrefix;
  }

  public void setS3KeyPrefix( final String s3KeyPrefix ) {
    this.s3KeyPrefix = s3KeyPrefix;
  }

  public String getSnsTopicARN( ) {
    return snsTopicARN;
  }

  public void setSnsTopicARN( final String snsTopicARN ) {
    this.snsTopicARN = snsTopicARN;
  }

  public String getSnsTopicName( ) {
    return snsTopicName;
  }

  public void setSnsTopicName( final String snsTopicName ) {
    this.snsTopicName = snsTopicName;
  }

  public String getTrailARN( ) {
    return trailARN;
  }

  public void setTrailARN( final String trailARN ) {
    this.trailARN = trailARN;
  }

}
