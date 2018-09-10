/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import javax.annotation.Nonnull;
import com.eucalyptus.binding.HttpContent;
import com.eucalyptus.binding.HttpNoContent;
import com.eucalyptus.binding.HttpHeaderMapping;
import com.eucalyptus.binding.HttpParameterMapping;
import com.eucalyptus.binding.HttpRequestMapping;
import com.eucalyptus.binding.HttpUriMapping;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRange;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRegex;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRegexValue;



public class ModifyOptionGroupType extends RdsMessage {

  private Boolean applyImmediately;
  @Nonnull
  private String optionGroupName;
  private OptionConfigurationList optionsToInclude;
  private OptionNamesList optionsToRemove;

  public Boolean getApplyImmediately( ) {
    return applyImmediately;
  }

  public void setApplyImmediately( final Boolean applyImmediately ) {
    this.applyImmediately = applyImmediately;
  }

  public String getOptionGroupName( ) {
    return optionGroupName;
  }

  public void setOptionGroupName( final String optionGroupName ) {
    this.optionGroupName = optionGroupName;
  }

  public OptionConfigurationList getOptionsToInclude( ) {
    return optionsToInclude;
  }

  public void setOptionsToInclude( final OptionConfigurationList optionsToInclude ) {
    this.optionsToInclude = optionsToInclude;
  }

  public OptionNamesList getOptionsToRemove( ) {
    return optionsToRemove;
  }

  public void setOptionsToRemove( final OptionNamesList optionsToRemove ) {
    this.optionsToRemove = optionsToRemove;
  }

}
