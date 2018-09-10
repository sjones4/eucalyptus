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


public class ContentTypeProfile extends EucalyptusData {

  @Nonnull
  private String contentType;
  @Nonnull
  @FieldRegex(FieldRegexValue.ENUM_FORMAT)
  private String format;
  private String profileId;

  public String getContentType( ) {
    return contentType;
  }

  public void setContentType( final String contentType ) {
    this.contentType = contentType;
  }

  public String getFormat( ) {
    return format;
  }

  public void setFormat( final String format ) {
    this.format = format;
  }

  public String getProfileId( ) {
    return profileId;
  }

  public void setProfileId( final String profileId ) {
    this.profileId = profileId;
  }

}
