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
package com.eucalyptus.container

import com.eucalyptus.container.agent.PayloadMessage
import com.eucalyptus.container.agent.PollResponse
import com.eucalyptus.container.agent.Task
import groovy.transform.CompileStatic
import org.junit.Test
import static org.junit.Assert.*

/**
 *
 */
@CompileStatic
class EcsJsonUtilsTest {

  @Test
  public void testWriteJson( ) {
    Long time = System.currentTimeMillis();
    String json = EcsJsonUtils.writeObjectAsString(new PollResponse(
        type: 'PayloadMessage',
        message: new PayloadMessage(
            clusterArn: 'arn:aws:ecs:us-east-1:012345678910:cluster/default',
            containerInstanceArn: 'arn:aws:ecs::585201416939:container-instance/f17f9e00-d7b8-46da-b457-8118840d3650',
            generatedAt: time,
            seqNum: 1l,
            messageId: '71',
            tasks: [
                new Task(
                    arn: 'arn:aws:ecs:us-east-1:012345678910:task-definition/sleep360:1',
                    family: 'sleep360',
                    version: '1',
                    desiredStatus: 'RUNNING',
                    containers: [
                        new com.eucalyptus.container.agent.Container(
                            name: 'sleep',
                            memory: 10,
                            cpu: 10,
                            image: 'busybox',
                            essential: true,
                            command: ['sleep', '360']
                        )
                    ]
                )
            ]
        )
    ))

    println json

    String expectedJson = '{"Message":{"clusterArn":"arn:aws:ecs:us-east-1:012345678910:cluster/default","containerInstanceArn":"arn:aws:ecs::585201416939:container-instance/f17f9e00-d7b8-46da-b457-8118840d3650","generatedAt":'+time+',"messageId":"71","seqNum":1,"tasks":[{"arn":"arn:aws:ecs:us-east-1:012345678910:task-definition/sleep360:1","containers":[{"command":["sleep","360"],"cpu":10,"essential":true,"image":"busybox","memory":10,"name":"sleep"}],"desiredStatus":"RUNNING","family":"sleep360","version":"1"}]},"Type":"PayloadMessage"}'

    assertEquals('Payload message', expectedJson, json)
  }

}
