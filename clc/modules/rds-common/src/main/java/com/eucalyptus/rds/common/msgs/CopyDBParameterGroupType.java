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



public class CopyDBParameterGroupType extends RdsMessage {

  @Nonnull
  private String sourceDBParameterGroupIdentifier;
  private TagList tags;
  @Nonnull
  private String targetDBParameterGroupDescription;
  @Nonnull
  private String targetDBParameterGroupIdentifier;

  public String getSourceDBParameterGroupIdentifier( ) {
    return sourceDBParameterGroupIdentifier;
  }

  public void setSourceDBParameterGroupIdentifier( final String sourceDBParameterGroupIdentifier ) {
    this.sourceDBParameterGroupIdentifier = sourceDBParameterGroupIdentifier;
  }

  public TagList getTags( ) {
    return tags;
  }

  public void setTags( final TagList tags ) {
    this.tags = tags;
  }

  public String getTargetDBParameterGroupDescription( ) {
    return targetDBParameterGroupDescription;
  }

  public void setTargetDBParameterGroupDescription( final String targetDBParameterGroupDescription ) {
    this.targetDBParameterGroupDescription = targetDBParameterGroupDescription;
  }

  public String getTargetDBParameterGroupIdentifier( ) {
    return targetDBParameterGroupIdentifier;
  }

  public void setTargetDBParameterGroupIdentifier( final String targetDBParameterGroupIdentifier ) {
    this.targetDBParameterGroupIdentifier = targetDBParameterGroupIdentifier;
  }

}
