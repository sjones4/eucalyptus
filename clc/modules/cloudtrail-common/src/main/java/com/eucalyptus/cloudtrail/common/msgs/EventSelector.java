/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudtrail.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;
import javax.annotation.Nonnull;
import com.eucalyptus.cloudtrail.common.CloudtrailMessageValidation.FieldRange;
import com.eucalyptus.cloudtrail.common.CloudtrailMessageValidation.FieldRegex;
import com.eucalyptus.cloudtrail.common.CloudtrailMessageValidation.FieldRegexValue;


public class EventSelector extends EucalyptusData {

  private java.util.ArrayList<DataResource> dataResources;
  private Boolean includeManagementEvents;
  @FieldRegex(FieldRegexValue.ENUM_READWRITETYPE)
  private String readWriteType;

  public java.util.ArrayList<DataResource> getDataResources( ) {
    return dataResources;
  }

  public void setDataResources( final java.util.ArrayList<DataResource> dataResources ) {
    this.dataResources = dataResources;
  }

  public Boolean getIncludeManagementEvents( ) {
    return includeManagementEvents;
  }

  public void setIncludeManagementEvents( final Boolean includeManagementEvents ) {
    this.includeManagementEvents = includeManagementEvents;
  }

  public String getReadWriteType( ) {
    return readWriteType;
  }

  public void setReadWriteType( final String readWriteType ) {
    this.readWriteType = readWriteType;
  }

}
