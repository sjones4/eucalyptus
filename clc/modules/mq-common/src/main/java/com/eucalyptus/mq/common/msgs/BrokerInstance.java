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


public class BrokerInstance extends EucalyptusData {

  private String consoleURL;
  private java.util.ArrayList<String> endpoints;
  private String ipAddress;

  public String getConsoleURL( ) {
    return consoleURL;
  }

  public void setConsoleURL( final String consoleURL ) {
    this.consoleURL = consoleURL;
  }

  public java.util.ArrayList<String> getEndpoints( ) {
    return endpoints;
  }

  public void setEndpoints( final java.util.ArrayList<String> endpoints ) {
    this.endpoints = endpoints;
  }

  public String getIpAddress( ) {
    return ipAddress;
  }

  public void setIpAddress( final String ipAddress ) {
    this.ipAddress = ipAddress;
  }

}
