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


public class SearchedLogStream extends EucalyptusData {

  @FieldRange(min=1, max=512)
  private String logStreamName;
  private Boolean searchedCompletely;

  @com.fasterxml.jackson.annotation.JsonProperty("logStreamName")
  public String getLogStreamName( ) {
    return logStreamName;
  }

  public void setLogStreamName( final String logStreamName ) {
    this.logStreamName = logStreamName;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("searchedCompletely")
  public Boolean getSearchedCompletely( ) {
    return searchedCompletely;
  }

  public void setSearchedCompletely( final Boolean searchedCompletely ) {
    this.searchedCompletely = searchedCompletely;
  }

}
