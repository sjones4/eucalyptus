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


public class QueryStatistics extends EucalyptusData {

  private Double bytesScanned;
  private Double recordsMatched;
  private Double recordsScanned;

  @com.fasterxml.jackson.annotation.JsonProperty("bytesScanned")
  public Double getBytesScanned( ) {
    return bytesScanned;
  }

  public void setBytesScanned( final Double bytesScanned ) {
    this.bytesScanned = bytesScanned;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("recordsMatched")
  public Double getRecordsMatched( ) {
    return recordsMatched;
  }

  public void setRecordsMatched( final Double recordsMatched ) {
    this.recordsMatched = recordsMatched;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("recordsScanned")
  public Double getRecordsScanned( ) {
    return recordsScanned;
  }

  public void setRecordsScanned( final Double recordsScanned ) {
    this.recordsScanned = recordsScanned;
  }

}
