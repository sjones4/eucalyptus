/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudtrail.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;
import javax.annotation.Nonnull;
import com.eucalyptus.cloudtrail.common.CloudtrailMessageValidation.FieldRange;
import com.eucalyptus.cloudtrail.common.CloudtrailMessageValidation.FieldRegex;
import com.eucalyptus.cloudtrail.common.CloudtrailMessageValidation.FieldRegexValue;


public class Event extends EucalyptusData {

  private String cloudTrailEvent;
  private String eventId;
  private String eventName;
  private String eventSource;
  private java.util.Date eventTime;
  private java.util.ArrayList<Resource> resources;
  private String username;

  public String getCloudTrailEvent( ) {
    return cloudTrailEvent;
  }

  public void setCloudTrailEvent( final String cloudTrailEvent ) {
    this.cloudTrailEvent = cloudTrailEvent;
  }

  public String getEventId( ) {
    return eventId;
  }

  public void setEventId( final String eventId ) {
    this.eventId = eventId;
  }

  public String getEventName( ) {
    return eventName;
  }

  public void setEventName( final String eventName ) {
    this.eventName = eventName;
  }

  public String getEventSource( ) {
    return eventSource;
  }

  public void setEventSource( final String eventSource ) {
    this.eventSource = eventSource;
  }

  public java.util.Date getEventTime( ) {
    return eventTime;
  }

  public void setEventTime( final java.util.Date eventTime ) {
    this.eventTime = eventTime;
  }

  public java.util.ArrayList<Resource> getResources( ) {
    return resources;
  }

  public void setResources( final java.util.ArrayList<Resource> resources ) {
    this.resources = resources;
  }

  public String getUsername( ) {
    return username;
  }

  public void setUsername( final String username ) {
    this.username = username;
  }

}
