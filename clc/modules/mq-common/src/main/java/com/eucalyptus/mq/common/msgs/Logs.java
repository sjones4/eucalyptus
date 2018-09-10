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


public class Logs extends EucalyptusData {

  private Boolean audit;
  private Boolean general;

  public Boolean getAudit( ) {
    return audit;
  }

  public void setAudit( final Boolean audit ) {
    this.audit = audit;
  }

  public Boolean getGeneral( ) {
    return general;
  }

  public void setGeneral( final Boolean general ) {
    this.general = general;
  }

}
