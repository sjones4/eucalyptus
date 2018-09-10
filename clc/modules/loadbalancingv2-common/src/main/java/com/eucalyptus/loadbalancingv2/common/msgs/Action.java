/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.loadbalancingv2.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;
import javax.annotation.Nonnull;
import com.eucalyptus.loadbalancingv2.common.Loadbalancingv2MessageValidation.FieldRange;
import com.eucalyptus.loadbalancingv2.common.Loadbalancingv2MessageValidation.FieldRegex;
import com.eucalyptus.loadbalancingv2.common.Loadbalancingv2MessageValidation.FieldRegexValue;


public class Action extends EucalyptusData {

  private AuthenticateCognitoActionConfig authenticateCognitoConfig;
  private AuthenticateOidcActionConfig authenticateOidcConfig;
  private FixedResponseActionConfig fixedResponseConfig;
  @FieldRange(min=1, max=50000)
  private Integer order;
  private RedirectActionConfig redirectConfig;
  private String targetGroupArn;
  @Nonnull
  @FieldRegex(FieldRegexValue.ENUM_ACTIONTYPEENUM)
  private String type;

  public AuthenticateCognitoActionConfig getAuthenticateCognitoConfig( ) {
    return authenticateCognitoConfig;
  }

  public void setAuthenticateCognitoConfig( final AuthenticateCognitoActionConfig authenticateCognitoConfig ) {
    this.authenticateCognitoConfig = authenticateCognitoConfig;
  }

  public AuthenticateOidcActionConfig getAuthenticateOidcConfig( ) {
    return authenticateOidcConfig;
  }

  public void setAuthenticateOidcConfig( final AuthenticateOidcActionConfig authenticateOidcConfig ) {
    this.authenticateOidcConfig = authenticateOidcConfig;
  }

  public FixedResponseActionConfig getFixedResponseConfig( ) {
    return fixedResponseConfig;
  }

  public void setFixedResponseConfig( final FixedResponseActionConfig fixedResponseConfig ) {
    this.fixedResponseConfig = fixedResponseConfig;
  }

  public Integer getOrder( ) {
    return order;
  }

  public void setOrder( final Integer order ) {
    this.order = order;
  }

  public RedirectActionConfig getRedirectConfig( ) {
    return redirectConfig;
  }

  public void setRedirectConfig( final RedirectActionConfig redirectConfig ) {
    this.redirectConfig = redirectConfig;
  }

  public String getTargetGroupArn( ) {
    return targetGroupArn;
  }

  public void setTargetGroupArn( final String targetGroupArn ) {
    this.targetGroupArn = targetGroupArn;
  }

  public String getType( ) {
    return type;
  }

  public void setType( final String type ) {
    this.type = type;
  }

}
