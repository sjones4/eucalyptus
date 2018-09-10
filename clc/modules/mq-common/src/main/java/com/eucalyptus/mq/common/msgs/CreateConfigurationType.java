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



@HttpRequestMapping(method="POST", uri="/v1/configurations")
public class CreateConfigurationType extends MqMessage {

  @FieldRegex(FieldRegexValue.ENUM_ENGINETYPE)
  private String engineType;
  private String engineVersion;
  private String name;

  public String getEngineType( ) {
    return engineType;
  }

  public void setEngineType( final String engineType ) {
    this.engineType = engineType;
  }

  public String getEngineVersion( ) {
    return engineVersion;
  }

  public void setEngineVersion( final String engineVersion ) {
    this.engineVersion = engineVersion;
  }

  public String getName( ) {
    return name;
  }

  public void setName( final String name ) {
    this.name = name;
  }

}
