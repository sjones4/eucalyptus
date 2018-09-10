/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.resourcegroups.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;
import javax.annotation.Nonnull;
import com.eucalyptus.resourcegroups.common.ResourcegroupsMessageValidation.FieldRange;
import com.eucalyptus.resourcegroups.common.ResourcegroupsMessageValidation.FieldRegex;
import com.eucalyptus.resourcegroups.common.ResourcegroupsMessageValidation.FieldRegexValue;


public class ResourceIdentifier extends EucalyptusData {

  private String resourceArn;
  private String resourceType;

  public String getResourceArn( ) {
    return resourceArn;
  }

  public void setResourceArn( final String resourceArn ) {
    this.resourceArn = resourceArn;
  }

  public String getResourceType( ) {
    return resourceType;
  }

  public void setResourceType( final String resourceType ) {
    this.resourceType = resourceType;
  }

}
