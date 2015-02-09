/*
 * Copyright 2010-2015 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 * 
 *  http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.eucalyptus.ecs.common.model;

import java.io.Serializable;

import com.amazonaws.AmazonWebServiceRequest;
import com.eucalyptus.auth.policy.PolicyAction;

/**
 * Container for the parameters to the {@link com.amazonaws.services.ecs.AmazonECS#stopTask(StopTaskRequest) StopTask operation}.
 * <p>
 * Stops a running task.
 * </p>
 *
 * @see com.amazonaws.services.ecs.AmazonECS#stopTask(StopTaskRequest)
 */
@PolicyAction( vendor = "ecs", action = "stoptask" )
public class StopTaskRequest extends EcsMessage implements Serializable {

    /**
     * The short name or full Amazon Resource Name (ARN) of the cluster that
     * hosts the task you want to stop. If you do not specify a cluster, the
     * default cluster is assumed..
     */
    private String cluster;

    /**
     * The task UUIDs or full Amazon Resource Name (ARN) entry of the task
     * you would like to stop.
     */
    private String task;

    /**
     * The short name or full Amazon Resource Name (ARN) of the cluster that
     * hosts the task you want to stop. If you do not specify a cluster, the
     * default cluster is assumed..
     *
     * @return The short name or full Amazon Resource Name (ARN) of the cluster that
     *         hosts the task you want to stop. If you do not specify a cluster, the
     *         default cluster is assumed..
     */
    public String getCluster() {
        return cluster;
    }
    
    /**
     * The short name or full Amazon Resource Name (ARN) of the cluster that
     * hosts the task you want to stop. If you do not specify a cluster, the
     * default cluster is assumed..
     *
     * @param cluster The short name or full Amazon Resource Name (ARN) of the cluster that
     *         hosts the task you want to stop. If you do not specify a cluster, the
     *         default cluster is assumed..
     */
    public void setCluster(String cluster) {
        this.cluster = cluster;
    }
    
    /**
     * The short name or full Amazon Resource Name (ARN) of the cluster that
     * hosts the task you want to stop. If you do not specify a cluster, the
     * default cluster is assumed..
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param cluster The short name or full Amazon Resource Name (ARN) of the cluster that
     *         hosts the task you want to stop. If you do not specify a cluster, the
     *         default cluster is assumed..
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public StopTaskRequest withCluster(String cluster) {
        this.cluster = cluster;
        return this;
    }

    /**
     * The task UUIDs or full Amazon Resource Name (ARN) entry of the task
     * you would like to stop.
     *
     * @return The task UUIDs or full Amazon Resource Name (ARN) entry of the task
     *         you would like to stop.
     */
    public String getTask() {
        return task;
    }
    
    /**
     * The task UUIDs or full Amazon Resource Name (ARN) entry of the task
     * you would like to stop.
     *
     * @param task The task UUIDs or full Amazon Resource Name (ARN) entry of the task
     *         you would like to stop.
     */
    public void setTask(String task) {
        this.task = task;
    }
    
    /**
     * The task UUIDs or full Amazon Resource Name (ARN) entry of the task
     * you would like to stop.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param task The task UUIDs or full Amazon Resource Name (ARN) entry of the task
     *         you would like to stop.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public StopTaskRequest withTask(String task) {
        this.task = task;
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
        if (getTask() != null) sb.append("Task: " + getTask() );
        sb.append("}");
        return sb.toString();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;
        
        hashCode = prime * hashCode + ((getCluster() == null) ? 0 : getCluster().hashCode()); 
        hashCode = prime * hashCode + ((getTask() == null) ? 0 : getTask().hashCode()); 
        return hashCode;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (obj instanceof StopTaskRequest == false) return false;
        StopTaskRequest other = (StopTaskRequest)obj;
        
        if (other.getCluster() == null ^ this.getCluster() == null) return false;
        if (other.getCluster() != null && other.getCluster().equals(this.getCluster()) == false) return false; 
        if (other.getTask() == null ^ this.getTask() == null) return false;
        if (other.getTask() != null && other.getTask().equals(this.getTask()) == false) return false; 
        return true;
    }
    
}
    