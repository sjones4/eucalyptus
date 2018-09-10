/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.mq.service.ws;

import java.util.Map;
import javax.annotation.Nonnull;

import com.eucalyptus.component.annotation.ComponentNamed;
import com.eucalyptus.context.ServiceAdvice;
import com.eucalyptus.mq.common.msgs.MqMessage;
import com.eucalyptus.mq.service.MqException;
import com.eucalyptus.mq.service.MqClientException;

/**
 *
 */
@ComponentNamed
public class MqMessageValidator extends ServiceAdvice {

  @Override
  protected void beforeService( @Nonnull final Object object ) throws MqException {
    // validate message
    if ( object instanceof MqMessage ) {
      final MqMessage request = (MqMessage) object;
      final Map<String,String> validationErrorsByField = request.validate( );
      if ( !validationErrorsByField.isEmpty() ) {
        throw new MqClientException( "ValidationError", validationErrorsByField.values().iterator().next() );
      }
    }
  }
}
