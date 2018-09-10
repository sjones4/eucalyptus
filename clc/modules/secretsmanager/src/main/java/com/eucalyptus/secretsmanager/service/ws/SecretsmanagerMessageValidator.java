/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.secretsmanager.service.ws;

import java.util.Map;
import javax.annotation.Nonnull;

import com.eucalyptus.component.annotation.ComponentNamed;
import com.eucalyptus.context.ServiceAdvice;
import com.eucalyptus.secretsmanager.common.msgs.SecretsmanagerMessage;
import com.eucalyptus.secretsmanager.service.SecretsmanagerException;
import com.eucalyptus.secretsmanager.service.SecretsmanagerClientException;

/**
 *
 */
@ComponentNamed
public class SecretsmanagerMessageValidator extends ServiceAdvice {

  @Override
  protected void beforeService( @Nonnull final Object object ) throws SecretsmanagerException {
    // validate message
    if ( object instanceof SecretsmanagerMessage ) {
      final SecretsmanagerMessage request = (SecretsmanagerMessage) object;
      final Map<String,String> validationErrorsByField = request.validate( );
      if ( !validationErrorsByField.isEmpty() ) {
        throw new SecretsmanagerClientException( "ValidationError", validationErrorsByField.values().iterator().next() );
      }
    }
  }
}
