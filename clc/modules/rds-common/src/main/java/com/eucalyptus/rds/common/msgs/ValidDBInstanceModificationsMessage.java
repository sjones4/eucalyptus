/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;


public class ValidDBInstanceModificationsMessage extends EucalyptusData {

  private ValidStorageOptionsList storage;

  private AvailableProcessorFeatureList validProcessorFeatures;

  public ValidStorageOptionsList getStorage() {
    return storage;
  }

  public void setStorage(final ValidStorageOptionsList storage) {
    this.storage = storage;
  }

  public AvailableProcessorFeatureList getValidProcessorFeatures() {
    return validProcessorFeatures;
  }

  public void setValidProcessorFeatures(final AvailableProcessorFeatureList validProcessorFeatures) {
    this.validProcessorFeatures = validProcessorFeatures;
  }

}
