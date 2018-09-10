/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;
import javax.annotation.Nonnull;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRange;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRegex;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRegexValue;


public class SourceRegion extends EucalyptusData {

  private String endpoint;
  private String regionName;
  private String status;

  public String getEndpoint( ) {
    return endpoint;
  }

  public void setEndpoint( final String endpoint ) {
    this.endpoint = endpoint;
  }

  public String getRegionName( ) {
    return regionName;
  }

  public void setRegionName( final String regionName ) {
    this.regionName = regionName;
  }

  public String getStatus( ) {
    return status;
  }

  public void setStatus( final String status ) {
    this.status = status;
  }

}
