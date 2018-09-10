/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;
import javax.annotation.Nonnull;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRange;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRegex;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRegexValue;


public class UpgradeTarget extends EucalyptusData {

  private Boolean autoUpgrade;
  private String description;
  private String engine;
  private String engineVersion;
  private Boolean isMajorVersionUpgrade;

  public Boolean getAutoUpgrade( ) {
    return autoUpgrade;
  }

  public void setAutoUpgrade( final Boolean autoUpgrade ) {
    this.autoUpgrade = autoUpgrade;
  }

  public String getDescription( ) {
    return description;
  }

  public void setDescription( final String description ) {
    this.description = description;
  }

  public String getEngine( ) {
    return engine;
  }

  public void setEngine( final String engine ) {
    this.engine = engine;
  }

  public String getEngineVersion( ) {
    return engineVersion;
  }

  public void setEngineVersion( final String engineVersion ) {
    this.engineVersion = engineVersion;
  }

  public Boolean getIsMajorVersionUpgrade( ) {
    return isMajorVersionUpgrade;
  }

  public void setIsMajorVersionUpgrade( final Boolean isMajorVersionUpgrade ) {
    this.isMajorVersionUpgrade = isMajorVersionUpgrade;
  }

}
