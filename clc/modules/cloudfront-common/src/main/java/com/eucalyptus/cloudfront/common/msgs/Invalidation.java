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


public class Invalidation extends EucalyptusData {

  @Nonnull
  private java.util.Date createTime;
  @Nonnull
  private String id;
  @Nonnull
  private InvalidationBatch invalidationBatch;
  @Nonnull
  private String status;

  public java.util.Date getCreateTime( ) {
    return createTime;
  }

  public void setCreateTime( final java.util.Date createTime ) {
    this.createTime = createTime;
  }

  public String getId( ) {
    return id;
  }

  public void setId( final String id ) {
    this.id = id;
  }

  public InvalidationBatch getInvalidationBatch( ) {
    return invalidationBatch;
  }

  public void setInvalidationBatch( final InvalidationBatch invalidationBatch ) {
    this.invalidationBatch = invalidationBatch;
  }

  public String getStatus( ) {
    return status;
  }

  public void setStatus( final String status ) {
    this.status = status;
  }

}
