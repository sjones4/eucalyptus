/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudwatchlogs.service.ws;

import com.eucalyptus.component.annotation.ComponentPart;
import com.eucalyptus.cloudwatchlogs.common.Cloudwatchlogs;
import com.eucalyptus.ws.protocol.BaseJsonBinding;

/**
 *
 */
@ComponentPart( Cloudwatchlogs.class )
public class CloudwatchlogsJsonBinding extends BaseJsonBinding {

  public CloudwatchlogsJsonBinding() {
    super( "Logs_20140328" );
  }
}
