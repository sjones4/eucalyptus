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


public class ExportTaskStatus extends EucalyptusData {

  @FieldRegex(FieldRegexValue.ENUM_EXPORTTASKSTATUSCODE)
  private String code;
  private String message;

  @com.fasterxml.jackson.annotation.JsonProperty("code")
  public String getCode( ) {
    return code;
  }

  public void setCode( final String code ) {
    this.code = code;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("message")
  public String getMessage( ) {
    return message;
  }

  public void setMessage( final String message ) {
    this.message = message;
  }

}
