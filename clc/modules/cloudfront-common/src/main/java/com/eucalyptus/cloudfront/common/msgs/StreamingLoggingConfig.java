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


public class StreamingLoggingConfig extends EucalyptusData {

  @Nonnull
  private String bucket;
  @Nonnull
  private Boolean enabled;
  @Nonnull
  private String prefix;

  public String getBucket( ) {
    return bucket;
  }

  public void setBucket( final String bucket ) {
    this.bucket = bucket;
  }

  public Boolean getEnabled( ) {
    return enabled;
  }

  public void setEnabled( final Boolean enabled ) {
    this.enabled = enabled;
  }

  public String getPrefix( ) {
    return prefix;
  }

  public void setPrefix( final String prefix ) {
    this.prefix = prefix;
  }

}
