/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

public class ModifyCertificatesType extends RdsMessage {

  private String certificateIdentifier;

  private Boolean removeCustomerOverride;

  public String getCertificateIdentifier() {
    return certificateIdentifier;
  }

  public void setCertificateIdentifier(final String certificateIdentifier) {
    this.certificateIdentifier = certificateIdentifier;
  }

  public Boolean getRemoveCustomerOverride() {
    return removeCustomerOverride;
  }

  public void setRemoveCustomerOverride(final Boolean removeCustomerOverride) {
    this.removeCustomerOverride = removeCustomerOverride;
  }

}
