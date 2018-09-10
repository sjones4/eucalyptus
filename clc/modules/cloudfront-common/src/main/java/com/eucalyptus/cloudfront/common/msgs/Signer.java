/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudfront.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;
import javax.annotation.Nonnull;
import com.eucalyptus.cloudfront.common.CloudfrontMessageValidation.FieldRange;
import com.eucalyptus.cloudfront.common.CloudfrontMessageValidation.FieldRegex;
import com.eucalyptus.cloudfront.common.CloudfrontMessageValidation.FieldRegexValue;


public class Signer extends EucalyptusData {

  private String awsAccountNumber;
  private KeyPairIds keyPairIds;

  public String getAwsAccountNumber( ) {
    return awsAccountNumber;
  }

  public void setAwsAccountNumber( final String awsAccountNumber ) {
    this.awsAccountNumber = awsAccountNumber;
  }

  public KeyPairIds getKeyPairIds( ) {
    return keyPairIds;
  }

  public void setKeyPairIds( final KeyPairIds keyPairIds ) {
    this.keyPairIds = keyPairIds;
  }

}
