/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.route53.common.msgs;

import javax.annotation.Nonnull;
import com.eucalyptus.binding.HttpContent;
import com.eucalyptus.binding.HttpHeaderMapping;
import com.eucalyptus.binding.HttpNoContent;
import com.eucalyptus.route53.common.Route53MessageValidation.FieldRange;
import com.eucalyptus.route53.common.Route53MessageValidation.FieldRegex;
import com.eucalyptus.route53.common.Route53MessageValidation.FieldRegexValue;



public class CreateQueryLoggingConfigResponseType extends Route53Message {


  @Nonnull
  @HttpHeaderMapping(header="Location")
  @FieldRange(max=1024)
  private String location;
  @Nonnull
  private QueryLoggingConfig queryLoggingConfig;

  public String getLocation( ) {
    return location;
  }

  public void setLocation( final String location ) {
    this.location = location;
  }

  public QueryLoggingConfig getQueryLoggingConfig( ) {
    return queryLoggingConfig;
  }

  public void setQueryLoggingConfig( final QueryLoggingConfig queryLoggingConfig ) {
    this.queryLoggingConfig = queryLoggingConfig;
  }

}
