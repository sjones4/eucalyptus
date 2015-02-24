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

import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;
import com.eucalyptus.auth.principal.AccountFullName;
import com.eucalyptus.component.annotation.ComponentNamed;
import com.eucalyptus.container.EcsMetadataException;
import com.eucalyptus.container.TaskDefinition;
import com.eucalyptus.container.TaskDefinitions;
import com.eucalyptus.container.common.EcsMetadata;
import com.eucalyptus.entities.Entities;
import com.eucalyptus.entities.TransactionResource;
import com.eucalyptus.util.OwnerFullName;

/**
 *
 */
@ComponentNamed
public class PersistenceTaskDefinitions extends EcsPersistenceSupport<EcsMetadata.TaskDefinitionMetadata,TaskDefinition> implements TaskDefinitions {

  public PersistenceTaskDefinitions( ) {
    super( "task-definition" );
  }

  @Override
  public Integer getNextRevision( final AccountFullName accountFullName,
                                  final String family ) throws EcsMetadataException {
    try ( final TransactionResource tx = Entities.transactionFor( TaskDefinition.class ) ) {
      final Number maxRevision = (Number) Entities.createCriteria( TaskDefinition.class )
          .add( Example.create( TaskDefinition.exampleWithFamily( accountFullName, family ) ) )
          .setProjection( Projections.max( "revision" ) )
          .uniqueResult( ) ;
      return maxRevision == null ?
          1 :
          maxRevision.intValue( ) + 1;
    } catch ( Exception e ) {
      throw new EcsMetadataException( "Error getting next revision for task definition family " + family, e );
    }
  }

  @Override
  protected TaskDefinition exampleWithOwner( final OwnerFullName ownerFullName ) {
    return TaskDefinition.exampleWithOwner( ownerFullName );
  }

  @Override
  protected TaskDefinition exampleWithName( final OwnerFullName ownerFullName, final String name ) {
    return TaskDefinition.exampleWithName( ownerFullName, name );
  }
}
