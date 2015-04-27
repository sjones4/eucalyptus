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

import javax.annotation.Nonnull;
import com.eucalyptus.auth.policy.PolicyAction;

/**
 * Container for the parameters to the {@link com.amazonaws.services.ecs.AmazonECS#registerContainerInstance(RegisterContainerInstanceRequest) RegisterContainerInstance operation}.
 * <p>
 * <b>NOTE:</b> This action is only used by the Amazon EC2 Container
 * Service agent, and it is not intended for use outside of the agent.
 * </p>
 * <p>
 * Registers an Amazon EC2 instance into the specified cluster. This
 * instance will become available to place containers on.
 * </p>
 *
 * @see com.amazonaws.services.ecs.AmazonECS#registerContainerInstance(RegisterContainerInstanceRequest)
 */
@PolicyAction( vendor = "ecs", action = "registercontainerinstance" )
public class RegisterContainerInstanceRequest extends EcsMessage implements Serializable {

    /**
     * The short name or full Amazon Resource Name (ARN) of the cluster that
     * you want to register your container instance with. If you do not
     * specify a cluster, the default cluster is assumed..
     */
    @Nonnull
    private String cluster;

    /**
     * 
     */
    private String instanceIdentityDocument;

    /**
     * 
     */
    private String instanceIdentityDocumentSignature;

    /**
     * 
     */
    private com.amazonaws.internal.ListWithAutoConstructFlag<Resource> totalResources;

    /**
     * The short name or full Amazon Resource Name (ARN) of the cluster that
     * you want to register your container instance with. If you do not
     * specify a cluster, the default cluster is assumed..
     *
     * @return The short name or full Amazon Resource Name (ARN) of the cluster that
     *         you want to register your container instance with. If you do not
     *         specify a cluster, the default cluster is assumed..
     */
    public String getCluster() {
        return cluster;
    }
    
    /**
     * The short name or full Amazon Resource Name (ARN) of the cluster that
     * you want to register your container instance with. If you do not
     * specify a cluster, the default cluster is assumed..
     *
     * @param cluster The short name or full Amazon Resource Name (ARN) of the cluster that
     *         you want to register your container instance with. If you do not
     *         specify a cluster, the default cluster is assumed..
     */
    public void setCluster(String cluster) {
        this.cluster = cluster;
    }
    
    /**
     * The short name or full Amazon Resource Name (ARN) of the cluster that
     * you want to register your container instance with. If you do not
     * specify a cluster, the default cluster is assumed..
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param cluster The short name or full Amazon Resource Name (ARN) of the cluster that
     *         you want to register your container instance with. If you do not
     *         specify a cluster, the default cluster is assumed..
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public RegisterContainerInstanceRequest withCluster(String cluster) {
        this.cluster = cluster;
        return this;
    }

    /**
     * 
     *
     * @return 
     */
    public String getInstanceIdentityDocument() {
        return instanceIdentityDocument;
    }
    
    /**
     * 
     *
     * @param instanceIdentityDocument 
     */
    public void setInstanceIdentityDocument(String instanceIdentityDocument) {
        this.instanceIdentityDocument = instanceIdentityDocument;
    }
    
    /**
     * 
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param instanceIdentityDocument 
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public RegisterContainerInstanceRequest withInstanceIdentityDocument(String instanceIdentityDocument) {
        this.instanceIdentityDocument = instanceIdentityDocument;
        return this;
    }

    /**
     * 
     *
     * @return 
     */
    public String getInstanceIdentityDocumentSignature() {
        return instanceIdentityDocumentSignature;
    }
    
    /**
     * 
     *
     * @param instanceIdentityDocumentSignature 
     */
    public void setInstanceIdentityDocumentSignature(String instanceIdentityDocumentSignature) {
        this.instanceIdentityDocumentSignature = instanceIdentityDocumentSignature;
    }
    
