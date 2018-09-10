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
import com.eucalyptus.binding.HttpNoContent;
import com.eucalyptus.binding.HttpHeaderMapping;
import com.eucalyptus.binding.HttpParameterMapping;
import com.eucalyptus.binding.HttpRequestMapping;
import com.eucalyptus.binding.HttpUriMapping;
import com.eucalyptus.mq.common.MqMessageValidation.FieldRange;
import com.eucalyptus.mq.common.MqMessageValidation.FieldRegex;
import com.eucalyptus.mq.common.MqMessageValidation.FieldRegexValue;



@HttpRequestMapping(method="PUT", uri="/v1/brokers/{broker-id}")
public class UpdateBrokerType extends MqMessage {

  @Nonnull
  @HttpUriMapping(uri="broker-id")
  private String brokerId;
  private ConfigurationId configuration;
  private Logs logs;

  public String getBrokerId( ) {
    return brokerId;
  }

  public void setBrokerId( final String brokerId ) {
    this.brokerId = brokerId;
  }

  public ConfigurationId getConfiguration( ) {
    return configuration;
  }

  public void setConfiguration( final ConfigurationId configuration ) {
    this.configuration = configuration;
  }

  public Logs getLogs( ) {
    return logs;
  }

  public void setLogs( final Logs logs ) {
    this.logs = logs;
  }

}
