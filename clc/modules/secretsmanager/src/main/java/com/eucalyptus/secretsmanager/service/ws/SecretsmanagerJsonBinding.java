/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.secretsmanager.service.ws;

import com.eucalyptus.component.annotation.ComponentPart;
import com.eucalyptus.secretsmanager.common.Secretsmanager;
import com.eucalyptus.ws.protocol.BaseJsonBinding;

/**
 *
 */
@ComponentPart( Secretsmanager.class )
public class SecretsmanagerJsonBinding extends BaseJsonBinding {

  public SecretsmanagerJsonBinding() {
    super( "secretsmanager" );
  }
}
