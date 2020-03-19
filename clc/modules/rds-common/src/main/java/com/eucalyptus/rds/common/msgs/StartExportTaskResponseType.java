/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

public class StartExportTaskResponseType extends RdsMessage {

  private StartExportTaskResult result = new StartExportTaskResult();

  private ResponseMetadata responseMetadata = new ResponseMetadata();

  public ResponseMetadata getResponseMetadata() {
    return responseMetadata;
  }

  public void setResponseMetadata(final ResponseMetadata responseMetadata) {
    this.responseMetadata = responseMetadata;
  }

  public StartExportTaskResult getStartExportTaskResult() {
    return result;
  }

  public void setStartExportTaskResult(final StartExportTaskResult result) {
    this.result = result;
  }

}
