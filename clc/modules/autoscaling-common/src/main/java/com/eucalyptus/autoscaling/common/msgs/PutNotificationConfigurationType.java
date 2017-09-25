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
package com.eucalyptus.autoscaling.common.msgs;

public class PutNotificationConfigurationType extends AutoScalingMessage {

  private String autoScalingGroupName;
  private String topicARN;
  private AutoScalingNotificationTypes notificationTypes;

  public String getAutoScalingGroupName( ) {
    return autoScalingGroupName;
  }

  public void setAutoScalingGroupName( String autoScalingGroupName ) {
    this.autoScalingGroupName = autoScalingGroupName;
  }

  public String getTopicARN( ) {
    return topicARN;
  }

  public void setTopicARN( String topicARN ) {
    this.topicARN = topicARN;
  }

  public AutoScalingNotificationTypes getNotificationTypes( ) {
    return notificationTypes;
  }

  public void setNotificationTypes( AutoScalingNotificationTypes notificationTypes ) {
    this.notificationTypes = notificationTypes;
  }
}
