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
import com.eucalyptus.binding.HttpNoContent;
import com.eucalyptus.binding.HttpHeaderMapping;
import com.eucalyptus.binding.HttpParameterMapping;
import com.eucalyptus.binding.HttpRequestMapping;
import com.eucalyptus.binding.HttpUriMapping;
import com.eucalyptus.route53.common.Route53MessageValidation.FieldRange;
import com.eucalyptus.route53.common.Route53MessageValidation.FieldRegex;
import com.eucalyptus.route53.common.Route53MessageValidation.FieldRegexValue;



@HttpRequestMapping(method="POST", uri="/2013-04-01/delegationset")
public class CreateReusableDelegationSetType extends Route53Message {

  @Nonnull
  @FieldRange(min=1, max=128)
  private String callerReference;
  @FieldRange(max=32)
  private String hostedZoneId;

  public String getCallerReference( ) {
    return callerReference;
  }

  public void setCallerReference( final String callerReference ) {
    this.callerReference = callerReference;
  }

  public String getHostedZoneId( ) {
    return hostedZoneId;
  }

  public void setHostedZoneId( final String hostedZoneId ) {
    this.hostedZoneId = hostedZoneId;
  }

}
