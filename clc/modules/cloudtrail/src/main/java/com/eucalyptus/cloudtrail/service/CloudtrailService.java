/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudtrail.service;

import com.eucalyptus.component.annotation.ComponentNamed;
import com.eucalyptus.cloudtrail.common.msgs.*;

/**
 *
 */
@ComponentNamed
public class CloudtrailService {

  public AddTagsResponseType addTags( final AddTagsType request ) {
    return request.getReply( );
  }
  
  public CreateTrailResponseType createTrail( final CreateTrailType request ) {
    return request.getReply( );
  }
  
  public DeleteTrailResponseType deleteTrail( final DeleteTrailType request ) {
    return request.getReply( );
  }
  
  public DescribeTrailsResponseType describeTrails( final DescribeTrailsType request ) {
    return request.getReply( );
  }
  
  public GetEventSelectorsResponseType getEventSelectors( final GetEventSelectorsType request ) {
    return request.getReply( );
  }
  
  public GetTrailStatusResponseType getTrailStatus( final GetTrailStatusType request ) {
    return request.getReply( );
  }
  
  public ListPublicKeysResponseType listPublicKeys( final ListPublicKeysType request ) {
    return request.getReply( );
  }
  
  public ListTagsResponseType listTags( final ListTagsType request ) {
    return request.getReply( );
  }
  
  public LookupEventsResponseType lookupEvents( final LookupEventsType request ) {
    return request.getReply( );
  }
  
  public PutEventSelectorsResponseType putEventSelectors( final PutEventSelectorsType request ) {
    return request.getReply( );
  }
  
  public RemoveTagsResponseType removeTags( final RemoveTagsType request ) {
    return request.getReply( );
  }
  
  public StartLoggingResponseType startLogging( final StartLoggingType request ) {
    return request.getReply( );
  }
  
  public StopLoggingResponseType stopLogging( final StopLoggingType request ) {
    return request.getReply( );
  }
  
  public UpdateTrailResponseType updateTrail( final UpdateTrailType request ) {
    return request.getReply( );
  }
  
}
