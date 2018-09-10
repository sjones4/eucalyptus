/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.mq.service.ws;

import com.eucalyptus.component.annotation.ComponentPart;
import com.eucalyptus.mq.common.Mq;
import com.eucalyptus.mq.service.config.MqConfiguration;
import com.eucalyptus.ws.protocol.BaseRestJsonBinding;

/**
 *
 */
@ComponentPart( Mq.class )
public class MqRestJsonBinding extends BaseRestJsonBinding {

  public MqRestJsonBinding() {
    super( MqConfiguration.SERVICE_PATH );
  }
}
