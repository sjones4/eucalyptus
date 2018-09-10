/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.loadbalancingv2.service.config;

import org.apache.log4j.Logger;
import com.eucalyptus.component.AbstractServiceBuilder;
import com.eucalyptus.component.ComponentId;
import com.eucalyptus.component.ComponentIds;
import com.eucalyptus.component.annotation.ComponentPart;
import com.eucalyptus.loadbalancingv2.common.Loadbalancingv2;

/**
 *
 */
@ComponentPart( Loadbalancingv2.class )
public class Loadbalancingv2ServiceBuilder extends AbstractServiceBuilder<Loadbalancingv2Configuration> {
  private static final Logger LOG = Logger.getLogger( Loadbalancingv2ServiceBuilder.class );

  @Override
  public Loadbalancingv2Configuration newInstance( ) {
    return new Loadbalancingv2Configuration( );
  }

  @Override
  public Loadbalancingv2Configuration newInstance( String partition, String name, String host, Integer port ) {
    return new Loadbalancingv2Configuration( partition, name, host, port );
  }

  @Override
  public ComponentId getComponentId( ) {
    return ComponentIds.lookup( Loadbalancingv2.class );
  }
}
