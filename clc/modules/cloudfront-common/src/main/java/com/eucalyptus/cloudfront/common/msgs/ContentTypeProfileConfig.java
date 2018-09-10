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


public class ContentTypeProfileConfig extends EucalyptusData {

  private ContentTypeProfiles contentTypeProfiles;
  @Nonnull
  private Boolean forwardWhenContentTypeIsUnknown;

  public ContentTypeProfiles getContentTypeProfiles( ) {
    return contentTypeProfiles;
  }

  public void setContentTypeProfiles( final ContentTypeProfiles contentTypeProfiles ) {
    this.contentTypeProfiles = contentTypeProfiles;
  }

  public Boolean getForwardWhenContentTypeIsUnknown( ) {
    return forwardWhenContentTypeIsUnknown;
  }

  public void setForwardWhenContentTypeIsUnknown( final Boolean forwardWhenContentTypeIsUnknown ) {
    this.forwardWhenContentTypeIsUnknown = forwardWhenContentTypeIsUnknown;
  }

}
