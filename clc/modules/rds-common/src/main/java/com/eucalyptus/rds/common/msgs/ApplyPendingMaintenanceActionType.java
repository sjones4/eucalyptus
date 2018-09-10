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



public class ApplyPendingMaintenanceActionType extends RdsMessage {

  @Nonnull
  private String applyAction;
  @Nonnull
  private String optInType;
  @Nonnull
  private String resourceIdentifier;

  public String getApplyAction( ) {
    return applyAction;
  }

  public void setApplyAction( final String applyAction ) {
    this.applyAction = applyAction;
  }

  public String getOptInType( ) {
    return optInType;
  }

  public void setOptInType( final String optInType ) {
    this.optInType = optInType;
  }

  public String getResourceIdentifier( ) {
    return resourceIdentifier;
  }

  public void setResourceIdentifier( final String resourceIdentifier ) {
    this.resourceIdentifier = resourceIdentifier;
  }

}
