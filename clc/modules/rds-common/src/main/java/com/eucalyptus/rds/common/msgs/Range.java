/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;


public class Range extends EucalyptusData {

  private Integer from;

  private Integer step;

  private Integer to;

  public Integer getFrom() {
    return from;
  }

  public void setFrom(final Integer from) {
    this.from = from;
  }

  public Integer getStep() {
    return step;
  }

  public void setStep(final Integer step) {
    this.step = step;
  }

  public Integer getTo() {
    return to;
  }

  public void setTo(final Integer to) {
    this.to = to;
  }

}
