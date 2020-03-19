/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;


public class DescribeEventSubscriptionsResult extends EucalyptusData {

  private EventSubscriptionsList eventSubscriptionsList;

  private String marker;

  public EventSubscriptionsList getEventSubscriptionsList() {
    return eventSubscriptionsList;
  }

  public void setEventSubscriptionsList(final EventSubscriptionsList eventSubscriptionsList) {
    this.eventSubscriptionsList = eventSubscriptionsList;
  }

  public String getMarker() {
    return marker;
  }

  public void setMarker(final String marker) {
    this.marker = marker;
  }

}
