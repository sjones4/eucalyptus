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



public class DescribeLogGroupsResponseType extends CloudwatchlogsMessage {


  private java.util.ArrayList<LogGroup> logGroups;
  @FieldRange(min=1)
  private String nextToken;

  @com.fasterxml.jackson.annotation.JsonProperty("logGroups")
  public java.util.ArrayList<LogGroup> getLogGroups( ) {
    return logGroups;
  }

  public void setLogGroups( final java.util.ArrayList<LogGroup> logGroups ) {
    this.logGroups = logGroups;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("nextToken")
  public String getNextToken( ) {
    return nextToken;
  }

  public void setNextToken( final String nextToken ) {
    this.nextToken = nextToken;
  }

}
