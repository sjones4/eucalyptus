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

public class AuthenticateOidcActionAuthenticationRequestExtraParams extends EucalyptusData {

  private ArrayList<AuthenticateOidcActionAuthenticationRequestExtraParamsEntry> entry = new ArrayList<>();

  public ArrayList<AuthenticateOidcActionAuthenticationRequestExtraParamsEntry> getEntry( ) {
    return entry;
  }

  public void setEntry( final ArrayList<AuthenticateOidcActionAuthenticationRequestExtraParamsEntry> entry ) {
    this.entry = entry;
  }

}