    /**
     * 
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param instanceIdentityDocumentSignature 
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public RegisterContainerInstanceRequest withInstanceIdentityDocumentSignature(String instanceIdentityDocumentSignature) {
        this.instanceIdentityDocumentSignature = instanceIdentityDocumentSignature;
        return this;
    }

    /**
     * 
     *
     * @return 
     */
    public java.util.List<Resource> getTotalResources() {
        if (totalResources == null) {
              totalResources = new com.amazonaws.internal.ListWithAutoConstructFlag<Resource>();
              totalResources.setAutoConstruct(true);
        }
        return totalResources;
    }
    
    /**
     * 
     *
     * @param totalResources 
     */
    public void setTotalResources(java.util.Collection<Resource> totalResources) {
        if (totalResources == null) {
            this.totalResources = null;
            return;
        }
        com.amazonaws.internal.ListWithAutoConstructFlag<Resource> totalResourcesCopy = new com.amazonaws.internal.ListWithAutoConstructFlag<Resource>(totalResources.size());
        totalResourcesCopy.addAll(totalResources);
        this.totalResources = totalResourcesCopy;
    }
    
    /**
     * 
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param totalResources 
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public RegisterContainerInstanceRequest withTotalResources(Resource... totalResources) {
        if (getTotalResources() == null) setTotalResources(new java.util.ArrayList<Resource>(totalResources.length));
        for (Resource value : totalResources) {
            getTotalResources().add(value);
        }
        return this;
    }
    
    /**
     * 
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param totalResources 
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public RegisterContainerInstanceRequest withTotalResources(java.util.Collection<Resource> totalResources) {
        if (totalResources == null) {
            this.totalResources = null;
        } else {
            com.amazonaws.internal.ListWithAutoConstructFlag<Resource> totalResourcesCopy = new com.amazonaws.internal.ListWithAutoConstructFlag<Resource>(totalResources.size());
            totalResourcesCopy.addAll(totalResources);
            this.totalResources = totalResourcesCopy;
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
        if (getInstanceIdentityDocument() != null) sb.append("InstanceIdentityDocument: " + getInstanceIdentityDocument() + ",");
        if (getInstanceIdentityDocumentSignature() != null) sb.append("InstanceIdentityDocumentSignature: " + getInstanceIdentityDocumentSignature() + ",");
        if (getTotalResources() != null) sb.append("TotalResources: " + getTotalResources() );
        sb.append("}");
        return sb.toString();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;
        
        hashCode = prime * hashCode + ((getCluster() == null) ? 0 : getCluster().hashCode()); 
        hashCode = prime * hashCode + ((getInstanceIdentityDocument() == null) ? 0 : getInstanceIdentityDocument().hashCode()); 
        hashCode = prime * hashCode + ((getInstanceIdentityDocumentSignature() == null) ? 0 : getInstanceIdentityDocumentSignature().hashCode()); 
        hashCode = prime * hashCode + ((getTotalResources() == null) ? 0 : getTotalResources().hashCode()); 
        return hashCode;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (obj instanceof RegisterContainerInstanceRequest == false) return false;
        RegisterContainerInstanceRequest other = (RegisterContainerInstanceRequest)obj;
        
        if (other.getCluster() == null ^ this.getCluster() == null) return false;
        if (other.getCluster() != null && other.getCluster().equals(this.getCluster()) == false) return false; 
        if (other.getInstanceIdentityDocument() == null ^ this.getInstanceIdentityDocument() == null) return false;
        if (other.getInstanceIdentityDocument() != null && other.getInstanceIdentityDocument().equals(this.getInstanceIdentityDocument()) == false) return false; 
        if (other.getInstanceIdentityDocumentSignature() == null ^ this.getInstanceIdentityDocumentSignature() == null) return false;
        if (other.getInstanceIdentityDocumentSignature() != null && other.getInstanceIdentityDocumentSignature().equals(this.getInstanceIdentityDocumentSignature()) == false) return false; 
        if (other.getTotalResources() == null ^ this.getTotalResources() == null) return false;
        if (other.getTotalResources() != null && other.getTotalResources().equals(this.getTotalResources()) == false) return false; 
        return true;
    }
    
}
    