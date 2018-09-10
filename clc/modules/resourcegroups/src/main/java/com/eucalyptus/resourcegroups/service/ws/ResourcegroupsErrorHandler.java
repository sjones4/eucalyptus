/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.resourcegroups.service.ws;

import org.apache.log4j.Logger;
import com.eucalyptus.resourcegroups.common.msgs.ErrorResponse;
import com.eucalyptus.component.annotation.ComponentNamed;
import com.eucalyptus.ws.Role;
import com.eucalyptus.ws.util.ErrorHandlerSupport;
import edu.ucsb.eucalyptus.msgs.BaseMessage;

/**
 *
 */
@ComponentNamed
public class ResourcegroupsErrorHandler extends ErrorHandlerSupport {
  private static final Logger LOG = Logger.getLogger( ResourcegroupsErrorHandler.class );
  private static final String INTERNAL_FAILURE = "InternalFailure";

  public ResourcegroupsErrorHandler() {
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
    final com.eucalyptus.resourcegroups.common.msgs.Error error = new com.eucalyptus.resourcegroups.common.msgs.Error( );
    error.setType( role == Role.Receiver ? "Receiver" : "Sender" );
    error.setCode( code );
    error.setMessage( message );
    errorResp.getError().add( error );
    return errorResp;
  }
}
