/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;
import javax.annotation.Nonnull;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRange;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRegex;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRegexValue;


public class ResourcePendingMaintenanceActions extends EucalyptusData {

  private PendingMaintenanceActionDetails pendingMaintenanceActionDetails;
  private String resourceIdentifier;

  public PendingMaintenanceActionDetails getPendingMaintenanceActionDetails( ) {
    return pendingMaintenanceActionDetails;
  }

  public void setPendingMaintenanceActionDetails( final PendingMaintenanceActionDetails pendingMaintenanceActionDetails ) {
    this.pendingMaintenanceActionDetails = pendingMaintenanceActionDetails;
  }

  public String getResourceIdentifier( ) {
    return resourceIdentifier;
  }

  public void setResourceIdentifier( final String resourceIdentifier ) {
    this.resourceIdentifier = resourceIdentifier;
  }

}
