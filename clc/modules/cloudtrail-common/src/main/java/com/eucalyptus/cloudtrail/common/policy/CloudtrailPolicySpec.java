/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudtrail.common.policy;

/**
 *
 */
public interface CloudtrailPolicySpec {

  // Vendor
  String VENDOR_CLOUDTRAIL = "cloudtrail";

  // Actions
  String CLOUDTRAIL_ADDTAGS = "addtags";
  String CLOUDTRAIL_CREATETRAIL = "createtrail";
  String CLOUDTRAIL_DELETETRAIL = "deletetrail";
  String CLOUDTRAIL_DESCRIBETRAILS = "describetrails";
  String CLOUDTRAIL_GETEVENTSELECTORS = "geteventselectors";
  String CLOUDTRAIL_GETTRAILSTATUS = "gettrailstatus";
  String CLOUDTRAIL_LISTPUBLICKEYS = "listpublickeys";
  String CLOUDTRAIL_LISTTAGS = "listtags";
  String CLOUDTRAIL_LOOKUPEVENTS = "lookupevents";
  String CLOUDTRAIL_PUTEVENTSELECTORS = "puteventselectors";
  String CLOUDTRAIL_REMOVETAGS = "removetags";
  String CLOUDTRAIL_STARTLOGGING = "startlogging";
  String CLOUDTRAIL_STOPLOGGING = "stoplogging";
  String CLOUDTRAIL_UPDATETRAIL = "updatetrail";

}
