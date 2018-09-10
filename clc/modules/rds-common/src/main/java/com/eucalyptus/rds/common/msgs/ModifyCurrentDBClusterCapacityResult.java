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


public class ModifyCurrentDBClusterCapacityResult extends EucalyptusData {

  private Integer currentCapacity;
  private String dBClusterIdentifier;
  private Integer pendingCapacity;
  private Integer secondsBeforeTimeout;
  private String timeoutAction;

  public Integer getCurrentCapacity( ) {
    return currentCapacity;
  }

  public void setCurrentCapacity( final Integer currentCapacity ) {
    this.currentCapacity = currentCapacity;
  }

  public String getDBClusterIdentifier( ) {
    return dBClusterIdentifier;
  }

  public void setDBClusterIdentifier( final String dBClusterIdentifier ) {
    this.dBClusterIdentifier = dBClusterIdentifier;
  }

  public Integer getPendingCapacity( ) {
    return pendingCapacity;
  }

  public void setPendingCapacity( final Integer pendingCapacity ) {
    this.pendingCapacity = pendingCapacity;
  }

  public Integer getSecondsBeforeTimeout( ) {
    return secondsBeforeTimeout;
  }

  public void setSecondsBeforeTimeout( final Integer secondsBeforeTimeout ) {
    this.secondsBeforeTimeout = secondsBeforeTimeout;
  }

  public String getTimeoutAction( ) {
    return timeoutAction;
  }

  public void setTimeoutAction( final String timeoutAction ) {
    this.timeoutAction = timeoutAction;
  }

}
