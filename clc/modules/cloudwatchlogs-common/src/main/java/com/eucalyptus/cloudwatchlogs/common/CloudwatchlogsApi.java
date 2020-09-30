/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudwatchlogs.common;

import com.eucalyptus.component.annotation.ComponentPart;
import com.eucalyptus.cloudwatchlogs.common.msgs.*;


@ComponentPart(Cloudwatchlogs.class)
public interface CloudwatchlogsApi {

  AssociateKmsKeyResponseType associateKmsKey( final AssociateKmsKeyType request );

  CancelExportTaskResponseType cancelExportTask( final CancelExportTaskType request );

  CreateExportTaskResponseType createExportTask( final CreateExportTaskType request );

  CreateLogGroupResponseType createLogGroup( final CreateLogGroupType request );

  CreateLogStreamResponseType createLogStream( final CreateLogStreamType request );

  DeleteDestinationResponseType deleteDestination( final DeleteDestinationType request );

  DeleteLogGroupResponseType deleteLogGroup( final DeleteLogGroupType request );

  DeleteLogStreamResponseType deleteLogStream( final DeleteLogStreamType request );

  DeleteMetricFilterResponseType deleteMetricFilter( final DeleteMetricFilterType request );

  DeleteQueryDefinitionResponseType deleteQueryDefinition( final DeleteQueryDefinitionType request );

  DeleteResourcePolicyResponseType deleteResourcePolicy( final DeleteResourcePolicyType request );

  default DeleteResourcePolicyResponseType deleteResourcePolicy( ) {
    return deleteResourcePolicy( new DeleteResourcePolicyType( ) );
  }

  DeleteRetentionPolicyResponseType deleteRetentionPolicy( final DeleteRetentionPolicyType request );

  DeleteSubscriptionFilterResponseType deleteSubscriptionFilter( final DeleteSubscriptionFilterType request );

  DescribeDestinationsResponseType describeDestinations( final DescribeDestinationsType request );

  default DescribeDestinationsResponseType describeDestinations( ) {
    return describeDestinations( new DescribeDestinationsType( ) );
  }

  DescribeExportTasksResponseType describeExportTasks( final DescribeExportTasksType request );

  default DescribeExportTasksResponseType describeExportTasks( ) {
    return describeExportTasks( new DescribeExportTasksType( ) );
  }

  DescribeLogGroupsResponseType describeLogGroups( final DescribeLogGroupsType request );

  default DescribeLogGroupsResponseType describeLogGroups( ) {
    return describeLogGroups( new DescribeLogGroupsType( ) );
  }

  DescribeLogStreamsResponseType describeLogStreams( final DescribeLogStreamsType request );

  DescribeMetricFiltersResponseType describeMetricFilters( final DescribeMetricFiltersType request );

  default DescribeMetricFiltersResponseType describeMetricFilters( ) {
    return describeMetricFilters( new DescribeMetricFiltersType( ) );
  }

  DescribeQueriesResponseType describeQueries( final DescribeQueriesType request );

  default DescribeQueriesResponseType describeQueries( ) {
    return describeQueries( new DescribeQueriesType( ) );
  }

  DescribeQueryDefinitionsResponseType describeQueryDefinitions( final DescribeQueryDefinitionsType request );

  default DescribeQueryDefinitionsResponseType describeQueryDefinitions( ) {
    return describeQueryDefinitions( new DescribeQueryDefinitionsType( ) );
  }

  DescribeResourcePoliciesResponseType describeResourcePolicies( final DescribeResourcePoliciesType request );

  default DescribeResourcePoliciesResponseType describeResourcePolicies( ) {
    return describeResourcePolicies( new DescribeResourcePoliciesType( ) );
  }

  DescribeSubscriptionFiltersResponseType describeSubscriptionFilters( final DescribeSubscriptionFiltersType request );

  DisassociateKmsKeyResponseType disassociateKmsKey( final DisassociateKmsKeyType request );

  FilterLogEventsResponseType filterLogEvents( final FilterLogEventsType request );

  GetLogEventsResponseType getLogEvents( final GetLogEventsType request );

  GetLogGroupFieldsResponseType getLogGroupFields( final GetLogGroupFieldsType request );

  GetLogRecordResponseType getLogRecord( final GetLogRecordType request );

  GetQueryResultsResponseType getQueryResults( final GetQueryResultsType request );

  ListTagsLogGroupResponseType listTagsLogGroup( final ListTagsLogGroupType request );

  PutDestinationResponseType putDestination( final PutDestinationType request );

  PutDestinationPolicyResponseType putDestinationPolicy( final PutDestinationPolicyType request );

  PutLogEventsResponseType putLogEvents( final PutLogEventsType request );

  PutMetricFilterResponseType putMetricFilter( final PutMetricFilterType request );

  PutQueryDefinitionResponseType putQueryDefinition( final PutQueryDefinitionType request );

  PutResourcePolicyResponseType putResourcePolicy( final PutResourcePolicyType request );

  default PutResourcePolicyResponseType putResourcePolicy( ) {
    return putResourcePolicy( new PutResourcePolicyType( ) );
  }

  PutRetentionPolicyResponseType putRetentionPolicy( final PutRetentionPolicyType request );

  PutSubscriptionFilterResponseType putSubscriptionFilter( final PutSubscriptionFilterType request );

  StartQueryResponseType startQuery( final StartQueryType request );

  StopQueryResponseType stopQuery( final StopQueryType request );

  TagLogGroupResponseType tagLogGroup( final TagLogGroupType request );

  TestMetricFilterResponseType testMetricFilter( final TestMetricFilterType request );

  UntagLogGroupResponseType untagLogGroup( final UntagLogGroupType request );

}
