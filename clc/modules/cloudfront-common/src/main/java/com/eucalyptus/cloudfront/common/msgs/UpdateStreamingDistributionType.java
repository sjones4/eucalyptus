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
import com.eucalyptus.binding.HttpNoContent;
import com.eucalyptus.binding.HttpHeaderMapping;
import com.eucalyptus.binding.HttpParameterMapping;
import com.eucalyptus.binding.HttpRequestMapping;
import com.eucalyptus.binding.HttpUriMapping;
import com.eucalyptus.cloudfront.common.CloudfrontMessageValidation.FieldRange;
import com.eucalyptus.cloudfront.common.CloudfrontMessageValidation.FieldRegex;
import com.eucalyptus.cloudfront.common.CloudfrontMessageValidation.FieldRegexValue;



@HttpRequestMapping(method="PUT", uri="/2018-06-18/streaming-distribution/{Id}/config")
@HttpContent(payload="streamingDistributionConfig")
public class UpdateStreamingDistributionType extends CloudfrontMessage {

  @Nonnull
  @HttpUriMapping(uri="Id")
  private String id;
  @HttpHeaderMapping(header="If-Match")
  private String ifMatch;
  @Nonnull
  private StreamingDistributionConfig streamingDistributionConfig = new StreamingDistributionConfig();

  public String getId( ) {
    return id;
  }

  public void setId( final String id ) {
    this.id = id;
  }

  public String getIfMatch( ) {
    return ifMatch;
  }

  public void setIfMatch( final String ifMatch ) {
    this.ifMatch = ifMatch;
  }

  public StreamingDistributionConfig getStreamingDistributionConfig( ) {
    return streamingDistributionConfig;
  }

  public void setStreamingDistributionConfig( final StreamingDistributionConfig streamingDistributionConfig ) {
    this.streamingDistributionConfig = streamingDistributionConfig;
  }

}
