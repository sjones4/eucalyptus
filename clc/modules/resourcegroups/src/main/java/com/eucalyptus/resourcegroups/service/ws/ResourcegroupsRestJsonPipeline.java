/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.resourcegroups.service.ws;

import java.util.EnumSet;
import org.jboss.netty.channel.ChannelPipeline;
import com.eucalyptus.auth.principal.TemporaryAccessKey;
import com.eucalyptus.resourcegroups.service.config.ResourcegroupsConfiguration;
import com.eucalyptus.component.annotation.ComponentPart;
import com.eucalyptus.resourcegroups.common.Resourcegroups;
import com.eucalyptus.ws.server.RestJsonPipeline;

/**
 *
 */
@ComponentPart(Resourcegroups.class)
public class ResourcegroupsRestJsonPipeline extends RestJsonPipeline {

  public ResourcegroupsRestJsonPipeline() {
    super(
        "resourcegroups-rest-json",
        ResourcegroupsConfiguration.SERVICE_PATH,
        EnumSet.allOf( TemporaryAccessKey.TemporaryKeyType.class ) );
  }

  @Override
  public ChannelPipeline addHandlers( final ChannelPipeline pipeline ) {
    super.addHandlers( pipeline );
    pipeline.addLast( "resourcegroups-rest-json-binding", new ResourcegroupsRestJsonBinding( ) );
    return pipeline;
  }
}
