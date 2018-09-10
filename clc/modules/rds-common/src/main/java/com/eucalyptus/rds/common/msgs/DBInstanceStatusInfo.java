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


public class DBInstanceStatusInfo extends EucalyptusData {

  private String message;
  private Boolean normal;
  private String status;
  private String statusType;

  public String getMessage( ) {
    return message;
  }

  public void setMessage( final String message ) {
    this.message = message;
  }

  public Boolean getNormal( ) {
    return normal;
  }

  public void setNormal( final Boolean normal ) {
    this.normal = normal;
  }

  public String getStatus( ) {
    return status;
  }

  public void setStatus( final String status ) {
    this.status = status;
  }

  public String getStatusType( ) {
    return statusType;
  }

  public void setStatusType( final String statusType ) {
    this.statusType = statusType;
  }

}
