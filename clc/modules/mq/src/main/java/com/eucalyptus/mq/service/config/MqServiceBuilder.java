/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.mq.service.config;

import org.apache.log4j.Logger;
import com.eucalyptus.component.AbstractServiceBuilder;
import com.eucalyptus.component.ComponentId;
import com.eucalyptus.component.ComponentIds;
import com.eucalyptus.component.annotation.ComponentPart;
import com.eucalyptus.mq.common.Mq;

/**
 *
 */
@ComponentPart( Mq.class )
public class MqServiceBuilder extends AbstractServiceBuilder<MqConfiguration> {
  private static final Logger LOG = Logger.getLogger( MqServiceBuilder.class );

  @Override
  public MqConfiguration newInstance( ) {
    return new MqConfiguration( );
  }

  @Override
  public MqConfiguration newInstance( String partition, String name, String host, Integer port ) {
    return new MqConfiguration( partition, name, host, port );
  }

  @Override
  public ComponentId getComponentId( ) {
    return ComponentIds.lookup( Mq.class );
  }
}
