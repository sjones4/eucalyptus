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


public class RuleCondition extends EucalyptusData {

  @FieldRange(max=64)
  private String field;
  private ListOfString values;

  public String getField( ) {
    return field;
  }

  public void setField( final String field ) {
    this.field = field;
  }

  public ListOfString getValues( ) {
    return values;
  }

  public void setValues( final ListOfString values ) {
    this.values = values;
  }

}
