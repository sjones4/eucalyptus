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


public class ExportTaskExecutionInfo extends EucalyptusData {

  @FieldRange()
  private Long completionTime;
  @FieldRange()
  private Long creationTime;

  @com.fasterxml.jackson.annotation.JsonProperty("completionTime")
  public Long getCompletionTime( ) {
    return completionTime;
  }

  public void setCompletionTime( final Long completionTime ) {
    this.completionTime = completionTime;
  }

  @com.fasterxml.jackson.annotation.JsonProperty("creationTime")
  public Long getCreationTime( ) {
    return creationTime;
  }

  public void setCreationTime( final Long creationTime ) {
    this.creationTime = creationTime;
  }

}
