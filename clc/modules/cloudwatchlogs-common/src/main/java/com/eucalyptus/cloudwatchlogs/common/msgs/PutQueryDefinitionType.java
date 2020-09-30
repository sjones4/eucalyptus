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
public class PutQueryDefinitionType extends CloudwatchlogsMessage {

  private java.util.ArrayList<String> logGroupNames;
  @Nonnull
  @FieldRange(min=1, max=255)
  private String name;
  @FieldRange(max=256)
  private String queryDefinitionId;
  @Nonnull
  @FieldRange(min=1, max=10000)
  private String queryString;

  @com.fasterxml.jackson.annotation.JsonProperty("logGroupNames")
  public java.util.ArrayList<String> getLogGroupNames( ) {
    return logGroupNames;
  }

  public void setLogGroupNames( final java.util.ArrayList<String> logGroupNames ) {
    this.logGroupNames = logGroupNames;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("name")
  public String getName( ) {
    return name;
  }

  public void setName( final String name ) {
    this.name = name;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("queryDefinitionId")
  public String getQueryDefinitionId( ) {
    return queryDefinitionId;
  }

  public void setQueryDefinitionId( final String queryDefinitionId ) {
    this.queryDefinitionId = queryDefinitionId;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("queryString")
  public String getQueryString( ) {
    return queryString;
  }

  public void setQueryString( final String queryString ) {
    this.queryString = queryString;
  }

}
