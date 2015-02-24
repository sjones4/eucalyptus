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

import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import org.hibernate.criterion.Criterion;
import com.eucalyptus.util.OwnerFullName;
import com.eucalyptus.util.TypeMapper;
import com.eucalyptus.util.TypeMappers;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;

/**
 *
 */
public interface Tasks {

  <T> T lookupByName( @Nullable final OwnerFullName ownerFullName,
                      String name,
                      Predicate<? super Task> filter,
                      Function<? super Task,T> transform ) throws EcsMetadataException;

  <T> List<T> list( OwnerFullName ownerFullName,
                    Criterion criterion,
                    Map<String,String> aliases,
                    Predicate<? super Task> filter,
                    Function<? super Task,T> transform ) throws EcsMetadataException;

  Task save( Task task ) throws EcsMetadataException;


  <T> T updateByExample( Task example,
                         OwnerFullName ownerFullName,
                         String id,
                         Function<? super Task,T> updateTransform ) throws EcsMetadataException;

  @TypeMapper
  public enum TaskToTaskTransform implements Function<Task,com.eucalyptus.container.common.model.Task> {
    INSTANCE;

    @Nullable
    @Override
    public com.eucalyptus.container.common.model.Task apply( @Nullable final Task task ) {
      return task == null ?
          null :
          new com.eucalyptus.container.common.model.Task( )
            .withClusterArn( task.getClusterArn( ) )
            .withContainerInstanceArn( task.getContainerInstanceArn( ) )
            .withContainers( Collections2.transform(
                task.getContainers( ),
                TypeMappers.lookup( Container.class, com.eucalyptus.container.common.model.Container.class ) ) )
            .withDesiredStatus( task.getDesiredStatus( ) )
            .withLastStatus( task.getLastStatus( ) )
            //.withOverrides(  ) TODO:STEVE: overrides
            .withTaskArn( task.getArn( ) )
            .withTaskDefinitionArn( task.getTaskDefinitionArn( ) )
            .withStartedBy( task.getStartedBy( ) );
    }
  }

  @TypeMapper
  public enum ContainerToContainerTransform implements Function<Container,com.eucalyptus.container.common.model.Container> {
    INSTANCE;

    @Nullable
    @Override
    public com.eucalyptus.container.common.model.Container apply( @Nullable final Container container ) {
      return container == null ?
          null :
          new com.eucalyptus.container.common.model.Container( )
            .withName( container.getName( ) )
            .withContainerArn( container.getArn( ) )
            .withTaskArn( container.getTaskArn( ) )
            .withLastStatus( container.getLastStatus( ) )
            .withExitCode( container.getExitCode( ) )
            .withReason( container.getReason( ) )
            .withNetworkBindings( Collections2.transform(
              Objects.firstNonNull( container.getNetworkBindings( ), Collections.<NetworkBinding>emptySet( ) ),
              TypeMappers.lookup( NetworkBinding.class, com.eucalyptus.container.common.model.NetworkBinding.class ) ) );
    }
  }

  @TypeMapper
  public enum NetworkBindingModelToNetworkBindingTransform implements Function<com.eucalyptus.container.common.model.NetworkBinding,NetworkBinding> {
    INSTANCE;

    @Nullable
    @Override
    public NetworkBinding apply( @Nullable final com.eucalyptus.container.common.model.NetworkBinding networkBinding ) {
      return networkBinding == null ?
          null :
          new NetworkBinding(
              networkBinding.getBindIP( ),
              networkBinding.getContainerPort( ),
              networkBinding.getHostPort( )
          );
    }
  }

  @TypeMapper
  public enum NetworkBindingToNetworkBindingTransform implements Function<NetworkBinding,com.eucalyptus.container.common.model.NetworkBinding> {
    INSTANCE;

    @Nullable
    @Override
    public com.eucalyptus.container.common.model.NetworkBinding apply( @Nullable final NetworkBinding networkBinding ) {
      return networkBinding == null ?
          null :
          new com.eucalyptus.container.common.model.NetworkBinding( )
              .withBindIP( networkBinding.getBindAddress( ) )
              .withContainerPort( networkBinding.getContainerPort( ) )
              .withHostPort( networkBinding.getHostPort( ) );
    }
  }

  public enum TaskStringFunctions implements Function<Task,String> {
    CLUSTER {
      @Nullable
      @Override
      public String apply( @Nullable final Task task ) {
        return task == null ?
            null :
            task.getClusterName( );
      }
    },
    CONTAINER_INSTANCE {
      @Nullable
      @Override
      public String apply( @Nullable final Task task ) {
        return task == null ?
            null :
            task.getContainerInstanceName( );
      }
    },
    FAMILY {
      @Nullable
      @Override
      public String apply( @Nullable final Task task ) {
        return task == null ?
            null :
            task.getFamily( );
      }
    },
    STARTED_BY {
      @Nullable
      @Override
      public String apply( @Nullable final Task task ) {
        return task == null ?
            null :
            task.getStartedBy();
      }
    },
  }
}
