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
import com.eucalyptus.binding.HttpNoContent;
import com.eucalyptus.binding.HttpHeaderMapping;
import com.eucalyptus.binding.HttpParameterMapping;
import com.eucalyptus.binding.HttpRequestMapping;
import com.eucalyptus.binding.HttpUriMapping;
import com.eucalyptus.secretsmanager.common.SecretsmanagerMessageValidation.FieldRange;
import com.eucalyptus.secretsmanager.common.SecretsmanagerMessageValidation.FieldRegex;
import com.eucalyptus.secretsmanager.common.SecretsmanagerMessageValidation.FieldRegexValue;



@HttpRequestMapping(method="POST", uri="/")
public class PutSecretValueType extends SecretsmanagerMessage {

  @FieldRange(min=32, max=64)
  private String clientRequestToken;
  @FieldRange(max=4096)
  private java.lang.String secretBinary;
  @Nonnull
  @FieldRange(min=1, max=2048)
  private String secretId;
  @FieldRange(max=4096)
  private String secretString;
  @FieldRange(min=1, max=20)
  private java.util.ArrayList<String> versionStages;

  public String getClientRequestToken( ) {
    return clientRequestToken;
  }

  public void setClientRequestToken( final String clientRequestToken ) {
    this.clientRequestToken = clientRequestToken;
  }

  public java.lang.String getSecretBinary( ) {
    return secretBinary;
  }

  public void setSecretBinary( final java.lang.String secretBinary ) {
    this.secretBinary = secretBinary;
  }

  public String getSecretId( ) {
    return secretId;
  }

  public void setSecretId( final String secretId ) {
    this.secretId = secretId;
  }

  public String getSecretString( ) {
    return secretString;
  }

  public void setSecretString( final String secretString ) {
    this.secretString = secretString;
  }

  public java.util.ArrayList<String> getVersionStages( ) {
    return versionStages;
  }

  public void setVersionStages( final java.util.ArrayList<String> versionStages ) {
    this.versionStages = versionStages;
  }

}
