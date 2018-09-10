/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.loadbalancingv2.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;
import java.util.ArrayList;


public class AuthenticateCognitoActionAuthenticationRequestExtraParamsEntry extends EucalyptusData {

  private java.lang.String key;
  private java.lang.String value;

  public java.lang.String getKey( ) {
    return key;
  }

  public void setKey( final java.lang.String key ) {
    this.key = key;
  }

  public java.lang.String getValue( ) {
    return value;
  }

  public void setValue( final java.lang.String value ) {
    this.value = value;
  }
}
