/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudwatchlogs.service.ws;

import org.apache.log4j.Logger;
import com.eucalyptus.cloudwatchlogs.common.msgs.ErrorResponse;
import com.eucalyptus.component.annotation.ComponentNamed;
import com.eucalyptus.ws.Role;
import com.eucalyptus.ws.util.ErrorHandlerSupport;
import edu.ucsb.eucalyptus.msgs.BaseMessage;

/**
 *
 */
@ComponentNamed
public class CloudwatchlogsErrorHandler extends ErrorHandlerSupport {
  private static final Logger LOG = Logger.getLogger( CloudwatchlogsErrorHandler.class );
  private static final String INTERNAL_FAILURE = "InternalFailure";

  public CloudwatchlogsErrorHandler() {
    super( LOG, "", INTERNAL_FAILURE );
  }

  @Override
  protected BaseMessage buildErrorResponse( final String correlationId,
                                            final Role role,
                                            final String code,
                                            final String message ) {
    final ErrorResponse errorResp = new ErrorResponse( );
    errorResp.setCorrelationId( correlationId );
    errorResp.setRequestId( correlationId );
    final com.eucalyptus.cloudwatchlogs.common.msgs.Error error = new com.eucalyptus.cloudwatchlogs.common.msgs.Error( );
    error.setType( role == Role.Receiver ? "Receiver" : "Sender" );
    error.setCode( code );
    error.setMessage( message );
    errorResp.getError().add( error );
    return errorResp;
  }
}
