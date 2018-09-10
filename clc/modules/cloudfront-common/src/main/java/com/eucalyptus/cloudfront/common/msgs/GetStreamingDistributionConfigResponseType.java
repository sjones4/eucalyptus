/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudfront.common.msgs;

import javax.annotation.Nonnull;
import com.eucalyptus.binding.HttpContent;
import com.eucalyptus.binding.HttpHeaderMapping;
import com.eucalyptus.binding.HttpNoContent;
import com.eucalyptus.cloudfront.common.CloudfrontMessageValidation.FieldRange;
import com.eucalyptus.cloudfront.common.CloudfrontMessageValidation.FieldRegex;
import com.eucalyptus.cloudfront.common.CloudfrontMessageValidation.FieldRegexValue;



@HttpContent(payload="streamingDistributionConfig")
public class GetStreamingDistributionConfigResponseType extends CloudfrontMessage {


  @HttpHeaderMapping(header="ETag")
  private String eTag;
  private StreamingDistributionConfig streamingDistributionConfig = new StreamingDistributionConfig();

  public String getETag( ) {
    return eTag;
  }

  public void setETag( final String eTag ) {
    this.eTag = eTag;
  }

  public StreamingDistributionConfig getStreamingDistributionConfig( ) {
    return streamingDistributionConfig;
  }

  public void setStreamingDistributionConfig( final StreamingDistributionConfig streamingDistributionConfig ) {
    this.streamingDistributionConfig = streamingDistributionConfig;
  }

}
