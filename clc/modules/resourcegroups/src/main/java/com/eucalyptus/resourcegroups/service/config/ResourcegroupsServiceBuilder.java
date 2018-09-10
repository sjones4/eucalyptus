/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.resourcegroups.service.config;

import org.apache.log4j.Logger;
import com.eucalyptus.component.AbstractServiceBuilder;
import com.eucalyptus.component.ComponentId;
import com.eucalyptus.component.ComponentIds;
import com.eucalyptus.component.annotation.ComponentPart;
import com.eucalyptus.resourcegroups.common.Resourcegroups;

/**
 *
 */
@ComponentPart( Resourcegroups.class )
public class ResourcegroupsServiceBuilder extends AbstractServiceBuilder<ResourcegroupsConfiguration> {
  private static final Logger LOG = Logger.getLogger( ResourcegroupsServiceBuilder.class );

  @Override
  public ResourcegroupsConfiguration newInstance( ) {
    return new ResourcegroupsConfiguration( );
  }

  @Override
  public ResourcegroupsConfiguration newInstance( String partition, String name, String host, Integer port ) {
    return new ResourcegroupsConfiguration( partition, name, host, port );
  }

  @Override
  public ComponentId getComponentId( ) {
    return ComponentIds.lookup( Resourcegroups.class );
  }
}
