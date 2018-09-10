/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.resourcegroups.common;

import com.eucalyptus.resourcegroups.common.msgs.*;
import com.eucalyptus.util.async.CheckedListenableFuture;

public interface ResourcegroupsApiAsync {

  CheckedListenableFuture<CreateGroupResponseType> createGroupAsync( final CreateGroupType request );

  CheckedListenableFuture<DeleteGroupResponseType> deleteGroupAsync( final DeleteGroupType request );

  CheckedListenableFuture<GetGroupResponseType> getGroupAsync( final GetGroupType request );

  CheckedListenableFuture<GetGroupQueryResponseType> getGroupQueryAsync( final GetGroupQueryType request );

  CheckedListenableFuture<GetTagsResponseType> getTagsAsync( final GetTagsType request );

  CheckedListenableFuture<ListGroupResourcesResponseType> listGroupResourcesAsync( final ListGroupResourcesType request );

  CheckedListenableFuture<ListGroupsResponseType> listGroupsAsync( final ListGroupsType request );

  default CheckedListenableFuture<ListGroupsResponseType> listGroupsAsync( ) {
    return listGroupsAsync( new ListGroupsType( ) );
  }

  CheckedListenableFuture<SearchResourcesResponseType> searchResourcesAsync( final SearchResourcesType request );

  CheckedListenableFuture<TagResponseType> tagAsync( final TagType request );

  CheckedListenableFuture<UntagResponseType> untagAsync( final UntagType request );

  CheckedListenableFuture<UpdateGroupResponseType> updateGroupAsync( final UpdateGroupType request );

  CheckedListenableFuture<UpdateGroupQueryResponseType> updateGroupQueryAsync( final UpdateGroupQueryType request );

}
