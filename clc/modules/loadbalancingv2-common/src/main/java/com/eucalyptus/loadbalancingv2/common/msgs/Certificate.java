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


public class Certificate extends EucalyptusData {

  private String certificateArn;
  private Boolean isDefault;

  public String getCertificateArn( ) {
    return certificateArn;
  }

  public void setCertificateArn( final String certificateArn ) {
    this.certificateArn = certificateArn;
  }

  public Boolean getIsDefault( ) {
    return isDefault;
  }

  public void setIsDefault( final Boolean isDefault ) {
    this.isDefault = isDefault;
  }

}
