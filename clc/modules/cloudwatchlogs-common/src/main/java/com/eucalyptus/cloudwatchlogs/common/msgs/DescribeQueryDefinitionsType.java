/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudwatchlogs.common.msgs;

import javax.annotation.Nonnull;
import com.eucalyptus.binding.HttpContent;
import com.eucalyptus.binding.HttpNoContent;
import com.eucalyptus.binding.HttpHeaderMapping;
import com.eucalyptus.binding.HttpParameterMapping;
import com.eucalyptus.binding.HttpRequestMapping;
import com.eucalyptus.binding.HttpUriMapping;
import com.eucalyptus.cloudwatchlogs.common.CloudwatchlogsMessageValidation.FieldRange;
import com.eucalyptus.cloudwatchlogs.common.CloudwatchlogsMessageValidation.FieldRegex;
import com.eucalyptus.cloudwatchlogs.common.CloudwatchlogsMessageValidation.FieldRegexValue;



@HttpRequestMapping(method="POST", uri="/")
public class DescribeQueryDefinitionsType extends CloudwatchlogsMessage {

  @FieldRange(min=1, max=1000)
  private Integer maxResults;
  @FieldRange(min=1)
  private String nextToken;
  @FieldRange(min=1, max=255)
  private String queryDefinitionNamePrefix;

  @com.fasterxml.jackson.annotation.JsonProperty("maxResults")
  public Integer getMaxResults( ) {
    return maxResults;
  }

  public void setMaxResults( final Integer maxResults ) {
    this.maxResults = maxResults;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("nextToken")
  public String getNextToken( ) {
    return nextToken;
  }

  public void setNextToken( final String nextToken ) {
    this.nextToken = nextToken;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("queryDefinitionNamePrefix")
  public String getQueryDefinitionNamePrefix( ) {
    return queryDefinitionNamePrefix;
  }

  public void setQueryDefinitionNamePrefix( final String queryDefinitionNamePrefix ) {
    this.queryDefinitionNamePrefix = queryDefinitionNamePrefix;
  }

}
