/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import javax.annotation.Nonnull;


public class ResetDBParameterGroupType extends RdsMessage {

  @Nonnull
  private String dBParameterGroupName;

  private ParametersList parameters;

  private Boolean resetAllParameters;

  public String getDBParameterGroupName() {
    return dBParameterGroupName;
  }

  public void setDBParameterGroupName(final String dBParameterGroupName) {
    this.dBParameterGroupName = dBParameterGroupName;
  }

  public ParametersList getParameters() {
    return parameters;
  }

  public void setParameters(final ParametersList parameters) {
    this.parameters = parameters;
  }

  public Boolean getResetAllParameters() {
    return resetAllParameters;
  }

  public void setResetAllParameters(final Boolean resetAllParameters) {
    this.resetAllParameters = resetAllParameters;
  }

}
