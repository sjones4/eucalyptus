/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudtrail.service.ws;

import com.eucalyptus.component.annotation.ComponentPart;
import com.eucalyptus.cloudtrail.common.Cloudtrail;
import com.eucalyptus.ws.protocol.BaseJsonBinding;

/**
 *
 */
@ComponentPart( Cloudtrail.class )
public class CloudtrailJsonBinding extends BaseJsonBinding {

  public CloudtrailJsonBinding() {
    super( "com.amazonaws.cloudtrail.v20131101.CloudTrail_20131101" );
  }
}
