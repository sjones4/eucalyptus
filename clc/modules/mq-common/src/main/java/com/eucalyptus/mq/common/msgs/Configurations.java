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


public class Configurations extends EucalyptusData {

  private ConfigurationId current;
  private java.util.ArrayList<ConfigurationId> history;
  private ConfigurationId pending;

  public ConfigurationId getCurrent( ) {
    return current;
  }

  public void setCurrent( final ConfigurationId current ) {
    this.current = current;
  }

  public java.util.ArrayList<ConfigurationId> getHistory( ) {
    return history;
  }

  public void setHistory( final java.util.ArrayList<ConfigurationId> history ) {
    this.history = history;
  }

  public ConfigurationId getPending( ) {
    return pending;
  }

  public void setPending( final ConfigurationId pending ) {
    this.pending = pending;
  }

}
