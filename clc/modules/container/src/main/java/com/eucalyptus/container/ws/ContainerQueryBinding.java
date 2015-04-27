/*************************************************************************
 * Copyright 2009-2015 Eucalyptus Systems, Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; version 3 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses/.
 *
 * Please contact Eucalyptus Systems, Inc., 6755 Hollister Ave., Goleta
 * CA 93117, USA or visit http://www.eucalyptus.com/licenses/ if you need
 * additional information or have any questions.
 ************************************************************************/
package com.eucalyptus.container.ws;

import com.eucalyptus.component.annotation.ComponentPart;
import com.eucalyptus.container.common.Container;
import com.eucalyptus.ws.protocol.BaseQueryBinding;
import com.eucalyptus.ws.protocol.OperationParameter;

/**
 *
 */
@ComponentPart( Container.class )
public class ContainerQueryBinding extends BaseQueryBinding<OperationParameter> {

  static final String CONTAINER_NAMESPACE_PATTERN = "http://ecs.amazonaws.com/doc/%s/";
  static final String CONTAINER_DEFAULT_VERSION = "2014-11-13";
  static final String CONTAINER_DEFAULT_NAMESPACE = String.format( CONTAINER_NAMESPACE_PATTERN, CONTAINER_DEFAULT_VERSION );

  public ContainerQueryBinding( ) {
    super( CONTAINER_NAMESPACE_PATTERN, CONTAINER_DEFAULT_VERSION, OperationParameter.Action, OperationParameter.Operation );
  }
}
