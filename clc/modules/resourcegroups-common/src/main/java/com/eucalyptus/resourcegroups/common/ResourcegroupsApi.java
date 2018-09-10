/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.resourcegroups.common;

import com.eucalyptus.resourcegroups.common.msgs.*;


public interface ResourcegroupsApi {

  CreateGroupResponseType createGroup( final CreateGroupType request );

  DeleteGroupResponseType deleteGroup( final DeleteGroupType request );

  GetGroupResponseType getGroup( final GetGroupType request );

  GetGroupQueryResponseType getGroupQuery( final GetGroupQueryType request );

  GetTagsResponseType getTags( final GetTagsType request );

  ListGroupResourcesResponseType listGroupResources( final ListGroupResourcesType request );

  ListGroupsResponseType listGroups( final ListGroupsType request );

  default ListGroupsResponseType listGroups( ) {
    return listGroups( new ListGroupsType( ) );
  }

  SearchResourcesResponseType searchResources( final SearchResourcesType request );

  TagResponseType tag( final TagType request );

  UntagResponseType untag( final UntagType request );

  UpdateGroupResponseType updateGroup( final UpdateGroupType request );

  UpdateGroupQueryResponseType updateGroupQuery( final UpdateGroupQueryType request );

}
