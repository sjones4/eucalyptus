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



public class CreateDBParameterGroupType extends RdsMessage {

  @Nonnull
  private String dBParameterGroupFamily;
  @Nonnull
  private String dBParameterGroupName;
  @Nonnull
  private String description;
  private TagList tags;

  public String getDBParameterGroupFamily( ) {
    return dBParameterGroupFamily;
  }

  public void setDBParameterGroupFamily( final String dBParameterGroupFamily ) {
    this.dBParameterGroupFamily = dBParameterGroupFamily;
  }

  public String getDBParameterGroupName( ) {
    return dBParameterGroupName;
  }

  public void setDBParameterGroupName( final String dBParameterGroupName ) {
    this.dBParameterGroupName = dBParameterGroupName;
  }

  public String getDescription( ) {
    return description;
  }

  public void setDescription( final String description ) {
    this.description = description;
  }

  public TagList getTags( ) {
    return tags;
  }

  public void setTags( final TagList tags ) {
    this.tags = tags;
  }

}
