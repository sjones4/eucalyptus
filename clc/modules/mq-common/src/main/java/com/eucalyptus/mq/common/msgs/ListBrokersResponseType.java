/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.mq.common.msgs;

import javax.annotation.Nonnull;
import com.eucalyptus.binding.HttpContent;
import com.eucalyptus.binding.HttpHeaderMapping;
import com.eucalyptus.binding.HttpNoContent;
import com.eucalyptus.mq.common.MqMessageValidation.FieldRange;
import com.eucalyptus.mq.common.MqMessageValidation.FieldRegex;
import com.eucalyptus.mq.common.MqMessageValidation.FieldRegexValue;



public class ListBrokersResponseType extends MqMessage {


  private java.util.ArrayList<BrokerSummary> brokerSummaries;
  private String nextToken;

  public java.util.ArrayList<BrokerSummary> getBrokerSummaries( ) {
    return brokerSummaries;
  }

  public void setBrokerSummaries( final java.util.ArrayList<BrokerSummary> brokerSummaries ) {
    this.brokerSummaries = brokerSummaries;
  }

  public String getNextToken( ) {
    return nextToken;
  }

  public void setNextToken( final String nextToken ) {
    this.nextToken = nextToken;
  }

}
