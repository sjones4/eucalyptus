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



public class CopyDBSnapshotType extends RdsMessage {

  private Boolean copyTags;
  private String kmsKeyId;
  private String optionGroupName;
  private String preSignedUrl;
  @Nonnull
  private String sourceDBSnapshotIdentifier;
  private TagList tags;
  @Nonnull
  private String targetDBSnapshotIdentifier;

  public Boolean getCopyTags( ) {
    return copyTags;
  }

  public void setCopyTags( final Boolean copyTags ) {
    this.copyTags = copyTags;
  }

  public String getKmsKeyId( ) {
    return kmsKeyId;
  }

  public void setKmsKeyId( final String kmsKeyId ) {
    this.kmsKeyId = kmsKeyId;
  }

  public String getOptionGroupName( ) {
    return optionGroupName;
  }

  public void setOptionGroupName( final String optionGroupName ) {
    this.optionGroupName = optionGroupName;
  }

  public String getPreSignedUrl( ) {
    return preSignedUrl;
  }

  public void setPreSignedUrl( final String preSignedUrl ) {
    this.preSignedUrl = preSignedUrl;
  }

  public String getSourceDBSnapshotIdentifier( ) {
    return sourceDBSnapshotIdentifier;
  }

  public void setSourceDBSnapshotIdentifier( final String sourceDBSnapshotIdentifier ) {
    this.sourceDBSnapshotIdentifier = sourceDBSnapshotIdentifier;
  }

  public TagList getTags( ) {
    return tags;
  }

  public void setTags( final TagList tags ) {
    this.tags = tags;
  }

  public String getTargetDBSnapshotIdentifier( ) {
    return targetDBSnapshotIdentifier;
  }

  public void setTargetDBSnapshotIdentifier( final String targetDBSnapshotIdentifier ) {
    this.targetDBSnapshotIdentifier = targetDBSnapshotIdentifier;
  }

}
