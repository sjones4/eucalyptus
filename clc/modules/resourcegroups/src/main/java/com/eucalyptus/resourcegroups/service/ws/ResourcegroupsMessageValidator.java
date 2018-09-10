/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.resourcegroups.service.ws;

import java.util.Map;
import javax.annotation.Nonnull;

import com.eucalyptus.component.annotation.ComponentNamed;
import com.eucalyptus.context.ServiceAdvice;
import com.eucalyptus.resourcegroups.common.msgs.ResourcegroupsMessage;
import com.eucalyptus.resourcegroups.service.ResourcegroupsException;
import com.eucalyptus.resourcegroups.service.ResourcegroupsClientException;

/**
 *
 */
@ComponentNamed
public class ResourcegroupsMessageValidator extends ServiceAdvice {

  @Override
  protected void beforeService( @Nonnull final Object object ) throws ResourcegroupsException {
    // validate message
    if ( object instanceof ResourcegroupsMessage ) {
      final ResourcegroupsMessage request = (ResourcegroupsMessage) object;
      final Map<String,String> validationErrorsByField = request.validate( );
      if ( !validationErrorsByField.isEmpty() ) {
        throw new ResourcegroupsClientException( "ValidationError", validationErrorsByField.values().iterator().next() );
      }
    }
  }
}
