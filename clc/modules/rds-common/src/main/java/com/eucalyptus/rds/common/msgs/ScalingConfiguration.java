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


public class ScalingConfiguration extends EucalyptusData {

  private Boolean autoPause;
  private Integer maxCapacity;
  private Integer minCapacity;
  private Integer secondsUntilAutoPause;

  public Boolean getAutoPause( ) {
    return autoPause;
  }

  public void setAutoPause( final Boolean autoPause ) {
    this.autoPause = autoPause;
  }

  public Integer getMaxCapacity( ) {
    return maxCapacity;
  }

  public void setMaxCapacity( final Integer maxCapacity ) {
    this.maxCapacity = maxCapacity;
  }

  public Integer getMinCapacity( ) {
    return minCapacity;
  }

  public void setMinCapacity( final Integer minCapacity ) {
    this.minCapacity = minCapacity;
  }

  public Integer getSecondsUntilAutoPause( ) {
    return secondsUntilAutoPause;
  }

  public void setSecondsUntilAutoPause( final Integer secondsUntilAutoPause ) {
    this.secondsUntilAutoPause = secondsUntilAutoPause;
  }

}
