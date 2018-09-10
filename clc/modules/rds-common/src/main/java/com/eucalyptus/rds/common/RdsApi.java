/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common;

import com.eucalyptus.rds.common.msgs.*;


public interface RdsApi {

  AddRoleToDBClusterResponseType addRoleToDBCluster( final AddRoleToDBClusterType request );

  AddSourceIdentifierToSubscriptionResponseType addSourceIdentifierToSubscription( final AddSourceIdentifierToSubscriptionType request );

  AddTagsToResourceResponseType addTagsToResource( final AddTagsToResourceType request );

  ApplyPendingMaintenanceActionResponseType applyPendingMaintenanceAction( final ApplyPendingMaintenanceActionType request );

  AuthorizeDBSecurityGroupIngressResponseType authorizeDBSecurityGroupIngress( final AuthorizeDBSecurityGroupIngressType request );

  BacktrackDBClusterResponseType backtrackDBCluster( final BacktrackDBClusterType request );

  CopyDBClusterParameterGroupResponseType copyDBClusterParameterGroup( final CopyDBClusterParameterGroupType request );

  CopyDBClusterSnapshotResponseType copyDBClusterSnapshot( final CopyDBClusterSnapshotType request );

  CopyDBParameterGroupResponseType copyDBParameterGroup( final CopyDBParameterGroupType request );

  CopyDBSnapshotResponseType copyDBSnapshot( final CopyDBSnapshotType request );

  CopyOptionGroupResponseType copyOptionGroup( final CopyOptionGroupType request );

  CreateDBClusterResponseType createDBCluster( final CreateDBClusterType request );

  CreateDBClusterParameterGroupResponseType createDBClusterParameterGroup( final CreateDBClusterParameterGroupType request );

  CreateDBClusterSnapshotResponseType createDBClusterSnapshot( final CreateDBClusterSnapshotType request );

  CreateDBInstanceResponseType createDBInstance( final CreateDBInstanceType request );

  CreateDBInstanceReadReplicaResponseType createDBInstanceReadReplica( final CreateDBInstanceReadReplicaType request );

  CreateDBParameterGroupResponseType createDBParameterGroup( final CreateDBParameterGroupType request );

  CreateDBSecurityGroupResponseType createDBSecurityGroup( final CreateDBSecurityGroupType request );

  CreateDBSnapshotResponseType createDBSnapshot( final CreateDBSnapshotType request );

  CreateDBSubnetGroupResponseType createDBSubnetGroup( final CreateDBSubnetGroupType request );

  CreateEventSubscriptionResponseType createEventSubscription( final CreateEventSubscriptionType request );

  CreateOptionGroupResponseType createOptionGroup( final CreateOptionGroupType request );

  DeleteDBClusterResponseType deleteDBCluster( final DeleteDBClusterType request );

  DeleteDBClusterParameterGroupResponseType deleteDBClusterParameterGroup( final DeleteDBClusterParameterGroupType request );

  DeleteDBClusterSnapshotResponseType deleteDBClusterSnapshot( final DeleteDBClusterSnapshotType request );

  DeleteDBInstanceResponseType deleteDBInstance( final DeleteDBInstanceType request );

  DeleteDBParameterGroupResponseType deleteDBParameterGroup( final DeleteDBParameterGroupType request );

  DeleteDBSecurityGroupResponseType deleteDBSecurityGroup( final DeleteDBSecurityGroupType request );

  DeleteDBSnapshotResponseType deleteDBSnapshot( final DeleteDBSnapshotType request );

  DeleteDBSubnetGroupResponseType deleteDBSubnetGroup( final DeleteDBSubnetGroupType request );

  DeleteEventSubscriptionResponseType deleteEventSubscription( final DeleteEventSubscriptionType request );

  DeleteOptionGroupResponseType deleteOptionGroup( final DeleteOptionGroupType request );

  DescribeAccountAttributesResponseType describeAccountAttributes( final DescribeAccountAttributesType request );

  default DescribeAccountAttributesResponseType describeAccountAttributes( ) {
    return describeAccountAttributes( new DescribeAccountAttributesType( ) );
  }

  DescribeCertificatesResponseType describeCertificates( final DescribeCertificatesType request );

  default DescribeCertificatesResponseType describeCertificates( ) {
    return describeCertificates( new DescribeCertificatesType( ) );
  }

  DescribeDBClusterBacktracksResponseType describeDBClusterBacktracks( final DescribeDBClusterBacktracksType request );

  DescribeDBClusterParameterGroupsResponseType describeDBClusterParameterGroups( final DescribeDBClusterParameterGroupsType request );

  default DescribeDBClusterParameterGroupsResponseType describeDBClusterParameterGroups( ) {
    return describeDBClusterParameterGroups( new DescribeDBClusterParameterGroupsType( ) );
  }

  DescribeDBClusterParametersResponseType describeDBClusterParameters( final DescribeDBClusterParametersType request );

