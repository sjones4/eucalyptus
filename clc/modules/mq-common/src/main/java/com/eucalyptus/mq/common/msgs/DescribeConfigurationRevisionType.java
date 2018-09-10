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



@HttpRequestMapping(method="GET", uri="/v1/configurations/{configuration-id}/revisions/{configuration-revision}")
@HttpNoContent
public class DescribeConfigurationRevisionType extends MqMessage {

  @Nonnull
  @HttpUriMapping(uri="configuration-id")
  private String configurationId;
  @Nonnull
  @HttpUriMapping(uri="configuration-revision")
  private String configurationRevision;

  public String getConfigurationId( ) {
    return configurationId;
  }

  public void setConfigurationId( final String configurationId ) {
    this.configurationId = configurationId;
  }

  public String getConfigurationRevision( ) {
    return configurationRevision;
  }

  public void setConfigurationRevision( final String configurationRevision ) {
    this.configurationRevision = configurationRevision;
  }

}
