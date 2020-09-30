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
import com.eucalyptus.util.async.CheckedListenableFuture;


@ComponentPart(Cloudwatchlogs.class)
public interface CloudwatchlogsApiAsync {

  CheckedListenableFuture<AssociateKmsKeyResponseType> associateKmsKeyAsync( final AssociateKmsKeyType request );

  CheckedListenableFuture<CancelExportTaskResponseType> cancelExportTaskAsync( final CancelExportTaskType request );

  CheckedListenableFuture<CreateExportTaskResponseType> createExportTaskAsync( final CreateExportTaskType request );

  CheckedListenableFuture<CreateLogGroupResponseType> createLogGroupAsync( final CreateLogGroupType request );

  CheckedListenableFuture<CreateLogStreamResponseType> createLogStreamAsync( final CreateLogStreamType request );

  CheckedListenableFuture<DeleteDestinationResponseType> deleteDestinationAsync( final DeleteDestinationType request );

  CheckedListenableFuture<DeleteLogGroupResponseType> deleteLogGroupAsync( final DeleteLogGroupType request );

  CheckedListenableFuture<DeleteLogStreamResponseType> deleteLogStreamAsync( final DeleteLogStreamType request );

  CheckedListenableFuture<DeleteMetricFilterResponseType> deleteMetricFilterAsync( final DeleteMetricFilterType request );

  CheckedListenableFuture<DeleteQueryDefinitionResponseType> deleteQueryDefinitionAsync( final DeleteQueryDefinitionType request );

  CheckedListenableFuture<DeleteResourcePolicyResponseType> deleteResourcePolicyAsync( final DeleteResourcePolicyType request );

  default CheckedListenableFuture<DeleteResourcePolicyResponseType> deleteResourcePolicyAsync( ) {
    return deleteResourcePolicyAsync( new DeleteResourcePolicyType( ) );
  }

  CheckedListenableFuture<DeleteRetentionPolicyResponseType> deleteRetentionPolicyAsync( final DeleteRetentionPolicyType request );

  CheckedListenableFuture<DeleteSubscriptionFilterResponseType> deleteSubscriptionFilterAsync( final DeleteSubscriptionFilterType request );

  CheckedListenableFuture<DescribeDestinationsResponseType> describeDestinationsAsync( final DescribeDestinationsType request );

  default CheckedListenableFuture<DescribeDestinationsResponseType> describeDestinationsAsync( ) {
    return describeDestinationsAsync( new DescribeDestinationsType( ) );
  }

  CheckedListenableFuture<DescribeExportTasksResponseType> describeExportTasksAsync( final DescribeExportTasksType request );

  default CheckedListenableFuture<DescribeExportTasksResponseType> describeExportTasksAsync( ) {
    return describeExportTasksAsync( new DescribeExportTasksType( ) );
  }

  CheckedListenableFuture<DescribeLogGroupsResponseType> describeLogGroupsAsync( final DescribeLogGroupsType request );

  default CheckedListenableFuture<DescribeLogGroupsResponseType> describeLogGroupsAsync( ) {
    return describeLogGroupsAsync( new DescribeLogGroupsType( ) );
  }

  CheckedListenableFuture<DescribeLogStreamsResponseType> describeLogStreamsAsync( final DescribeLogStreamsType request );

  CheckedListenableFuture<DescribeMetricFiltersResponseType> describeMetricFiltersAsync( final DescribeMetricFiltersType request );

  default CheckedListenableFuture<DescribeMetricFiltersResponseType> describeMetricFiltersAsync( ) {
    return describeMetricFiltersAsync( new DescribeMetricFiltersType( ) );
  }

  CheckedListenableFuture<DescribeQueriesResponseType> describeQueriesAsync( final DescribeQueriesType request );

  default CheckedListenableFuture<DescribeQueriesResponseType> describeQueriesAsync( ) {
    return describeQueriesAsync( new DescribeQueriesType( ) );
  }

  CheckedListenableFuture<DescribeQueryDefinitionsResponseType> describeQueryDefinitionsAsync( final DescribeQueryDefinitionsType request );

  default CheckedListenableFuture<DescribeQueryDefinitionsResponseType> describeQueryDefinitionsAsync( ) {
    return describeQueryDefinitionsAsync( new DescribeQueryDefinitionsType( ) );
  }

  CheckedListenableFuture<DescribeResourcePoliciesResponseType> describeResourcePoliciesAsync( final DescribeResourcePoliciesType request );

  default CheckedListenableFuture<DescribeResourcePoliciesResponseType> describeResourcePoliciesAsync( ) {
    return describeResourcePoliciesAsync( new DescribeResourcePoliciesType( ) );
  }

  CheckedListenableFuture<DescribeSubscriptionFiltersResponseType> describeSubscriptionFiltersAsync( final DescribeSubscriptionFiltersType request );

  CheckedListenableFuture<DisassociateKmsKeyResponseType> disassociateKmsKeyAsync( final DisassociateKmsKeyType request );

  CheckedListenableFuture<FilterLogEventsResponseType> filterLogEventsAsync( final FilterLogEventsType request );

  CheckedListenableFuture<GetLogEventsResponseType> getLogEventsAsync( final GetLogEventsType request );

  CheckedListenableFuture<GetLogGroupFieldsResponseType> getLogGroupFieldsAsync( final GetLogGroupFieldsType request );

  CheckedListenableFuture<GetLogRecordResponseType> getLogRecordAsync( final GetLogRecordType request );

  CheckedListenableFuture<GetQueryResultsResponseType> getQueryResultsAsync( final GetQueryResultsType request );

  CheckedListenableFuture<ListTagsLogGroupResponseType> listTagsLogGroupAsync( final ListTagsLogGroupType request );

  CheckedListenableFuture<PutDestinationResponseType> putDestinationAsync( final PutDestinationType request );

  CheckedListenableFuture<PutDestinationPolicyResponseType> putDestinationPolicyAsync( final PutDestinationPolicyType request );

  CheckedListenableFuture<PutLogEventsResponseType> putLogEventsAsync( final PutLogEventsType request );

  CheckedListenableFuture<PutMetricFilterResponseType> putMetricFilterAsync( final PutMetricFilterType request );

  CheckedListenableFuture<PutQueryDefinitionResponseType> putQueryDefinitionAsync( final PutQueryDefinitionType request );

  CheckedListenableFuture<PutResourcePolicyResponseType> putResourcePolicyAsync( final PutResourcePolicyType request );

  default CheckedListenableFuture<PutResourcePolicyResponseType> putResourcePolicyAsync( ) {
    return putResourcePolicyAsync( new PutResourcePolicyType( ) );
  }

  CheckedListenableFuture<PutRetentionPolicyResponseType> putRetentionPolicyAsync( final PutRetentionPolicyType request );

  CheckedListenableFuture<PutSubscriptionFilterResponseType> putSubscriptionFilterAsync( final PutSubscriptionFilterType request );

  CheckedListenableFuture<StartQueryResponseType> startQueryAsync( final StartQueryType request );

  CheckedListenableFuture<StopQueryResponseType> stopQueryAsync( final StopQueryType request );

  CheckedListenableFuture<TagLogGroupResponseType> tagLogGroupAsync( final TagLogGroupType request );

  CheckedListenableFuture<TestMetricFilterResponseType> testMetricFilterAsync( final TestMetricFilterType request );

  CheckedListenableFuture<UntagLogGroupResponseType> untagLogGroupAsync( final UntagLogGroupType request );

}
