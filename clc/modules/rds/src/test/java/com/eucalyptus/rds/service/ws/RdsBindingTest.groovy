/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.service.ws

import com.eucalyptus.ws.protocol.QueryBindingTestSupport
import org.junit.Test

/**
 *
 */
class RdsBindingTest extends QueryBindingTestSupport {

  @Test
  void testValidBinding() {
    URL resource = RdsBindingTest.class.getResource( '/rds-binding.xml' )
    assertValidBindingXml( resource )
  }

  @Test
  void testValidQueryBinding() {
    URL resource = RdsBindingTest.class.getResource( '/rds-binding.xml' )
    assertValidQueryBinding( resource )
  }

  @Test
  void testInternalRoundTrip() {
    URL resource = RdsBindingTest.class.getResource( '/rds-binding.xml' )
    assertValidInternalRoundTrip( resource )
  }
}
