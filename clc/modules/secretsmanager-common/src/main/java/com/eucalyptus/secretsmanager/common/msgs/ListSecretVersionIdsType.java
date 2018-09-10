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
public class ListSecretVersionIdsType extends SecretsmanagerMessage {

  private Boolean includeDeprecated;
  @FieldRange(min=1, max=100)
  private Integer maxResults;
  @FieldRange(min=1, max=4096)
  private String nextToken;
  @Nonnull
  @FieldRange(min=1, max=2048)
  private String secretId;

  public Boolean getIncludeDeprecated( ) {
    return includeDeprecated;
  }

  public void setIncludeDeprecated( final Boolean includeDeprecated ) {
    this.includeDeprecated = includeDeprecated;
  }

  public Integer getMaxResults( ) {
    return maxResults;
  }

  public void setMaxResults( final Integer maxResults ) {
    this.maxResults = maxResults;
  }

  public String getNextToken( ) {
    return nextToken;
  }

  public void setNextToken( final String nextToken ) {
    this.nextToken = nextToken;
  }

  public String getSecretId( ) {
    return secretId;
  }

  public void setSecretId( final String secretId ) {
    this.secretId = secretId;
  }

}
