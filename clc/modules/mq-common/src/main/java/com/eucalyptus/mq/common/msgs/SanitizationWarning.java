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


public class SanitizationWarning extends EucalyptusData {

  private String attributeName;
  private String elementName;
  @FieldRegex(FieldRegexValue.ENUM_SANITIZATIONWARNINGREASON)
  private String reason;

  public String getAttributeName( ) {
    return attributeName;
  }

  public void setAttributeName( final String attributeName ) {
    this.attributeName = attributeName;
  }

  public String getElementName( ) {
    return elementName;
  }

  public void setElementName( final String elementName ) {
    this.elementName = elementName;
  }

  public String getReason( ) {
    return reason;
  }

  public void setReason( final String reason ) {
    this.reason = reason;
  }

}
