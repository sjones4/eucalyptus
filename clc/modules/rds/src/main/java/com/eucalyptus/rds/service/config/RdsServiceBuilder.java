/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.service.config;

import org.apache.log4j.Logger;
import com.eucalyptus.component.AbstractServiceBuilder;
import com.eucalyptus.component.ComponentId;
import com.eucalyptus.component.ComponentIds;
import com.eucalyptus.component.annotation.ComponentPart;
import com.eucalyptus.rds.common.Rds;

/**
 *
 */
@ComponentPart( Rds.class )
public class RdsServiceBuilder extends AbstractServiceBuilder<RdsConfiguration> {
  private static final Logger LOG = Logger.getLogger( RdsServiceBuilder.class );

  @Override
  public RdsConfiguration newInstance( ) {
    return new RdsConfiguration( );
  }

  @Override
  public RdsConfiguration newInstance( String partition, String name, String host, Integer port ) {
    return new RdsConfiguration( partition, name, host, port );
  }

  @Override
  public ComponentId getComponentId( ) {
    return ComponentIds.lookup( Rds.class );
  }
}
