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


public class BacktrackDBClusterResult extends EucalyptusData {

  private String backtrackIdentifier;
  private java.util.Date backtrackRequestCreationTime;
  private java.util.Date backtrackTo;
  private java.util.Date backtrackedFrom;
  private String dBClusterIdentifier;
  private String status;

  public String getBacktrackIdentifier( ) {
    return backtrackIdentifier;
  }

  public void setBacktrackIdentifier( final String backtrackIdentifier ) {
    this.backtrackIdentifier = backtrackIdentifier;
  }

  public java.util.Date getBacktrackRequestCreationTime( ) {
    return backtrackRequestCreationTime;
  }

  public void setBacktrackRequestCreationTime( final java.util.Date backtrackRequestCreationTime ) {
    this.backtrackRequestCreationTime = backtrackRequestCreationTime;
  }

  public java.util.Date getBacktrackTo( ) {
    return backtrackTo;
  }

  public void setBacktrackTo( final java.util.Date backtrackTo ) {
    this.backtrackTo = backtrackTo;
  }

  public java.util.Date getBacktrackedFrom( ) {
    return backtrackedFrom;
  }

  public void setBacktrackedFrom( final java.util.Date backtrackedFrom ) {
    this.backtrackedFrom = backtrackedFrom;
  }

  public String getDBClusterIdentifier( ) {
    return dBClusterIdentifier;
  }

  public void setDBClusterIdentifier( final String dBClusterIdentifier ) {
    this.dBClusterIdentifier = dBClusterIdentifier;
  }

  public String getStatus( ) {
    return status;
  }

  public void setStatus( final String status ) {
    this.status = status;
  }

}
