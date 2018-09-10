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



@HttpRequestMapping(method="POST", uri="/2013-04-01/hostedzone")
public class CreateHostedZoneType extends Route53Message {

  @Nonnull
  @FieldRange(min=1, max=128)
  private String callerReference;
  @FieldRange(max=32)
  private String delegationSetId;
  private HostedZoneConfig hostedZoneConfig;
  @Nonnull
  @FieldRange(max=1024)
  private String name;
  private VPC vPC;

  public String getCallerReference( ) {
    return callerReference;
  }

  public void setCallerReference( final String callerReference ) {
    this.callerReference = callerReference;
  }

  public String getDelegationSetId( ) {
    return delegationSetId;
  }

  public void setDelegationSetId( final String delegationSetId ) {
    this.delegationSetId = delegationSetId;
  }

  public HostedZoneConfig getHostedZoneConfig( ) {
    return hostedZoneConfig;
  }

  public void setHostedZoneConfig( final HostedZoneConfig hostedZoneConfig ) {
    this.hostedZoneConfig = hostedZoneConfig;
  }

  public String getName( ) {
    return name;
  }

  public void setName( final String name ) {
    this.name = name;
  }

  public VPC getVPC( ) {
    return vPC;
  }

  public void setVPC( final VPC vPC ) {
    this.vPC = vPC;
  }

}
