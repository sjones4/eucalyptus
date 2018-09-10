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



public class GetTrailStatusResponseType extends CloudtrailMessage {


  private Boolean isLogging;
  private String latestCloudWatchLogsDeliveryError;
  private java.util.Date latestCloudWatchLogsDeliveryTime;
  private String latestDeliveryAttemptSucceeded;
  private String latestDeliveryAttemptTime;
  private String latestDeliveryError;
  private java.util.Date latestDeliveryTime;
  private String latestDigestDeliveryError;
  private java.util.Date latestDigestDeliveryTime;
  private String latestNotificationAttemptSucceeded;
  private String latestNotificationAttemptTime;
  private String latestNotificationError;
  private java.util.Date latestNotificationTime;
  private java.util.Date startLoggingTime;
  private java.util.Date stopLoggingTime;
  private String timeLoggingStarted;
  private String timeLoggingStopped;

  public Boolean getIsLogging( ) {
    return isLogging;
  }

  public void setIsLogging( final Boolean isLogging ) {
    this.isLogging = isLogging;
  }

  public String getLatestCloudWatchLogsDeliveryError( ) {
    return latestCloudWatchLogsDeliveryError;
  }

  public void setLatestCloudWatchLogsDeliveryError( final String latestCloudWatchLogsDeliveryError ) {
    this.latestCloudWatchLogsDeliveryError = latestCloudWatchLogsDeliveryError;
  }

  public java.util.Date getLatestCloudWatchLogsDeliveryTime( ) {
    return latestCloudWatchLogsDeliveryTime;
  }

  public void setLatestCloudWatchLogsDeliveryTime( final java.util.Date latestCloudWatchLogsDeliveryTime ) {
    this.latestCloudWatchLogsDeliveryTime = latestCloudWatchLogsDeliveryTime;
  }

  public String getLatestDeliveryAttemptSucceeded( ) {
    return latestDeliveryAttemptSucceeded;
  }

  public void setLatestDeliveryAttemptSucceeded( final String latestDeliveryAttemptSucceeded ) {
    this.latestDeliveryAttemptSucceeded = latestDeliveryAttemptSucceeded;
  }

  public String getLatestDeliveryAttemptTime( ) {
    return latestDeliveryAttemptTime;
  }

  public void setLatestDeliveryAttemptTime( final String latestDeliveryAttemptTime ) {
    this.latestDeliveryAttemptTime = latestDeliveryAttemptTime;
  }

  public String getLatestDeliveryError( ) {
    return latestDeliveryError;
  }

  public void setLatestDeliveryError( final String latestDeliveryError ) {
    this.latestDeliveryError = latestDeliveryError;
  }

  public java.util.Date getLatestDeliveryTime( ) {
    return latestDeliveryTime;
  }

  public void setLatestDeliveryTime( final java.util.Date latestDeliveryTime ) {
    this.latestDeliveryTime = latestDeliveryTime;
  }

  public String getLatestDigestDeliveryError( ) {
    return latestDigestDeliveryError;
  }

  public void setLatestDigestDeliveryError( final String latestDigestDeliveryError ) {
    this.latestDigestDeliveryError = latestDigestDeliveryError;
  }

  public java.util.Date getLatestDigestDeliveryTime( ) {
    return latestDigestDeliveryTime;
  }

  public void setLatestDigestDeliveryTime( final java.util.Date latestDigestDeliveryTime ) {
    this.latestDigestDeliveryTime = latestDigestDeliveryTime;
  }

  public String getLatestNotificationAttemptSucceeded( ) {
    return latestNotificationAttemptSucceeded;
  }

  public void setLatestNotificationAttemptSucceeded( final String latestNotificationAttemptSucceeded ) {
    this.latestNotificationAttemptSucceeded = latestNotificationAttemptSucceeded;
  }

  public String getLatestNotificationAttemptTime( ) {
    return latestNotificationAttemptTime;
  }

  public void setLatestNotificationAttemptTime( final String latestNotificationAttemptTime ) {
    this.latestNotificationAttemptTime = latestNotificationAttemptTime;
  }

  public String getLatestNotificationError( ) {
    return latestNotificationError;
  }

  public void setLatestNotificationError( final String latestNotificationError ) {
    this.latestNotificationError = latestNotificationError;
  }

  public java.util.Date getLatestNotificationTime( ) {
    return latestNotificationTime;
  }

  public void setLatestNotificationTime( final java.util.Date latestNotificationTime ) {
    this.latestNotificationTime = latestNotificationTime;
  }

  public java.util.Date getStartLoggingTime( ) {
    return startLoggingTime;
  }

  public void setStartLoggingTime( final java.util.Date startLoggingTime ) {
    this.startLoggingTime = startLoggingTime;
  }

  public java.util.Date getStopLoggingTime( ) {
    return stopLoggingTime;
  }

  public void setStopLoggingTime( final java.util.Date stopLoggingTime ) {
    this.stopLoggingTime = stopLoggingTime;
  }

  public String getTimeLoggingStarted( ) {
    return timeLoggingStarted;
  }

  public void setTimeLoggingStarted( final String timeLoggingStarted ) {
    this.timeLoggingStarted = timeLoggingStarted;
  }

  public String getTimeLoggingStopped( ) {
    return timeLoggingStopped;
  }

  public void setTimeLoggingStopped( final String timeLoggingStopped ) {
    this.timeLoggingStopped = timeLoggingStopped;
  }

}
