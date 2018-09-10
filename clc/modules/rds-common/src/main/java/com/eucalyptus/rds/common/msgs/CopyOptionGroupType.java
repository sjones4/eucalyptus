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



public class CopyOptionGroupType extends RdsMessage {

  @Nonnull
  private String sourceOptionGroupIdentifier;
  private TagList tags;
  @Nonnull
  private String targetOptionGroupDescription;
  @Nonnull
  private String targetOptionGroupIdentifier;

  public String getSourceOptionGroupIdentifier( ) {
    return sourceOptionGroupIdentifier;
  }

  public void setSourceOptionGroupIdentifier( final String sourceOptionGroupIdentifier ) {
    this.sourceOptionGroupIdentifier = sourceOptionGroupIdentifier;
  }

  public TagList getTags( ) {
    return tags;
  }

  public void setTags( final TagList tags ) {
    this.tags = tags;
  }

  public String getTargetOptionGroupDescription( ) {
    return targetOptionGroupDescription;
  }

  public void setTargetOptionGroupDescription( final String targetOptionGroupDescription ) {
    this.targetOptionGroupDescription = targetOptionGroupDescription;
  }

  public String getTargetOptionGroupIdentifier( ) {
    return targetOptionGroupIdentifier;
  }

  public void setTargetOptionGroupIdentifier( final String targetOptionGroupIdentifier ) {
    this.targetOptionGroupIdentifier = targetOptionGroupIdentifier;
  }

}
