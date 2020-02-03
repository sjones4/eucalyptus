/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;


public class DoubleRange extends EucalyptusData {

  private Double from;

  private Double to;

  public Double getFrom() {
    return from;
  }

  public void setFrom(final Double from) {
    this.from = from;
  }

  public Double getTo() {
    return to;
  }

  public void setTo(final Double to) {
    this.to = to;
  }

}
