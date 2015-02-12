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
 * Container for the parameters to the {@link com.amazonaws.services.ecs.AmazonECS#createCluster(CreateClusterRequest) CreateCluster operation}.
 * <p>
 * Creates a new Amazon ECS cluster. By default, your account will
 * receive a <code>default</code> cluster when you launch your first
 * container instance. However, you can create your own cluster with a
 * unique name with the <code>CreateCluster</code> action.
 * </p>
 * <p>
 * <b>IMPORTANT:</b> During the preview, each account is limited to two
 * clusters.
 * </p>
 *
 * @see com.amazonaws.services.ecs.AmazonECS#createCluster(CreateClusterRequest)
 */
@PolicyAction( vendor = "ecs", action = "createcluster" )
public class CreateClusterRequest extends EcsMessage implements Serializable {

    /**
     * The name of your cluster. If you do not specify a name for your
     * cluster, you will create a cluster named <code>default</code>.
     */
    @HttpParameterMapping( parameter = "clusterName" )
    private String clusterName;

    /**
     * The name of your cluster. If you do not specify a name for your
     * cluster, you will create a cluster named <code>default</code>.
     *
     * @return The name of your cluster. If you do not specify a name for your
     *         cluster, you will create a cluster named <code>default</code>.
     */
    public String getClusterName() {
        return clusterName;
    }
    
    /**
     * The name of your cluster. If you do not specify a name for your
     * cluster, you will create a cluster named <code>default</code>.
     *
     * @param clusterName The name of your cluster. If you do not specify a name for your
     *         cluster, you will create a cluster named <code>default</code>.
     */
    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }
    
    /**
     * The name of your cluster. If you do not specify a name for your
     * cluster, you will create a cluster named <code>default</code>.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param clusterName The name of your cluster. If you do not specify a name for your
     *         cluster, you will create a cluster named <code>default</code>.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public CreateClusterRequest withClusterName(String clusterName) {
        this.clusterName = clusterName;
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
        if (getClusterName() != null) sb.append("ClusterName: " + getClusterName() );
        sb.append("}");
        return sb.toString();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;
        
        hashCode = prime * hashCode + ((getClusterName() == null) ? 0 : getClusterName().hashCode()); 
        return hashCode;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (obj instanceof CreateClusterRequest == false) return false;
        CreateClusterRequest other = (CreateClusterRequest)obj;
        
        if (other.getClusterName() == null ^ this.getClusterName() == null) return false;
        if (other.getClusterName() != null && other.getClusterName().equals(this.getClusterName()) == false) return false; 
        return true;
    }
    
}
    