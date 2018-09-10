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



public class DescribeReservedDBInstancesType extends RdsMessage {

  private String dBInstanceClass;
  private String duration;
  private FilterList filters;
  private String marker;
  private Integer maxRecords;
  private Boolean multiAZ;
  private String offeringType;
  private String productDescription;
  private String reservedDBInstanceId;
  private String reservedDBInstancesOfferingId;

  public String getDBInstanceClass( ) {
    return dBInstanceClass;
  }

  public void setDBInstanceClass( final String dBInstanceClass ) {
    this.dBInstanceClass = dBInstanceClass;
  }

  public String getDuration( ) {
    return duration;
  }

  public void setDuration( final String duration ) {
    this.duration = duration;
  }

  public FilterList getFilters( ) {
    return filters;
  }

  public void setFilters( final FilterList filters ) {
    this.filters = filters;
  }

  public String getMarker( ) {
    return marker;
  }

  public void setMarker( final String marker ) {
    this.marker = marker;
  }

  public Integer getMaxRecords( ) {
    return maxRecords;
  }

  public void setMaxRecords( final Integer maxRecords ) {
    this.maxRecords = maxRecords;
  }

  public Boolean getMultiAZ( ) {
    return multiAZ;
  }

  public void setMultiAZ( final Boolean multiAZ ) {
    this.multiAZ = multiAZ;
  }

  public String getOfferingType( ) {
    return offeringType;
  }

  public void setOfferingType( final String offeringType ) {
    this.offeringType = offeringType;
  }

  public String getProductDescription( ) {
    return productDescription;
  }

  public void setProductDescription( final String productDescription ) {
    this.productDescription = productDescription;
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

}
