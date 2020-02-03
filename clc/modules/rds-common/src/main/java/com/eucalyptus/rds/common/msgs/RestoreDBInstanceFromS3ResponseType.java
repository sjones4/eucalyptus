/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

public class RestoreDBInstanceFromS3ResponseType extends RdsMessage {

  private RestoreDBInstanceFromS3Result result = new RestoreDBInstanceFromS3Result();

  private ResponseMetadata responseMetadata = new ResponseMetadata();

  public ResponseMetadata getResponseMetadata() {
    return responseMetadata;
  }

  public void setResponseMetadata(final ResponseMetadata responseMetadata) {
    this.responseMetadata = responseMetadata;
  }

  public RestoreDBInstanceFromS3Result getRestoreDBInstanceFromS3Result() {
    return result;
  }

  public void setRestoreDBInstanceFromS3Result(final RestoreDBInstanceFromS3Result result) {
    this.result = result;
  }

}
