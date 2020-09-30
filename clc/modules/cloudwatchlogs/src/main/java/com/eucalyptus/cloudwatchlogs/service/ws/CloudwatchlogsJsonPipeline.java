/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudwatchlogs.service.ws;

import java.util.Collections;
import java.util.EnumSet;
import org.jboss.netty.channel.ChannelPipeline;
import com.eucalyptus.auth.principal.TemporaryAccessKey;
import com.eucalyptus.cloudwatchlogs.service.config.CloudwatchlogsConfiguration;
import com.eucalyptus.component.annotation.ComponentPart;
import com.eucalyptus.cloudwatchlogs.common.Cloudwatchlogs;
import com.eucalyptus.ws.server.JsonPipeline;
import com.eucalyptus.ws.util.HmacUtils.SignatureVersion;

/**
 *
 */
@ComponentPart(Cloudwatchlogs.class)
public class CloudwatchlogsJsonPipeline extends JsonPipeline {

  public CloudwatchlogsJsonPipeline() {
    super(
        "cloudwatchlogs-json",
        "Logs_20140328",
        Collections.singleton( CloudwatchlogsConfiguration.SERVICE_PATH ),
        EnumSet.allOf( TemporaryAccessKey.TemporaryKeyType.class ),
        EnumSet.allOf( SignatureVersion.class ) );
  }

  @Override
  public ChannelPipeline addHandlers( final ChannelPipeline pipeline ) {
    super.addHandlers( pipeline );
    pipeline.addLast( "cloudwatchlogs-json-binding", new CloudwatchlogsJsonBinding( ) );
    return pipeline;
  }
}
