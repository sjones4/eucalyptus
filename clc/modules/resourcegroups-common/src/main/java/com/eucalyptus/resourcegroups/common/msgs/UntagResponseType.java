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



public class UntagResponseType extends ResourcegroupsMessage {


  private String arn;
  private java.util.ArrayList<String> keys;

  public String getArn( ) {
    return arn;
  }

  public void setArn( final String arn ) {
    this.arn = arn;
  }

  public java.util.ArrayList<String> getKeys( ) {
    return keys;
  }

  public void setKeys( final java.util.ArrayList<String> keys ) {
    this.keys = keys;
  }

}
