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


public class AvailableProcessorFeature extends EucalyptusData {

  private String allowedValues;
  private String defaultValue;
  private String name;

  public String getAllowedValues( ) {
    return allowedValues;
  }

  public void setAllowedValues( final String allowedValues ) {
    this.allowedValues = allowedValues;
  }

  public String getDefaultValue( ) {
    return defaultValue;
  }

  public void setDefaultValue( final String defaultValue ) {
    this.defaultValue = defaultValue;
  }

  public String getName( ) {
    return name;
  }

  public void setName( final String name ) {
    this.name = name;
  }

}
