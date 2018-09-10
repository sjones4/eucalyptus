/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.secretsmanager.common.msgs;

import javax.annotation.Nonnull;
import com.eucalyptus.binding.HttpContent;
import com.eucalyptus.binding.HttpHeaderMapping;
import com.eucalyptus.binding.HttpNoContent;
import com.eucalyptus.secretsmanager.common.SecretsmanagerMessageValidation.FieldRange;
import com.eucalyptus.secretsmanager.common.SecretsmanagerMessageValidation.FieldRegex;
import com.eucalyptus.secretsmanager.common.SecretsmanagerMessageValidation.FieldRegexValue;



public class ListSecretVersionIdsResponseType extends SecretsmanagerMessage {


  @FieldRange(min=20, max=2048)
  private String aRN;
  @FieldRange(min=1, max=256)
  private String name;
  @FieldRange(min=1, max=4096)
  private String nextToken;
  private java.util.ArrayList<SecretVersionsListEntry> versions;

  public String getARN( ) {
    return aRN;
  }

  public void setARN( final String aRN ) {
    this.aRN = aRN;
  }

  public String getName( ) {
    return name;
  }

  public void setName( final String name ) {
    this.name = name;
  }

  public String getNextToken( ) {
    return nextToken;
  }

  public void setNextToken( final String nextToken ) {
    this.nextToken = nextToken;
  }

  public java.util.ArrayList<SecretVersionsListEntry> getVersions( ) {
    return versions;
  }

  public void setVersions( final java.util.ArrayList<SecretVersionsListEntry> versions ) {
    this.versions = versions;
  }

}
