/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;


public class GlobalClusterMember extends EucalyptusData {

  private String dBClusterArn;

  private Boolean isWriter;

  private ReadersArnList readers;

  public String getDBClusterArn() {
    return dBClusterArn;
  }

  public void setDBClusterArn(final String dBClusterArn) {
    this.dBClusterArn = dBClusterArn;
  }

  public Boolean getIsWriter() {
    return isWriter;
  }

  public void setIsWriter(final Boolean isWriter) {
    this.isWriter = isWriter;
  }

  public ReadersArnList getReaders() {
    return readers;
  }

  public void setReaders(final ReadersArnList readers) {
    this.readers = readers;
  }

}
