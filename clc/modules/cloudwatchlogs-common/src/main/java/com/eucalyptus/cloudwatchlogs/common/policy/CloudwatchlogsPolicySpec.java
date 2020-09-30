/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudwatchlogs.common.policy;

/**
 *
 */
public interface CloudwatchlogsPolicySpec {

  // Vendor
  String VENDOR_CLOUDWATCHLOGS = "logs";

  // Actions
  String CLOUDWATCHLOGS_ASSOCIATEKMSKEY = "associatekmskey";
  String CLOUDWATCHLOGS_CANCELEXPORTTASK = "cancelexporttask";
  String CLOUDWATCHLOGS_CREATEEXPORTTASK = "createexporttask";
  String CLOUDWATCHLOGS_CREATELOGGROUP = "createloggroup";
  String CLOUDWATCHLOGS_CREATELOGSTREAM = "createlogstream";
  String CLOUDWATCHLOGS_DELETEDESTINATION = "deletedestination";
  String CLOUDWATCHLOGS_DELETELOGGROUP = "deleteloggroup";
  String CLOUDWATCHLOGS_DELETELOGSTREAM = "deletelogstream";
  String CLOUDWATCHLOGS_DELETEMETRICFILTER = "deletemetricfilter";
  String CLOUDWATCHLOGS_DELETEQUERYDEFINITION = "deletequerydefinition";
  String CLOUDWATCHLOGS_DELETERESOURCEPOLICY = "deleteresourcepolicy";
  String CLOUDWATCHLOGS_DELETERETENTIONPOLICY = "deleteretentionpolicy";
  String CLOUDWATCHLOGS_DELETESUBSCRIPTIONFILTER = "deletesubscriptionfilter";
  String CLOUDWATCHLOGS_DESCRIBEDESTINATIONS = "describedestinations";
  String CLOUDWATCHLOGS_DESCRIBEEXPORTTASKS = "describeexporttasks";
  String CLOUDWATCHLOGS_DESCRIBELOGGROUPS = "describeloggroups";
  String CLOUDWATCHLOGS_DESCRIBELOGSTREAMS = "describelogstreams";
  String CLOUDWATCHLOGS_DESCRIBEMETRICFILTERS = "describemetricfilters";
  String CLOUDWATCHLOGS_DESCRIBEQUERIES = "describequeries";
  String CLOUDWATCHLOGS_DESCRIBEQUERYDEFINITIONS = "describequerydefinitions";
  String CLOUDWATCHLOGS_DESCRIBERESOURCEPOLICIES = "describeresourcepolicies";
  String CLOUDWATCHLOGS_DESCRIBESUBSCRIPTIONFILTERS = "describesubscriptionfilters";
  String CLOUDWATCHLOGS_DISASSOCIATEKMSKEY = "disassociatekmskey";
  String CLOUDWATCHLOGS_FILTERLOGEVENTS = "filterlogevents";
  String CLOUDWATCHLOGS_GETLOGEVENTS = "getlogevents";
  String CLOUDWATCHLOGS_GETLOGGROUPFIELDS = "getloggroupfields";
  String CLOUDWATCHLOGS_GETLOGRECORD = "getlogrecord";
  String CLOUDWATCHLOGS_GETQUERYRESULTS = "getqueryresults";
  String CLOUDWATCHLOGS_LISTTAGSLOGGROUP = "listtagsloggroup";
  String CLOUDWATCHLOGS_PUTDESTINATION = "putdestination";
  String CLOUDWATCHLOGS_PUTDESTINATIONPOLICY = "putdestinationpolicy";
  String CLOUDWATCHLOGS_PUTLOGEVENTS = "putlogevents";
  String CLOUDWATCHLOGS_PUTMETRICFILTER = "putmetricfilter";
  String CLOUDWATCHLOGS_PUTQUERYDEFINITION = "putquerydefinition";
  String CLOUDWATCHLOGS_PUTRESOURCEPOLICY = "putresourcepolicy";
  String CLOUDWATCHLOGS_PUTRETENTIONPOLICY = "putretentionpolicy";
  String CLOUDWATCHLOGS_PUTSUBSCRIPTIONFILTER = "putsubscriptionfilter";
  String CLOUDWATCHLOGS_STARTQUERY = "startquery";
  String CLOUDWATCHLOGS_STOPQUERY = "stopquery";
  String CLOUDWATCHLOGS_TAGLOGGROUP = "tagloggroup";
  String CLOUDWATCHLOGS_TESTMETRICFILTER = "testmetricfilter";
  String CLOUDWATCHLOGS_UNTAGLOGGROUP = "untagloggroup";

}
