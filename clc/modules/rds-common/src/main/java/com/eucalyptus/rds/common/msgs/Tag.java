/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;
import javax.annotation.Nonnull;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRange;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRegex;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRegexValue;


public class Tag extends EucalyptusData {

  private String key;
  private String value;

  public String getKey( ) {
    return key;
  }

  public void setKey( final String key ) {
    this.key = key;
  }

  public String getValue( ) {
    return value;
  }

  public void setValue( final String value ) {
    this.value = value;
  }

}
