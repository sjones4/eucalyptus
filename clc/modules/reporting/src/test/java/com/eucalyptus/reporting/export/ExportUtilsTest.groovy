/*************************************************************************
 * Copyright 2009-2013 Ent. Services Development Corporation LP
 *
 * Redistribution and use of this software in source and binary forms,
 * with or without modification, are permitted provided that the
 * following conditions are met:
 *
 *   Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 *
 *   Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer
 *   in the documentation and/or other materials provided with the
 *   distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
 * FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
 * COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN
 * ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 ************************************************************************/
package com.eucalyptus.reporting.export

import static org.junit.Assert.*
import org.junit.Test
import com.eucalyptus.reporting.event_store.ReportingElasticIpAttachEvent
import com.eucalyptus.reporting.event_store.ReportingEventSupport
import com.eucalyptus.reporting.event_store.ReportingElasticIpCreateEvent
import com.eucalyptus.reporting.event_store.EventFactory
import java.text.SimpleDateFormat
import com.eucalyptus.reporting.event_store.ReportingElasticIpDetachEvent
import com.eucalyptus.reporting.event_store.ReportingElasticIpDeleteEvent
import com.eucalyptus.reporting.event_store.ReportingInstanceCreateEvent
import com.eucalyptus.reporting.event_store.ReportingS3ObjectCreateEvent
import com.eucalyptus.reporting.event_store.ReportingS3ObjectDeleteEvent
import com.eucalyptus.reporting.event_store.ReportingVolumeCreateEvent
import com.eucalyptus.reporting.event_store.ReportingVolumeAttachEvent
import com.eucalyptus.reporting.event_store.ReportingVolumeDetachEvent
import com.eucalyptus.reporting.event_store.ReportingVolumeDeleteEvent
import com.eucalyptus.reporting.event_store.ReportingVolumeSnapshotCreateEvent
import com.eucalyptus.reporting.event_store.ReportingVolumeSnapshotDeleteEvent
import com.eucalyptus.reporting.event_store.ReportingInstanceUsageEvent

/**
 * 
 */
class ExportUtilsTest {

  private Map<Class<? extends ReportingEventSupport>,ReportingEventSupport> instances = [
    (ReportingElasticIpCreateEvent.class): EventFactory.newIpCreate( "EID", date("2012-09-01T11:55:00"), date("2012-09-01T11:55:01"), "userId", "ip" ),
    ( ReportingElasticIpAttachEvent.class): EventFactory.newIpAttach( "EID", date("2012-09-01T11:55:00"), date("2012-09-01T11:55:01"), "ip", "instanceUuid" ),
    ( ReportingElasticIpDetachEvent.class): EventFactory.newIpDetach( "EID", date("2012-09-01T11:55:00"), date("2012-09-01T11:55:01"), "ip", "instanceUuid" ),
    ( ReportingElasticIpDeleteEvent.class): EventFactory.newIpDelete( "EID", date("2012-09-01T11:55:00"), date("2012-09-01T11:55:01"), "ip",  ),
    ( ReportingInstanceCreateEvent.class): EventFactory.newInstanceCreate( "EID", date("2012-09-01T11:55:00"), date("2012-09-01T11:55:01"), "uuid","instanceId", "instanceType", "userId", "availabilityZone" ),
    ( ReportingS3ObjectCreateEvent.class): EventFactory.newS3ObjectCreate( "EID", date("2012-09-01T11:55:00"), date("2012-09-01T11:55:01"), "bucket", "key", "version", 1, "userId" ),
    ( ReportingS3ObjectDeleteEvent.class): EventFactory.newS3ObjectDelete( "EID", date("2012-09-01T11:55:00"), date("2012-09-01T11:55:01"), "bucket", "key", "version" ),
    ( ReportingVolumeCreateEvent.class): EventFactory.newVolumeCreate( "EID", date("2012-09-01T11:55:00"), date("2012-09-01T11:55:01"), "uuid", "id", "userId", "availabilityZone", 1 ),
    ( ReportingVolumeAttachEvent.class): EventFactory.newVolumeAttach( "EID", date("2012-09-01T11:55:00"), date("2012-09-01T11:55:01"), "uuid", "instanceUuid", 1 ),
    ( ReportingVolumeDetachEvent.class): EventFactory.newVolumeDetach( "EID", date("2012-09-01T11:55:00"), date("2012-09-01T11:55:01"), "uuid", "instanceUuid" ),
    ( ReportingVolumeDeleteEvent.class): EventFactory.newVolumeDelete( "EID", date("2012-09-01T11:55:00"), date("2012-09-01T11:55:01"), "uuid" ),
    ( ReportingVolumeSnapshotCreateEvent.class): EventFactory.newSnapshotCreate( "EID", date("2012-09-01T11:55:00"), date("2012-09-01T11:55:01"), "uuid", "id", "volumeUuid", "userId", 1 ),
    ( ReportingVolumeSnapshotDeleteEvent.class): EventFactory.newSnapshotDelete( "EID", date("2012-09-01T11:55:00"), date("2012-09-01T11:55:01"), "uuid" ),
  ]
  private Map<Class<? extends ReportingEventSupport>,ReportingEventSupport> usageInstances = [
      (ReportingInstanceUsageEvent.class): EventFactory.newInstanceUsage( "EID", date("2012-09-01T11:55:00"), date("2012-09-01T11:55:01"), "uuid", "metric", "dimension", 1, 6.66 )
  ]

  /**
   * Test conversion from internal objects to export model events and back
   */
  @Test
  void testActionRoundTrip() {
    ExportUtils.eventClasses.each{ Class<? extends ReportingEventSupport> eventClass ->
      ReportingEventSupport eventIn = instances[eventClass]
      assertNotNull( "Missing instance for " + eventClass, eventIn )
      ReportedAction action = ExportUtils.toExportAction().apply(eventIn)
      ReportingEventSupport eventOut = ExportUtils.fromExportAction().apply(action)

      eventIn.properties.each{ String name, Object value ->
        assertEquals( "event " + eventClass.getSimpleName() + " property " + name, value, eventOut.properties[name] )
      }
    }
  }

  /**
   * Test conversion from internal objects to export model usage and back
   */
  @Test
  void testUsageRoundTrip() {
    ExportUtils.usageClasses.each{ Class<? extends ReportingEventSupport> eventClass ->
      ReportingEventSupport eventIn = usageInstances[eventClass]
      List<Object> events = []
      assertNotNull( "Missing instance for " + eventClass, eventIn )
      ReportedUsage usage = ExportUtils.toExportUsage(events).apply(eventIn)
      ReportingEventSupport eventOut = ExportUtils.fromExportUsage().apply(usage)
      assertTrue("No dependency events", events.isEmpty())

      eventIn.properties.each{ String name, Object value ->
        if ( value instanceof Double ) {
          assertEquals( "event " + eventClass.getSimpleName() + " property " + name, value, (Double)eventOut.properties[name], 0d )
        } else {
          assertEquals( "event " + eventClass.getSimpleName() + " property " + name, value, eventOut.properties[name] )
        }
      }
    }
  }

  private Date date( String timestamp ) {
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    sdf.parse( timestamp )
  }
}
