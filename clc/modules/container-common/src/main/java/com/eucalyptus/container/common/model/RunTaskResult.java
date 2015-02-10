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
public class RunTaskResult extends EcsMessage implements Serializable {

    /**
     * A full description of the tasks that were run. Each task that was
     * successfully placed on your cluster will be described here.
     */
    private com.amazonaws.internal.ListWithAutoConstructFlag<Task> tasks;

    /**
     * Any failed tasks from your <code>RunTask</code> action are listed
     * here.
     */
    private com.amazonaws.internal.ListWithAutoConstructFlag<Failure> failures;

    /**
     * A full description of the tasks that were run. Each task that was
     * successfully placed on your cluster will be described here.
     *
     * @return A full description of the tasks that were run. Each task that was
     *         successfully placed on your cluster will be described here.
     */
    public java.util.List<Task> getTasks() {
        if (tasks == null) {
              tasks = new com.amazonaws.internal.ListWithAutoConstructFlag<Task>();
              tasks.setAutoConstruct(true);
        }
        return tasks;
    }
    
    /**
     * A full description of the tasks that were run. Each task that was
     * successfully placed on your cluster will be described here.
     *
     * @param tasks A full description of the tasks that were run. Each task that was
     *         successfully placed on your cluster will be described here.
     */
    public void setTasks(java.util.Collection<Task> tasks) {
        if (tasks == null) {
            this.tasks = null;
            return;
        }
        com.amazonaws.internal.ListWithAutoConstructFlag<Task> tasksCopy = new com.amazonaws.internal.ListWithAutoConstructFlag<Task>(tasks.size());
        tasksCopy.addAll(tasks);
        this.tasks = tasksCopy;
    }
    
    /**
     * A full description of the tasks that were run. Each task that was
     * successfully placed on your cluster will be described here.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param tasks A full description of the tasks that were run. Each task that was
     *         successfully placed on your cluster will be described here.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public RunTaskResult withTasks(Task... tasks) {
        if (getTasks() == null) setTasks(new java.util.ArrayList<Task>(tasks.length));
        for (Task value : tasks) {
            getTasks().add(value);
        }
        return this;
    }
    
    /**
     * A full description of the tasks that were run. Each task that was
     * successfully placed on your cluster will be described here.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param tasks A full description of the tasks that were run. Each task that was
     *         successfully placed on your cluster will be described here.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public RunTaskResult withTasks(java.util.Collection<Task> tasks) {
        if (tasks == null) {
            this.tasks = null;
        } else {
            com.amazonaws.internal.ListWithAutoConstructFlag<Task> tasksCopy = new com.amazonaws.internal.ListWithAutoConstructFlag<Task>(tasks.size());
            tasksCopy.addAll(tasks);
            this.tasks = tasksCopy;
        }

        return this;
    }

    /**
     * Any failed tasks from your <code>RunTask</code> action are listed
     * here.
     *
     * @return Any failed tasks from your <code>RunTask</code> action are listed
     *         here.
     */
    public java.util.List<Failure> getFailures() {
        if (failures == null) {
              failures = new com.amazonaws.internal.ListWithAutoConstructFlag<Failure>();
              failures.setAutoConstruct(true);
        }
        return failures;
    }
    
    /**
     * Any failed tasks from your <code>RunTask</code> action are listed
     * here.
     *
     * @param failures Any failed tasks from your <code>RunTask</code> action are listed
     *         here.
     */
    public void setFailures(java.util.Collection<Failure> failures) {
        if (failures == null) {
            this.failures = null;
            return;
        }
        com.amazonaws.internal.ListWithAutoConstructFlag<Failure> failuresCopy = new com.amazonaws.internal.ListWithAutoConstructFlag<Failure>(failures.size());
        failuresCopy.addAll(failures);
        this.failures = failuresCopy;
    }
    
    /**
     * Any failed tasks from your <code>RunTask</code> action are listed
     * here.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param failures Any failed tasks from your <code>RunTask</code> action are listed
     *         here.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public RunTaskResult withFailures(Failure... failures) {
        if (getFailures() == null) setFailures(new java.util.ArrayList<Failure>(failures.length));
        for (Failure value : failures) {
            getFailures().add(value);
        }
        return this;
    }
    
    /**
     * Any failed tasks from your <code>RunTask</code> action are listed
     * here.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param failures Any failed tasks from your <code>RunTask</code> action are listed
     *         here.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public RunTaskResult withFailures(java.util.Collection<Failure> failures) {
        if (failures == null) {
            this.failures = null;
        } else {
            com.amazonaws.internal.ListWithAutoConstructFlag<Failure> failuresCopy = new com.amazonaws.internal.ListWithAutoConstructFlag<Failure>(failures.size());
            failuresCopy.addAll(failures);
            this.failures = failuresCopy;
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
        if (getTasks() != null) sb.append("Tasks: " + getTasks() + ",");
        if (getFailures() != null) sb.append("Failures: " + getFailures() );
        sb.append("}");
        return sb.toString();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;
        
        hashCode = prime * hashCode + ((getTasks() == null) ? 0 : getTasks().hashCode()); 
        hashCode = prime * hashCode + ((getFailures() == null) ? 0 : getFailures().hashCode()); 
        return hashCode;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (obj instanceof RunTaskResult == false) return false;
        RunTaskResult other = (RunTaskResult)obj;
        
        if (other.getTasks() == null ^ this.getTasks() == null) return false;
        if (other.getTasks() != null && other.getTasks().equals(this.getTasks()) == false) return false; 
        if (other.getFailures() == null ^ this.getFailures() == null) return false;
        if (other.getFailures() != null && other.getFailures().equals(this.getFailures()) == false) return false; 
        return true;
    }
    
}
    