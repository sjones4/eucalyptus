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


public class ResourceTag extends EucalyptusData {

  private String resourceId;
  private java.util.ArrayList<Tag> tagsList;

  public String getResourceId( ) {
    return resourceId;
  }

  public void setResourceId( final String resourceId ) {
    this.resourceId = resourceId;
  }

  public java.util.ArrayList<Tag> getTagsList( ) {
    return tagsList;
  }

  public void setTagsList( final java.util.ArrayList<Tag> tagsList ) {
    this.tagsList = tagsList;
  }

}
