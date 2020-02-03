/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;


public class AccountQuota extends EucalyptusData {

  private String accountQuotaName;

  private Long max;

  private Long used;

  public String getAccountQuotaName() {
    return accountQuotaName;
  }

  public void setAccountQuotaName(final String accountQuotaName) {
    this.accountQuotaName = accountQuotaName;
  }

  public Long getMax() {
    return max;
  }

  public void setMax(final Long max) {
    this.max = max;
  }

  public Long getUsed() {
    return used;
  }

  public void setUsed(final Long used) {
    this.used = used;
  }

}
