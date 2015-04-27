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
 * Container for the parameters to the {@link com.amazonaws.services.ecs.AmazonECS#submitContainerStateChange(SubmitContainerStateChangeRequest) SubmitContainerStateChange operation}.
 * <p>
 * <b>NOTE:</b> This action is only used by the Amazon EC2 Container
 * Service agent, and it is not intended for use outside of the agent.
 * </p>
 * <p>
 * Sent to acknowledge that a container changed states.
 * </p>
 *
 * @see com.amazonaws.services.ecs.AmazonECS#submitContainerStateChange(SubmitContainerStateChangeRequest)
 */
@PolicyAction( vendor = "ecs", action = "submitcontainerstatechange" )
public class SubmitContainerStateChangeRequest extends EcsMessage implements Serializable {

    /**
     * The short name or full Amazon Resource Name (ARN) of the cluster that
     * hosts the container.
     */
    @HttpParameterMapping( parameter = "cluster" )
    private String cluster;

    /**
     * The task UUID or full Amazon Resource Name (ARN) of the task that
     * hosts the container.
     */
    @HttpParameterMapping( parameter = "task" )
    private String task;

    /**
     * The name of the container.
     */
    @HttpParameterMapping( parameter = "containerName" )
    private String containerName;

    /**
     * The status of the state change request.
     */
    @HttpParameterMapping( parameter = "status" )
    private String status;

    /**
     * The exit code returned for the state change request.
     */
    @HttpParameterMapping( parameter = "exitCode" )
    private Integer exitCode;

    /**
     * The reason for the state change request.
     */
    @HttpParameterMapping( parameter = "reason" )
    private String reason;

    /**
     * The network bindings of the container.
     */
    @HttpParameterMapping( parameter = "networkBindings" )
    private com.amazonaws.internal.ListWithAutoConstructFlag<NetworkBinding> networkBindings;

    /**
     * The short name or full Amazon Resource Name (ARN) of the cluster that
     * hosts the container.
     *
     * @return The short name or full Amazon Resource Name (ARN) of the cluster that
     *         hosts the container.
     */
    public String getCluster() {
        return cluster;
    }
    
    /**
     * The short name or full Amazon Resource Name (ARN) of the cluster that
     * hosts the container.
     *
     * @param cluster The short name or full Amazon Resource Name (ARN) of the cluster that
     *         hosts the container.
     */
    public void setCluster(String cluster) {
        this.cluster = cluster;
    }
    
    /**
     * The short name or full Amazon Resource Name (ARN) of the cluster that
     * hosts the container.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param cluster The short name or full Amazon Resource Name (ARN) of the cluster that
     *         hosts the container.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public SubmitContainerStateChangeRequest withCluster(String cluster) {
        this.cluster = cluster;
        return this;
    }

    /**
     * The task UUID or full Amazon Resource Name (ARN) of the task that
     * hosts the container.
     *
     * @return The task UUID or full Amazon Resource Name (ARN) of the task that
     *         hosts the container.
     */
    public String getTask() {
        return task;
    }
    
    /**
     * The task UUID or full Amazon Resource Name (ARN) of the task that
     * hosts the container.
     *
     * @param task The task UUID or full Amazon Resource Name (ARN) of the task that
     *         hosts the container.
     */
    public void setTask(String task) {
        this.task = task;
    }
    
    /**
     * The task UUID or full Amazon Resource Name (ARN) of the task that
     * hosts the container.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param task The task UUID or full Amazon Resource Name (ARN) of the task that
     *         hosts the container.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public SubmitContainerStateChangeRequest withTask(String task) {
        this.task = task;
        return this;
    }

    /**
     * The name of the container.
     *
     * @return The name of the container.
     */
    public String getContainerName() {
        return containerName;
    }
    
    /**
     * The name of the container.
     *
     * @param containerName The name of the container.
     */
    public void setContainerName(String containerName) {
        this.containerName = containerName;
    }
    
    /**
     * The name of the container.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param containerName The name of the container.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public SubmitContainerStateChangeRequest withContainerName(String containerName) {
        this.containerName = containerName;
        return this;
    }

    /**
     * The status of the state change request.
     *
     * @return The status of the state change request.
     */
    public String getStatus() {
        return status;
    }
    
    /**
     * The status of the state change request.
     *
     * @param status The status of the state change request.
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
    /**
     * The status of the state change request.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param status The status of the state change request.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public SubmitContainerStateChangeRequest withStatus(String status) {
        this.status = status;
        return this;
    }

    /**
     * The exit code returned for the state change request.
     *
     * @return The exit code returned for the state change request.
     */
    public Integer getExitCode() {
        return exitCode;
    }
    
    /**
     * The exit code returned for the state change request.
     *
     * @param exitCode The exit code returned for the state change request.
     */
    public void setExitCode(Integer exitCode) {
        this.exitCode = exitCode;
    }
    
    /**
     * The exit code returned for the state change request.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param exitCode The exit code returned for the state change request.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public SubmitContainerStateChangeRequest withExitCode(Integer exitCode) {
        this.exitCode = exitCode;
        return this;
    }

    /**
     * The reason for the state change request.
     *
     * @return The reason for the state change request.
     */
    public String getReason() {
        return reason;
    }
    
    /**
     * The reason for the state change request.
     *
     * @param reason The reason for the state change request.
     */
    public void setReason(String reason) {
        this.reason = reason;
    }
    
    /**
     * The reason for the state change request.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param reason The reason for the state change request.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public SubmitContainerStateChangeRequest withReason(String reason) {
        this.reason = reason;
        return this;
    }

    /**
     * The network bindings of the container.
     *
     * @return The network bindings of the container.
     */
    public java.util.List<NetworkBinding> getNetworkBindings() {
        if (networkBindings == null) {
              networkBindings = new com.amazonaws.internal.ListWithAutoConstructFlag<NetworkBinding>();
              networkBindings.setAutoConstruct(true);
        }
        return networkBindings;
    }
    
    /**
     * The network bindings of the container.
     *
     * @param networkBindings The network bindings of the container.
     */
    public void setNetworkBindings(java.util.Collection<NetworkBinding> networkBindings) {
        if (networkBindings == null) {
            this.networkBindings = null;
            return;
        }
        com.amazonaws.internal.ListWithAutoConstructFlag<NetworkBinding> networkBindingsCopy = new com.amazonaws.internal.ListWithAutoConstructFlag<NetworkBinding>(networkBindings.size());
        networkBindingsCopy.addAll(networkBindings);
        this.networkBindings = networkBindingsCopy;
    }
    
    /**
     * The network bindings of the container.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param networkBindings The network bindings of the container.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public SubmitContainerStateChangeRequest withNetworkBindings(NetworkBinding... networkBindings) {
        if (getNetworkBindings() == null) setNetworkBindings(new java.util.ArrayList<NetworkBinding>(networkBindings.length));
        for (NetworkBinding value : networkBindings) {
            getNetworkBindings().add(value);
        }
        return this;
    }
    
    /**
     * The network bindings of the container.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param networkBindings The network bindings of the container.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public SubmitContainerStateChangeRequest withNetworkBindings(java.util.Collection<NetworkBinding> networkBindings) {
        if (networkBindings == null) {
            this.networkBindings = null;
        } else {
            com.amazonaws.internal.ListWithAutoConstructFlag<NetworkBinding> networkBindingsCopy = new com.amazonaws.internal.ListWithAutoConstructFlag<NetworkBinding>(networkBindings.size());
            networkBindingsCopy.addAll(networkBindings);
            this.networkBindings = networkBindingsCopy;
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
        if (getTask() != null) sb.append("Task: " + getTask() + ",");
        if (getContainerName() != null) sb.append("ContainerName: " + getContainerName() + ",");
        if (getStatus() != null) sb.append("Status: " + getStatus() + ",");
        if (getExitCode() != null) sb.append("ExitCode: " + getExitCode() + ",");
        if (getReason() != null) sb.append("Reason: " + getReason() + ",");
        if (getNetworkBindings() != null) sb.append("NetworkBindings: " + getNetworkBindings() );
        sb.append("}");
        return sb.toString();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;
        
        hashCode = prime * hashCode + ((getCluster() == null) ? 0 : getCluster().hashCode()); 
        hashCode = prime * hashCode + ((getTask() == null) ? 0 : getTask().hashCode()); 
        hashCode = prime * hashCode + ((getContainerName() == null) ? 0 : getContainerName().hashCode()); 
        hashCode = prime * hashCode + ((getStatus() == null) ? 0 : getStatus().hashCode()); 
        hashCode = prime * hashCode + ((getExitCode() == null) ? 0 : getExitCode().hashCode()); 
        hashCode = prime * hashCode + ((getReason() == null) ? 0 : getReason().hashCode()); 
        hashCode = prime * hashCode + ((getNetworkBindings() == null) ? 0 : getNetworkBindings().hashCode()); 
        return hashCode;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (obj instanceof SubmitContainerStateChangeRequest == false) return false;
        SubmitContainerStateChangeRequest other = (SubmitContainerStateChangeRequest)obj;
        
        if (other.getCluster() == null ^ this.getCluster() == null) return false;
        if (other.getCluster() != null && other.getCluster().equals(this.getCluster()) == false) return false; 
        if (other.getTask() == null ^ this.getTask() == null) return false;
        if (other.getTask() != null && other.getTask().equals(this.getTask()) == false) return false; 
        if (other.getContainerName() == null ^ this.getContainerName() == null) return false;
        if (other.getContainerName() != null && other.getContainerName().equals(this.getContainerName()) == false) return false; 
        if (other.getStatus() == null ^ this.getStatus() == null) return false;
        if (other.getStatus() != null && other.getStatus().equals(this.getStatus()) == false) return false; 
        if (other.getExitCode() == null ^ this.getExitCode() == null) return false;
        if (other.getExitCode() != null && other.getExitCode().equals(this.getExitCode()) == false) return false; 
        if (other.getReason() == null ^ this.getReason() == null) return false;
        if (other.getReason() != null && other.getReason().equals(this.getReason()) == false) return false; 
        if (other.getNetworkBindings() == null ^ this.getNetworkBindings() == null) return false;
        if (other.getNetworkBindings() != null && other.getNetworkBindings().equals(this.getNetworkBindings()) == false) return false; 
        return true;
    }
    
}
    