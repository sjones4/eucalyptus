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
public class DeleteSecretType extends SecretsmanagerMessage {

  private Boolean forceDeleteWithoutRecovery;
  private Long recoveryWindowInDays;
  @Nonnull
  @FieldRange(min=1, max=2048)
  private String secretId;

  public Boolean getForceDeleteWithoutRecovery( ) {
    return forceDeleteWithoutRecovery;
  }

  public void setForceDeleteWithoutRecovery( final Boolean forceDeleteWithoutRecovery ) {
    this.forceDeleteWithoutRecovery = forceDeleteWithoutRecovery;
  }

  public Long getRecoveryWindowInDays( ) {
    return recoveryWindowInDays;
  }

  public void setRecoveryWindowInDays( final Long recoveryWindowInDays ) {
    this.recoveryWindowInDays = recoveryWindowInDays;
  }

  public String getSecretId( ) {
    return secretId;
  }

  public void setSecretId( final String secretId ) {
    this.secretId = secretId;
  }

}
