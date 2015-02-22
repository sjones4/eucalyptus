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

import com.eucalyptus.container.common.model.Task  //TODO:STEVE: define API specific Task

class ContainerAgentMessage { }

class PollResponse extends ContainerAgentMessage {
  String messageType // PayloadMessage | HeartbeatMessage
  Payload message
}

class Payload {
  List<Task> tasks
  String messageId
}

class AckRequest extends ContainerAgentMessage {
  String clusterArn
  String containerInstanceArn
  String messageId
}

class Task {
  String arn
  String family
  String version
  List<Container> containers
  String desiredStatus
  String knownStatus
  String sentStatus
}

class Container {
  String name
  String image
  List<String> command
  Integer cpu
  Integer memory
  List<String> links
  Boolean essential
  List<String> entryPoints
  Map<String,String> environment
  String desiredStatus
  String knownStatus
  List<String> runDependencies
}

//TODO:STEVE
//type Task struct {
//  Arn string
//  Overrides TaskOverrides `json:"-"`
//  Family string
//  Version string
//  Containers []*Container
//  Volumes []TaskVolume `json:"volumes"`
//  DesiredStatus TaskStatus
//  KnownStatus TaskStatus
//  KnownTime time.Time
//  SentStatus TaskStatus
//  containersByNameLock sync.Mutex
//  containersByName map[string]*Container
//}

//type Container struct {
//  Name string
//  Image string
//  Command []string
//  Cpu uint
//  Memory uint
//  Links []string
//  VolumesFrom []VolumeFrom `json:"volumesFrom"`
//  MountPoints []MountPoint `json:"mountPoints"`
//  Ports []PortBinding `json:"portMappings"`
//  Essential bool
//  EntryPoint *[]string
//  Environment map[string]string `json:"environment"`
//  Overrides ContainerOverrides `json:"overrides"`
//  DesiredStatus ContainerStatus `json:"desiredStatus"` // int32
//  KnownStatus ContainerStatus
//// RunDependencies is a list of containers that must be run before
//// this one is created
//  RunDependencies []string
//// 'Internal' containers are ones that are not directly specified by task definitions, but created by the agent
//  IsInternal bool
//  AppliedStatus ContainerStatus
//  ApplyingError *ApplyingError
//  SentStatus ContainerStatus
//  KnownExitCode *int
//  KnownPortBindings []PortBinding
//// Not upstream; todo move this out into a wrapper type
//  StatusLock sync.Mutex
//}


//// MountPoint describes the in-container location of a Volume and references
//// that Volume by name.
//type MountPoint struct {
//  SourceVolume string `json:"sourceVolume"`
//  ContainerPath string `json:"containerPath"`
//  ReadOnly bool `json:"readOnly"`
//}

//type PortBinding struct {
//  ContainerPort uint16
//  HostPort uint16
//  BindIp string
//}

//TODO:STEVE: is this used?
//type HealthResponse struct {
//  Healthy bool `json:"healthy"`
//}
