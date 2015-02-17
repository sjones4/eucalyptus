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

import static com.eucalyptus.container.common.ContainerMetadata.ContainerInstanceMetadata;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import org.hibernate.criterion.Criterion;
import com.eucalyptus.container.common.model.Resource;
import com.eucalyptus.util.OwnerFullName;
import com.eucalyptus.util.TypeMapper;
import com.eucalyptus.util.TypeMappers;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.FluentIterable;

/**
 *
 */
public interface ContainerInstances {

  <T> T lookupByName( @Nullable final OwnerFullName ownerFullName,
                      String name,
                      Predicate<? super ContainerInstance> filter,
                      Function<? super ContainerInstance,T> transform ) throws EcsMetadataException;

  <T> List<T> list( OwnerFullName ownerFullName,
                    Criterion criterion,
                    Map<String,String> aliases,
                    Predicate<? super ContainerInstance> filter,
                    Function<? super ContainerInstance,T> transform ) throws EcsMetadataException;

  boolean delete( ContainerInstanceMetadata containerInstanceMetadata ) throws EcsMetadataException;

  ContainerInstance save( ContainerInstance containerInstance ) throws EcsMetadataException;

  @TypeMapper
  public enum ContainerInstanceToContainerInstanceTransform implements Function<ContainerInstance,com.eucalyptus.container.common.model.ContainerInstance> {
    INSTANCE;

    @Nullable
    @Override
    public com.eucalyptus.container.common.model.ContainerInstance apply( @Nullable final ContainerInstance containerInstance ) {
      return containerInstance == null ?
          null :
          new com.eucalyptus.container.common.model.ContainerInstance( )
              .withAgentConnected( containerInstance.getAgentConnected( ) )
              .withContainerInstanceArn( containerInstance.getArn( ) )
              .withEc2InstanceId( containerInstance.getEc2InstanceId( ) )
              .withRegisteredResources( FluentIterable.from( containerInstance.getContainerResources( ) )
                  .filter( ResourcePredicates.REGISTERED )
                  .transform( TypeMappers.lookup( ContainerResource.class, Resource.class ) ).toList( ) )
              .withRemainingResources( FluentIterable.from( containerInstance.getContainerResources( ) )
                  .filter( Predicates.not( ResourcePredicates.REGISTERED ) )
                  .transform( TypeMappers.lookup( ContainerResource.class, Resource.class ) ).toList( ) )
              .withStatus( containerInstance.getState( ).name( ) )
          ;
    }
  }

  @TypeMapper
  public enum ContainerResourceToResource implements Function<ContainerResource,Resource> {
    INSTANCE;

    @Nullable
    @Override
    public Resource apply( @Nullable final ContainerResource containerResource ) {
      return containerResource == null ?
          null :
          new Resource( )
            .withName( containerResource.getName( ) )
          .withType( containerResource.getType( ).name( ) )
          .withDoubleValue( containerResource.getDoubleValue( ) )
          .withIntegerValue( containerResource.getIntegerValue( ) )
          .withLongValue( containerResource.getLongValue( ) )
          .withStringSetValue( containerResource.getStringSetValue( ) );
    }
  }

  @TypeMapper
  public enum ResourceToContainerResource implements Function<Resource,ContainerResource> {
    INSTANCE;

    @Nullable
    @Override
    public ContainerResource apply( @Nullable final Resource resource ) {
      if ( resource == null ) return null;
      final ContainerResource containerResource = new ContainerResource( );
      containerResource.setName( resource.getName( ) );
      containerResource.setType( ContainerResource.Type.valueOf( resource.getType() ) );
      containerResource.setDoubleValue( resource.getDoubleValue() );
      containerResource.setIntegerValue( resource.getIntegerValue() );
      containerResource.setLongValue( resource.getLongValue() );
      containerResource.setStringSetValue( resource.getStringSetValue() );
      containerResource.setRegistered( false );
      return containerResource;
    }
  }

  public enum ContainerInstanceStringFunctions implements Function<ContainerInstance,String> {
    CLUSTER {
      @Nullable
      @Override
      public String apply( @Nullable final ContainerInstance containerInstance ) {
        return containerInstance == null ?
            null :
            containerInstance.getClusterName( );
      }
    }
  }

  public enum ResourcePredicates implements Predicate<ContainerResource> {
    REGISTERED {
      @Override
      public boolean apply( @Nullable final ContainerResource containerResource ) {
        return containerResource != null && containerResource.getRegistered( );
      }
    }
  }
}
