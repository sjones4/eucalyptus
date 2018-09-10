/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.mq.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;
import javax.annotation.Nonnull;
import com.eucalyptus.mq.common.MqMessageValidation.FieldRange;
import com.eucalyptus.mq.common.MqMessageValidation.FieldRegex;
import com.eucalyptus.mq.common.MqMessageValidation.FieldRegexValue;


public class LogsSummary extends EucalyptusData {

  private Boolean audit;
  private String auditLogGroup;
  private Boolean general;
  private String generalLogGroup;
  private PendingLogs pending;

  public Boolean getAudit( ) {
    return audit;
  }

  public void setAudit( final Boolean audit ) {
    this.audit = audit;
  }

  public String getAuditLogGroup( ) {
    return auditLogGroup;
  }

  public void setAuditLogGroup( final String auditLogGroup ) {
    this.auditLogGroup = auditLogGroup;
  }

  public Boolean getGeneral( ) {
    return general;
  }

  public void setGeneral( final Boolean general ) {
    this.general = general;
  }

  public String getGeneralLogGroup( ) {
    return generalLogGroup;
  }

  public void setGeneralLogGroup( final String generalLogGroup ) {
    this.generalLogGroup = generalLogGroup;
  }

  public PendingLogs getPending( ) {
    return pending;
  }

  public void setPending( final PendingLogs pending ) {
    this.pending = pending;
  }

}
