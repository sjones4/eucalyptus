/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;


public class RecurringCharge extends EucalyptusData {

  private Double recurringChargeAmount;

  private String recurringChargeFrequency;

  public Double getRecurringChargeAmount() {
    return recurringChargeAmount;
  }

  public void setRecurringChargeAmount(final Double recurringChargeAmount) {
    this.recurringChargeAmount = recurringChargeAmount;
  }

  public String getRecurringChargeFrequency() {
    return recurringChargeFrequency;
  }

  public void setRecurringChargeFrequency(final String recurringChargeFrequency) {
    this.recurringChargeFrequency = recurringChargeFrequency;
  }

}
