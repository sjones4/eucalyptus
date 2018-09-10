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


public class DoubleRange extends EucalyptusData {

  private Double from;
  private Double to;

  public Double getFrom( ) {
    return from;
  }

  public void setFrom( final Double from ) {
    this.from = from;
  }

  public Double getTo( ) {
    return to;
  }

  public void setTo( final Double to ) {
    this.to = to;
  }

}
