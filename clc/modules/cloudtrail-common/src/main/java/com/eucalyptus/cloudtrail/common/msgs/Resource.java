/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudtrail.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;
import javax.annotation.Nonnull;
import com.eucalyptus.cloudtrail.common.CloudtrailMessageValidation.FieldRange;
import com.eucalyptus.cloudtrail.common.CloudtrailMessageValidation.FieldRegex;
import com.eucalyptus.cloudtrail.common.CloudtrailMessageValidation.FieldRegexValue;


public class Resource extends EucalyptusData {

  private String resourceName;
  private String resourceType;

  public String getResourceName( ) {
    return resourceName;
  }

  public void setResourceName( final String resourceName ) {
    this.resourceName = resourceName;
  }

  public String getResourceType( ) {
    return resourceType;
  }

  public void setResourceType( final String resourceType ) {
    this.resourceType = resourceType;
  }

}
