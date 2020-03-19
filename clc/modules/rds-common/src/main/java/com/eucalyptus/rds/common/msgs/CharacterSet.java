/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;


public class CharacterSet extends EucalyptusData {

  private String characterSetDescription;

  private String characterSetName;

  public String getCharacterSetDescription() {
    return characterSetDescription;
  }

  public void setCharacterSetDescription(final String characterSetDescription) {
    this.characterSetDescription = characterSetDescription;
  }

  public String getCharacterSetName() {
    return characterSetName;
  }

  public void setCharacterSetName(final String characterSetName) {
    this.characterSetName = characterSetName;
  }

}
