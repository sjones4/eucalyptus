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


public class DomainMembership extends EucalyptusData {

  private String domain;
  private String fQDN;
  private String iAMRoleName;
  private String status;

  public String getDomain( ) {
    return domain;
  }

  public void setDomain( final String domain ) {
    this.domain = domain;
  }

  public String getFQDN( ) {
    return fQDN;
  }

  public void setFQDN( final String fQDN ) {
    this.fQDN = fQDN;
  }

  public String getIAMRoleName( ) {
    return iAMRoleName;
  }

  public void setIAMRoleName( final String iAMRoleName ) {
    this.iAMRoleName = iAMRoleName;
  }

  public String getStatus( ) {
    return status;
  }

  public void setStatus( final String status ) {
    this.status = status;
  }

}
