/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import javax.annotation.Nonnull;
import com.eucalyptus.binding.HttpContent;
import com.eucalyptus.binding.HttpNoContent;
import com.eucalyptus.binding.HttpHeaderMapping;
import com.eucalyptus.binding.HttpParameterMapping;
import com.eucalyptus.binding.HttpRequestMapping;
import com.eucalyptus.binding.HttpUriMapping;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRange;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRegex;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRegexValue;



public class PurchaseReservedDBInstancesOfferingType extends RdsMessage {

  private Integer dBInstanceCount;
  private String reservedDBInstanceId;
  @Nonnull
  private String reservedDBInstancesOfferingId;
  private TagList tags;

  public Integer getDBInstanceCount( ) {
    return dBInstanceCount;
  }

  public void setDBInstanceCount( final Integer dBInstanceCount ) {
    this.dBInstanceCount = dBInstanceCount;
  }

  public String getReservedDBInstanceId( ) {
    return reservedDBInstanceId;
  }

  public void setReservedDBInstanceId( final String reservedDBInstanceId ) {
    this.reservedDBInstanceId = reservedDBInstanceId;
  }

  public String getReservedDBInstancesOfferingId( ) {
    return reservedDBInstancesOfferingId;
  }

  public void setReservedDBInstancesOfferingId( final String reservedDBInstancesOfferingId ) {
    this.reservedDBInstancesOfferingId = reservedDBInstancesOfferingId;
  }

  public TagList getTags( ) {
    return tags;
  }

  public void setTags( final TagList tags ) {
    this.tags = tags;
  }

}
