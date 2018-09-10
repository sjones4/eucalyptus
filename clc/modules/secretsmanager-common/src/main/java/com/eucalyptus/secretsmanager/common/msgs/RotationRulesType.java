/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.secretsmanager.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;
import javax.annotation.Nonnull;
import com.eucalyptus.secretsmanager.common.SecretsmanagerMessageValidation.FieldRange;
import com.eucalyptus.secretsmanager.common.SecretsmanagerMessageValidation.FieldRegex;
import com.eucalyptus.secretsmanager.common.SecretsmanagerMessageValidation.FieldRegexValue;


public class RotationRulesType extends EucalyptusData {

  @FieldRange(min=1, max=1000)
  private Long automaticallyAfterDays;

  public Long getAutomaticallyAfterDays( ) {
    return automaticallyAfterDays;
  }

  public void setAutomaticallyAfterDays( final Long automaticallyAfterDays ) {
    this.automaticallyAfterDays = automaticallyAfterDays;
  }

}
