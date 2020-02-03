/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import javax.annotation.Nonnull;


public class StopActivityStreamType extends RdsMessage {

  private Boolean applyImmediately;

  @Nonnull
  private String resourceArn;

  public Boolean getApplyImmediately() {
    return applyImmediately;
  }

  public void setApplyImmediately(final Boolean applyImmediately) {
    this.applyImmediately = applyImmediately;
  }

  public String getResourceArn() {
    return resourceArn;
  }

  public void setResourceArn(final String resourceArn) {
    this.resourceArn = resourceArn;
  }

}
