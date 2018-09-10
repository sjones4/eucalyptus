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


public class ResourceFilter extends EucalyptusData {

  @Nonnull
  @FieldRegex(FieldRegexValue.ENUM_RESOURCEFILTERNAME)
  private String name;
  @Nonnull
  @FieldRange(min=1, max=5)
  private java.util.ArrayList<String> values;

  public String getName( ) {
    return name;
  }

  public void setName( final String name ) {
    this.name = name;
  }

  public java.util.ArrayList<String> getValues( ) {
    return values;
  }

  public void setValues( final java.util.ArrayList<String> values ) {
    this.values = values;
  }

}
