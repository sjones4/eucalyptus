/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudtrail.common;

import com.eucalyptus.cloudtrail.common.msgs.*;


public interface CloudtrailApi {

  AddTagsResponseType addTags( final AddTagsType request );

  CreateTrailResponseType createTrail( final CreateTrailType request );

  DeleteTrailResponseType deleteTrail( final DeleteTrailType request );

  DescribeTrailsResponseType describeTrails( final DescribeTrailsType request );

  default DescribeTrailsResponseType describeTrails( ) {
    return describeTrails( new DescribeTrailsType( ) );
  }

  GetEventSelectorsResponseType getEventSelectors( final GetEventSelectorsType request );

  GetTrailStatusResponseType getTrailStatus( final GetTrailStatusType request );

  ListPublicKeysResponseType listPublicKeys( final ListPublicKeysType request );

  default ListPublicKeysResponseType listPublicKeys( ) {
    return listPublicKeys( new ListPublicKeysType( ) );
  }

  ListTagsResponseType listTags( final ListTagsType request );

  LookupEventsResponseType lookupEvents( final LookupEventsType request );

  default LookupEventsResponseType lookupEvents( ) {
    return lookupEvents( new LookupEventsType( ) );
  }

  PutEventSelectorsResponseType putEventSelectors( final PutEventSelectorsType request );

  RemoveTagsResponseType removeTags( final RemoveTagsType request );

  StartLoggingResponseType startLogging( final StartLoggingType request );

  StopLoggingResponseType stopLogging( final StopLoggingType request );

  UpdateTrailResponseType updateTrail( final UpdateTrailType request );

}
