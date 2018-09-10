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
public class GetRandomPasswordType extends SecretsmanagerMessage {

  @FieldRange(max=4096)
  private String excludeCharacters;
  private Boolean excludeLowercase;
  private Boolean excludeNumbers;
  private Boolean excludePunctuation;
  private Boolean excludeUppercase;
  private Boolean includeSpace;
  @FieldRange(min=1, max=4096)
  private Long passwordLength;
  private Boolean requireEachIncludedType;

  public String getExcludeCharacters( ) {
    return excludeCharacters;
  }

  public void setExcludeCharacters( final String excludeCharacters ) {
    this.excludeCharacters = excludeCharacters;
  }

  public Boolean getExcludeLowercase( ) {
    return excludeLowercase;
  }

  public void setExcludeLowercase( final Boolean excludeLowercase ) {
    this.excludeLowercase = excludeLowercase;
  }

  public Boolean getExcludeNumbers( ) {
    return excludeNumbers;
  }

  public void setExcludeNumbers( final Boolean excludeNumbers ) {
    this.excludeNumbers = excludeNumbers;
  }

  public Boolean getExcludePunctuation( ) {
    return excludePunctuation;
  }

  public void setExcludePunctuation( final Boolean excludePunctuation ) {
    this.excludePunctuation = excludePunctuation;
  }

  public Boolean getExcludeUppercase( ) {
    return excludeUppercase;
  }

  public void setExcludeUppercase( final Boolean excludeUppercase ) {
    this.excludeUppercase = excludeUppercase;
  }

  public Boolean getIncludeSpace( ) {
    return includeSpace;
  }

  public void setIncludeSpace( final Boolean includeSpace ) {
    this.includeSpace = includeSpace;
  }

  public Long getPasswordLength( ) {
    return passwordLength;
  }

  public void setPasswordLength( final Long passwordLength ) {
    this.passwordLength = passwordLength;
  }

  public Boolean getRequireEachIncludedType( ) {
    return requireEachIncludedType;
  }

  public void setRequireEachIncludedType( final Boolean requireEachIncludedType ) {
    this.requireEachIncludedType = requireEachIncludedType;
  }

}
