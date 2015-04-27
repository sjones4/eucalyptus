/*************************************************************************
 * Copyright 2015 Eucalyptus Systems, Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; version 3 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses/.
 *
 * Please contact Eucalyptus Systems, Inc., 6755 Hollister Ave., Goleta
 * CA 93117, USA or visit http://www.eucalyptus.com/licenses/ if you
 * need additional information or have any questions.
 *
 * This file may incorporate work covered under the following copyright
 * and permission notice:
 *
 *   Copyright 2010-2015 Amazon.com, Inc. or its affiliates. All Rights
 *   Reserved.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License").
 *   You may not use this file except in compliance with the License.
 *   A copy of the License is located at
 *
 *    http://aws.amazon.com/apache2.0
 *
 *   or in the "license" file accompanying this file. This file is
 *   distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF
 *   ANY KIND, either express or implied. See the License for the specific
 *   language governing permissions and limitations under the License.
 ************************************************************************/
package com.eucalyptus.container.common.model;

import java.io.Serializable;

import com.eucalyptus.auth.policy.PolicyAction;
import com.eucalyptus.binding.HttpParameterMapping;

/**
 * Container for the parameters to the {@link com.amazonaws.services.ecs.AmazonECS#startTask(StartTaskRequest) StartTask operation}.
 * <p>
 * Starts a new task from the specified task definition on the specified
 * container instance or instances. If you want to use the default Amazon
 * ECS scheduler to place your task, use <code>RunTask</code> instead.
 * </p>
 *
 * @see com.amazonaws.services.ecs.AmazonECS#startTask(StartTaskRequest)
 */
@PolicyAction( vendor = "ecs", action = "starttask" )
public class StartTaskRequest extends EcsMessage implements Serializable {

    /**
     * The short name or full Amazon Resource Name (ARN) of the cluster that
     * you want to start your task on. If you do not specify a cluster, the
     * default cluster is assumed..
     */
    @HttpParameterMapping( parameter = "cluster" )
    private String cluster;

    /**
     * The <code>family</code> and <code>revision</code>
     * (<code>family:revision</code>) or full Amazon Resource Name (ARN) of
     * the task definition that you want to start.
     */
    @HttpParameterMapping( parameter = "taskDefinition" )
    private String taskDefinition;

    /**
     * 
     */
    @HttpParameterMapping( parameter = "overrides" )
    private TaskOverride overrides;

    /**
     * The container instance UUIDs or full Amazon Resource Name (ARN)
     * entries for the container instances on which you would like to place
     * your task.
     */
    @HttpParameterMapping( parameter = "containerInstances" )
    private com.amazonaws.internal.ListWithAutoConstructFlag<String> containerInstances;

    /**
     * The short name or full Amazon Resource Name (ARN) of the cluster that
     * you want to start your task on. If you do not specify a cluster, the
     * default cluster is assumed..
     *
     * @return The short name or full Amazon Resource Name (ARN) of the cluster that
     *         you want to start your task on. If you do not specify a cluster, the
     *         default cluster is assumed..
     */
    public String getCluster() {
        return cluster;
    }
    
    /**
     * The short name or full Amazon Resource Name (ARN) of the cluster that
     * you want to start your task on. If you do not specify a cluster, the
     * default cluster is assumed..
     *
     * @param cluster The short name or full Amazon Resource Name (ARN) of the cluster that
     *         you want to start your task on. If you do not specify a cluster, the
     *         default cluster is assumed..
     */
    public void setCluster(String cluster) {
        this.cluster = cluster;
    }
    
    /**
     * The short name or full Amazon Resource Name (ARN) of the cluster that
     * you want to start your task on. If you do not specify a cluster, the
     * default cluster is assumed..
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param cluster The short name or full Amazon Resource Name (ARN) of the cluster that
     *         you want to start your task on. If you do not specify a cluster, the
     *         default cluster is assumed..
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public StartTaskRequest withCluster(String cluster) {
        this.cluster = cluster;
        return this;
    }

    /**
     * The <code>family</code> and <code>revision</code>
     * (<code>family:revision</code>) or full Amazon Resource Name (ARN) of
     * the task definition that you want to start.
     *
     * @return The <code>family</code> and <code>revision</code>
     *         (<code>family:revision</code>) or full Amazon Resource Name (ARN) of
     *         the task definition that you want to start.
     */
    public String getTaskDefinition() {
        return taskDefinition;
    }
    
    /**
     * The <code>family</code> and <code>revision</code>
     * (<code>family:revision</code>) or full Amazon Resource Name (ARN) of
     * the task definition that you want to start.
     *
     * @param taskDefinition The <code>family</code> and <code>revision</code>
     *         (<code>family:revision</code>) or full Amazon Resource Name (ARN) of
     *         the task definition that you want to start.
     */
    public void setTaskDefinition(String taskDefinition) {
        this.taskDefinition = taskDefinition;
    }
    
    /**
     * The <code>family</code> and <code>revision</code>
     * (<code>family:revision</code>) or full Amazon Resource Name (ARN) of
     * the task definition that you want to start.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param taskDefinition The <code>family</code> and <code>revision</code>
     *         (<code>family:revision</code>) or full Amazon Resource Name (ARN) of
     *         the task definition that you want to start.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public StartTaskRequest withTaskDefinition(String taskDefinition) {
        this.taskDefinition = taskDefinition;
        return this;
    }

    /**
     * 
     *
     * @return 
     */
    public TaskOverride getOverrides() {
        return overrides;
    }
    
