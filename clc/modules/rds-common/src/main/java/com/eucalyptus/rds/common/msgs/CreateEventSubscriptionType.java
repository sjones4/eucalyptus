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
import com.eucalyptus.binding.HttpNoContent;
import com.eucalyptus.binding.HttpHeaderMapping;
import com.eucalyptus.binding.HttpParameterMapping;
import com.eucalyptus.binding.HttpRequestMapping;
import com.eucalyptus.binding.HttpUriMapping;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRange;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRegex;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRegexValue;



public class CreateEventSubscriptionType extends RdsMessage {

  private Boolean enabled;
  private EventCategoriesList eventCategories;
  @Nonnull
  private String snsTopicArn;
  private SourceIdsList sourceIds;
  private String sourceType;
  @Nonnull
  private String subscriptionName;
  private TagList tags;

  public Boolean getEnabled( ) {
    return enabled;
  }

  public void setEnabled( final Boolean enabled ) {
    this.enabled = enabled;
  }

  public EventCategoriesList getEventCategories( ) {
    return eventCategories;
  }

  public void setEventCategories( final EventCategoriesList eventCategories ) {
    this.eventCategories = eventCategories;
  }

  public String getSnsTopicArn( ) {
    return snsTopicArn;
  }

  public void setSnsTopicArn( final String snsTopicArn ) {
    this.snsTopicArn = snsTopicArn;
  }

  public SourceIdsList getSourceIds( ) {
    return sourceIds;
  }

  public void setSourceIds( final SourceIdsList sourceIds ) {
    this.sourceIds = sourceIds;
  }

  public String getSourceType( ) {
    return sourceType;
  }

  public void setSourceType( final String sourceType ) {
    this.sourceType = sourceType;
  }

  public String getSubscriptionName( ) {
    return subscriptionName;
  }

  public void setSubscriptionName( final String subscriptionName ) {
    this.subscriptionName = subscriptionName;
  }

  public TagList getTags( ) {
    return tags;
  }

  public void setTags( final TagList tags ) {
    this.tags = tags;
  }

}
