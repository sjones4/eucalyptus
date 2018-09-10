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


public class DBSubnetGroup extends EucalyptusData {

  private String dBSubnetGroupArn;
  private String dBSubnetGroupDescription;
  private String dBSubnetGroupName;
  private String subnetGroupStatus;
  private SubnetList subnets;
  private String vpcId;

  public String getDBSubnetGroupArn( ) {
    return dBSubnetGroupArn;
  }

  public void setDBSubnetGroupArn( final String dBSubnetGroupArn ) {
    this.dBSubnetGroupArn = dBSubnetGroupArn;
  }

  public String getDBSubnetGroupDescription( ) {
    return dBSubnetGroupDescription;
  }

  public void setDBSubnetGroupDescription( final String dBSubnetGroupDescription ) {
    this.dBSubnetGroupDescription = dBSubnetGroupDescription;
  }

  public String getDBSubnetGroupName( ) {
    return dBSubnetGroupName;
  }

  public void setDBSubnetGroupName( final String dBSubnetGroupName ) {
    this.dBSubnetGroupName = dBSubnetGroupName;
  }

  public String getSubnetGroupStatus( ) {
    return subnetGroupStatus;
  }

  public void setSubnetGroupStatus( final String subnetGroupStatus ) {
    this.subnetGroupStatus = subnetGroupStatus;
  }

  public SubnetList getSubnets( ) {
    return subnets;
  }

  public void setSubnets( final SubnetList subnets ) {
    this.subnets = subnets;
  }

  public String getVpcId( ) {
    return vpcId;
  }

  public void setVpcId( final String vpcId ) {
    this.vpcId = vpcId;
  }

}
