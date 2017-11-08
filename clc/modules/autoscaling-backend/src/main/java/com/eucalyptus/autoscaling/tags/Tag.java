/*************************************************************************
 * Copyright 2009-2013 Ent. Services Development Corporation LP
 *
 * Redistribution and use of this software in source and binary forms,
 * with or without modification, are permitted provided that the
 * following conditions are met:
 *
 *   Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 *
 *   Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer
 *   in the documentation and/or other materials provided with the
 *   distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
 * FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
 * COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN
 * ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 ************************************************************************/
package com.eucalyptus.autoscaling.tags;

import static com.eucalyptus.autoscaling.common.AutoScalingMetadata.AutoScalingTagMetadata;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PersistenceContext;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.eucalyptus.entities.AbstractOwnedPersistent;
import com.eucalyptus.auth.principal.OwnerFullName;
import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Preconditions;

/**
 *
 */
@Entity
@PersistenceContext( name = "eucalyptus_autoscaling" )
@Table( name = "metadata_tags" )
@Inheritance( strategy = InheritanceType.JOINED )
@DiscriminatorColumn( name="metadata_tag_resource_type", discriminatorType = DiscriminatorType.STRING, length = 32) // ignored by Hibernate (for JOINED)
@AttributeOverride(name = "displayName", column = @Column(name = "metadata_display_name", updatable = false, nullable = false, length = 128))
public class Tag<T extends Tag<T>> extends AbstractOwnedPersistent implements AutoScalingTagMetadata {
  private static final long serialVersionUID = 1L;

  @SuppressWarnings( "FieldCanBeLocal" )
  @Column( name = "metadata_resource_id", nullable = false )
  private String resourceId;

  @Column( name = "metadata_tag_value", nullable = false, length = 256 )
  private String value;

  @Column( name = "metadata_propagate_at_launch", nullable = false )
  private Boolean propagateAtLaunch;

  @Transient
  @Nonnull
  private Function<? super T,String> resourceIdFunction = Functions.constant( null );

  @Transient
  @Nullable
  private String resourceType;

  protected Tag(  ) {
  }

  protected Tag( @Nullable final String resourceType,
                 @Nonnull final Function<? super T,String> resourceIdFunction ) {
    this.resourceType = resourceType;
    this.resourceIdFunction = resourceIdFunction;
  }

  public Tag( @Nullable final String resourceType,
              @Nonnull final Function<? super T,String> resourceIdFunction,
              @Nonnull final OwnerFullName ownerFullName,
              @Nullable final String key,
              @Nullable final String value,
              @Nullable final Boolean propagateAtLaunch ) {
    this( resourceType, resourceIdFunction );
    setOwner( ownerFullName );
    setDisplayName( key );
    setValue( value );
    setPropagateAtLaunch( propagateAtLaunch );
  }

  @Override
  protected String createUniqueName() {
    return getOwnerAccountNumber() + ":" + getResourceType() + ":" + getResourceId() + ":" + getKey();
  }

  public String getKey() {
    return getDisplayName();
  }

  public void setKey( final String key ) {
    setDisplayName( key );
  }

  public String getValue() {
    return value;
  }

  public void setValue( @Nullable final String value ) {
    this.value = value;
  }

  public Boolean getPropagateAtLaunch() {
    return propagateAtLaunch;
  }

  public void setPropagateAtLaunch( final Boolean propagateAtLaunch ) {
    this.propagateAtLaunch = propagateAtLaunch;
  }

  @Nullable
  public String getResourceId(){
    return resourceId != null ?
        resourceId :
        extractResourceId( );
  }

  @Nullable
  public String getResourceType(){
    return resourceType;
  }

  @SuppressWarnings( "unchecked" )
  public static Tag withOwner( @Nonnull final OwnerFullName ownerFullName ) {
    Preconditions.checkNotNull( ownerFullName, "ownerFullName" );
    return new Tag( null, Functions.constant( null ), ownerFullName, null, null, null );
  }

  /**
   * The resource ID can be set for query by example usage.
   */
  protected void setResourceId( final String resourceId ) {
    this.resourceId = resourceId;
  }

  @SuppressWarnings( "unchecked" )
  private String extractResourceId() {
    return resourceIdFunction.apply( (T) this );
  }

  @PrePersist
  @PreUpdate
  private void generatedFieldUpdate( ) {
    setResourceId( extractResourceId() );
  }
}

