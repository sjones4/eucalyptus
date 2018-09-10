/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.resourcegroups.common.msgs;

import javax.annotation.Nonnull;
import com.eucalyptus.binding.HttpContent;
import com.eucalyptus.binding.HttpHeaderMapping;
import com.eucalyptus.binding.HttpNoContent;
import com.eucalyptus.resourcegroups.common.ResourcegroupsMessageValidation.FieldRange;
import com.eucalyptus.resourcegroups.common.ResourcegroupsMessageValidation.FieldRegex;
import com.eucalyptus.resourcegroups.common.ResourcegroupsMessageValidation.FieldRegexValue;



public class GetGroupResponseType extends ResourcegroupsMessage {


  private Group group;

  public Group getGroup( ) {
    return group;
  }

  public void setGroup( final Group group ) {
    this.group = group;
  }

}
