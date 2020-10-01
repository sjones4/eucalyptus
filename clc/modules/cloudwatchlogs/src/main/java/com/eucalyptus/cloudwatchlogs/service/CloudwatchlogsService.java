/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudwatchlogs.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import com.eucalyptus.component.annotation.ComponentNamed;
import com.eucalyptus.cloudwatchlogs.common.msgs.*;
import com.eucalyptus.context.Context;
import com.eucalyptus.context.Contexts;
import com.eucalyptus.util.Strings;
import com.google.common.collect.Ordering;
import com.google.common.collect.Sets;

/**
 *
 */
@ComponentNamed
public class CloudwatchlogsService {

  private static final int MAX_EVENTS_PER_STREAM = 1_000;

  private static final ConcurrentHashMap<String, ConcurrentHashMap<String, ConcurrentHashMap<String,ArrayList<InputLogEvent>>>> GROUPS_BY_ACCOUNT
      = new ConcurrentHashMap<>();

  private static ConcurrentHashMap<String, ConcurrentHashMap<String,ArrayList<InputLogEvent>>> groups() {
    final Context context = Contexts.lookup();
    final String accountNumber = context.getAccountNumber();
    return GROUPS_BY_ACCOUNT.computeIfAbsent(accountNumber, __ -> new ConcurrentHashMap<>());
  }

  private static ConcurrentHashMap<String,ArrayList<InputLogEvent>> streams(final String group) {
    final ConcurrentHashMap<String, ConcurrentHashMap<String,ArrayList<InputLogEvent>>> groups = groups();
    return groups.computeIfAbsent(group, __ -> new ConcurrentHashMap<>());
  }

  private static ArrayList<InputLogEvent> stream(final String group, final String stream) {
    final ConcurrentHashMap<String,ArrayList<InputLogEvent>> streams = streams(group);
    return streams.computeIfAbsent(stream, __ -> new ArrayList<>(MAX_EVENTS_PER_STREAM));
  }

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
    streams(request.getLogGroupName());
    return request.getReply( );
  }
  
  public CreateLogStreamResponseType createLogStream( final CreateLogStreamType request ) {
    stream(request.getLogGroupName(), request.getLogStreamName());
    return request.getReply( );
  }
  
  public DeleteDestinationResponseType deleteDestination( final DeleteDestinationType request ) {
    return request.getReply( );
  }
  
  public DeleteLogGroupResponseType deleteLogGroup( final DeleteLogGroupType request ) {
    groups().remove(request.getLogGroupName());
    return request.getReply( );
  }
  
  public DeleteLogStreamResponseType deleteLogStream( final DeleteLogStreamType request ) {
    streams(request.getLogGroupName()).remove(request.getLogStreamName());
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
    final DescribeLogGroupsResponseType response = request.getReply( );
    final ArrayList<LogGroup> groups = new ArrayList<>();
    for ( final String groupKey : groups().keySet() ) {
      final LogGroup group = new LogGroup();
      group.setCreationTime(System.currentTimeMillis());
      group.setLogGroupName(groupKey);
      group.setArn("arn:" + groupKey);
      group.setMetricFilterCount(0);
      group.setRetentionInDays(7);
      group.setStoredBytes(123L);
      groups.add(group);
    }
    response.setLogGroups(groups);
    return response;
  }
  
  public DescribeLogStreamsResponseType describeLogStreams( final DescribeLogStreamsType request ) {
    final DescribeLogStreamsResponseType response = request.getReply( );
    final ArrayList<LogStream> streams = new ArrayList<>();
    for ( final String streamKey : streams(request.getLogGroupName()).keySet() ) {
      final LogStream stream = new LogStream();
      stream.setCreationTime(System.currentTimeMillis());
      stream.setArn("arn:" + streamKey);
      stream.setStoredBytes(123L);
      stream.setLogStreamName(streamKey);
      stream.setUploadSequenceToken("0");
      streams.add(stream);
    }
    response.setLogStreams(streams);
    return response;
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
    final FilterLogEventsResponseType response = request.getReply( );
    final String streamPrefix = Objects.toString(request.getLogStreamNamePrefix(), "");
    final Set<String> streamNames = request.getLogStreamNames()==null ?
        Collections.emptySet() :
        Sets.newHashSet(request.getLogStreamNames());
    final ArrayList<SearchedLogStream> streams = new ArrayList<>();
    final ArrayList<FilteredLogEvent> events = new ArrayList<>();
    for ( final Map.Entry<String,ArrayList<InputLogEvent>> streamEntry : streams(request.getLogGroupName()).entrySet( ) ) {
      final String streamKey = streamEntry.getKey();
      if ( !streamNames.isEmpty() && !streamNames.contains(streamKey) ) continue;
      if ( !streamKey.startsWith(streamPrefix)) continue;

      final SearchedLogStream stream = new SearchedLogStream();
      stream.setLogStreamName(streamKey);
      stream.setSearchedCompletely(true);
      streams.add(stream);

      for ( final InputLogEvent ievent : streamEntry.getValue() ) {
        if (( request.getStartTime()==null || request.getStartTime() <= ievent.getTimestamp( ) ) &&
            ( request.getEndTime()==null || request.getEndTime( ) > ievent.getTimestamp( ) ) ) {
          final FilteredLogEvent fevent = new FilteredLogEvent();
          fevent.setEventId(Strings.toString(Objects.hash(ievent.getMessage(), ievent.getTimestamp())));
          fevent.setLogStreamName(streamKey);
          fevent.setIngestionTime(ievent.getTimestamp());
          fevent.setTimestamp(ievent.getTimestamp());
          fevent.setMessage(ievent.getMessage());
          events.add(fevent);
        }
      }
    }
    events.sort(Ordering.natural().onResultOf(FilteredLogEvent::getTimestamp));
    response.setEvents(events);
    response.setSearchedLogStreams(streams);
    return response;
  }
  
  public GetLogEventsResponseType getLogEvents( final GetLogEventsType request ) {
    final GetLogEventsResponseType response = request.getReply();
    final ArrayList<OutputLogEvent> events = new ArrayList<>();
    for ( final InputLogEvent ievent : stream(request.getLogGroupName(), request.getLogStreamName()) ) {
      if (( request.getStartTime()==null || request.getStartTime() <= ievent.getTimestamp( ) ) &&
          ( request.getEndTime()==null || request.getEndTime( ) > ievent.getTimestamp( ) ) ) {
        final OutputLogEvent oevent = new OutputLogEvent();
        oevent.setIngestionTime(ievent.getTimestamp());
        oevent.setTimestamp(ievent.getTimestamp());
        oevent.setMessage(ievent.getMessage());
        events.add(oevent);
      }
    }
    response.setEvents(events);
    return response;
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
    final ArrayList<InputLogEvent> store = stream(request.getLogGroupName(), request.getLogStreamName() );
    final ArrayList<InputLogEvent> events = request.getLogEvents();
    if ( store.size() + events.size() > MAX_EVENTS_PER_STREAM ) {
      store.subList(0, Math.min(store.size(), (store.size() + events.size()) - MAX_EVENTS_PER_STREAM)).clear();
    }
    store.addAll(events.subList(Math.max(0, events.size() - MAX_EVENTS_PER_STREAM), events.size()));
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
