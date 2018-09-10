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
public class GetSecretValueType extends SecretsmanagerMessage {

  @Nonnull
  @FieldRange(min=1, max=2048)
  private String secretId;
  @FieldRange(min=32, max=64)
  private String versionId;
  @FieldRange(min=1, max=256)
  private String versionStage;

  public String getSecretId( ) {
    return secretId;
  }

  public void setSecretId( final String secretId ) {
    this.secretId = secretId;
  }

  public String getVersionId( ) {
    return versionId;
  }

  public void setVersionId( final String versionId ) {
    this.versionId = versionId;
  }

  public String getVersionStage( ) {
    return versionStage;
  }

  public void setVersionStage( final String versionStage ) {
    this.versionStage = versionStage;
  }

}
