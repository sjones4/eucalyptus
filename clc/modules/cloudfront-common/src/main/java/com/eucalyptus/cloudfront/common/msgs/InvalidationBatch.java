/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudfront.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;
import javax.annotation.Nonnull;
import com.eucalyptus.cloudfront.common.CloudfrontMessageValidation.FieldRange;
import com.eucalyptus.cloudfront.common.CloudfrontMessageValidation.FieldRegex;
import com.eucalyptus.cloudfront.common.CloudfrontMessageValidation.FieldRegexValue;


public class InvalidationBatch extends EucalyptusData {

  @Nonnull
  private String callerReference;
  @Nonnull
  private Paths paths;

  public String getCallerReference( ) {
    return callerReference;
  }

  public void setCallerReference( final String callerReference ) {
    this.callerReference = callerReference;
  }

  public Paths getPaths( ) {
    return paths;
  }

  public void setPaths( final Paths paths ) {
    this.paths = paths;
  }

}
