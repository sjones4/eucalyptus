/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.loadbalancingv2.service.ws;

import java.util.Map;
import javax.annotation.Nonnull;

import com.eucalyptus.component.annotation.ComponentNamed;
import com.eucalyptus.context.ServiceAdvice;
import com.eucalyptus.loadbalancingv2.common.msgs.Loadbalancingv2Message;
import com.eucalyptus.loadbalancingv2.service.Loadbalancingv2Exception;
import com.eucalyptus.loadbalancingv2.service.Loadbalancingv2ClientException;

/**
 *
 */
@ComponentNamed
public class Loadbalancingv2MessageValidator extends ServiceAdvice {

  @Override
  protected void beforeService( @Nonnull final Object object ) throws Loadbalancingv2Exception {
    // validate message
    if ( object instanceof Loadbalancingv2Message ) {
      final Loadbalancingv2Message request = (Loadbalancingv2Message) object;
      final Map<String,String> validationErrorsByField = request.validate( );
      if ( !validationErrorsByField.isEmpty() ) {
        throw new Loadbalancingv2ClientException( "ValidationError", validationErrorsByField.values().iterator().next() );
      }
    }
  }
}
