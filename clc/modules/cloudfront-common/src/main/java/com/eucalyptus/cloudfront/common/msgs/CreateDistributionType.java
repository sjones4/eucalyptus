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



@HttpRequestMapping(method="POST", uri="/2018-06-18/distribution")
@HttpContent(payload="distributionConfig")
public class CreateDistributionType extends CloudfrontMessage {

  @Nonnull
  private DistributionConfig distributionConfig = new DistributionConfig();

  public DistributionConfig getDistributionConfig( ) {
    return distributionConfig;
  }

  public void setDistributionConfig( final DistributionConfig distributionConfig ) {
    this.distributionConfig = distributionConfig;
  }

}
