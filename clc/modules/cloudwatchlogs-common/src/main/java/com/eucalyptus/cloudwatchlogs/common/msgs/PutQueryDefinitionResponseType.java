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
import com.eucalyptus.binding.HttpHeaderMapping;
import com.eucalyptus.binding.HttpNoContent;
import com.eucalyptus.cloudwatchlogs.common.CloudwatchlogsMessageValidation.FieldRange;
import com.eucalyptus.cloudwatchlogs.common.CloudwatchlogsMessageValidation.FieldRegex;
import com.eucalyptus.cloudwatchlogs.common.CloudwatchlogsMessageValidation.FieldRegexValue;



public class PutQueryDefinitionResponseType extends CloudwatchlogsMessage {


  @FieldRange(max=256)
  private String queryDefinitionId;

  @com.fasterxml.jackson.annotation.JsonProperty("queryDefinitionId")
  public String getQueryDefinitionId( ) {
    return queryDefinitionId;
  }

  public void setQueryDefinitionId( final String queryDefinitionId ) {
    this.queryDefinitionId = queryDefinitionId;
  }

}
