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


public class TargetGroupAttribute extends EucalyptusData {

  @FieldRange(max=256)
  private String key;
  private String value;

  public String getKey( ) {
    return key;
  }

  public void setKey( final String key ) {
    this.key = key;
  }

  public String getValue( ) {
    return value;
  }

  public void setValue( final String value ) {
    this.value = value;
  }

}
