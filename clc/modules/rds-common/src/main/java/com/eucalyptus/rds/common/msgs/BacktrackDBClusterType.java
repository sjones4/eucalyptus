/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import javax.annotation.Nonnull;
import com.eucalyptus.binding.HttpContent;
import com.eucalyptus.binding.HttpNoContent;
import com.eucalyptus.binding.HttpHeaderMapping;
import com.eucalyptus.binding.HttpParameterMapping;
import com.eucalyptus.binding.HttpRequestMapping;
import com.eucalyptus.binding.HttpUriMapping;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRange;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRegex;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRegexValue;



public class BacktrackDBClusterType extends RdsMessage {

  @Nonnull
  private java.util.Date backtrackTo;
  @Nonnull
  private String dBClusterIdentifier;
  private Boolean force;
  private Boolean useEarliestTimeOnPointInTimeUnavailable;

  public java.util.Date getBacktrackTo( ) {
    return backtrackTo;
  }

  public void setBacktrackTo( final java.util.Date backtrackTo ) {
    this.backtrackTo = backtrackTo;
  }

  public String getDBClusterIdentifier( ) {
    return dBClusterIdentifier;
  }

  public void setDBClusterIdentifier( final String dBClusterIdentifier ) {
    this.dBClusterIdentifier = dBClusterIdentifier;
  }

  public Boolean getForce( ) {
    return force;
  }

  public void setForce( final Boolean force ) {
    this.force = force;
  }

  public Boolean getUseEarliestTimeOnPointInTimeUnavailable( ) {
    return useEarliestTimeOnPointInTimeUnavailable;
  }

  public void setUseEarliestTimeOnPointInTimeUnavailable( final Boolean useEarliestTimeOnPointInTimeUnavailable ) {
    this.useEarliestTimeOnPointInTimeUnavailable = useEarliestTimeOnPointInTimeUnavailable;
  }

}
