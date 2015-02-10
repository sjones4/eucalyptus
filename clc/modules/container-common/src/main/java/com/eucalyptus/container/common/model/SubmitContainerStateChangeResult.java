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

/**
 * 
 */
public class SubmitContainerStateChangeResult extends EcsMessage implements Serializable {

    /**
     * Acknowledgement of the state change.
     */
    private String acknowledgment;

    /**
     * Acknowledgement of the state change.
     *
     * @return Acknowledgement of the state change.
     */
    public String getAcknowledgment() {
        return acknowledgment;
    }
    
    /**
     * Acknowledgement of the state change.
     *
     * @param acknowledgment Acknowledgement of the state change.
     */
    public void setAcknowledgment(String acknowledgment) {
        this.acknowledgment = acknowledgment;
    }
    
    /**
     * Acknowledgement of the state change.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param acknowledgment Acknowledgement of the state change.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public SubmitContainerStateChangeResult withAcknowledgment(String acknowledgment) {
        this.acknowledgment = acknowledgment;
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
        if (getAcknowledgment() != null) sb.append("Acknowledgment: " + getAcknowledgment() );
        sb.append("}");
        return sb.toString();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;
        
        hashCode = prime * hashCode + ((getAcknowledgment() == null) ? 0 : getAcknowledgment().hashCode()); 
        return hashCode;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (obj instanceof SubmitContainerStateChangeResult == false) return false;
        SubmitContainerStateChangeResult other = (SubmitContainerStateChangeResult)obj;
        
        if (other.getAcknowledgment() == null ^ this.getAcknowledgment() == null) return false;
        if (other.getAcknowledgment() != null && other.getAcknowledgment().equals(this.getAcknowledgment()) == false) return false; 
        return true;
    }
    
}
    