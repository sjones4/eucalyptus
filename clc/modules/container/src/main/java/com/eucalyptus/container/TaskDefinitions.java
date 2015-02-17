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

import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import org.hibernate.criterion.Criterion;
import com.eucalyptus.util.OwnerFullName;
import com.eucalyptus.util.TypeMapper;
import com.eucalyptus.util.TypeMappers;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;

/**
 *
 */
public interface TaskDefinitions {

  <T> T lookupByName( @Nullable final OwnerFullName ownerFullName,
                      String name,
                      Predicate<? super TaskDefinition> filter,
                      Function<? super TaskDefinition,T> transform ) throws EcsMetadataException;

  <T> List<T> list( OwnerFullName ownerFullName,
                    Criterion criterion,
                    Map<String,String> aliases,
                    Predicate<? super TaskDefinition> filter,
                    Function<? super TaskDefinition,T> transform ) throws EcsMetadataException;

  TaskDefinition save( TaskDefinition taskDefinition ) throws EcsMetadataException;

  @TypeMapper
  public enum TaskDefinitionToTaskDefinitionTransform implements Function<TaskDefinition,com.eucalyptus.container.common.model.TaskDefinition> {
    INSTANCE;

    @Nullable
    @Override
    public com.eucalyptus.container.common.model.TaskDefinition apply( @Nullable final TaskDefinition taskDefinition ) {
      return taskDefinition == null ?
          null :
          new com.eucalyptus.container.common.model.TaskDefinition( )
              .withFamily( taskDefinition.getFamily( ) )
              .withRevision( taskDefinition.getRevision( ) )
              .withContainerDefinitions( Collections2.transform(
                  taskDefinition.getContainerDefinitions( ),
                  TypeMappers.lookup( ContainerDefinition.class, com.eucalyptus.container.common.model.ContainerDefinition.class ) ) );
    }
  }

  @TypeMapper
  public enum ContainerDefinitionToContainerDefinitionTransform implements Function<ContainerDefinition,com.eucalyptus.container.common.model.ContainerDefinition> {
    INSTANCE;

    @Nullable
    @Override
    public com.eucalyptus.container.common.model.ContainerDefinition apply( @Nullable final ContainerDefinition containerDefinition ) {
      return containerDefinition == null ?
          null :
          new com.eucalyptus.container.common.model.ContainerDefinition( )
              .withCommand( containerDefinition.getCommands( ) )
              .withCpu( containerDefinition.getCpu( ) )
              .withEntryPoint( containerDefinition.getEntryPoints( ) )
              .withEssential( containerDefinition.getEssential( ) )
              .withImage( containerDefinition.getImage( ) )
              .withLinks( containerDefinition.getLinks( ) )
              .withMemory( containerDefinition.getMemory( ) )
              .withName( containerDefinition.getName( ) );
    }
  }

  @TypeMapper
  public enum ContainerDefinitionToContainerDefinitionReverseTransform implements Function<com.eucalyptus.container.common.model.ContainerDefinition,ContainerDefinition> {
    INSTANCE;

    @Nullable
    @Override
    public ContainerDefinition apply( @Nullable final com.eucalyptus.container.common.model.ContainerDefinition containerDefinition ) {
      return containerDefinition == null ?
          null :
          new ContainerDefinition(
              containerDefinition.getCommand( ),
              containerDefinition.getCpu( ),
              containerDefinition.getEntryPoint( ),
              containerDefinition.getEssential( ),
              containerDefinition.getImage( ),
              containerDefinition.getLinks( ),
              containerDefinition.getMemory( ),
              containerDefinition.getName( )
          );
    }
  }

  public enum TaskDefinitionStringFunctions implements Function<TaskDefinition,String> {
    FAMILY {
      @Nullable
      @Override
      public String apply( @Nullable final TaskDefinition taskDefinition ) {
        return taskDefinition == null ?
            null :
            taskDefinition.getFamily( );
      }
    }
  }
}
