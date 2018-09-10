/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.resourcegroups.service.ws;

import com.eucalyptus.component.annotation.ComponentPart;
import com.eucalyptus.resourcegroups.common.Resourcegroups;
import com.eucalyptus.resourcegroups.service.config.ResourcegroupsConfiguration;
import com.eucalyptus.ws.protocol.BaseRestJsonBinding;

/**
 *
 */
@ComponentPart( Resourcegroups.class )
public class ResourcegroupsRestJsonBinding extends BaseRestJsonBinding {

  public ResourcegroupsRestJsonBinding() {
    super( ResourcegroupsConfiguration.SERVICE_PATH );
  }
}
