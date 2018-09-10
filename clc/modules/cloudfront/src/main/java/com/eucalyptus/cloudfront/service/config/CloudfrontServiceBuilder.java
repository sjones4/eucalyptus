/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudfront.service.config;

import org.apache.log4j.Logger;
import com.eucalyptus.component.AbstractServiceBuilder;
import com.eucalyptus.component.ComponentId;
import com.eucalyptus.component.ComponentIds;
import com.eucalyptus.component.annotation.ComponentPart;
import com.eucalyptus.cloudfront.common.Cloudfront;

/**
 *
 */
@ComponentPart( Cloudfront.class )
public class CloudfrontServiceBuilder extends AbstractServiceBuilder<CloudfrontConfiguration> {
  private static final Logger LOG = Logger.getLogger( CloudfrontServiceBuilder.class );

  @Override
  public CloudfrontConfiguration newInstance( ) {
    return new CloudfrontConfiguration( );
  }

  @Override
  public CloudfrontConfiguration newInstance( String partition, String name, String host, Integer port ) {
    return new CloudfrontConfiguration( partition, name, host, port );
  }

  @Override
  public ComponentId getComponentId( ) {
    return ComponentIds.lookup( Cloudfront.class );
  }
}
