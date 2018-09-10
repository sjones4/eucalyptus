/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.resourcegroups.common.policy;

/**
 *
 */
public interface ResourcegroupsPolicySpec {

  // Vendor
  String VENDOR_RESOURCEGROUPS = "resource-groups";

  // Actions
  String RESOURCEGROUPS_CREATEGROUP = "creategroup";
  String RESOURCEGROUPS_DELETEGROUP = "deletegroup";
  String RESOURCEGROUPS_GETGROUP = "getgroup";
  String RESOURCEGROUPS_GETGROUPQUERY = "getgroupquery";
  String RESOURCEGROUPS_GETTAGS = "gettags";
  String RESOURCEGROUPS_LISTGROUPRESOURCES = "listgroupresources";
  String RESOURCEGROUPS_LISTGROUPS = "listgroups";
  String RESOURCEGROUPS_SEARCHRESOURCES = "searchresources";
  String RESOURCEGROUPS_TAG = "tag";
  String RESOURCEGROUPS_UNTAG = "untag";
  String RESOURCEGROUPS_UPDATEGROUP = "updategroup";
  String RESOURCEGROUPS_UPDATEGROUPQUERY = "updategroupquery";

}
