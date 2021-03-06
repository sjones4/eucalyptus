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
package com.eucalyptus.compute.common;

import java.util.Objects;
import com.eucalyptus.util.CompatFunction;
import edu.ucsb.eucalyptus.msgs.EucalyptusData;

public class CreateVolumePermissionItemType extends EucalyptusData {

  private String userId;
  private String group;

  public CreateVolumePermissionItemType( ) {
  }

  public CreateVolumePermissionItemType( final String userId, final String group ) {
    this.userId = userId;
    this.group = group;
  }

  public static CreateVolumePermissionItemType newUserCreateVolumePermission( String userId ) {
    return new CreateVolumePermissionItemType( userId, null );
  }

  public static CreateVolumePermissionItemType newGroupCreateVolumePermission( ) {
    return new CreateVolumePermissionItemType( null, "all" );
  }

  public static CompatFunction<String, CreateVolumePermissionItemType> forUser( ) {
    return new CompatFunction<String, CreateVolumePermissionItemType>( ) {
      @Override
      public CreateVolumePermissionItemType apply( final String s ) {
        return new CreateVolumePermissionItemType( s, null );
      }
    };
  }

  public static CompatFunction<String, CreateVolumePermissionItemType> forGroup( ) {
    return new CompatFunction<String, CreateVolumePermissionItemType>( ) {
      @Override
      public CreateVolumePermissionItemType apply( final String s ) {
        return new CreateVolumePermissionItemType( null, s );
      }
    };
  }

  public boolean user( ) {
    return this.userId != null;
  }

  public boolean group( ) {
    return this.group != null;
  }

  @Override
  public boolean equals( final Object o ) {
    if ( this == o ) return true;
    if ( o == null || getClass( ) != o.getClass( ) ) return false;
    final CreateVolumePermissionItemType that = (CreateVolumePermissionItemType) o;
    return Objects.equals( getUserId( ), that.getUserId( ) ) &&
        Objects.equals( getGroup( ), that.getGroup( ) );
  }

  @Override
  public int hashCode( ) {
    return Objects.hash( getUserId( ), getGroup( ) );
  }

  public String getUserId( ) {
    return userId;
  }

  public void setUserId( String userId ) {
    this.userId = userId;
  }

  public String getGroup( ) {
    return group;
  }

  public void setGroup( String group ) {
    this.group = group;
  }
}
