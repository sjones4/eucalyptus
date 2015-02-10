package com.eucalyptus.container.ws

import com.eucalyptus.ws.protocol.QueryBindingTestSupport
import org.junit.Test

/**
 *
 */
class ContainerQueryBindingTest extends QueryBindingTestSupport {

  @Test
  void testValidBinding2014_11_13() {
    URL resource = ContainerQueryBindingTest.getResource('/container-binding.xml')
    assertValidBindingXml(resource)
  }

}