    /**
     * 
     *
     * @param overrides 
     */
    public void setOverrides(TaskOverride overrides) {
        this.overrides = overrides;
    }
    
    /**
     * 
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param overrides 
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public StartTaskRequest withOverrides(TaskOverride overrides) {
        this.overrides = overrides;
        return this;
    }

    /**
     * The container instance UUIDs or full Amazon Resource Name (ARN)
     * entries for the container instances on which you would like to place
     * your task.
     *
     * @return The container instance UUIDs or full Amazon Resource Name (ARN)
     *         entries for the container instances on which you would like to place
     *         your task.
     */
    public java.util.List<String> getContainerInstances() {
        if (containerInstances == null) {
              containerInstances = new com.amazonaws.internal.ListWithAutoConstructFlag<String>();
              containerInstances.setAutoConstruct(true);
        }
        return containerInstances;
    }
    
    /**
     * The container instance UUIDs or full Amazon Resource Name (ARN)
     * entries for the container instances on which you would like to place
     * your task.
     *
     * @param containerInstances The container instance UUIDs or full Amazon Resource Name (ARN)
     *         entries for the container instances on which you would like to place
     *         your task.
     */
    public void setContainerInstances(java.util.Collection<String> containerInstances) {
        if (containerInstances == null) {
            this.containerInstances = null;
            return;
        }
        com.amazonaws.internal.ListWithAutoConstructFlag<String> containerInstancesCopy = new com.amazonaws.internal.ListWithAutoConstructFlag<String>(containerInstances.size());
        containerInstancesCopy.addAll(containerInstances);
        this.containerInstances = containerInstancesCopy;
    }
    
    /**
     * The container instance UUIDs or full Amazon Resource Name (ARN)
     * entries for the container instances on which you would like to place
     * your task.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param containerInstances The container instance UUIDs or full Amazon Resource Name (ARN)
     *         entries for the container instances on which you would like to place
     *         your task.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public StartTaskRequest withContainerInstances(String... containerInstances) {
        if (getContainerInstances() == null) setContainerInstances(new java.util.ArrayList<String>(containerInstances.length));
        for (String value : containerInstances) {
            getContainerInstances().add(value);
        }
        return this;
    }
    
    /**
     * The container instance UUIDs or full Amazon Resource Name (ARN)
     * entries for the container instances on which you would like to place
     * your task.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param containerInstances The container instance UUIDs or full Amazon Resource Name (ARN)
     *         entries for the container instances on which you would like to place
     *         your task.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public StartTaskRequest withContainerInstances(java.util.Collection<String> containerInstances) {
        if (containerInstances == null) {
            this.containerInstances = null;
        } else {
            com.amazonaws.internal.ListWithAutoConstructFlag<String> containerInstancesCopy = new com.amazonaws.internal.ListWithAutoConstructFlag<String>(containerInstances.size());
            containerInstancesCopy.addAll(containerInstances);
            this.containerInstances = containerInstancesCopy;
        }

        return this;
    }

    /**
     * Returns a string representation of this object; useful for testing and
     * debugging.
     *
     * @return A string representation of this object.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getCluster() != null) sb.append("Cluster: " + getCluster() + ",");
        if (getTaskDefinition() != null) sb.append("TaskDefinition: " + getTaskDefinition() + ",");
        if (getOverrides() != null) sb.append("Overrides: " + getOverrides() + ",");
        if (getContainerInstances() != null) sb.append("ContainerInstances: " + getContainerInstances() );
        sb.append("}");
        return sb.toString();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;
        
        hashCode = prime * hashCode + ((getCluster() == null) ? 0 : getCluster().hashCode()); 
        hashCode = prime * hashCode + ((getTaskDefinition() == null) ? 0 : getTaskDefinition().hashCode()); 
        hashCode = prime * hashCode + ((getOverrides() == null) ? 0 : getOverrides().hashCode()); 
        hashCode = prime * hashCode + ((getContainerInstances() == null) ? 0 : getContainerInstances().hashCode()); 
        return hashCode;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (obj instanceof StartTaskRequest == false) return false;
        StartTaskRequest other = (StartTaskRequest)obj;
        
        if (other.getCluster() == null ^ this.getCluster() == null) return false;
        if (other.getCluster() != null && other.getCluster().equals(this.getCluster()) == false) return false; 
        if (other.getTaskDefinition() == null ^ this.getTaskDefinition() == null) return false;
        if (other.getTaskDefinition() != null && other.getTaskDefinition().equals(this.getTaskDefinition()) == false) return false; 
        if (other.getOverrides() == null ^ this.getOverrides() == null) return false;
        if (other.getOverrides() != null && other.getOverrides().equals(this.getOverrides()) == false) return false; 
        if (other.getContainerInstances() == null ^ this.getContainerInstances() == null) return false;
        if (other.getContainerInstances() != null && other.getContainerInstances().equals(this.getContainerInstances()) == false) return false; 
        return true;
    }
    
}
    