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



@HttpRequestMapping(method="GET", uri="/2013-04-01/hostedzonesbyname")
@HttpNoContent
public class ListHostedZonesByNameType extends Route53Message {

  @HttpParameterMapping(parameter="dnsname")
  @FieldRange(max=1024)
  private String dNSName;
  @HttpParameterMapping(parameter="hostedzoneid")
  @FieldRange(max=32)
  private String hostedZoneId;
  @HttpParameterMapping(parameter="maxitems")
  private String maxItems;

  public String getDNSName( ) {
    return dNSName;
  }

  public void setDNSName( final String dNSName ) {
    this.dNSName = dNSName;
  }

  public String getHostedZoneId( ) {
    return hostedZoneId;
  }

  public void setHostedZoneId( final String hostedZoneId ) {
    this.hostedZoneId = hostedZoneId;
  }

  public String getMaxItems( ) {
    return maxItems;
  }

  public void setMaxItems( final String maxItems ) {
    this.maxItems = maxItems;
  }

}
