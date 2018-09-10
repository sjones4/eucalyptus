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
import java.util.HashMap;
import java.util.Map;

public class AuthenticateCognitoActionAuthenticationRequestExtraParams extends EucalyptusData {

  private ArrayList<AuthenticateCognitoActionAuthenticationRequestExtraParamsEntry> entry = new ArrayList<>();

  public ArrayList<AuthenticateCognitoActionAuthenticationRequestExtraParamsEntry> getEntry( ) {
    return entry;
  }

  public void setEntry( final ArrayList<AuthenticateCognitoActionAuthenticationRequestExtraParamsEntry> entry ) {
    this.entry = entry;
  }

}