  DescribeDBClusterSnapshotAttributesResponseType describeDBClusterSnapshotAttributes( final DescribeDBClusterSnapshotAttributesType request );

  DescribeDBClusterSnapshotsResponseType describeDBClusterSnapshots( final DescribeDBClusterSnapshotsType request );

  default DescribeDBClusterSnapshotsResponseType describeDBClusterSnapshots( ) {
    return describeDBClusterSnapshots( new DescribeDBClusterSnapshotsType( ) );
  }

  DescribeDBClustersResponseType describeDBClusters( final DescribeDBClustersType request );

  default DescribeDBClustersResponseType describeDBClusters( ) {
    return describeDBClusters( new DescribeDBClustersType( ) );
  }

  DescribeDBEngineVersionsResponseType describeDBEngineVersions( final DescribeDBEngineVersionsType request );

  default DescribeDBEngineVersionsResponseType describeDBEngineVersions( ) {
    return describeDBEngineVersions( new DescribeDBEngineVersionsType( ) );
  }

  DescribeDBInstancesResponseType describeDBInstances( final DescribeDBInstancesType request );

  default DescribeDBInstancesResponseType describeDBInstances( ) {
    return describeDBInstances( new DescribeDBInstancesType( ) );
  }

  DescribeDBLogFilesResponseType describeDBLogFiles( final DescribeDBLogFilesType request );

  DescribeDBParameterGroupsResponseType describeDBParameterGroups( final DescribeDBParameterGroupsType request );

  default DescribeDBParameterGroupsResponseType describeDBParameterGroups( ) {
    return describeDBParameterGroups( new DescribeDBParameterGroupsType( ) );
  }

  DescribeDBParametersResponseType describeDBParameters( final DescribeDBParametersType request );

  DescribeDBSecurityGroupsResponseType describeDBSecurityGroups( final DescribeDBSecurityGroupsType request );

  default DescribeDBSecurityGroupsResponseType describeDBSecurityGroups( ) {
    return describeDBSecurityGroups( new DescribeDBSecurityGroupsType( ) );
  }

  DescribeDBSnapshotAttributesResponseType describeDBSnapshotAttributes( final DescribeDBSnapshotAttributesType request );

  DescribeDBSnapshotsResponseType describeDBSnapshots( final DescribeDBSnapshotsType request );

  default DescribeDBSnapshotsResponseType describeDBSnapshots( ) {
    return describeDBSnapshots( new DescribeDBSnapshotsType( ) );
  }

  DescribeDBSubnetGroupsResponseType describeDBSubnetGroups( final DescribeDBSubnetGroupsType request );

  default DescribeDBSubnetGroupsResponseType describeDBSubnetGroups( ) {
    return describeDBSubnetGroups( new DescribeDBSubnetGroupsType( ) );
  }

  DescribeEngineDefaultClusterParametersResponseType describeEngineDefaultClusterParameters( final DescribeEngineDefaultClusterParametersType request );

  DescribeEngineDefaultParametersResponseType describeEngineDefaultParameters( final DescribeEngineDefaultParametersType request );

  DescribeEventCategoriesResponseType describeEventCategories( final DescribeEventCategoriesType request );

  default DescribeEventCategoriesResponseType describeEventCategories( ) {
    return describeEventCategories( new DescribeEventCategoriesType( ) );
  }

  DescribeEventSubscriptionsResponseType describeEventSubscriptions( final DescribeEventSubscriptionsType request );

  default DescribeEventSubscriptionsResponseType describeEventSubscriptions( ) {
    return describeEventSubscriptions( new DescribeEventSubscriptionsType( ) );
  }

  DescribeEventsResponseType describeEvents( final DescribeEventsType request );

  default DescribeEventsResponseType describeEvents( ) {
    return describeEvents( new DescribeEventsType( ) );
  }

  DescribeOptionGroupOptionsResponseType describeOptionGroupOptions( final DescribeOptionGroupOptionsType request );

  DescribeOptionGroupsResponseType describeOptionGroups( final DescribeOptionGroupsType request );

  default DescribeOptionGroupsResponseType describeOptionGroups( ) {
    return describeOptionGroups( new DescribeOptionGroupsType( ) );
  }

  DescribeOrderableDBInstanceOptionsResponseType describeOrderableDBInstanceOptions( final DescribeOrderableDBInstanceOptionsType request );

  DescribePendingMaintenanceActionsResponseType describePendingMaintenanceActions( final DescribePendingMaintenanceActionsType request );

  default DescribePendingMaintenanceActionsResponseType describePendingMaintenanceActions( ) {
    return describePendingMaintenanceActions( new DescribePendingMaintenanceActionsType( ) );
  }

  DescribeReservedDBInstancesResponseType describeReservedDBInstances( final DescribeReservedDBInstancesType request );

  default DescribeReservedDBInstancesResponseType describeReservedDBInstances( ) {
    return describeReservedDBInstances( new DescribeReservedDBInstancesType( ) );
  }

