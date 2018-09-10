/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.loadbalancingv2.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;
import javax.annotation.Nonnull;
import com.eucalyptus.loadbalancingv2.common.Loadbalancingv2MessageValidation.FieldRange;
import com.eucalyptus.loadbalancingv2.common.Loadbalancingv2MessageValidation.FieldRegex;
import com.eucalyptus.loadbalancingv2.common.Loadbalancingv2MessageValidation.FieldRegexValue;


public class TargetHealth extends EucalyptusData {

  private String description;
  @FieldRegex(FieldRegexValue.ENUM_TARGETHEALTHREASONENUM)
  private String reason;
  @FieldRegex(FieldRegexValue.ENUM_TARGETHEALTHSTATEENUM)
  private String state;

  public String getDescription( ) {
    return description;
  }

  public void setDescription( final String description ) {
    this.description = description;
  }

  public String getReason( ) {
    return reason;
  }

  public void setReason( final String reason ) {
    this.reason = reason;
  }

  public String getState( ) {
    return state;
  }

  public void setState( final String state ) {
    this.state = state;
  }

}
