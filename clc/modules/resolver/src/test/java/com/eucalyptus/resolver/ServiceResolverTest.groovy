package com.eucalyptus.resolver

import static org.junit.Assert.*
import org.junit.Test

/**
 * 
 */
class ServiceResolverTest {

  @Test
  void testUniqueResolutionParameters( ) {
    Set<List<String>> paramLists = []
    ServiceResolver.values( ).each { ServiceResolver resolver ->
      resolver.actions.each { String action ->
        resolver.versions.each { String version ->
          assertTrue( resolver.name( ) + " " + action + " " + version + " is duplicate", paramLists.add( [ action, version ] ) )
        }
      }
    }
  }
}
