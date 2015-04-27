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
public class TaskDefinition implements Serializable {

    /**
     * The full Amazon Resource Name (ARN) of the of the task definition.
     */
    private String taskDefinitionArn;

    /**
     * A list of container definitions in JSON format that describe the
     * different containers that make up your task.
     */
    private com.amazonaws.internal.ListWithAutoConstructFlag<ContainerDefinition> containerDefinitions;

    /**
     * The family of your task definition. You can think of the
     * <code>family</code> as the name of your task definition.
     */
    private String family;

    /**
     * The revision of the task in a particular family. You can think of the
     * revision as a version number of a task definition in a family. When
     * you register a task definition for the first time, the revision is
     * <code>1</code>, and each time you register a task definition in the
     * same family, the revision value increases by one.
     */
    private Integer revision;

    /**
     * The full Amazon Resource Name (ARN) of the of the task definition.
     *
     * @return The full Amazon Resource Name (ARN) of the of the task definition.
     */
    public String getTaskDefinitionArn() {
        return taskDefinitionArn;
    }
    
    /**
     * The full Amazon Resource Name (ARN) of the of the task definition.
     *
     * @param taskDefinitionArn The full Amazon Resource Name (ARN) of the of the task definition.
     */
    public void setTaskDefinitionArn(String taskDefinitionArn) {
        this.taskDefinitionArn = taskDefinitionArn;
    }
    
    /**
     * The full Amazon Resource Name (ARN) of the of the task definition.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param taskDefinitionArn The full Amazon Resource Name (ARN) of the of the task definition.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public TaskDefinition withTaskDefinitionArn(String taskDefinitionArn) {
        this.taskDefinitionArn = taskDefinitionArn;
        return this;
    }

    /**
     * A list of container definitions in JSON format that describe the
     * different containers that make up your task.
     *
     * @return A list of container definitions in JSON format that describe the
     *         different containers that make up your task.
     */
    public java.util.List<ContainerDefinition> getContainerDefinitions() {
        if (containerDefinitions == null) {
              containerDefinitions = new com.amazonaws.internal.ListWithAutoConstructFlag<ContainerDefinition>();
              containerDefinitions.setAutoConstruct(true);
        }
        return containerDefinitions;
    }
    
    /**
     * A list of container definitions in JSON format that describe the
     * different containers that make up your task.
     *
     * @param containerDefinitions A list of container definitions in JSON format that describe the
     *         different containers that make up your task.
     */
    public void setContainerDefinitions(java.util.Collection<ContainerDefinition> containerDefinitions) {
        if (containerDefinitions == null) {
            this.containerDefinitions = null;
            return;
        }
        com.amazonaws.internal.ListWithAutoConstructFlag<ContainerDefinition> containerDefinitionsCopy = new com.amazonaws.internal.ListWithAutoConstructFlag<ContainerDefinition>(containerDefinitions.size());
        containerDefinitionsCopy.addAll(containerDefinitions);
        this.containerDefinitions = containerDefinitionsCopy;
    }
    
    /**
     * A list of container definitions in JSON format that describe the
     * different containers that make up your task.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param containerDefinitions A list of container definitions in JSON format that describe the
     *         different containers that make up your task.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public TaskDefinition withContainerDefinitions(ContainerDefinition... containerDefinitions) {
        if (getContainerDefinitions() == null) setContainerDefinitions(new java.util.ArrayList<ContainerDefinition>(containerDefinitions.length));
        for (ContainerDefinition value : containerDefinitions) {
            getContainerDefinitions().add(value);
        }
        return this;
    }
    
    /**
     * A list of container definitions in JSON format that describe the
     * different containers that make up your task.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param containerDefinitions A list of container definitions in JSON format that describe the
     *         different containers that make up your task.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public TaskDefinition withContainerDefinitions(java.util.Collection<ContainerDefinition> containerDefinitions) {
        if (containerDefinitions == null) {
            this.containerDefinitions = null;
        } else {
            com.amazonaws.internal.ListWithAutoConstructFlag<ContainerDefinition> containerDefinitionsCopy = new com.amazonaws.internal.ListWithAutoConstructFlag<ContainerDefinition>(containerDefinitions.size());
            containerDefinitionsCopy.addAll(containerDefinitions);
            this.containerDefinitions = containerDefinitionsCopy;
        }

        return this;
    }

    /**
     * The family of your task definition. You can think of the
     * <code>family</code> as the name of your task definition.
     *
     * @return The family of your task definition. You can think of the
     *         <code>family</code> as the name of your task definition.
     */
    public String getFamily() {
        return family;
    }
    
