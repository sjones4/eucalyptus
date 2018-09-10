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


public class CloudwatchLogsExportConfiguration extends EucalyptusData {

  private LogTypeList disableLogTypes;
  private LogTypeList enableLogTypes;

  public LogTypeList getDisableLogTypes( ) {
    return disableLogTypes;
  }

  public void setDisableLogTypes( final LogTypeList disableLogTypes ) {
    this.disableLogTypes = disableLogTypes;
  }

  public LogTypeList getEnableLogTypes( ) {
    return enableLogTypes;
  }

  public void setEnableLogTypes( final LogTypeList enableLogTypes ) {
    this.enableLogTypes = enableLogTypes;
  }

}
