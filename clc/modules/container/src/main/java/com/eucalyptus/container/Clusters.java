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

import static com.eucalyptus.container.common.EcsMetadata.ClusterMetadata;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import org.hibernate.criterion.Criterion;
import com.eucalyptus.util.OwnerFullName;
import com.eucalyptus.util.TypeMapper;
import com.google.common.base.Function;
import com.google.common.base.Predicate;

/**
 *
 */
public interface Clusters {

  <T> T lookupByName( @Nullable final OwnerFullName ownerFullName,
                      String name,
                      Predicate<? super Cluster> filter,
                      Function<? super Cluster,T> transform ) throws EcsMetadataException;

  <T> List<T> list( OwnerFullName ownerFullName,
                    Criterion criterion,
                    Map<String,String> aliases,
                    Predicate<? super Cluster> filter,
                    Function<? super Cluster,T> transform ) throws EcsMetadataException;

  <T> T updateByExample( Cluster example,
                         OwnerFullName ownerFullName,
                         String activityId,
                         Function<? super Cluster,T> updateTransform ) throws EcsMetadataException;


  Cluster save( Cluster cluster ) throws EcsMetadataException;

  boolean delete( ClusterMetadata example ) throws EcsMetadataException;

  @TypeMapper
  public enum ClusterToClusterTransform implements Function<Cluster,com.eucalyptus.container.common.model.Cluster> {
    INSTANCE;

    @Nullable
    @Override
    public com.eucalyptus.container.common.model.Cluster apply( @Nullable final Cluster cluster ) {
      return cluster == null ?
          null :
          new com.eucalyptus.container.common.model.Cluster( )
              .withClusterName( cluster.getDisplayName( ) )
              .withClusterArn( cluster.getArn( ) )
              .withStatus( "ACTIVE" );
    }
  }
}
