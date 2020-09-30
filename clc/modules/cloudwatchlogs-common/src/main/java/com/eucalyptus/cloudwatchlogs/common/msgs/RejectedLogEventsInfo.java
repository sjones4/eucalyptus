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


public class RejectedLogEventsInfo extends EucalyptusData {

  private Integer expiredLogEventEndIndex;
  private Integer tooNewLogEventStartIndex;
  private Integer tooOldLogEventEndIndex;

  @com.fasterxml.jackson.annotation.JsonProperty("expiredLogEventEndIndex")
  public Integer getExpiredLogEventEndIndex( ) {
    return expiredLogEventEndIndex;
  }

  public void setExpiredLogEventEndIndex( final Integer expiredLogEventEndIndex ) {
    this.expiredLogEventEndIndex = expiredLogEventEndIndex;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("tooNewLogEventStartIndex")
  public Integer getTooNewLogEventStartIndex( ) {
    return tooNewLogEventStartIndex;
  }

  public void setTooNewLogEventStartIndex( final Integer tooNewLogEventStartIndex ) {
    this.tooNewLogEventStartIndex = tooNewLogEventStartIndex;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("tooOldLogEventEndIndex")
  public Integer getTooOldLogEventEndIndex( ) {
    return tooOldLogEventEndIndex;
  }

  public void setTooOldLogEventEndIndex( final Integer tooOldLogEventEndIndex ) {
    this.tooOldLogEventEndIndex = tooOldLogEventEndIndex;
  }

}
