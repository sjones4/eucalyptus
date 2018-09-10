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



public class DescribeConfigurationRevisionResponseType extends MqMessage {


  private String configurationId;
  private java.util.Date created;
  private String data;
  private String description;

  public String getConfigurationId( ) {
    return configurationId;
  }

  public void setConfigurationId( final String configurationId ) {
    this.configurationId = configurationId;
  }

  public java.util.Date getCreated( ) {
    return created;
  }

  public void setCreated( final java.util.Date created ) {
    this.created = created;
  }

  public String getData( ) {
    return data;
  }

  public void setData( final String data ) {
    this.data = data;
  }

  public String getDescription( ) {
    return description;
  }

  public void setDescription( final String description ) {
    this.description = description;
  }

}
