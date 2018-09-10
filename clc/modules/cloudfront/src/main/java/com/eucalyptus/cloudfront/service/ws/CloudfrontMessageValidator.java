/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudfront.service.ws;

import java.util.Map;
import javax.annotation.Nonnull;

import com.eucalyptus.component.annotation.ComponentNamed;
import com.eucalyptus.context.ServiceAdvice;
import com.eucalyptus.cloudfront.common.msgs.CloudfrontMessage;
import com.eucalyptus.cloudfront.service.CloudfrontException;
import com.eucalyptus.cloudfront.service.CloudfrontClientException;

/**
 *
 */
@ComponentNamed
public class CloudfrontMessageValidator extends ServiceAdvice {

  @Override
  protected void beforeService( @Nonnull final Object object ) throws CloudfrontException {
    // validate message
    if ( object instanceof CloudfrontMessage ) {
      final CloudfrontMessage request = (CloudfrontMessage) object;
      final Map<String,String> validationErrorsByField = request.validate( );
      if ( !validationErrorsByField.isEmpty() ) {
        throw new CloudfrontClientException( "ValidationError", validationErrorsByField.values().iterator().next() );
      }
    }
  }
}
