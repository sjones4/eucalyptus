/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import javax.annotation.Nonnull;
import com.eucalyptus.binding.HttpContent;
import com.eucalyptus.binding.HttpHeaderMapping;
import com.eucalyptus.binding.HttpNoContent;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRange;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRegex;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRegexValue;



public class RemoveSourceIdentifierFromSubscriptionResponseType extends RdsMessage {

  private RemoveSourceIdentifierFromSubscriptionResult result = new RemoveSourceIdentifierFromSubscriptionResult( );
  private ResponseMetadata responseMetadata = new ResponseMetadata( );

  public RemoveSourceIdentifierFromSubscriptionResult getRemoveSourceIdentifierFromSubscriptionResult( ) {
    return result;
  }

  public void setRemoveSourceIdentifierFromSubscriptionResult( final RemoveSourceIdentifierFromSubscriptionResult result ) {
    this.result = result;
  }
  public ResponseMetadata getResponseMetadata( ) {
    return responseMetadata;
  }

  public void setResponseMetadata( final ResponseMetadata responseMetadata ) {
    this.responseMetadata = responseMetadata;
  }

}
