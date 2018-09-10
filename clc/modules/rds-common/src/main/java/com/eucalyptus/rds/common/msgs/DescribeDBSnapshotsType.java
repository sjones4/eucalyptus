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



public class DescribeDBSnapshotsType extends RdsMessage {

  private String dBInstanceIdentifier;
  private String dBSnapshotIdentifier;
  private FilterList filters;
  private Boolean includePublic;
  private Boolean includeShared;
  private String marker;
  private Integer maxRecords;
  private String snapshotType;

  public String getDBInstanceIdentifier( ) {
    return dBInstanceIdentifier;
  }

  public void setDBInstanceIdentifier( final String dBInstanceIdentifier ) {
    this.dBInstanceIdentifier = dBInstanceIdentifier;
  }

  public String getDBSnapshotIdentifier( ) {
    return dBSnapshotIdentifier;
  }

  public void setDBSnapshotIdentifier( final String dBSnapshotIdentifier ) {
    this.dBSnapshotIdentifier = dBSnapshotIdentifier;
  }

  public FilterList getFilters( ) {
    return filters;
  }

  public void setFilters( final FilterList filters ) {
    this.filters = filters;
  }

  public Boolean getIncludePublic( ) {
    return includePublic;
  }

  public void setIncludePublic( final Boolean includePublic ) {
    this.includePublic = includePublic;
  }

  public Boolean getIncludeShared( ) {
    return includeShared;
  }

  public void setIncludeShared( final Boolean includeShared ) {
    this.includeShared = includeShared;
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

  public String getSnapshotType( ) {
    return snapshotType;
  }

  public void setSnapshotType( final String snapshotType ) {
    this.snapshotType = snapshotType;
  }

}
