/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.service.ws;

import java.util.EnumSet;
import org.jboss.netty.channel.ChannelPipeline;
import com.eucalyptus.auth.principal.TemporaryAccessKey;
import com.eucalyptus.component.annotation.ComponentPart;
import com.eucalyptus.rds.common.Rds;
import com.eucalyptus.rds.service.config.RdsConfiguration;
import com.eucalyptus.ws.server.QueryPipeline;

/**
 *
 */
@ComponentPart(Rds.class)
public class RdsQueryPipeline extends QueryPipeline {

  public RdsQueryPipeline() {
    super(
        "rds-query",
        RdsConfiguration.SERVICE_PATH,
        EnumSet.allOf(TemporaryAccessKey.TemporaryKeyType.class));
  }

  @Override
  public ChannelPipeline addHandlers(final ChannelPipeline pipeline) {
    super.addHandlers(pipeline);
    pipeline.addLast("rds-query-binding", new RdsQueryBinding());
    return pipeline;
  }
}
