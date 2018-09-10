/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudtrail.service.config;

import org.apache.log4j.Logger;
import com.eucalyptus.component.AbstractServiceBuilder;
import com.eucalyptus.component.ComponentId;
import com.eucalyptus.component.ComponentIds;
import com.eucalyptus.component.annotation.ComponentPart;
import com.eucalyptus.cloudtrail.common.Cloudtrail;

/**
 *
 */
@ComponentPart( Cloudtrail.class )
public class CloudtrailServiceBuilder extends AbstractServiceBuilder<CloudtrailConfiguration> {
  private static final Logger LOG = Logger.getLogger( CloudtrailServiceBuilder.class );

  @Override
  public CloudtrailConfiguration newInstance( ) {
    return new CloudtrailConfiguration( );
  }

  @Override
  public CloudtrailConfiguration newInstance( String partition, String name, String host, Integer port ) {
    return new CloudtrailConfiguration( partition, name, host, port );
  }

  @Override
  public ComponentId getComponentId( ) {
    return ComponentIds.lookup( Cloudtrail.class );
  }
}
