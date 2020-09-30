/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudwatchlogs.service.ws;

import java.util.Map;
import javax.annotation.Nonnull;

import com.eucalyptus.component.annotation.ComponentNamed;
import com.eucalyptus.context.ServiceAdvice;
import com.eucalyptus.cloudwatchlogs.common.msgs.CloudwatchlogsMessage;
import com.eucalyptus.cloudwatchlogs.service.CloudwatchlogsException;
import com.eucalyptus.cloudwatchlogs.service.CloudwatchlogsClientException;

/**
 *
 */
@ComponentNamed
public class CloudwatchlogsMessageValidator extends ServiceAdvice {

  @Override
  protected void beforeService( @Nonnull final Object object ) throws CloudwatchlogsException {
    // validate message
    if ( object instanceof CloudwatchlogsMessage ) {
      final CloudwatchlogsMessage request = (CloudwatchlogsMessage) object;
      final Map<String,String> validationErrorsByField = request.validate( );
      if ( !validationErrorsByField.isEmpty() ) {
        throw new CloudwatchlogsClientException( "ValidationError", validationErrorsByField.values().iterator().next() );
      }
    }
  }
}
