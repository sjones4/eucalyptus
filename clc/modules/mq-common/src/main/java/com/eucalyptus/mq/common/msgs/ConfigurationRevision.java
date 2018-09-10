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


public class ConfigurationRevision extends EucalyptusData {

  private java.util.Date created;
  private String description;
  private Integer revision;

  public java.util.Date getCreated( ) {
    return created;
  }

  public void setCreated( final java.util.Date created ) {
    this.created = created;
  }

  public String getDescription( ) {
    return description;
  }

  public void setDescription( final String description ) {
    this.description = description;
  }

  public Integer getRevision( ) {
    return revision;
  }

  public void setRevision( final Integer revision ) {
    this.revision = revision;
  }

}
