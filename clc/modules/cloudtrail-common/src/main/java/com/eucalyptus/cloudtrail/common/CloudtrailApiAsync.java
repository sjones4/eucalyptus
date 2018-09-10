/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudtrail.common;

import com.eucalyptus.cloudtrail.common.msgs.*;
import com.eucalyptus.util.async.CheckedListenableFuture;

public interface CloudtrailApiAsync {

  CheckedListenableFuture<AddTagsResponseType> addTagsAsync( final AddTagsType request );

  CheckedListenableFuture<CreateTrailResponseType> createTrailAsync( final CreateTrailType request );

  CheckedListenableFuture<DeleteTrailResponseType> deleteTrailAsync( final DeleteTrailType request );

  CheckedListenableFuture<DescribeTrailsResponseType> describeTrailsAsync( final DescribeTrailsType request );

  default CheckedListenableFuture<DescribeTrailsResponseType> describeTrailsAsync( ) {
    return describeTrailsAsync( new DescribeTrailsType( ) );
  }

  CheckedListenableFuture<GetEventSelectorsResponseType> getEventSelectorsAsync( final GetEventSelectorsType request );

  CheckedListenableFuture<GetTrailStatusResponseType> getTrailStatusAsync( final GetTrailStatusType request );

  CheckedListenableFuture<ListPublicKeysResponseType> listPublicKeysAsync( final ListPublicKeysType request );

  default CheckedListenableFuture<ListPublicKeysResponseType> listPublicKeysAsync( ) {
    return listPublicKeysAsync( new ListPublicKeysType( ) );
  }

  CheckedListenableFuture<ListTagsResponseType> listTagsAsync( final ListTagsType request );

  CheckedListenableFuture<LookupEventsResponseType> lookupEventsAsync( final LookupEventsType request );

  default CheckedListenableFuture<LookupEventsResponseType> lookupEventsAsync( ) {
    return lookupEventsAsync( new LookupEventsType( ) );
  }

  CheckedListenableFuture<PutEventSelectorsResponseType> putEventSelectorsAsync( final PutEventSelectorsType request );

  CheckedListenableFuture<RemoveTagsResponseType> removeTagsAsync( final RemoveTagsType request );

  CheckedListenableFuture<StartLoggingResponseType> startLoggingAsync( final StartLoggingType request );

  CheckedListenableFuture<StopLoggingResponseType> stopLoggingAsync( final StopLoggingType request );

  CheckedListenableFuture<UpdateTrailResponseType> updateTrailAsync( final UpdateTrailType request );

}
