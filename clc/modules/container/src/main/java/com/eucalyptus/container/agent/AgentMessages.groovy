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
package com.eucalyptus.container.agent

import org.codehaus.jackson.annotate.JsonProperty


class ContainerAgentMessage { }

class PollRequest extends ContainerAgentMessage {
  VersionInfo agentVersion
  String cluster
  String containerInstance
  Long seqNum
}

class PollResponse extends ContainerAgentMessage {
  String type // PayloadMessage | HeartbeatMessage
  ContainerAgentMessage message

  @JsonProperty("Type")
  String getType() {
    return type
  }

  void setType(final String type) {
    this.type = type
  }

  @JsonProperty("Message")
  ContainerAgentMessage getMessage( ) {
    return message
  }

  void setMessage(final ContainerAgentMessage message) {
    this.message = message
  }
}

class CloseMessage extends ContainerAgentMessage {
  String message
}

class HeartbeatMessage extends ContainerAgentMessage {
  Boolean healthy
}

class PayloadMessage extends ContainerAgentMessage {
  String clusterArn
  String containerInstanceArn
  Long generatedAt
  String messageId
  Long seqNum
  List<Task> tasks
}

class Task {
  String arn
  List<Container> containers
  String desiredStatus
  String family
  String overrides
  String taskDefinitionAccountId
  String version
  List<Volume> volumes
}

class Container {
  List<String> command
  Integer cpu
  List<String> entryPoint
  Map<String,String> environment
  Boolean essential
  String image
  List<String> links
  Integer memory
  List<MountPoint> mountPoints
  String name
  List<String> overrides
  List<PortMapping> portMappings
  List<VolumeFrom> volumesFrom
}

class Volume {
  HostVolumeProperties host
 String name
}

class VolumeFrom {
  Boolean readOnly
  String sourceContainer
}

class HostVolumeProperties {
  String sourcePath
}

class MountPoint {
  String containerPath
  Boolean readOnly
  String sourceVolume
}

class PortMapping {
  Integer containerPort
  Integer hostPort

  PortMapping( ) {
  }

  PortMapping( Integer containerPort, Integer hostPort ) {
    this.containerPort = containerPort
    this.hostPort = hostPort
  }
}

class AckRequest extends ContainerAgentMessage {
  String cluster
  String containerInstance
  String messageId
}

class NackRequest extends ContainerAgentMessage {
  String cluster
  String containerInstance
  String messageId
  String reason
}

class UpdateInfo {
  String location
  String signature
}

class VersionInfo {
  String agentHash
  String agentVersion
  String dockerVersion
}

class PerformUpdateMessage extends ContainerAgentMessage {
  String clusterArn
  String containerInstanceArn
  String messageId
  UpdateInfo updateInfo
}

class StageUpdateMessage extends ContainerAgentMessage {
  String clusterArn
  String containerInstanceArn
  String messageId
  UpdateInfo updateInfo
}
