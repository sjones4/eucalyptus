/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;


public class OptionGroup extends EucalyptusData {

  private Boolean allowsVpcAndNonVpcInstanceMemberships;

  private String engineName;

  private String majorEngineVersion;

  private String optionGroupArn;

  private String optionGroupDescription;

  private String optionGroupName;

  private OptionsList options;

  private String vpcId;

  public Boolean getAllowsVpcAndNonVpcInstanceMemberships() {
    return allowsVpcAndNonVpcInstanceMemberships;
  }

  public void setAllowsVpcAndNonVpcInstanceMemberships(final Boolean allowsVpcAndNonVpcInstanceMemberships) {
    this.allowsVpcAndNonVpcInstanceMemberships = allowsVpcAndNonVpcInstanceMemberships;
  }

  public String getEngineName() {
    return engineName;
  }

  public void setEngineName(final String engineName) {
    this.engineName = engineName;
  }

  public String getMajorEngineVersion() {
    return majorEngineVersion;
  }

  public void setMajorEngineVersion(final String majorEngineVersion) {
    this.majorEngineVersion = majorEngineVersion;
  }

  public String getOptionGroupArn() {
    return optionGroupArn;
  }

  public void setOptionGroupArn(final String optionGroupArn) {
    this.optionGroupArn = optionGroupArn;
  }

  public String getOptionGroupDescription() {
    return optionGroupDescription;
  }

  public void setOptionGroupDescription(final String optionGroupDescription) {
    this.optionGroupDescription = optionGroupDescription;
  }

  public String getOptionGroupName() {
    return optionGroupName;
  }

  public void setOptionGroupName(final String optionGroupName) {
    this.optionGroupName = optionGroupName;
  }

  public OptionsList getOptions() {
    return options;
  }

  public void setOptions(final OptionsList options) {
    this.options = options;
  }

  public String getVpcId() {
    return vpcId;
  }

  public void setVpcId(final String vpcId) {
    this.vpcId = vpcId;
  }

}
