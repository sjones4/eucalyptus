/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.secretsmanager.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;
import javax.annotation.Nonnull;
import com.eucalyptus.secretsmanager.common.SecretsmanagerMessageValidation.FieldRange;
import com.eucalyptus.secretsmanager.common.SecretsmanagerMessageValidation.FieldRegex;
import com.eucalyptus.secretsmanager.common.SecretsmanagerMessageValidation.FieldRegexValue;


public class SecretListEntry extends EucalyptusData {

  @FieldRange(min=20, max=2048)
  private String aRN;
  private java.util.Date deletedDate;
  @FieldRange(max=2048)
  private String description;
  @FieldRange(max=2048)
  private String kmsKeyId;
  private java.util.Date lastAccessedDate;
  private java.util.Date lastChangedDate;
  private java.util.Date lastRotatedDate;
  @FieldRange(min=1, max=256)
  private String name;
  private Boolean rotationEnabled;
  @FieldRange(max=2048)
  private String rotationLambdaARN;
  private RotationRulesType rotationRules;
  private SecretVersionsToStagesMapType secretVersionsToStages;
  private java.util.ArrayList<Tag> tags;

  public String getARN( ) {
    return aRN;
  }

  public void setARN( final String aRN ) {
    this.aRN = aRN;
  }

  public java.util.Date getDeletedDate( ) {
    return deletedDate;
  }

  public void setDeletedDate( final java.util.Date deletedDate ) {
    this.deletedDate = deletedDate;
  }

  public String getDescription( ) {
    return description;
  }

  public void setDescription( final String description ) {
    this.description = description;
  }

  public String getKmsKeyId( ) {
    return kmsKeyId;
  }

  public void setKmsKeyId( final String kmsKeyId ) {
    this.kmsKeyId = kmsKeyId;
  }

  public java.util.Date getLastAccessedDate( ) {
    return lastAccessedDate;
  }

  public void setLastAccessedDate( final java.util.Date lastAccessedDate ) {
    this.lastAccessedDate = lastAccessedDate;
  }

  public java.util.Date getLastChangedDate( ) {
    return lastChangedDate;
  }

  public void setLastChangedDate( final java.util.Date lastChangedDate ) {
    this.lastChangedDate = lastChangedDate;
  }

  public java.util.Date getLastRotatedDate( ) {
    return lastRotatedDate;
  }

  public void setLastRotatedDate( final java.util.Date lastRotatedDate ) {
    this.lastRotatedDate = lastRotatedDate;
  }

  public String getName( ) {
    return name;
  }

  public void setName( final String name ) {
    this.name = name;
  }

  public Boolean getRotationEnabled( ) {
    return rotationEnabled;
  }

  public void setRotationEnabled( final Boolean rotationEnabled ) {
    this.rotationEnabled = rotationEnabled;
  }

  public String getRotationLambdaARN( ) {
    return rotationLambdaARN;
  }

  public void setRotationLambdaARN( final String rotationLambdaARN ) {
    this.rotationLambdaARN = rotationLambdaARN;
  }

  public RotationRulesType getRotationRules( ) {
    return rotationRules;
  }

  public void setRotationRules( final RotationRulesType rotationRules ) {
    this.rotationRules = rotationRules;
  }

  public SecretVersionsToStagesMapType getSecretVersionsToStages( ) {
    return secretVersionsToStages;
  }

  public void setSecretVersionsToStages( final SecretVersionsToStagesMapType secretVersionsToStages ) {
    this.secretVersionsToStages = secretVersionsToStages;
  }

  public java.util.ArrayList<Tag> getTags( ) {
    return tags;
  }

  public void setTags( final java.util.ArrayList<Tag> tags ) {
    this.tags = tags;
  }

}
