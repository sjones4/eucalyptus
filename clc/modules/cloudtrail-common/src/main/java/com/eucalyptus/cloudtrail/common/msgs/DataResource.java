/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudtrail.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;
import javax.annotation.Nonnull;
import com.eucalyptus.cloudtrail.common.CloudtrailMessageValidation.FieldRange;
import com.eucalyptus.cloudtrail.common.CloudtrailMessageValidation.FieldRegex;
import com.eucalyptus.cloudtrail.common.CloudtrailMessageValidation.FieldRegexValue;


public class DataResource extends EucalyptusData {

  private String type;
  private java.util.ArrayList<String> values;

  public String getType( ) {
    return type;
  }

  public void setType( final String type ) {
    this.type = type;
  }

  public java.util.ArrayList<String> getValues( ) {
    return values;
  }

  public void setValues( final java.util.ArrayList<String> values ) {
    this.values = values;
  }

}
