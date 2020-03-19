/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import javax.annotation.Nonnull;
import edu.ucsb.eucalyptus.msgs.EucalyptusData;


public class Filter extends EucalyptusData {

  @Nonnull
  private String name;

  @Nonnull
  private FilterValueList values;

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public FilterValueList getValues() {
    return values;
  }

  public void setValues(final FilterValueList values) {
    this.values = values;
  }

}
