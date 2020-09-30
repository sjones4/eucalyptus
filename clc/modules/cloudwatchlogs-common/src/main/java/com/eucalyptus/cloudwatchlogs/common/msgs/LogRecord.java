/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudwatchlogs.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LogRecord extends EucalyptusData {

  private Map<java.lang.String,java.lang.String> mapping = new HashMap<>( );

  public Map<java.lang.String,java.lang.String> getMapping( ) {
    return mapping;
  }

  public void setMapping( final Map<java.lang.String,java.lang.String> mapping ) {
    this.mapping = mapping;
  }

  public void setMapping( final java.lang.String key,
                          final java.lang.String value ) {
    mapping.put( key, value );
  }

}
