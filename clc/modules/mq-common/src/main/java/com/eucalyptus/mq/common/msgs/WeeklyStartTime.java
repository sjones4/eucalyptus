/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.mq.common.msgs;

import edu.ucsb.eucalyptus.msgs.EucalyptusData;
import javax.annotation.Nonnull;
import com.eucalyptus.mq.common.MqMessageValidation.FieldRange;
import com.eucalyptus.mq.common.MqMessageValidation.FieldRegex;
import com.eucalyptus.mq.common.MqMessageValidation.FieldRegexValue;


public class WeeklyStartTime extends EucalyptusData {

  @FieldRegex(FieldRegexValue.ENUM_DAYOFWEEK)
  private String dayOfWeek;
  private String timeOfDay;
  private String timeZone;

  public String getDayOfWeek( ) {
    return dayOfWeek;
  }

  public void setDayOfWeek( final String dayOfWeek ) {
    this.dayOfWeek = dayOfWeek;
  }

  public String getTimeOfDay( ) {
    return timeOfDay;
  }

  public void setTimeOfDay( final String timeOfDay ) {
    this.timeOfDay = timeOfDay;
  }

  public String getTimeZone( ) {
    return timeZone;
  }

  public void setTimeZone( final String timeZone ) {
    this.timeZone = timeZone;
  }

}
