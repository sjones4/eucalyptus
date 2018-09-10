/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.mq.service.ws;

import java.util.EnumSet;
import org.jboss.netty.channel.ChannelPipeline;
import com.eucalyptus.auth.principal.TemporaryAccessKey;
import com.eucalyptus.mq.service.config.MqConfiguration;
import com.eucalyptus.component.annotation.ComponentPart;
import com.eucalyptus.mq.common.Mq;
import com.eucalyptus.ws.server.RestJsonPipeline;

/**
 *
 */
@ComponentPart(Mq.class)
public class MqRestJsonPipeline extends RestJsonPipeline {

  public MqRestJsonPipeline() {
    super(
        "mq-rest-json",
        MqConfiguration.SERVICE_PATH,
        EnumSet.allOf( TemporaryAccessKey.TemporaryKeyType.class ) );
  }

  @Override
  public ChannelPipeline addHandlers( final ChannelPipeline pipeline ) {
    super.addHandlers( pipeline );
    pipeline.addLast( "mq-rest-json-binding", new MqRestJsonBinding( ) );
    return pipeline;
  }
}
