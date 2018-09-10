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


public class SecretVersionsListEntry extends EucalyptusData {

  private java.util.Date createdDate;
  private java.util.Date lastAccessedDate;
  @FieldRange(min=32, max=64)
  private String versionId;
  @FieldRange(min=1, max=20)
  private java.util.ArrayList<String> versionStages;

  public java.util.Date getCreatedDate( ) {
    return createdDate;
  }

  public void setCreatedDate( final java.util.Date createdDate ) {
    this.createdDate = createdDate;
  }

  public java.util.Date getLastAccessedDate( ) {
    return lastAccessedDate;
  }

  public void setLastAccessedDate( final java.util.Date lastAccessedDate ) {
    this.lastAccessedDate = lastAccessedDate;
  }

  public String getVersionId( ) {
    return versionId;
  }

  public void setVersionId( final String versionId ) {
    this.versionId = versionId;
  }

  public java.util.ArrayList<String> getVersionStages( ) {
    return versionStages;
  }

  public void setVersionStages( final java.util.ArrayList<String> versionStages ) {
    this.versionStages = versionStages;
  }

}
