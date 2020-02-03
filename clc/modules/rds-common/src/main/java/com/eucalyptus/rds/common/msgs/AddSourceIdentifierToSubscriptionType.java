/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import javax.annotation.Nonnull;


public class AddSourceIdentifierToSubscriptionType extends RdsMessage {

  @Nonnull
  private String sourceIdentifier;

  @Nonnull
  private String subscriptionName;

  public String getSourceIdentifier() {
    return sourceIdentifier;
  }

  public void setSourceIdentifier(final String sourceIdentifier) {
    this.sourceIdentifier = sourceIdentifier;
  }

  public String getSubscriptionName() {
    return subscriptionName;
  }

  public void setSubscriptionName(final String subscriptionName) {
    this.subscriptionName = subscriptionName;
  }

}
