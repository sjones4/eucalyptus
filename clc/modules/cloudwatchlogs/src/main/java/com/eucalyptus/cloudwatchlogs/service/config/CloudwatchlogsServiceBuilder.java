/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudwatchlogs.service.config;

import org.apache.log4j.Logger;
import com.eucalyptus.component.AbstractServiceBuilder;
import com.eucalyptus.component.ComponentId;
import com.eucalyptus.component.ComponentIds;
import com.eucalyptus.component.annotation.ComponentPart;
import com.eucalyptus.cloudwatchlogs.common.Cloudwatchlogs;

/**
 *
 */
@ComponentPart( Cloudwatchlogs.class )
public class CloudwatchlogsServiceBuilder extends AbstractServiceBuilder<CloudwatchlogsConfiguration> {
  private static final Logger LOG = Logger.getLogger( CloudwatchlogsServiceBuilder.class );

  @Override
  public CloudwatchlogsConfiguration newInstance( ) {
    return new CloudwatchlogsConfiguration( );
  }

  @Override
  public CloudwatchlogsConfiguration newInstance( String partition, String name, String host, Integer port ) {
    return new CloudwatchlogsConfiguration( partition, name, host, port );
  }

  @Override
  public ComponentId getComponentId( ) {
    return ComponentIds.lookup( Cloudwatchlogs.class );
  }
}
