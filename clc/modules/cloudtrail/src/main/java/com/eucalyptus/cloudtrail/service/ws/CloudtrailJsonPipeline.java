/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudtrail.service.ws;

import java.util.Collections;
import java.util.EnumSet;
import org.jboss.netty.channel.ChannelPipeline;
import com.eucalyptus.auth.principal.TemporaryAccessKey;
import com.eucalyptus.cloudtrail.service.config.CloudtrailConfiguration;
import com.eucalyptus.component.annotation.ComponentPart;
import com.eucalyptus.cloudtrail.common.Cloudtrail;
import com.eucalyptus.ws.server.JsonPipeline;
import com.eucalyptus.ws.util.HmacUtils.SignatureVersion;

/**
 *
 */
@ComponentPart(Cloudtrail.class)
public class CloudtrailJsonPipeline extends JsonPipeline {

  public CloudtrailJsonPipeline() {
    super(
        "cloudtrail-json",
        "com.amazonaws.cloudtrail.v20131101.CloudTrail_20131101",
        Collections.singleton( CloudtrailConfiguration.SERVICE_PATH ),
        EnumSet.allOf( TemporaryAccessKey.TemporaryKeyType.class ),
        EnumSet.allOf( SignatureVersion.class ) );
  }

  @Override
  public ChannelPipeline addHandlers( final ChannelPipeline pipeline ) {
    super.addHandlers( pipeline );
    pipeline.addLast( "cloudtrail-json-binding", new CloudtrailJsonBinding( ) );
    return pipeline;
  }
}
