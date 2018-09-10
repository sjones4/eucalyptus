/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.route53.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;
import javax.annotation.Nonnull;
import com.eucalyptus.route53.common.Route53MessageValidation.FieldRange;
import com.eucalyptus.route53.common.Route53MessageValidation.FieldRegex;
import com.eucalyptus.route53.common.Route53MessageValidation.FieldRegexValue;


public class AlarmIdentifier extends EucalyptusData {

  @Nonnull
  @FieldRange(min=1, max=256)
  private String name;
  @Nonnull
  @FieldRange(min=1, max=64)
  @FieldRegex(FieldRegexValue.ENUM_CLOUDWATCHREGION)
  private String region;

  public String getName( ) {
    return name;
  }

  public void setName( final String name ) {
    this.name = name;
  }

  public String getRegion( ) {
    return region;
  }

  public void setRegion( final String region ) {
    this.region = region;
  }

}
