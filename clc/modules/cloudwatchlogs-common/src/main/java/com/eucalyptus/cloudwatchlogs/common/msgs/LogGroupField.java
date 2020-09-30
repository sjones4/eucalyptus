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


public class LogGroupField extends EucalyptusData {

  private String name;
  @FieldRange(max=100)
  private Integer percent;

  @com.fasterxml.jackson.annotation.JsonProperty("name")
  public String getName( ) {
    return name;
  }

  public void setName( final String name ) {
    this.name = name;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("percent")
  public Integer getPercent( ) {
    return percent;
  }

  public void setPercent( final Integer percent ) {
    this.percent = percent;
  }

}
