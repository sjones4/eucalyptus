/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.secretsmanager.service.config;

import org.apache.log4j.Logger;
import com.eucalyptus.component.AbstractServiceBuilder;
import com.eucalyptus.component.ComponentId;
import com.eucalyptus.component.ComponentIds;
import com.eucalyptus.component.annotation.ComponentPart;
import com.eucalyptus.secretsmanager.common.Secretsmanager;

/**
 *
 */
@ComponentPart( Secretsmanager.class )
public class SecretsmanagerServiceBuilder extends AbstractServiceBuilder<SecretsmanagerConfiguration> {
  private static final Logger LOG = Logger.getLogger( SecretsmanagerServiceBuilder.class );

  @Override
  public SecretsmanagerConfiguration newInstance( ) {
    return new SecretsmanagerConfiguration( );
  }

  @Override
  public SecretsmanagerConfiguration newInstance( String partition, String name, String host, Integer port ) {
    return new SecretsmanagerConfiguration( partition, name, host, port );
  }

  @Override
  public ComponentId getComponentId( ) {
    return ComponentIds.lookup( Secretsmanager.class );
  }
}
