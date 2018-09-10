/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.policy;

/**
 *
 */
public interface RdsPolicySpec {

  // Vendor
  String VENDOR_RDS = "rds";

  // Actions
  String RDS_ADDROLETODBCLUSTER = "addroletodbcluster";
  String RDS_ADDSOURCEIDENTIFIERTOSUBSCRIPTION = "addsourceidentifiertosubscription";
  String RDS_ADDTAGSTORESOURCE = "addtagstoresource";
  String RDS_APPLYPENDINGMAINTENANCEACTION = "applypendingmaintenanceaction";
  String RDS_AUTHORIZEDBSECURITYGROUPINGRESS = "authorizedbsecuritygroupingress";
  String RDS_BACKTRACKDBCLUSTER = "backtrackdbcluster";
  String RDS_COPYDBCLUSTERPARAMETERGROUP = "copydbclusterparametergroup";
  String RDS_COPYDBCLUSTERSNAPSHOT = "copydbclustersnapshot";
  String RDS_COPYDBPARAMETERGROUP = "copydbparametergroup";
  String RDS_COPYDBSNAPSHOT = "copydbsnapshot";
  String RDS_COPYOPTIONGROUP = "copyoptiongroup";
  String RDS_CREATEDBCLUSTER = "createdbcluster";
  String RDS_CREATEDBCLUSTERPARAMETERGROUP = "createdbclusterparametergroup";
  String RDS_CREATEDBCLUSTERSNAPSHOT = "createdbclustersnapshot";
  String RDS_CREATEDBINSTANCE = "createdbinstance";
  String RDS_CREATEDBINSTANCEREADREPLICA = "createdbinstancereadreplica";
  String RDS_CREATEDBPARAMETERGROUP = "createdbparametergroup";
  String RDS_CREATEDBSECURITYGROUP = "createdbsecuritygroup";
  String RDS_CREATEDBSNAPSHOT = "createdbsnapshot";
  String RDS_CREATEDBSUBNETGROUP = "createdbsubnetgroup";
  String RDS_CREATEEVENTSUBSCRIPTION = "createeventsubscription";
  String RDS_CREATEOPTIONGROUP = "createoptiongroup";
  String RDS_DELETEDBCLUSTER = "deletedbcluster";
  String RDS_DELETEDBCLUSTERPARAMETERGROUP = "deletedbclusterparametergroup";
  String RDS_DELETEDBCLUSTERSNAPSHOT = "deletedbclustersnapshot";
  String RDS_DELETEDBINSTANCE = "deletedbinstance";
  String RDS_DELETEDBPARAMETERGROUP = "deletedbparametergroup";
  String RDS_DELETEDBSECURITYGROUP = "deletedbsecuritygroup";
  String RDS_DELETEDBSNAPSHOT = "deletedbsnapshot";
  String RDS_DELETEDBSUBNETGROUP = "deletedbsubnetgroup";
  String RDS_DELETEEVENTSUBSCRIPTION = "deleteeventsubscription";
  String RDS_DELETEOPTIONGROUP = "deleteoptiongroup";
  String RDS_DESCRIBEACCOUNTATTRIBUTES = "describeaccountattributes";
  String RDS_DESCRIBECERTIFICATES = "describecertificates";
  String RDS_DESCRIBEDBCLUSTERBACKTRACKS = "describedbclusterbacktracks";
  String RDS_DESCRIBEDBCLUSTERPARAMETERGROUPS = "describedbclusterparametergroups";
  String RDS_DESCRIBEDBCLUSTERPARAMETERS = "describedbclusterparameters";
  String RDS_DESCRIBEDBCLUSTERSNAPSHOTATTRIBUTES = "describedbclustersnapshotattributes";
  String RDS_DESCRIBEDBCLUSTERSNAPSHOTS = "describedbclustersnapshots";
  String RDS_DESCRIBEDBCLUSTERS = "describedbclusters";
  String RDS_DESCRIBEDBENGINEVERSIONS = "describedbengineversions";
  String RDS_DESCRIBEDBINSTANCES = "describedbinstances";
  String RDS_DESCRIBEDBLOGFILES = "describedblogfiles";
  String RDS_DESCRIBEDBPARAMETERGROUPS = "describedbparametergroups";
  String RDS_DESCRIBEDBPARAMETERS = "describedbparameters";
  String RDS_DESCRIBEDBSECURITYGROUPS = "describedbsecuritygroups";
  String RDS_DESCRIBEDBSNAPSHOTATTRIBUTES = "describedbsnapshotattributes";
  String RDS_DESCRIBEDBSNAPSHOTS = "describedbsnapshots";
  String RDS_DESCRIBEDBSUBNETGROUPS = "describedbsubnetgroups";
  String RDS_DESCRIBEENGINEDEFAULTCLUSTERPARAMETERS = "describeenginedefaultclusterparameters";
  String RDS_DESCRIBEENGINEDEFAULTPARAMETERS = "describeenginedefaultparameters";
  String RDS_DESCRIBEEVENTCATEGORIES = "describeeventcategories";
  String RDS_DESCRIBEEVENTSUBSCRIPTIONS = "describeeventsubscriptions";
  String RDS_DESCRIBEEVENTS = "describeevents";
  String RDS_DESCRIBEOPTIONGROUPOPTIONS = "describeoptiongroupoptions";
  String RDS_DESCRIBEOPTIONGROUPS = "describeoptiongroups";
  String RDS_DESCRIBEORDERABLEDBINSTANCEOPTIONS = "describeorderabledbinstanceoptions";
  String RDS_DESCRIBEPENDINGMAINTENANCEACTIONS = "describependingmaintenanceactions";
  String RDS_DESCRIBERESERVEDDBINSTANCES = "describereserveddbinstances";
  String RDS_DESCRIBERESERVEDDBINSTANCESOFFERINGS = "describereserveddbinstancesofferings";
  String RDS_DESCRIBESOURCEREGIONS = "describesourceregions";
  String RDS_DESCRIBEVALIDDBINSTANCEMODIFICATIONS = "describevaliddbinstancemodifications";
  String RDS_DOWNLOADDBLOGFILEPORTION = "downloaddblogfileportion";
  String RDS_FAILOVERDBCLUSTER = "failoverdbcluster";
  String RDS_LISTTAGSFORRESOURCE = "listtagsforresource";
  String RDS_MODIFYCURRENTDBCLUSTERCAPACITY = "modifycurrentdbclustercapacity";
  String RDS_MODIFYDBCLUSTER = "modifydbcluster";
  String RDS_MODIFYDBCLUSTERPARAMETERGROUP = "modifydbclusterparametergroup";
  String RDS_MODIFYDBCLUSTERSNAPSHOTATTRIBUTE = "modifydbclustersnapshotattribute";
  String RDS_MODIFYDBINSTANCE = "modifydbinstance";
  String RDS_MODIFYDBPARAMETERGROUP = "modifydbparametergroup";
  String RDS_MODIFYDBSNAPSHOT = "modifydbsnapshot";
  String RDS_MODIFYDBSNAPSHOTATTRIBUTE = "modifydbsnapshotattribute";
  String RDS_MODIFYDBSUBNETGROUP = "modifydbsubnetgroup";
  String RDS_MODIFYEVENTSUBSCRIPTION = "modifyeventsubscription";
  String RDS_MODIFYOPTIONGROUP = "modifyoptiongroup";
  String RDS_PROMOTEREADREPLICA = "promotereadreplica";
  String RDS_PROMOTEREADREPLICADBCLUSTER = "promotereadreplicadbcluster";
  String RDS_PURCHASERESERVEDDBINSTANCESOFFERING = "purchasereserveddbinstancesoffering";
  String RDS_REBOOTDBINSTANCE = "rebootdbinstance";
  String RDS_REMOVEROLEFROMDBCLUSTER = "removerolefromdbcluster";
  String RDS_REMOVESOURCEIDENTIFIERFROMSUBSCRIPTION = "removesourceidentifierfromsubscription";
  String RDS_REMOVETAGSFROMRESOURCE = "removetagsfromresource";
  String RDS_RESETDBCLUSTERPARAMETERGROUP = "resetdbclusterparametergroup";
  String RDS_RESETDBPARAMETERGROUP = "resetdbparametergroup";
  String RDS_RESTOREDBCLUSTERFROMS3 = "restoredbclusterfroms3";
  String RDS_RESTOREDBCLUSTERFROMSNAPSHOT = "restoredbclusterfromsnapshot";
  String RDS_RESTOREDBCLUSTERTOPOINTINTIME = "restoredbclustertopointintime";
  String RDS_RESTOREDBINSTANCEFROMDBSNAPSHOT = "restoredbinstancefromdbsnapshot";
  String RDS_RESTOREDBINSTANCEFROMS3 = "restoredbinstancefroms3";
  String RDS_RESTOREDBINSTANCETOPOINTINTIME = "restoredbinstancetopointintime";
  String RDS_REVOKEDBSECURITYGROUPINGRESS = "revokedbsecuritygroupingress";
  String RDS_STARTDBINSTANCE = "startdbinstance";
  String RDS_STOPDBINSTANCE = "stopdbinstance";

}
