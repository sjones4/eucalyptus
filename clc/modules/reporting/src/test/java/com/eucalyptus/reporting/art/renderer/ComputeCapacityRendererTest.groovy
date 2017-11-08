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
package com.eucalyptus.reporting.art.renderer

import org.junit.Test
import com.eucalyptus.reporting.art.entity.ReportArtEntity
import com.eucalyptus.reporting.ReportType
import com.eucalyptus.reporting.ReportFormat
import com.eucalyptus.reporting.art.entity.AvailabilityZoneArtEntity

/**
 * 
 */
class ComputeCapacityRendererTest extends RendererTestSupport {

  @Test
  void testCsvLayout() {
    assertCsvColumns( render( ReportType.CAPACITY, ReportFormat.CSV, art() ) )
  }

  @Test
  void testHtmlLayout() {
    assertHtmlColumns( render( ReportType.CAPACITY, ReportFormat.HTML, art() ) )
  }

  private ReportArtEntity art() {
    ReportArtEntity art = new ReportArtEntity( millis("2012-10-01T00:00:00"), millis("2012-10-10T00:00:00") )
    art.getUsageTotals().getComputeCapacityArtEntity().setInstancesAvailableForType("m1.small", 0)
    art.getUsageTotals().getComputeCapacityArtEntity().setInstancesTotalForType("m1.small", 0)
    AvailabilityZoneArtEntity zoneArt = new AvailabilityZoneArtEntity()
    art.getZones().put("zone1", zoneArt)
    zoneArt.getUsageTotals().getComputeCapacityArtEntity().setInstancesAvailableForType("m1.small", 0)
    zoneArt.getUsageTotals().getComputeCapacityArtEntity().setInstancesTotalForType("m1.small", 0)
    art
  }

}
