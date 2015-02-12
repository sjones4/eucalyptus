/*************************************************************************
 * Copyright 2009-2015 Eucalyptus Systems, Inc.
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
 *
 * Please contact Eucalyptus Systems, Inc., 6755 Hollister Ave., Goleta
 * CA 93117, USA or visit http://www.eucalyptus.com/licenses/ if you need
 * additional information or have any questions.
 ************************************************************************/
package com.eucalyptus.container.ws

import com.eucalyptus.container.common.model.CreateClusterRequest
import com.eucalyptus.ws.protocol.QueryBindingTestSupport
import edu.ucsb.eucalyptus.msgs.BaseMessage
import org.junit.Test

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNotNull

/**
 *
 */
class ContainerQueryBindingTest extends QueryBindingTestSupport {

  @Test
  void testValidBinding2014_11_13() {
    URL resource = ContainerQueryBindingTest.getResource('/container-binding.xml')
    assertValidBindingXml(resource)
  }

  @Test
  void testCreateClusterMessageQueryBindings() {
    URL resource = ContainerQueryBindingTest.class.getResource('/container-binding.xml')

    String version = "2014-11-13"
    ContainerQueryBinding eb = new ContainerQueryBinding() {
      @Override
      protected com.eucalyptus.binding.Binding getBindingWithElementClass(final String operationName) {
        createTestBindingFromXml(resource, operationName)
      }

      @Override
      String getNamespace() {
        return getNamespaceForVersion(version);
      }

      @Override
      protected void validateBinding(final com.eucalyptus.binding.Binding currentBinding,
                                     final String operationName,
                                     final Map<String, String> params,
                                     final BaseMessage eucaMsg) {
        // Validation requires compiled bindings
      }
    }

    bindAndAssertParameters(eb, CreateClusterRequest.class, "CreateClusterRequest", new CreateClusterRequest(
        clusterName: 'cluster-1',
    ), [
        clusterName: 'cluster-1',
    ]).with {
      assertNotNull( 'Expected clustername', clusterName )
      assertEquals( 'clustername', 'cluster-1', clusterName )
    }
  }
}
