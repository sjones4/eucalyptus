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


public class OptionGroupOptionSetting extends EucalyptusData {

  private String allowedValues;
  private String applyType;
  private String defaultValue;
  private Boolean isModifiable;
  private String settingDescription;
  private String settingName;

  public String getAllowedValues( ) {
    return allowedValues;
  }

  public void setAllowedValues( final String allowedValues ) {
    this.allowedValues = allowedValues;
  }

  public String getApplyType( ) {
    return applyType;
  }

  public void setApplyType( final String applyType ) {
    this.applyType = applyType;
  }

  public String getDefaultValue( ) {
    return defaultValue;
  }

  public void setDefaultValue( final String defaultValue ) {
    this.defaultValue = defaultValue;
  }

  public Boolean getIsModifiable( ) {
    return isModifiable;
  }

  public void setIsModifiable( final Boolean isModifiable ) {
    this.isModifiable = isModifiable;
  }

  public String getSettingDescription( ) {
    return settingDescription;
  }

  public void setSettingDescription( final String settingDescription ) {
    this.settingDescription = settingDescription;
  }

  public String getSettingName( ) {
    return settingName;
  }

  public void setSettingName( final String settingName ) {
    this.settingName = settingName;
  }

}
