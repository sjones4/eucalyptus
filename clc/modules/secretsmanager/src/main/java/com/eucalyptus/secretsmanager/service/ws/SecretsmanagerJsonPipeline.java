/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.secretsmanager.service.ws;

import java.util.Collections;
import java.util.EnumSet;
import org.jboss.netty.channel.ChannelPipeline;
import com.eucalyptus.auth.principal.TemporaryAccessKey;
import com.eucalyptus.secretsmanager.service.config.SecretsmanagerConfiguration;
import com.eucalyptus.component.annotation.ComponentPart;
import com.eucalyptus.secretsmanager.common.Secretsmanager;
import com.eucalyptus.ws.server.JsonPipeline;
import com.eucalyptus.ws.util.HmacUtils.SignatureVersion;

/**
 *
 */
@ComponentPart(Secretsmanager.class)
public class SecretsmanagerJsonPipeline extends JsonPipeline {

  public SecretsmanagerJsonPipeline() {
    super(
        "secretsmanager-json",
        "secretsmanager",
        Collections.singleton( SecretsmanagerConfiguration.SERVICE_PATH ),
        EnumSet.allOf( TemporaryAccessKey.TemporaryKeyType.class ),
        EnumSet.allOf( SignatureVersion.class ) );
  }

  @Override
  public ChannelPipeline addHandlers( final ChannelPipeline pipeline ) {
    super.addHandlers( pipeline );
    pipeline.addLast( "secretsmanager-json-binding", new SecretsmanagerJsonBinding( ) );
    return pipeline;
  }
}
