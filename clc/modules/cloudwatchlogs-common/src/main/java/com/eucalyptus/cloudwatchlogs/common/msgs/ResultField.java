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


public class ResultField extends EucalyptusData {

  private String field;
  private String value;

  @com.fasterxml.jackson.annotation.JsonProperty("field")
  public String getField( ) {
    return field;
  }

  public void setField( final String field ) {
    this.field = field;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("value")
  public String getValue( ) {
    return value;
  }

  public void setValue( final String value ) {
    this.value = value;
  }

}
