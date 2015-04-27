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
package com.eucalyptus.container.persist;

import static com.eucalyptus.container.common.EcsMetadata.TaskMetadata;
import com.eucalyptus.component.annotation.ComponentNamed;
import com.eucalyptus.container.Task;
import com.eucalyptus.container.Tasks;
import com.eucalyptus.util.OwnerFullName;

/**
 *
 */
@ComponentNamed
public class PersistenceTasks extends EcsPersistenceSupport<TaskMetadata,Task> implements Tasks {

  public PersistenceTasks( ) {
    super( "task" );
  }

  @Override
  protected Task exampleWithOwner( final OwnerFullName ownerFullName ) {
    return Task.exampleWithOwner( ownerFullName );
  }

  @Override
  protected Task exampleWithName( final OwnerFullName ownerFullName, final String name ) {
    return Task.exampleWithName( ownerFullName, name );
  }
}