    /**
     * The family of your task definition. You can think of the
     * <code>family</code> as the name of your task definition.
     *
     * @param family The family of your task definition. You can think of the
     *         <code>family</code> as the name of your task definition.
     */
    public void setFamily(String family) {
        this.family = family;
    }
    
    /**
     * The family of your task definition. You can think of the
     * <code>family</code> as the name of your task definition.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param family The family of your task definition. You can think of the
     *         <code>family</code> as the name of your task definition.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public TaskDefinition withFamily(String family) {
        this.family = family;
        return this;
    }

    /**
     * The revision of the task in a particular family. You can think of the
     * revision as a version number of a task definition in a family. When
     * you register a task definition for the first time, the revision is
     * <code>1</code>, and each time you register a task definition in the
     * same family, the revision value increases by one.
     *
     * @return The revision of the task in a particular family. You can think of the
     *         revision as a version number of a task definition in a family. When
     *         you register a task definition for the first time, the revision is
     *         <code>1</code>, and each time you register a task definition in the
     *         same family, the revision value increases by one.
     */
    public Integer getRevision() {
        return revision;
    }
    
    /**
     * The revision of the task in a particular family. You can think of the
     * revision as a version number of a task definition in a family. When
     * you register a task definition for the first time, the revision is
     * <code>1</code>, and each time you register a task definition in the
     * same family, the revision value increases by one.
     *
     * @param revision The revision of the task in a particular family. You can think of the
     *         revision as a version number of a task definition in a family. When
     *         you register a task definition for the first time, the revision is
     *         <code>1</code>, and each time you register a task definition in the
     *         same family, the revision value increases by one.
     */
    public void setRevision(Integer revision) {
        this.revision = revision;
    }
    
    /**
     * The revision of the task in a particular family. You can think of the
     * revision as a version number of a task definition in a family. When
     * you register a task definition for the first time, the revision is
     * <code>1</code>, and each time you register a task definition in the
     * same family, the revision value increases by one.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param revision The revision of the task in a particular family. You can think of the
     *         revision as a version number of a task definition in a family. When
     *         you register a task definition for the first time, the revision is
     *         <code>1</code>, and each time you register a task definition in the
     *         same family, the revision value increases by one.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public TaskDefinition withRevision(Integer revision) {
        this.revision = revision;
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
        if (getTaskDefinitionArn() != null) sb.append("TaskDefinitionArn: " + getTaskDefinitionArn() + ",");
        if (getContainerDefinitions() != null) sb.append("ContainerDefinitions: " + getContainerDefinitions() + ",");
        if (getFamily() != null) sb.append("Family: " + getFamily() + ",");
        if (getRevision() != null) sb.append("Revision: " + getRevision() );
        sb.append("}");
        return sb.toString();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;
        
        hashCode = prime * hashCode + ((getTaskDefinitionArn() == null) ? 0 : getTaskDefinitionArn().hashCode()); 
        hashCode = prime * hashCode + ((getContainerDefinitions() == null) ? 0 : getContainerDefinitions().hashCode()); 
        hashCode = prime * hashCode + ((getFamily() == null) ? 0 : getFamily().hashCode()); 
        hashCode = prime * hashCode + ((getRevision() == null) ? 0 : getRevision().hashCode()); 
        return hashCode;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (obj instanceof TaskDefinition == false) return false;
        TaskDefinition other = (TaskDefinition)obj;
        
        if (other.getTaskDefinitionArn() == null ^ this.getTaskDefinitionArn() == null) return false;
        if (other.getTaskDefinitionArn() != null && other.getTaskDefinitionArn().equals(this.getTaskDefinitionArn()) == false) return false; 
        if (other.getContainerDefinitions() == null ^ this.getContainerDefinitions() == null) return false;
        if (other.getContainerDefinitions() != null && other.getContainerDefinitions().equals(this.getContainerDefinitions()) == false) return false; 
        if (other.getFamily() == null ^ this.getFamily() == null) return false;
        if (other.getFamily() != null && other.getFamily().equals(this.getFamily()) == false) return false; 
        if (other.getRevision() == null ^ this.getRevision() == null) return false;
        if (other.getRevision() != null && other.getRevision().equals(this.getRevision()) == false) return false; 
        return true;
    }
    
}
    