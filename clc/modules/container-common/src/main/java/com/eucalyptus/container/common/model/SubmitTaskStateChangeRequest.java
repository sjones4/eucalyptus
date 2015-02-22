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
 * Container for the parameters to the {@link com.amazonaws.services.ecs.AmazonECS#submitTaskStateChange(SubmitTaskStateChangeRequest) SubmitTaskStateChange operation}.
 * <p>
 * <b>NOTE:</b> This action is only used by the Amazon EC2 Container
 * Service agent, and it is not intended for use outside of the agent.
 * </p>
 * <p>
 * Sent to acknowledge that a task changed states.
 * </p>
 *
 * @see com.amazonaws.services.ecs.AmazonECS#submitTaskStateChange(SubmitTaskStateChangeRequest)
 */
@PolicyAction( vendor = "ecs", action = "submittaskstatechange" )
public class SubmitTaskStateChangeRequest extends EcsMessage implements Serializable {

    /**
     * The short name or full Amazon Resource Name (ARN) of the cluster that
     * hosts the task.
     */
    @HttpParameterMapping( parameter = "cluster" )
    private String cluster;

    /**
     * The task UUID or full Amazon Resource Name (ARN) of the task in the
     * state change request.
     */
    @HttpParameterMapping( parameter = "task" )
    private String task;

    /**
     * The status of the state change request.
     */
    @HttpParameterMapping( parameter = "status" )
    private String status;

    /**
     * The reason for the state change request.
     */
    @HttpParameterMapping( parameter = "reason" )
    private String reason;

    /**
     * The short name or full Amazon Resource Name (ARN) of the cluster that
     * hosts the task.
     *
     * @return The short name or full Amazon Resource Name (ARN) of the cluster that
     *         hosts the task.
     */
    public String getCluster() {
        return cluster;
    }
    
    /**
     * The short name or full Amazon Resource Name (ARN) of the cluster that
     * hosts the task.
     *
     * @param cluster The short name or full Amazon Resource Name (ARN) of the cluster that
     *         hosts the task.
     */
    public void setCluster(String cluster) {
        this.cluster = cluster;
    }
    
    /**
     * The short name or full Amazon Resource Name (ARN) of the cluster that
     * hosts the task.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param cluster The short name or full Amazon Resource Name (ARN) of the cluster that
     *         hosts the task.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public SubmitTaskStateChangeRequest withCluster(String cluster) {
        this.cluster = cluster;
        return this;
    }

    /**
     * The task UUID or full Amazon Resource Name (ARN) of the task in the
     * state change request.
     *
     * @return The task UUID or full Amazon Resource Name (ARN) of the task in the
     *         state change request.
     */
    public String getTask() {
        return task;
    }
    
    /**
     * The task UUID or full Amazon Resource Name (ARN) of the task in the
     * state change request.
     *
     * @param task The task UUID or full Amazon Resource Name (ARN) of the task in the
     *         state change request.
     */
    public void setTask(String task) {
        this.task = task;
    }
    
    /**
     * The task UUID or full Amazon Resource Name (ARN) of the task in the
     * state change request.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param task The task UUID or full Amazon Resource Name (ARN) of the task in the
     *         state change request.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public SubmitTaskStateChangeRequest withTask(String task) {
        this.task = task;
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
    public SubmitTaskStateChangeRequest withStatus(String status) {
        this.status = status;
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
    public SubmitTaskStateChangeRequest withReason(String reason) {
        this.reason = reason;
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
        if (getStatus() != null) sb.append("Status: " + getStatus() + ",");
        if (getReason() != null) sb.append("Reason: " + getReason() );
        sb.append("}");
        return sb.toString();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;
        
        hashCode = prime * hashCode + ((getCluster() == null) ? 0 : getCluster().hashCode()); 
        hashCode = prime * hashCode + ((getTask() == null) ? 0 : getTask().hashCode()); 
        hashCode = prime * hashCode + ((getStatus() == null) ? 0 : getStatus().hashCode()); 
        hashCode = prime * hashCode + ((getReason() == null) ? 0 : getReason().hashCode()); 
        return hashCode;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (obj instanceof SubmitTaskStateChangeRequest == false) return false;
        SubmitTaskStateChangeRequest other = (SubmitTaskStateChangeRequest)obj;
        
        if (other.getCluster() == null ^ this.getCluster() == null) return false;
        if (other.getCluster() != null && other.getCluster().equals(this.getCluster()) == false) return false; 
        if (other.getTask() == null ^ this.getTask() == null) return false;
        if (other.getTask() != null && other.getTask().equals(this.getTask()) == false) return false; 
        if (other.getStatus() == null ^ this.getStatus() == null) return false;
        if (other.getStatus() != null && other.getStatus().equals(this.getStatus()) == false) return false; 
        if (other.getReason() == null ^ this.getReason() == null) return false;
        if (other.getReason() != null && other.getReason().equals(this.getReason()) == false) return false; 
        return true;
    }
    
}
    