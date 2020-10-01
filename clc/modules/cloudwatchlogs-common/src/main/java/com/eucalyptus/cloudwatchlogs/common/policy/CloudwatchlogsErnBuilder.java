/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudwatchlogs.common.policy;

import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.eucalyptus.auth.policy.ern.Ern;
import com.eucalyptus.auth.policy.ern.ServiceErnBuilder;
import net.sf.json.JSONException;

/**
 *
 */
public class CloudwatchlogsErnBuilder extends ServiceErnBuilder {

  public static final Pattern RESOURCE_PATTERN = Pattern.compile( "([a-z0-9-]+):(\\*|[^:*]{1,512})" );
  public static final Pattern RESOURCE_PATTERN_GROUP = Pattern.compile( "log-group:(?:\\*|[^:*]{1,512}):(log-stream):(\\*|[^:*]{1,512})" );

  public static final int ARN_PATTERNGROUP_LOGS_TYPE = 1;
  public static final int ARN_PATTERNGROUP_LOGS_ID = 2;

  public CloudwatchlogsErnBuilder( ) {
    super(Collections.singleton(CloudwatchlogsPolicySpec.VENDOR_CLOUDWATCHLOGS));
  }

  @Override
  public Ern build(final String ern,
                   final String service,
                   final String region,
                   final String account,
                   final String resource ) throws JSONException {
    final Matcher matcher = RESOURCE_PATTERN.matcher( resource );
    if ( matcher.matches( ) ) {
      String type = matcher.group( ARN_PATTERNGROUP_LOGS_TYPE ).toLowerCase( );
      String id = matcher.group( ARN_PATTERNGROUP_LOGS_ID );
      return new CloudwatchlogsResourceName(region, account, type, id);
    } else {
      final Matcher groupMatcher = RESOURCE_PATTERN_GROUP.matcher(resource);
      if (groupMatcher.matches()) {
        String type = matcher.group(ARN_PATTERNGROUP_LOGS_TYPE).toLowerCase();
        String id = matcher.group(ARN_PATTERNGROUP_LOGS_ID);
        return new CloudwatchlogsResourceName(region, account, type, id);
      }
    }
    throw new JSONException( "'" + ern + "' is not a valid ARN" );
  }
}
