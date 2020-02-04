/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.service.persist.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;
import com.eucalyptus.entities.AbstractPersistent;

/**
 *
 */
@Entity
@PersistenceContext( name = "eucalyptus_rds" )
@Table( name = "rds_db_subnet", indexes = {
    @Index( name = "rds_db_subnet_id_idx", columnList = "rds_db_subnet_group_id" )
} )
public class DBSubnet extends AbstractPersistent {
  private static final long serialVersionUID = 1L;

  public enum Status {
    Active,
  }

  @ManyToOne
  @JoinColumn( name = "rds_db_subnet_group_id", nullable = false, updatable = false )
  private DBSubnetGroup dbSubnetGroup;

  @Column( name = "rds_db_status", nullable = false )
  @Enumerated( EnumType.STRING )
  private Status status;

  @Column( name = "rds_db_subnet_id", nullable = false, updatable = false )
  private String subnetId;

  @Column( name = "rds_db_zone", nullable = false, updatable = false )
  private String availabilityZone;

  public static DBSubnet create(
      final DBSubnetGroup dbSubnetGroup,
      final String subnetId,
      final String availabilityZone
  ) {
    final DBSubnet subnet = new DBSubnet();
    subnet.setDbSubnetGroup(dbSubnetGroup);
    subnet.setSubnetId(subnetId);
    subnet.setAvailabilityZone(availabilityZone);
    subnet.setStatus(Status.Active);
    return subnet;
  }

  public DBSubnetGroup getDbSubnetGroup() {
    return dbSubnetGroup;
  }

  public void setDbSubnetGroup(final DBSubnetGroup dbSubnetGroup) {
    this.dbSubnetGroup = dbSubnetGroup;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(final Status status) {
    this.status = status;
  }

  public String getSubnetId() {
    return subnetId;
  }

  public void setSubnetId(final String subnetId) {
    this.subnetId = subnetId;
  }

  public String getAvailabilityZone() {
    return availabilityZone;
  }

  public void setAvailabilityZone(final String availabilityZone) {
    this.availabilityZone = availabilityZone;
  }
}
