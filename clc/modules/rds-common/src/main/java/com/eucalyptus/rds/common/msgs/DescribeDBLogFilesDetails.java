/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;
import javax.annotation.Nonnull;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRange;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRegex;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRegexValue;


public class DescribeDBLogFilesDetails extends EucalyptusData {

  private Long lastWritten;
  private String logFileName;
  private Long size;

  public Long getLastWritten( ) {
    return lastWritten;
  }

  public void setLastWritten( final Long lastWritten ) {
    this.lastWritten = lastWritten;
  }

  public String getLogFileName( ) {
    return logFileName;
  }

  public void setLogFileName( final String logFileName ) {
    this.logFileName = logFileName;
  }

  public Long getSize( ) {
    return size;
  }

  public void setSize( final Long size ) {
    this.size = size;
  }

}
