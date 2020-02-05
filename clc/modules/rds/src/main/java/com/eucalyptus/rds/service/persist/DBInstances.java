/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.service.persist;

import java.util.List;
import com.eucalyptus.auth.principal.OwnerFullName;
import com.eucalyptus.entities.AbstractPersistentSupport;
import com.eucalyptus.entities.Entities;
import com.eucalyptus.rds.common.RdsMetadata.DBInstanceMetadata;
import com.eucalyptus.rds.common.RdsMetadatas;
import com.eucalyptus.rds.common.msgs.VpcSecurityGroupMembership;
import com.eucalyptus.rds.common.msgs.VpcSecurityGroupMembershipList;
import com.eucalyptus.rds.service.persist.entities.DBInstance;
import com.eucalyptus.util.TypeMapper;
import com.eucalyptus.util.TypeMappers;
import com.google.common.base.Function;
import com.google.common.base.Predicate;

/**
 *
 */
public interface DBInstances {

  List<DBInstance> deleteByExample(DBInstance example) throws RdsMetadataException;

  <T> List<T> list(OwnerFullName ownerFullName,
                   Predicate<? super DBInstance> filter,
                   Function<? super DBInstance, T> transform) throws RdsMetadataException;

  <T> List<T> listByExample(DBInstance example,
                            Predicate<? super DBInstance> filter,
                            Function<? super DBInstance, T> transform) throws RdsMetadataException;

  <T> T lookupByName(OwnerFullName ownerFullName,
                     String name,
                     Predicate<? super DBInstance> filter,
                     Function<? super DBInstance, T> transform) throws RdsMetadataException;

  <T> T lookupByExample(DBInstance example,
                        OwnerFullName ownerFullName,
                        String name,
                        Predicate<? super DBInstance> filter,
                        Function<? super DBInstance, T> transform) throws RdsMetadataException;

  DBInstance save(DBInstance dbSubnetGroup) throws RdsMetadataException;

  <T> T updateByExample(DBInstance example,
                        OwnerFullName ownerFullName,
                        String desc,
                        Function<? super DBInstance, T> updateTransform) throws RdsMetadataException;

  AbstractPersistentSupport<DBInstanceMetadata, DBInstance, RdsMetadataException> withRetries();

  @TypeMapper
  enum DBInstanceTransform implements Function<DBInstance, com.eucalyptus.rds.common.msgs.DBInstance> {
    INSTANCE;

    @Override
    public com.eucalyptus.rds.common.msgs.DBInstance apply(final DBInstance instance) {
      final com.eucalyptus.rds.common.msgs.DBInstance result = new com.eucalyptus.rds.common.msgs.DBInstance();
      result.setDBInstanceIdentifier(instance.getDisplayName());
      result.setDBInstanceArn(RdsMetadatas.toArn(instance));
      result.setDBInstanceStatus(instance.getState().toString());
      result.setInstanceCreateTime(instance.getCreationTimestamp());
      result.setAllocatedStorage(instance.getAllocatedStorage());
      result.setAvailabilityZone(instance.getAvailabilityZone());
      result.setCopyTagsToSnapshot(instance.getCopyTagsToSnapshot());
      result.setDBInstanceClass(instance.getInstanceClass());
      result.setMasterUsername(instance.getMasterUsername());
      result.setEngine(instance.getEngine());
      result.setEngineVersion(instance.getEngineVersion());
      result.setDBName(instance.getDbName());
      result.setPubliclyAccessible(instance.getPubliclyAccessible());

      if ( Entities.isReadable( instance.getDbSubnetGroup( ) ) ) {
        result.setDBSubnetGroup(TypeMappers.transform(
            instance.getDbSubnetGroup( ),
            com.eucalyptus.rds.common.msgs.DBSubnetGroup.class ) );
      }

      if ( Entities.isReadable( instance.getVpcSecurityGroups( ) ) ) {
        final VpcSecurityGroupMembershipList list = new VpcSecurityGroupMembershipList();
        for ( final String securityGroupId : instance.getVpcSecurityGroups( ) ) {
          final VpcSecurityGroupMembership item = new VpcSecurityGroupMembership();
          item.setStatus("active");
          item.setVpcSecurityGroupId(securityGroupId);
          list.getMember().add(item);
        }
        result.setVpcSecurityGroups(list);
      }

      // hard-code some items we do not support
      result.setAutoMinorVersionUpgrade(false);
      result.setBackupRetentionPeriod(0);
      result.setDeletionProtection(false);
      result.setIAMDatabaseAuthenticationEnabled(false);
      result.setMultiAZ(false);
      result.setPerformanceInsightsEnabled(false);
      result.setStorageEncrypted(false);

      return result;
    }
  }
}
