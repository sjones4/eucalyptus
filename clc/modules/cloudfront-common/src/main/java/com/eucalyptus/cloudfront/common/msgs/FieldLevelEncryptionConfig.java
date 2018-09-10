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


public class FieldLevelEncryptionConfig extends EucalyptusData {

  @Nonnull
  private String callerReference;
  private String comment;
  private ContentTypeProfileConfig contentTypeProfileConfig;
  private QueryArgProfileConfig queryArgProfileConfig;

  public String getCallerReference( ) {
    return callerReference;
  }

  public void setCallerReference( final String callerReference ) {
    this.callerReference = callerReference;
  }

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

  public QueryArgProfileConfig getQueryArgProfileConfig( ) {
    return queryArgProfileConfig;
  }

  public void setQueryArgProfileConfig( final QueryArgProfileConfig queryArgProfileConfig ) {
    this.queryArgProfileConfig = queryArgProfileConfig;
  }

}
