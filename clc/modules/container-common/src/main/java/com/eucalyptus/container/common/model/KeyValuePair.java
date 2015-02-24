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
import javax.annotation.Nullable;
import com.google.common.base.Function;

/**
 * 
 */
public class KeyValuePair implements Serializable {

    /**
     * The name of the key value pair.
     */
    private String name;

    /**
     * The value of the key value pair.
     */
    private String value;

    /**
     * The name of the key value pair.
     *
     * @return The name of the key value pair.
     */
    public String getName() {
        return name;
    }
    
    /**
     * The name of the key value pair.
     *
     * @param name The name of the key value pair.
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * The name of the key value pair.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param name The name of the key value pair.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public KeyValuePair withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * The value of the key value pair.
     *
     * @return The value of the key value pair.
     */
    public String getValue() {
        return value;
    }
    
    /**
     * The value of the key value pair.
     *
     * @param value The value of the key value pair.
     */
    public void setValue(String value) {
        this.value = value;
    }
    
    /**
     * The value of the key value pair.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param value The value of the key value pair.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public KeyValuePair withValue(String value) {
        this.value = value;
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
        if (getName() != null) sb.append("Name: " + getName() + ",");
        if (getValue() != null) sb.append("Value: " + getValue() );
        sb.append("}");
        return sb.toString();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;
        
        hashCode = prime * hashCode + ((getName() == null) ? 0 : getName().hashCode()); 
        hashCode = prime * hashCode + ((getValue() == null) ? 0 : getValue().hashCode()); 
        return hashCode;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (obj instanceof KeyValuePair == false) return false;
        KeyValuePair other = (KeyValuePair)obj;
        
        if (other.getName() == null ^ this.getName() == null) return false;
        if (other.getName() != null && other.getName().equals(this.getName()) == false) return false; 
        if (other.getValue() == null ^ this.getValue() == null) return false;
        if (other.getValue() != null && other.getValue().equals(this.getValue()) == false) return false; 
        return true;
    }

    public static Function<KeyValuePair,String> name( ) {
      return StringPropertyFunctions.NAME;
    }

    public static Function<KeyValuePair,String> value( ) {
      return StringPropertyFunctions.VALUE;
    }

    private enum StringPropertyFunctions implements Function<KeyValuePair,String> {
      NAME {
        @Nullable
        @Override
        public String apply( @Nullable final KeyValuePair keyValuePair ) {
          return keyValuePair == null ? null : keyValuePair.getName( );
        }
      },
      VALUE {
        @Nullable
        @Override
        public String apply( @Nullable final KeyValuePair keyValuePair ) {
          return keyValuePair == null ? null : keyValuePair.getValue( );
        }
      },
    }
}
    