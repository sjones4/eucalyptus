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


public class StreamingDistributionConfigWithTags extends EucalyptusData {

  @Nonnull
  private StreamingDistributionConfig streamingDistributionConfig;
  @Nonnull
  private Tags tags;

  public StreamingDistributionConfig getStreamingDistributionConfig( ) {
    return streamingDistributionConfig;
  }

  public void setStreamingDistributionConfig( final StreamingDistributionConfig streamingDistributionConfig ) {
    this.streamingDistributionConfig = streamingDistributionConfig;
  }

  public Tags getTags( ) {
    return tags;
  }

  public void setTags( final Tags tags ) {
    this.tags = tags;
  }

}
