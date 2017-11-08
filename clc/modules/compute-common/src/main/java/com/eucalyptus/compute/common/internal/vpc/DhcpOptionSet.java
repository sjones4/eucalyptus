/*************************************************************************
 * Copyright 2009-2014 Ent. Services Development Corporation LP
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
package com.eucalyptus.compute.common.internal.vpc;

import static com.eucalyptus.compute.common.CloudMetadata.DhcpOptionSetMetadata;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;
import com.eucalyptus.entities.AbstractOwnedPersistent;
import com.eucalyptus.auth.principal.OwnerFullName;
import com.eucalyptus.util.Strings;
import com.google.common.collect.Sets;

/**
 *
 */
@Entity
@PersistenceContext( name = "eucalyptus_cloud" )
@Table( name = "metadata_dhcp_option_sets", indexes = {
    @Index( name = "metadata_dhcp_option_sets_account_id_idx", columnList = "metadata_account_id" ),
    @Index( name = "metadata_dhcp_option_sets_display_name_idx", columnList = "metadata_display_name" ),
} )
public class DhcpOptionSet extends AbstractOwnedPersistent implements DhcpOptionSetMetadata {

  private static final long serialVersionUID = 1L;

  @Column( name = "metadata_default", nullable = false, updatable = false )
  private Boolean defaultOptions;

  @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "dhcpOptionSet" )
  private Set<DhcpOption> dhcpOptions = new HashSet<>( );

  @OneToMany( fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true, mappedBy = "dhcpOptionSet" )
  private Collection<DhcpOptionSetTag> tags;

  protected DhcpOptionSet( ) {
  }

  protected DhcpOptionSet( final OwnerFullName owner, final String displayName ) {
    super( owner, displayName );
  }

  public static DhcpOptionSet create( final OwnerFullName owner,
                                      final String name ) {
    final DhcpOptionSet dhcpOptionSet = new DhcpOptionSet( owner, name );
    dhcpOptionSet.setDefaultOptions( false );
    return dhcpOptionSet;
  }

  public static DhcpOptionSet createDefault( final OwnerFullName owner,
                                             final String name,
                                             final String instanceSubdomain ) {
    final DhcpOptionSet dhcpOptionSet = new DhcpOptionSet( owner, name );
    dhcpOptionSet.setDefaultOptions( true );
    dhcpOptionSet.setDhcpOptions( Sets.newHashSet(
        DhcpOption.create( dhcpOptionSet, "domain-name", Strings.trimPrefix( ".", instanceSubdomain + ".internal" ) ),
        DhcpOption.create( dhcpOptionSet, "domain-name-servers", "AmazonProvidedDNS" )
    ) );
    return dhcpOptionSet;
  }

  public static DhcpOptionSet exampleWithOwner( final OwnerFullName owner ) {
    return new DhcpOptionSet( owner, null );
  }

  public static DhcpOptionSet exampleWithName( final OwnerFullName owner, final String name ) {
    return new DhcpOptionSet( owner, name );
  }

  public static DhcpOptionSet exampleDefault( final OwnerFullName owner  ) {
    final DhcpOptionSet dhcpOptionSet = exampleWithOwner( owner );
    dhcpOptionSet.setDefaultOptions( true );
    return dhcpOptionSet;
  }

  public Boolean getDefaultOptions( ) {
    return defaultOptions;
  }

  public void setDefaultOptions( final Boolean defaultOptions ) {
    this.defaultOptions = defaultOptions;
  }

  public Set<DhcpOption> getDhcpOptions() {
    return dhcpOptions;
  }

  public void setDhcpOptions( final Set<DhcpOption> dhcpOptions ) {
    this.dhcpOptions = dhcpOptions;
  }
}
