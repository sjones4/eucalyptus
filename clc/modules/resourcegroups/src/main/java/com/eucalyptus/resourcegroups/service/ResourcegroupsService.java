/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.resourcegroups.service;

import com.eucalyptus.component.annotation.ComponentNamed;
import com.eucalyptus.resourcegroups.common.msgs.*;

/**
 *
 */
@ComponentNamed
public class ResourcegroupsService {

  public CreateGroupResponseType createGroup( final CreateGroupType request ) {
    return request.getReply( );
  }
  
  public DeleteGroupResponseType deleteGroup( final DeleteGroupType request ) {
    return request.getReply( );
  }
  
  public GetGroupResponseType getGroup( final GetGroupType request ) {
    return request.getReply( );
  }
  
  public GetGroupQueryResponseType getGroupQuery( final GetGroupQueryType request ) {
    return request.getReply( );
  }
  
  public GetTagsResponseType getTags( final GetTagsType request ) {
    return request.getReply( );
  }
  
  public ListGroupResourcesResponseType listGroupResources( final ListGroupResourcesType request ) {
    return request.getReply( );
  }
  
  public ListGroupsResponseType listGroups( final ListGroupsType request ) {
    return request.getReply( );
  }
  
  public SearchResourcesResponseType searchResources( final SearchResourcesType request ) {
    return request.getReply( );
  }
  
  public TagResponseType tag( final TagType request ) {
    return request.getReply( );
  }
  
  public UntagResponseType untag( final UntagType request ) {
    return request.getReply( );
  }
  
  public UpdateGroupResponseType updateGroup( final UpdateGroupType request ) {
    return request.getReply( );
  }
  
  public UpdateGroupQueryResponseType updateGroupQuery( final UpdateGroupQueryType request ) {
    return request.getReply( );
  }
  
}
