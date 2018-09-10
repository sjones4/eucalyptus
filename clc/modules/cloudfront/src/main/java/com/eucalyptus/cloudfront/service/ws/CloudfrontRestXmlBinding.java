/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudfront.service.ws;

import javax.annotation.Nonnull;
import com.eucalyptus.component.annotation.ComponentPart;
import com.eucalyptus.cloudfront.common.Cloudfront;
import com.eucalyptus.cloudfront.common.msgs.ErrorResponse;
import com.eucalyptus.cloudfront.service.config.CloudfrontConfiguration;
import com.eucalyptus.ws.protocol.BaseRestXmlBinding;

/**
 *
 */
@ComponentPart( Cloudfront.class )
public class CloudfrontRestXmlBinding extends BaseRestXmlBinding<ErrorResponse> {
  //TODO verify namespace pattern is correct for ns http://cloudfront.amazonaws.com/doc/2018-06-18/
  static final String NAMESPACE_PATTERN = "http://cloudfront.amazonaws.com/doc/%s/";
  static final String DEFAULT_VERSION = "2018-06-18";
  static final String DEFAULT_NAMESPACE = String.format( NAMESPACE_PATTERN, DEFAULT_VERSION );

  public CloudfrontRestXmlBinding() {
    super( NAMESPACE_PATTERN, DEFAULT_VERSION, CloudfrontConfiguration.SERVICE_PATH, true );
  }

  @Override
  protected ErrorResponse errorResponse(
               final String requestId,
      @Nonnull final String type,
      @Nonnull final String code,
      @Nonnull final String message ) {
    final ErrorResponse errorResponse = new ErrorResponse( );
    errorResponse.setRequestId( requestId );
    final com.eucalyptus.cloudfront.common.msgs.Error error = new com.eucalyptus.cloudfront.common.msgs.Error();
    error.setType( type );
    error.setCode( code );
    error.setMessage( message );
    errorResponse.getError( ).add( error );
    return errorResponse;
  }
}
