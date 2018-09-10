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


public class QueryArgProfileConfig extends EucalyptusData {

  @Nonnull
  private Boolean forwardWhenQueryArgProfileIsUnknown;
  private QueryArgProfiles queryArgProfiles;

  public Boolean getForwardWhenQueryArgProfileIsUnknown( ) {
    return forwardWhenQueryArgProfileIsUnknown;
  }

  public void setForwardWhenQueryArgProfileIsUnknown( final Boolean forwardWhenQueryArgProfileIsUnknown ) {
    this.forwardWhenQueryArgProfileIsUnknown = forwardWhenQueryArgProfileIsUnknown;
  }

  public QueryArgProfiles getQueryArgProfiles( ) {
    return queryArgProfiles;
  }

  public void setQueryArgProfiles( final QueryArgProfiles queryArgProfiles ) {
    this.queryArgProfiles = queryArgProfiles;
  }

}
