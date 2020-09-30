/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudwatchlogs.service;

import com.eucalyptus.component.annotation.ComponentNamed;
import com.eucalyptus.cloudwatchlogs.common.msgs.*;

/**
 *
 */
@ComponentNamed
public class CloudwatchlogsService {

  public AssociateKmsKeyResponseType associateKmsKey( final AssociateKmsKeyType request ) {
    return request.getReply( );
  }
  
  public CancelExportTaskResponseType cancelExportTask( final CancelExportTaskType request ) {
    return request.getReply( );
  }
  
  public CreateExportTaskResponseType createExportTask( final CreateExportTaskType request ) {
    return request.getReply( );
  }
  
  public CreateLogGroupResponseType createLogGroup( final CreateLogGroupType request ) {
    return request.getReply( );
  }
  
  public CreateLogStreamResponseType createLogStream( final CreateLogStreamType request ) {
    return request.getReply( );
  }
  
  public DeleteDestinationResponseType deleteDestination( final DeleteDestinationType request ) {
    return request.getReply( );
  }
  
  public DeleteLogGroupResponseType deleteLogGroup( final DeleteLogGroupType request ) {
    return request.getReply( );
  }
  
  public DeleteLogStreamResponseType deleteLogStream( final DeleteLogStreamType request ) {
    return request.getReply( );
  }
  
  public DeleteMetricFilterResponseType deleteMetricFilter( final DeleteMetricFilterType request ) {
    return request.getReply( );
  }
  
  public DeleteQueryDefinitionResponseType deleteQueryDefinition( final DeleteQueryDefinitionType request ) {
    return request.getReply( );
  }
  
  public DeleteResourcePolicyResponseType deleteResourcePolicy( final DeleteResourcePolicyType request ) {
    return request.getReply( );
  }
  
  public DeleteRetentionPolicyResponseType deleteRetentionPolicy( final DeleteRetentionPolicyType request ) {
    return request.getReply( );
  }
  
  public DeleteSubscriptionFilterResponseType deleteSubscriptionFilter( final DeleteSubscriptionFilterType request ) {
    return request.getReply( );
  }
  
  public DescribeDestinationsResponseType describeDestinations( final DescribeDestinationsType request ) {
    return request.getReply( );
  }
  
  public DescribeExportTasksResponseType describeExportTasks( final DescribeExportTasksType request ) {
    return request.getReply( );
  }
  
  public DescribeLogGroupsResponseType describeLogGroups( final DescribeLogGroupsType request ) {
    return request.getReply( );
  }
  
  public DescribeLogStreamsResponseType describeLogStreams( final DescribeLogStreamsType request ) {
    return request.getReply( );
  }
  
  public DescribeMetricFiltersResponseType describeMetricFilters( final DescribeMetricFiltersType request ) {
    return request.getReply( );
  }
  
  public DescribeQueriesResponseType describeQueries( final DescribeQueriesType request ) {
    return request.getReply( );
  }
  
  public DescribeQueryDefinitionsResponseType describeQueryDefinitions( final DescribeQueryDefinitionsType request ) {
    return request.getReply( );
  }
  
  public DescribeResourcePoliciesResponseType describeResourcePolicies( final DescribeResourcePoliciesType request ) {
    return request.getReply( );
  }
  
  public DescribeSubscriptionFiltersResponseType describeSubscriptionFilters( final DescribeSubscriptionFiltersType request ) {
    return request.getReply( );
  }
  
  public DisassociateKmsKeyResponseType disassociateKmsKey( final DisassociateKmsKeyType request ) {
    return request.getReply( );
  }
  
  public FilterLogEventsResponseType filterLogEvents( final FilterLogEventsType request ) {
    return request.getReply( );
  }
  
  public GetLogEventsResponseType getLogEvents( final GetLogEventsType request ) {
    return request.getReply( );
  }
  
  public GetLogGroupFieldsResponseType getLogGroupFields( final GetLogGroupFieldsType request ) {
    return request.getReply( );
  }
  
  public GetLogRecordResponseType getLogRecord( final GetLogRecordType request ) {
    return request.getReply( );
  }
  
  public GetQueryResultsResponseType getQueryResults( final GetQueryResultsType request ) {
    return request.getReply( );
  }
  
  public ListTagsLogGroupResponseType listTagsLogGroup( final ListTagsLogGroupType request ) {
    return request.getReply( );
  }
  
  public PutDestinationResponseType putDestination( final PutDestinationType request ) {
    return request.getReply( );
  }
  
  public PutDestinationPolicyResponseType putDestinationPolicy( final PutDestinationPolicyType request ) {
    return request.getReply( );
  }
  
  public PutLogEventsResponseType putLogEvents( final PutLogEventsType request ) {
    return request.getReply( );
  }
  
  public PutMetricFilterResponseType putMetricFilter( final PutMetricFilterType request ) {
    return request.getReply( );
  }
  
  public PutQueryDefinitionResponseType putQueryDefinition( final PutQueryDefinitionType request ) {
    return request.getReply( );
  }
  
  public PutResourcePolicyResponseType putResourcePolicy( final PutResourcePolicyType request ) {
    return request.getReply( );
  }
  
  public PutRetentionPolicyResponseType putRetentionPolicy( final PutRetentionPolicyType request ) {
    return request.getReply( );
  }
  
  public PutSubscriptionFilterResponseType putSubscriptionFilter( final PutSubscriptionFilterType request ) {
    return request.getReply( );
  }
  
  public StartQueryResponseType startQuery( final StartQueryType request ) {
    return request.getReply( );
  }
  
  public StopQueryResponseType stopQuery( final StopQueryType request ) {
    return request.getReply( );
  }
  
  public TagLogGroupResponseType tagLogGroup( final TagLogGroupType request ) {
    return request.getReply( );
  }
  
  public TestMetricFilterResponseType testMetricFilter( final TestMetricFilterType request ) {
    return request.getReply( );
  }
  
  public UntagLogGroupResponseType untagLogGroup( final UntagLogGroupType request ) {
    return request.getReply( );
  }
  
}
