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



public class GetQueryResultsResponseType extends CloudwatchlogsMessage {


  private java.util.ArrayList<java.util.ArrayList<ResultField>> results;
  private QueryStatistics statistics;
  @FieldRegex(FieldRegexValue.ENUM_QUERYSTATUS)
  private String status;

  @com.fasterxml.jackson.annotation.JsonProperty("results")
  public java.util.ArrayList<java.util.ArrayList<ResultField>> getResults( ) {
    return results;
  }

  public void setResults( final java.util.ArrayList<java.util.ArrayList<ResultField>> results ) {
    this.results = results;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("statistics")
  public QueryStatistics getStatistics( ) {
    return statistics;
  }

  public void setStatistics( final QueryStatistics statistics ) {
    this.statistics = statistics;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("status")
  public String getStatus( ) {
    return status;
  }

  public void setStatus( final String status ) {
    this.status = status;
  }

}
