/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudwatchlogs.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;
import javax.annotation.Nonnull;
import com.eucalyptus.cloudwatchlogs.common.CloudwatchlogsMessageValidation.FieldRange;
import com.eucalyptus.cloudwatchlogs.common.CloudwatchlogsMessageValidation.FieldRegex;
import com.eucalyptus.cloudwatchlogs.common.CloudwatchlogsMessageValidation.FieldRegexValue;


public class QueryInfo extends EucalyptusData {

  @FieldRange()
  private Long createTime;
  @FieldRange(min=1, max=512)
  private String logGroupName;
  @FieldRange(max=256)
  private String queryId;
  @FieldRange(max=10000)
  private String queryString;
  @FieldRegex(FieldRegexValue.ENUM_QUERYSTATUS)
  private String status;

  @com.fasterxml.jackson.annotation.JsonProperty("createTime")
  public Long getCreateTime( ) {
    return createTime;
  }

  public void setCreateTime( final Long createTime ) {
    this.createTime = createTime;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("logGroupName")
  public String getLogGroupName( ) {
    return logGroupName;
  }

  public void setLogGroupName( final String logGroupName ) {
    this.logGroupName = logGroupName;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("queryId")
  public String getQueryId( ) {
    return queryId;
  }

  public void setQueryId( final String queryId ) {
    this.queryId = queryId;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("queryString")
  public String getQueryString( ) {
    return queryString;
  }

  public void setQueryString( final String queryString ) {
    this.queryString = queryString;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("status")
  public String getStatus( ) {
    return status;
  }

  public void setStatus( final String status ) {
    this.status = status;
  }

}
