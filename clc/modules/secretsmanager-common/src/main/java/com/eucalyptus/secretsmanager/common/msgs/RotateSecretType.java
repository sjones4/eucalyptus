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
public class RotateSecretType extends SecretsmanagerMessage {

  @FieldRange(min=32, max=64)
  private String clientRequestToken;
  @FieldRange(max=2048)
  private String rotationLambdaARN;
  private RotationRulesType rotationRules;
  @Nonnull
  @FieldRange(min=1, max=2048)
  private String secretId;

  public String getClientRequestToken( ) {
    return clientRequestToken;
  }

  public void setClientRequestToken( final String clientRequestToken ) {
    this.clientRequestToken = clientRequestToken;
  }

  public String getRotationLambdaARN( ) {
    return rotationLambdaARN;
  }

  public void setRotationLambdaARN( final String rotationLambdaARN ) {
    this.rotationLambdaARN = rotationLambdaARN;
  }

  public RotationRulesType getRotationRules( ) {
    return rotationRules;
  }

  public void setRotationRules( final RotationRulesType rotationRules ) {
    this.rotationRules = rotationRules;
  }

  public String getSecretId( ) {
    return secretId;
  }

  public void setSecretId( final String secretId ) {
    this.secretId = secretId;
  }

}
