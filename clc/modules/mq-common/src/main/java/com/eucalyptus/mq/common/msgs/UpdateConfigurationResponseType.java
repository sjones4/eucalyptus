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



public class UpdateConfigurationResponseType extends MqMessage {


  private String arn;
  private java.util.Date created;
  private String id;
  private ConfigurationRevision latestRevision;
  private String name;
  private java.util.ArrayList<SanitizationWarning> warnings;

  public String getArn( ) {
    return arn;
  }

  public void setArn( final String arn ) {
    this.arn = arn;
  }

  public java.util.Date getCreated( ) {
    return created;
  }

  public void setCreated( final java.util.Date created ) {
    this.created = created;
  }

  public String getId( ) {
    return id;
  }

  public void setId( final String id ) {
    this.id = id;
  }

  public ConfigurationRevision getLatestRevision( ) {
    return latestRevision;
  }

  public void setLatestRevision( final ConfigurationRevision latestRevision ) {
    this.latestRevision = latestRevision;
  }

  public String getName( ) {
    return name;
  }

  public void setName( final String name ) {
    this.name = name;
  }

  public java.util.ArrayList<SanitizationWarning> getWarnings( ) {
    return warnings;
  }

  public void setWarnings( final java.util.ArrayList<SanitizationWarning> warnings ) {
    this.warnings = warnings;
  }

}
