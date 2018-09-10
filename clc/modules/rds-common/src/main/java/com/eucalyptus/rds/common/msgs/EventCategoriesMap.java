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


public class EventCategoriesMap extends EucalyptusData {

  private EventCategoriesList eventCategories;
  private String sourceType;

  public EventCategoriesList getEventCategories( ) {
    return eventCategories;
  }

  public void setEventCategories( final EventCategoriesList eventCategories ) {
    this.eventCategories = eventCategories;
  }

  public String getSourceType( ) {
    return sourceType;
  }

  public void setSourceType( final String sourceType ) {
    this.sourceType = sourceType;
  }

}
