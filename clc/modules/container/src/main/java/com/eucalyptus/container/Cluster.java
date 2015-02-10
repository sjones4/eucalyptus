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
package com.eucalyptus.container;

import static com.eucalyptus.container.common.ContainerMetadata.ClusterMetadata;
import javax.persistence.Entity;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import com.eucalyptus.entities.AbstractOwnedPersistent;
import com.eucalyptus.util.OwnerFullName;

/**
 *
 */
@Entity
@PersistenceContext( name = "eucalyptus_ecs" )
@Table( name = "ecs_cluster" )
@Cache( usage = CacheConcurrencyStrategy.TRANSACTIONAL )
public class Cluster extends AbstractOwnedPersistent implements ClusterMetadata {
  private static final long serialVersionUID = 1L;

  protected Cluster( ) {
  }

  protected Cluster( final OwnerFullName owner, final String displayName ) {
    super( owner, displayName );
  }

  public static Cluster create( final OwnerFullName owner, final String name ) {
    return new Cluster( owner, name );
  }

  public static Cluster exampleWithOwner( final OwnerFullName owner ) {
    return new Cluster( owner, null );
  }

  public static Cluster exampleWithName( final OwnerFullName owner, final String name ) {
    return new Cluster( owner, name );
  }

  @Override
  public String getArn( ) {
    return String.format(
        "arn:aws:ecs::%1s:cluster/%2s",
        getOwnerAccountNumber(),
        getDisplayName() );
  }
}
