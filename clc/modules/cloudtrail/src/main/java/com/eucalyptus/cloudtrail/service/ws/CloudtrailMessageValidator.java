/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudtrail.service.ws;

import java.util.Map;
import javax.annotation.Nonnull;

import com.eucalyptus.component.annotation.ComponentNamed;
import com.eucalyptus.context.ServiceAdvice;
import com.eucalyptus.cloudtrail.common.msgs.CloudtrailMessage;
import com.eucalyptus.cloudtrail.service.CloudtrailException;
import com.eucalyptus.cloudtrail.service.CloudtrailClientException;

/**
 *
 */
@ComponentNamed
public class CloudtrailMessageValidator extends ServiceAdvice {

  @Override
  protected void beforeService( @Nonnull final Object object ) throws CloudtrailException {
    // validate message
    if ( object instanceof CloudtrailMessage ) {
      final CloudtrailMessage request = (CloudtrailMessage) object;
      final Map<String,String> validationErrorsByField = request.validate( );
      if ( !validationErrorsByField.isEmpty() ) {
        throw new CloudtrailClientException( "ValidationError", validationErrorsByField.values().iterator().next() );
      }
    }
  }
}
