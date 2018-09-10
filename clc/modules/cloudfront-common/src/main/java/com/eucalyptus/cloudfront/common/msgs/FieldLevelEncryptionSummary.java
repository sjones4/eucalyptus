/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudfront.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;
import javax.annotation.Nonnull;
import com.eucalyptus.cloudfront.common.CloudfrontMessageValidation.FieldRange;
import com.eucalyptus.cloudfront.common.CloudfrontMessageValidation.FieldRegex;
import com.eucalyptus.cloudfront.common.CloudfrontMessageValidation.FieldRegexValue;


public class FieldLevelEncryptionSummary extends EucalyptusData {

  private String comment;
  private ContentTypeProfileConfig contentTypeProfileConfig;
  @Nonnull
  private String id;
  @Nonnull
  private java.util.Date lastModifiedTime;
  private QueryArgProfileConfig queryArgProfileConfig;

  public String getComment( ) {
    return comment;
  }

  public void setComment( final String comment ) {
    this.comment = comment;
  }

  public ContentTypeProfileConfig getContentTypeProfileConfig( ) {
    return contentTypeProfileConfig;
  }

  public void setContentTypeProfileConfig( final ContentTypeProfileConfig contentTypeProfileConfig ) {
    this.contentTypeProfileConfig = contentTypeProfileConfig;
  }

  public String getId( ) {
    return id;
  }

  public void setId( final String id ) {
    this.id = id;
  }

  public java.util.Date getLastModifiedTime( ) {
    return lastModifiedTime;
  }

  public void setLastModifiedTime( final java.util.Date lastModifiedTime ) {
    this.lastModifiedTime = lastModifiedTime;
  }

  public QueryArgProfileConfig getQueryArgProfileConfig( ) {
    return queryArgProfileConfig;
  }

  public void setQueryArgProfileConfig( final QueryArgProfileConfig queryArgProfileConfig ) {
    this.queryArgProfileConfig = queryArgProfileConfig;
  }

}
