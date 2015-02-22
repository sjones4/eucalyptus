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
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import com.eucalyptus.component.ComponentIds;
import com.eucalyptus.container.common.Container;
import com.eucalyptus.container.common.EcsMetadata;
import com.eucalyptus.entities.AccountMetadata;
import com.eucalyptus.util.FullName;
import com.eucalyptus.util.OwnerFullName;
import com.google.common.collect.Lists;

/**
 *
 */
@Entity
@PersistenceContext( name = "eucalyptus_ecs" )
@Table( name = "ecs_container_instance" )
@Cache( usage = CacheConcurrencyStrategy.TRANSACTIONAL )
public class ContainerInstance extends AccountMetadata<ContainerInstance.State> implements EcsMetadata.ContainerInstanceMetadata {
  private static final long serialVersionUID = 1L;

  @Column( name = "cluster_name", nullable = false, updatable = false )
  private String clusterName;

  @ManyToOne
  @JoinColumn( name = "cluster_id", nullable = false, updatable = false )
  @Cache( usage = CacheConcurrencyStrategy.TRANSACTIONAL )
  private Cluster cluster;

  @Column( name = "ec2_instance_id", nullable = false, updatable = false )
  private String ec2InstanceId;  //TODO:STEVE: should be unique

  @Column( name = "agent_connected", nullable = false )
  private Boolean agentConnected;

  @OneToMany( cascade = { CascadeType.ALL }, mappedBy = "containerInstance" )
  private List<ContainerResource> containerResources = Lists.newArrayList( );

  public enum State {
    ACTIVE,
    INACTIVE,
    ;
  }

  protected ContainerInstance( ) {
  }

  public ContainerInstance( final OwnerFullName owner, final String displayName ) {
    super( owner, displayName );
  }

  public static ContainerInstance create( final OwnerFullName owner,
                                          final Cluster cluster,
                                          final String ec2InstanceId,
                                          final List<ContainerResource> resources ) {
    final String name = UUID.randomUUID( ).toString( );
    final ContainerInstance containerInstance = new ContainerInstance( owner, name );
    containerInstance.setNaturalId( name );
    containerInstance.setCluster(  cluster  );
    containerInstance.setClusterName( cluster.getDisplayName() );
    containerInstance.setEc2InstanceId( ec2InstanceId );
    containerInstance.setAgentConnected( false );
    containerInstance.setState( State.INACTIVE );
    containerInstance.setContainerResources( resources );
    for ( final ContainerResource resource : resources ) {
      resource.setContainerInstance( containerInstance );
    }
    return containerInstance;
  }

  public static ContainerInstance exampleWithOwner( final OwnerFullName owner ) {
    return new ContainerInstance( owner, null );
  }

  public static ContainerInstance exampleWithName( final OwnerFullName owner, final String name ) {
    return new ContainerInstance( owner, name );
  }

  @Override
  public String getPartition( ) {
    return "eucalyptus";
  }

  @Override
  public FullName getFullName( ) {
    return FullName.create.vendor( "euca" )
        .region( ComponentIds.lookup( Container.class ).name( ) )
        .namespace( this.getOwnerAccountNumber( ) )
        .relativeId(
            "cluster", getClusterName( ),
            "uuid", getNaturalId()
        );
  }

  @Override
  public String getArn( ) {
    return String.format(
        "arn:aws:ecs::%s:container-instance/%s",
        getOwnerAccountNumber( ),
        getNaturalId( ) );
  }

  public String getClusterName( ) {
    return clusterName;
  }

  public void setClusterName( final String clusterName ) {
    this.clusterName = clusterName;
  }

  public Cluster getCluster( ) {
    return cluster;
  }

  public void setCluster( final Cluster cluster ) {
    this.cluster = cluster;
  }

  public String getEc2InstanceId( ) {
    return ec2InstanceId;
  }

  public void setEc2InstanceId( final String ec2InstanceId ) {
    this.ec2InstanceId = ec2InstanceId;
  }

  public Boolean getAgentConnected( ) {
    return agentConnected;
  }

  public void setAgentConnected( final Boolean agentConnected ) {
    this.agentConnected = agentConnected;
  }

  public List<ContainerResource> getContainerResources( ) {
    return containerResources;
  }

  public void setContainerResources( final List<ContainerResource> containerResources ) {
    this.containerResources = containerResources;
  }
}
