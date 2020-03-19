/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import com.eucalyptus.rds.common.RdsMessageValidation.FieldRegex;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRegexValue;
import edu.ucsb.eucalyptus.msgs.EucalyptusData;


public class StopActivityStreamResult extends EucalyptusData {

  private String kinesisStreamName;

  private String kmsKeyId;

  @FieldRegex(FieldRegexValue.ENUM_ACTIVITYSTREAMSTATUS)
  private String status;

  public String getKinesisStreamName() {
    return kinesisStreamName;
  }

  public void setKinesisStreamName(final String kinesisStreamName) {
    this.kinesisStreamName = kinesisStreamName;
  }

  public String getKmsKeyId() {
    return kmsKeyId;
  }

  public void setKmsKeyId(final String kmsKeyId) {
    this.kmsKeyId = kmsKeyId;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(final String status) {
    this.status = status;
  }

}
