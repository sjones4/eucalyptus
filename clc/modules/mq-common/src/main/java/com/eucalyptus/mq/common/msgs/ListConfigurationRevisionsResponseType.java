/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.mq.common.msgs;

import javax.annotation.Nonnull;
import com.eucalyptus.binding.HttpContent;
import com.eucalyptus.binding.HttpHeaderMapping;
import com.eucalyptus.binding.HttpNoContent;
import com.eucalyptus.mq.common.MqMessageValidation.FieldRange;
import com.eucalyptus.mq.common.MqMessageValidation.FieldRegex;
import com.eucalyptus.mq.common.MqMessageValidation.FieldRegexValue;



public class ListConfigurationRevisionsResponseType extends MqMessage {


  private String configurationId;
  private Integer maxResults;
  private String nextToken;
  private java.util.ArrayList<ConfigurationRevision> revisions;

  public String getConfigurationId( ) {
    return configurationId;
  }

  public void setConfigurationId( final String configurationId ) {
    this.configurationId = configurationId;
  }

  public Integer getMaxResults( ) {
    return maxResults;
  }

  public void setMaxResults( final Integer maxResults ) {
    this.maxResults = maxResults;
  }

  public String getNextToken( ) {
    return nextToken;
  }

  public void setNextToken( final String nextToken ) {
    this.nextToken = nextToken;
  }

  public java.util.ArrayList<ConfigurationRevision> getRevisions( ) {
    return revisions;
  }

  public void setRevisions( final java.util.ArrayList<ConfigurationRevision> revisions ) {
    this.revisions = revisions;
  }

}
