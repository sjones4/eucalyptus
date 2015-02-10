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

/**
 * Container for the parameters to the {@link com.amazonaws.services.ecs.AmazonECS#describeTasks(DescribeTasksRequest) DescribeTasks operation}.
 * <p>
 * Describes a specified task or tasks.
 * </p>
 *
 * @see com.amazonaws.services.ecs.AmazonECS#describeTasks(DescribeTasksRequest)
 */
@PolicyAction( vendor = "ecs", action = "describetasks" )
public class DescribeTasksRequest extends EcsMessage implements Serializable {

    /**
     * The short name or full Amazon Resource Name (ARN) of the cluster that
     * hosts the task you want to describe. If you do not specify a cluster,
     * the default cluster is assumed.
     */
    private String cluster;

    /**
     * A space-separated list of task UUIDs or full Amazon Resource Name
     * (ARN) entries.
     */
    private com.amazonaws.internal.ListWithAutoConstructFlag<String> tasks;

    /**
     * The short name or full Amazon Resource Name (ARN) of the cluster that
     * hosts the task you want to describe. If you do not specify a cluster,
     * the default cluster is assumed.
     *
     * @return The short name or full Amazon Resource Name (ARN) of the cluster that
     *         hosts the task you want to describe. If you do not specify a cluster,
     *         the default cluster is assumed.
     */
    public String getCluster() {
        return cluster;
    }
    
    /**
     * The short name or full Amazon Resource Name (ARN) of the cluster that
     * hosts the task you want to describe. If you do not specify a cluster,
     * the default cluster is assumed.
     *
     * @param cluster The short name or full Amazon Resource Name (ARN) of the cluster that
     *         hosts the task you want to describe. If you do not specify a cluster,
     *         the default cluster is assumed.
     */
    public void setCluster(String cluster) {
        this.cluster = cluster;
    }
    
    /**
     * The short name or full Amazon Resource Name (ARN) of the cluster that
     * hosts the task you want to describe. If you do not specify a cluster,
     * the default cluster is assumed.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param cluster The short name or full Amazon Resource Name (ARN) of the cluster that
     *         hosts the task you want to describe. If you do not specify a cluster,
     *         the default cluster is assumed.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public DescribeTasksRequest withCluster(String cluster) {
        this.cluster = cluster;
        return this;
    }

    /**
     * A space-separated list of task UUIDs or full Amazon Resource Name
     * (ARN) entries.
     *
     * @return A space-separated list of task UUIDs or full Amazon Resource Name
     *         (ARN) entries.
     */
    public java.util.List<String> getTasks() {
        if (tasks == null) {
              tasks = new com.amazonaws.internal.ListWithAutoConstructFlag<String>();
              tasks.setAutoConstruct(true);
        }
        return tasks;
    }
    
    /**
     * A space-separated list of task UUIDs or full Amazon Resource Name
     * (ARN) entries.
     *
     * @param tasks A space-separated list of task UUIDs or full Amazon Resource Name
     *         (ARN) entries.
     */
    public void setTasks(java.util.Collection<String> tasks) {
        if (tasks == null) {
            this.tasks = null;
            return;
        }
        com.amazonaws.internal.ListWithAutoConstructFlag<String> tasksCopy = new com.amazonaws.internal.ListWithAutoConstructFlag<String>(tasks.size());
        tasksCopy.addAll(tasks);
        this.tasks = tasksCopy;
    }
    
    /**
     * A space-separated list of task UUIDs or full Amazon Resource Name
     * (ARN) entries.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param tasks A space-separated list of task UUIDs or full Amazon Resource Name
     *         (ARN) entries.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public DescribeTasksRequest withTasks(String... tasks) {
        if (getTasks() == null) setTasks(new java.util.ArrayList<String>(tasks.length));
        for (String value : tasks) {
            getTasks().add(value);
        }
        return this;
    }
    
    /**
     * A space-separated list of task UUIDs or full Amazon Resource Name
     * (ARN) entries.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param tasks A space-separated list of task UUIDs or full Amazon Resource Name
     *         (ARN) entries.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public DescribeTasksRequest withTasks(java.util.Collection<String> tasks) {
        if (tasks == null) {
            this.tasks = null;
        } else {
            com.amazonaws.internal.ListWithAutoConstructFlag<String> tasksCopy = new com.amazonaws.internal.ListWithAutoConstructFlag<String>(tasks.size());
            tasksCopy.addAll(tasks);
            this.tasks = tasksCopy;
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
        if (getTasks() != null) sb.append("Tasks: " + getTasks() );
        sb.append("}");
        return sb.toString();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;
        
        hashCode = prime * hashCode + ((getCluster() == null) ? 0 : getCluster().hashCode()); 
        hashCode = prime * hashCode + ((getTasks() == null) ? 0 : getTasks().hashCode()); 
        return hashCode;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (obj instanceof DescribeTasksRequest == false) return false;
        DescribeTasksRequest other = (DescribeTasksRequest)obj;
        
        if (other.getCluster() == null ^ this.getCluster() == null) return false;
        if (other.getCluster() != null && other.getCluster().equals(this.getCluster()) == false) return false; 
        if (other.getTasks() == null ^ this.getTasks() == null) return false;
        if (other.getTasks() != null && other.getTasks().equals(this.getTasks()) == false) return false; 
        return true;
    }
    
}
    