  DescribeReservedDBInstancesOfferingsResponseType describeReservedDBInstancesOfferings( final DescribeReservedDBInstancesOfferingsType request );

  default DescribeReservedDBInstancesOfferingsResponseType describeReservedDBInstancesOfferings( ) {
    return describeReservedDBInstancesOfferings( new DescribeReservedDBInstancesOfferingsType( ) );
  }

  DescribeSourceRegionsResponseType describeSourceRegions( final DescribeSourceRegionsType request );

  default DescribeSourceRegionsResponseType describeSourceRegions( ) {
    return describeSourceRegions( new DescribeSourceRegionsType( ) );
  }

  DescribeValidDBInstanceModificationsResponseType describeValidDBInstanceModifications( final DescribeValidDBInstanceModificationsType request );

  DownloadDBLogFilePortionResponseType downloadDBLogFilePortion( final DownloadDBLogFilePortionType request );

  FailoverDBClusterResponseType failoverDBCluster( final FailoverDBClusterType request );

  default FailoverDBClusterResponseType failoverDBCluster( ) {
    return failoverDBCluster( new FailoverDBClusterType( ) );
  }

  ListTagsForResourceResponseType listTagsForResource( final ListTagsForResourceType request );

  ModifyCurrentDBClusterCapacityResponseType modifyCurrentDBClusterCapacity( final ModifyCurrentDBClusterCapacityType request );

  ModifyDBClusterResponseType modifyDBCluster( final ModifyDBClusterType request );

  ModifyDBClusterParameterGroupResponseType modifyDBClusterParameterGroup( final ModifyDBClusterParameterGroupType request );

  ModifyDBClusterSnapshotAttributeResponseType modifyDBClusterSnapshotAttribute( final ModifyDBClusterSnapshotAttributeType request );

  ModifyDBInstanceResponseType modifyDBInstance( final ModifyDBInstanceType request );

  ModifyDBParameterGroupResponseType modifyDBParameterGroup( final ModifyDBParameterGroupType request );

  ModifyDBSnapshotResponseType modifyDBSnapshot( final ModifyDBSnapshotType request );

  ModifyDBSnapshotAttributeResponseType modifyDBSnapshotAttribute( final ModifyDBSnapshotAttributeType request );

  ModifyDBSubnetGroupResponseType modifyDBSubnetGroup( final ModifyDBSubnetGroupType request );

  ModifyEventSubscriptionResponseType modifyEventSubscription( final ModifyEventSubscriptionType request );

  ModifyOptionGroupResponseType modifyOptionGroup( final ModifyOptionGroupType request );

  PromoteReadReplicaResponseType promoteReadReplica( final PromoteReadReplicaType request );

  PromoteReadReplicaDBClusterResponseType promoteReadReplicaDBCluster( final PromoteReadReplicaDBClusterType request );

  PurchaseReservedDBInstancesOfferingResponseType purchaseReservedDBInstancesOffering( final PurchaseReservedDBInstancesOfferingType request );

  RebootDBInstanceResponseType rebootDBInstance( final RebootDBInstanceType request );

  RemoveRoleFromDBClusterResponseType removeRoleFromDBCluster( final RemoveRoleFromDBClusterType request );

  RemoveSourceIdentifierFromSubscriptionResponseType removeSourceIdentifierFromSubscription( final RemoveSourceIdentifierFromSubscriptionType request );

  RemoveTagsFromResourceResponseType removeTagsFromResource( final RemoveTagsFromResourceType request );

  ResetDBClusterParameterGroupResponseType resetDBClusterParameterGroup( final ResetDBClusterParameterGroupType request );

  ResetDBParameterGroupResponseType resetDBParameterGroup( final ResetDBParameterGroupType request );

  RestoreDBClusterFromS3ResponseType restoreDBClusterFromS3( final RestoreDBClusterFromS3Type request );

  RestoreDBClusterFromSnapshotResponseType restoreDBClusterFromSnapshot( final RestoreDBClusterFromSnapshotType request );

  RestoreDBClusterToPointInTimeResponseType restoreDBClusterToPointInTime( final RestoreDBClusterToPointInTimeType request );

  RestoreDBInstanceFromDBSnapshotResponseType restoreDBInstanceFromDBSnapshot( final RestoreDBInstanceFromDBSnapshotType request );

  RestoreDBInstanceFromS3ResponseType restoreDBInstanceFromS3( final RestoreDBInstanceFromS3Type request );

  RestoreDBInstanceToPointInTimeResponseType restoreDBInstanceToPointInTime( final RestoreDBInstanceToPointInTimeType request );

  RevokeDBSecurityGroupIngressResponseType revokeDBSecurityGroupIngress( final RevokeDBSecurityGroupIngressType request );

  StartDBInstanceResponseType startDBInstance( final StartDBInstanceType request );

  StopDBInstanceResponseType stopDBInstance( final StopDBInstanceType request );

}
