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
public class UpdateSecretVersionStageType extends SecretsmanagerMessage {

  @FieldRange(min=32, max=64)
  private String moveToVersionId;
  @FieldRange(min=32, max=64)
  private String removeFromVersionId;
  @Nonnull
  @FieldRange(min=1, max=2048)
  private String secretId;
  @Nonnull
  @FieldRange(min=1, max=256)
  private String versionStage;

  public String getMoveToVersionId( ) {
    return moveToVersionId;
  }

  public void setMoveToVersionId( final String moveToVersionId ) {
    this.moveToVersionId = moveToVersionId;
  }

  public String getRemoveFromVersionId( ) {
    return removeFromVersionId;
  }

  public void setRemoveFromVersionId( final String removeFromVersionId ) {
    this.removeFromVersionId = removeFromVersionId;
  }

  public String getSecretId( ) {
    return secretId;
  }

  public void setSecretId( final String secretId ) {
    this.secretId = secretId;
  }

  public String getVersionStage( ) {
    return versionStage;
  }

  public void setVersionStage( final String versionStage ) {
    this.versionStage = versionStage;
  }

}
