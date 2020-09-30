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


public class MetricFilterMatchRecord extends EucalyptusData {

  @FieldRange(min=1)
  private String eventMessage;
  private Long eventNumber;
  private ExtractedValues extractedValues;

  @com.fasterxml.jackson.annotation.JsonProperty("eventMessage")
  public String getEventMessage( ) {
    return eventMessage;
  }

  public void setEventMessage( final String eventMessage ) {
    this.eventMessage = eventMessage;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("eventNumber")
  public Long getEventNumber( ) {
    return eventNumber;
  }

  public void setEventNumber( final Long eventNumber ) {
    this.eventNumber = eventNumber;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("extractedValues")
  public ExtractedValues getExtractedValues( ) {
    return extractedValues;
  }

  public void setExtractedValues( final ExtractedValues extractedValues ) {
    this.extractedValues = extractedValues;
  }

}
