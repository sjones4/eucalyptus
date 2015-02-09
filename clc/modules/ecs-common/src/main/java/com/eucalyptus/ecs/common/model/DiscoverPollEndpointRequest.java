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
 * Container for the parameters to the {@link com.amazonaws.services.ecs.AmazonECS#discoverPollEndpoint(DiscoverPollEndpointRequest) DiscoverPollEndpoint operation}.
 * <p>
 * <b>NOTE:</b> This action is only used by the Amazon EC2 Container
 * Service agent, and it is not intended for use outside of the agent.
 * </p>
 * <p>
 * Returns an endpoint for the Amazon EC2 Container Service agent to poll
 * for updates.
 * </p>
 *
 * @see com.amazonaws.services.ecs.AmazonECS#discoverPollEndpoint(DiscoverPollEndpointRequest)
 */
@PolicyAction( vendor = "ecs", action = "discoverpollendpoint" )
public class DiscoverPollEndpointRequest extends EcsMessage implements Serializable {

    /**
     * The container instance UUID or full Amazon Resource Name (ARN) of the
     * container instance. The ARN contains the <code>arn:aws:ecs</code>
     * namespace, followed by the region of the container instance, the AWS
     * account ID of the container instance owner, the
     * <code>container-instance</code> namespace, and then the container
     * instance UUID. For example,
     * arn:aws:ecs:<i>region</i>:<i>aws_account_id</i>:container-instance/<i>container_instance_UUID</i>.
     */
    private String containerInstance;

    /**
     * The container instance UUID or full Amazon Resource Name (ARN) of the
     * container instance. The ARN contains the <code>arn:aws:ecs</code>
     * namespace, followed by the region of the container instance, the AWS
     * account ID of the container instance owner, the
     * <code>container-instance</code> namespace, and then the container
     * instance UUID. For example,
     * arn:aws:ecs:<i>region</i>:<i>aws_account_id</i>:container-instance/<i>container_instance_UUID</i>.
     *
     * @return The container instance UUID or full Amazon Resource Name (ARN) of the
     *         container instance. The ARN contains the <code>arn:aws:ecs</code>
     *         namespace, followed by the region of the container instance, the AWS
     *         account ID of the container instance owner, the
     *         <code>container-instance</code> namespace, and then the container
     *         instance UUID. For example,
     *         arn:aws:ecs:<i>region</i>:<i>aws_account_id</i>:container-instance/<i>container_instance_UUID</i>.
     */
    public String getContainerInstance() {
        return containerInstance;
    }
    
    /**
     * The container instance UUID or full Amazon Resource Name (ARN) of the
     * container instance. The ARN contains the <code>arn:aws:ecs</code>
     * namespace, followed by the region of the container instance, the AWS
     * account ID of the container instance owner, the
     * <code>container-instance</code> namespace, and then the container
     * instance UUID. For example,
     * arn:aws:ecs:<i>region</i>:<i>aws_account_id</i>:container-instance/<i>container_instance_UUID</i>.
     *
     * @param containerInstance The container instance UUID or full Amazon Resource Name (ARN) of the
     *         container instance. The ARN contains the <code>arn:aws:ecs</code>
     *         namespace, followed by the region of the container instance, the AWS
     *         account ID of the container instance owner, the
     *         <code>container-instance</code> namespace, and then the container
     *         instance UUID. For example,
     *         arn:aws:ecs:<i>region</i>:<i>aws_account_id</i>:container-instance/<i>container_instance_UUID</i>.
     */
    public void setContainerInstance(String containerInstance) {
        this.containerInstance = containerInstance;
    }
    
    /**
     * The container instance UUID or full Amazon Resource Name (ARN) of the
     * container instance. The ARN contains the <code>arn:aws:ecs</code>
     * namespace, followed by the region of the container instance, the AWS
     * account ID of the container instance owner, the
     * <code>container-instance</code> namespace, and then the container
     * instance UUID. For example,
     * arn:aws:ecs:<i>region</i>:<i>aws_account_id</i>:container-instance/<i>container_instance_UUID</i>.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param containerInstance The container instance UUID or full Amazon Resource Name (ARN) of the
     *         container instance. The ARN contains the <code>arn:aws:ecs</code>
     *         namespace, followed by the region of the container instance, the AWS
     *         account ID of the container instance owner, the
     *         <code>container-instance</code> namespace, and then the container
     *         instance UUID. For example,
     *         arn:aws:ecs:<i>region</i>:<i>aws_account_id</i>:container-instance/<i>container_instance_UUID</i>.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public DiscoverPollEndpointRequest withContainerInstance(String containerInstance) {
        this.containerInstance = containerInstance;
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
        if (getContainerInstance() != null) sb.append("ContainerInstance: " + getContainerInstance() );
        sb.append("}");
        return sb.toString();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;
        
        hashCode = prime * hashCode + ((getContainerInstance() == null) ? 0 : getContainerInstance().hashCode()); 
        return hashCode;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (obj instanceof DiscoverPollEndpointRequest == false) return false;
        DiscoverPollEndpointRequest other = (DiscoverPollEndpointRequest)obj;
        
        if (other.getContainerInstance() == null ^ this.getContainerInstance() == null) return false;
        if (other.getContainerInstance() != null && other.getContainerInstance().equals(this.getContainerInstance()) == false) return false; 
        return true;
    }
    
}
    