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


public class PendingMaintenanceAction extends EucalyptusData {

  private String action;
  private java.util.Date autoAppliedAfterDate;
  private java.util.Date currentApplyDate;
  private String description;
  private java.util.Date forcedApplyDate;
  private String optInStatus;

  public String getAction( ) {
    return action;
  }

  public void setAction( final String action ) {
    this.action = action;
  }

  public java.util.Date getAutoAppliedAfterDate( ) {
    return autoAppliedAfterDate;
  }

  public void setAutoAppliedAfterDate( final java.util.Date autoAppliedAfterDate ) {
    this.autoAppliedAfterDate = autoAppliedAfterDate;
  }

  public java.util.Date getCurrentApplyDate( ) {
    return currentApplyDate;
  }

  public void setCurrentApplyDate( final java.util.Date currentApplyDate ) {
    this.currentApplyDate = currentApplyDate;
  }

  public String getDescription( ) {
    return description;
  }

  public void setDescription( final String description ) {
    this.description = description;
  }

  public java.util.Date getForcedApplyDate( ) {
    return forcedApplyDate;
  }

  public void setForcedApplyDate( final java.util.Date forcedApplyDate ) {
    this.forcedApplyDate = forcedApplyDate;
  }

  public String getOptInStatus( ) {
    return optInStatus;
  }

  public void setOptInStatus( final String optInStatus ) {
    this.optInStatus = optInStatus;
  }

}
