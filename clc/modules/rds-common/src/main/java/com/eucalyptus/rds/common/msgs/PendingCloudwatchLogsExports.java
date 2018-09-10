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


public class PendingCloudwatchLogsExports extends EucalyptusData {

  private LogTypeList logTypesToDisable;
  private LogTypeList logTypesToEnable;

  public LogTypeList getLogTypesToDisable( ) {
    return logTypesToDisable;
  }

  public void setLogTypesToDisable( final LogTypeList logTypesToDisable ) {
    this.logTypesToDisable = logTypesToDisable;
  }

  public LogTypeList getLogTypesToEnable( ) {
    return logTypesToEnable;
  }

  public void setLogTypesToEnable( final LogTypeList logTypesToEnable ) {
    this.logTypesToEnable = logTypesToEnable;
  }

}
