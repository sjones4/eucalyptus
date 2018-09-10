/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudfront.service.ws;

import java.util.EnumSet;
import org.jboss.netty.channel.ChannelPipeline;
import com.eucalyptus.auth.principal.TemporaryAccessKey;
import com.eucalyptus.cloudfront.service.config.CloudfrontConfiguration;
import com.eucalyptus.component.annotation.ComponentPart;
import com.eucalyptus.cloudfront.common.Cloudfront;
import com.eucalyptus.ws.server.RestXmlPipeline;

/**
 *
 */
@ComponentPart(Cloudfront.class)
public class CloudfrontRestXmlPipeline extends RestXmlPipeline {

  public CloudfrontRestXmlPipeline() {
    super(
        "cloudfront-rest-xml",
        CloudfrontConfiguration.SERVICE_PATH,
        EnumSet.allOf( TemporaryAccessKey.TemporaryKeyType.class ) );
  }

  @Override
  public ChannelPipeline addHandlers( final ChannelPipeline pipeline ) {
    super.addHandlers( pipeline );
    pipeline.addLast( "cloudfront-rest-xml-binding", new CloudfrontRestXmlBinding( ) );
    return pipeline;
  }
}
