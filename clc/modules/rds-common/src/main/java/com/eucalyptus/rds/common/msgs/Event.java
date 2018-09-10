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


public class Event extends EucalyptusData {

  private java.util.Date date;
  private EventCategoriesList eventCategories;
  private String message;
  private String sourceArn;
  private String sourceIdentifier;
  @FieldRegex(FieldRegexValue.ENUM_SOURCETYPE)
  private String sourceType;

  public java.util.Date getDate( ) {
    return date;
  }

  public void setDate( final java.util.Date date ) {
    this.date = date;
  }

  public EventCategoriesList getEventCategories( ) {
    return eventCategories;
  }

  public void setEventCategories( final EventCategoriesList eventCategories ) {
    this.eventCategories = eventCategories;
  }

  public String getMessage( ) {
    return message;
  }

  public void setMessage( final String message ) {
    this.message = message;
  }

  public String getSourceArn( ) {
    return sourceArn;
  }

  public void setSourceArn( final String sourceArn ) {
    this.sourceArn = sourceArn;
  }

  public String getSourceIdentifier( ) {
    return sourceIdentifier;
  }

  public void setSourceIdentifier( final String sourceIdentifier ) {
    this.sourceIdentifier = sourceIdentifier;
  }

  public String getSourceType( ) {
    return sourceType;
  }

  public void setSourceType( final String sourceType ) {
    this.sourceType = sourceType;
  }

}
