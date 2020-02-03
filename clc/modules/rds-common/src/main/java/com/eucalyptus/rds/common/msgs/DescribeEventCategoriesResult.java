/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;


public class DescribeEventCategoriesResult extends EucalyptusData {

  private EventCategoriesMapList eventCategoriesMapList;

  public EventCategoriesMapList getEventCategoriesMapList() {
    return eventCategoriesMapList;
  }

  public void setEventCategoriesMapList(final EventCategoriesMapList eventCategoriesMapList) {
    this.eventCategoriesMapList = eventCategoriesMapList;
  }

}
