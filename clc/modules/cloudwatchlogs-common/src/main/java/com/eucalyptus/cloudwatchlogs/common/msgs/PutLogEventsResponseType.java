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



public class PutLogEventsResponseType extends CloudwatchlogsMessage {


  @FieldRange(min=1)
  private String nextSequenceToken;
  private RejectedLogEventsInfo rejectedLogEventsInfo;

  @com.fasterxml.jackson.annotation.JsonProperty("nextSequenceToken")
  public String getNextSequenceToken( ) {
    return nextSequenceToken;
  }

  public void setNextSequenceToken( final String nextSequenceToken ) {
    this.nextSequenceToken = nextSequenceToken;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("rejectedLogEventsInfo")
  public RejectedLogEventsInfo getRejectedLogEventsInfo( ) {
    return rejectedLogEventsInfo;
  }

  public void setRejectedLogEventsInfo( final RejectedLogEventsInfo rejectedLogEventsInfo ) {
    this.rejectedLogEventsInfo = rejectedLogEventsInfo;
  }

}
