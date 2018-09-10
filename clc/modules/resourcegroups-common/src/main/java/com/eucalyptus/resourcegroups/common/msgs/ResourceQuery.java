/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.resourcegroups.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;
import javax.annotation.Nonnull;
import com.eucalyptus.resourcegroups.common.ResourcegroupsMessageValidation.FieldRange;
import com.eucalyptus.resourcegroups.common.ResourcegroupsMessageValidation.FieldRegex;
import com.eucalyptus.resourcegroups.common.ResourcegroupsMessageValidation.FieldRegexValue;


public class ResourceQuery extends EucalyptusData {

  @Nonnull
  @FieldRange(max=2048)
  private String query;
  @Nonnull
  @FieldRegex(FieldRegexValue.ENUM_QUERYTYPE)
  private String type;

  public String getQuery( ) {
    return query;
  }

  public void setQuery( final String query ) {
    this.query = query;
  }

  public String getType( ) {
    return type;
  }

  public void setType( final String type ) {
    this.type = type;
  }

}
