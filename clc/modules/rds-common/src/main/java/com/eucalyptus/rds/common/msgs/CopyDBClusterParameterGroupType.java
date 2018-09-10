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



public class CopyDBClusterParameterGroupType extends RdsMessage {

  @Nonnull
  private String sourceDBClusterParameterGroupIdentifier;
  private TagList tags;
  @Nonnull
  private String targetDBClusterParameterGroupDescription;
  @Nonnull
  private String targetDBClusterParameterGroupIdentifier;

  public String getSourceDBClusterParameterGroupIdentifier( ) {
    return sourceDBClusterParameterGroupIdentifier;
  }

  public void setSourceDBClusterParameterGroupIdentifier( final String sourceDBClusterParameterGroupIdentifier ) {
    this.sourceDBClusterParameterGroupIdentifier = sourceDBClusterParameterGroupIdentifier;
  }

  public TagList getTags( ) {
    return tags;
  }

  public void setTags( final TagList tags ) {
    this.tags = tags;
  }

  public String getTargetDBClusterParameterGroupDescription( ) {
    return targetDBClusterParameterGroupDescription;
  }

  public void setTargetDBClusterParameterGroupDescription( final String targetDBClusterParameterGroupDescription ) {
    this.targetDBClusterParameterGroupDescription = targetDBClusterParameterGroupDescription;
  }

  public String getTargetDBClusterParameterGroupIdentifier( ) {
    return targetDBClusterParameterGroupIdentifier;
  }

  public void setTargetDBClusterParameterGroupIdentifier( final String targetDBClusterParameterGroupIdentifier ) {
    this.targetDBClusterParameterGroupIdentifier = targetDBClusterParameterGroupIdentifier;
  }

}
