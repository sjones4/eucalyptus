/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRange;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRegex;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRegexValue;


public class DescribeDBLogFilesResult extends EucalyptusData {

  private DescribeDBLogFilesList describeDBLogFiles;
  private String marker;

  public DescribeDBLogFilesList getDescribeDBLogFiles( ) {
    return describeDBLogFiles;
  }

  public void setDescribeDBLogFiles( final DescribeDBLogFilesList describeDBLogFiles ) {
    this.describeDBLogFiles = describeDBLogFiles;
  }

  public String getMarker( ) {
    return marker;
  }

  public void setMarker( final String marker ) {
    this.marker = marker;
  }

}
