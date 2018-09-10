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


public class Subnet extends EucalyptusData {

  private AvailabilityZone subnetAvailabilityZone;
  private String subnetIdentifier;
  private String subnetStatus;

  public AvailabilityZone getSubnetAvailabilityZone( ) {
    return subnetAvailabilityZone;
  }

  public void setSubnetAvailabilityZone( final AvailabilityZone subnetAvailabilityZone ) {
    this.subnetAvailabilityZone = subnetAvailabilityZone;
  }

  public String getSubnetIdentifier( ) {
    return subnetIdentifier;
  }

  public void setSubnetIdentifier( final String subnetIdentifier ) {
    this.subnetIdentifier = subnetIdentifier;
  }

  public String getSubnetStatus( ) {
    return subnetStatus;
  }

  public void setSubnetStatus( final String subnetStatus ) {
    this.subnetStatus = subnetStatus;
  }

}
