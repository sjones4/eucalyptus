/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import javax.annotation.Nonnull;


public class RemoveTagsFromResourceType extends RdsMessage {

  @Nonnull
  private String resourceName;

  @Nonnull
  private KeyList tagKeys;

  public String getResourceName() {
    return resourceName;
  }

  public void setResourceName(final String resourceName) {
    this.resourceName = resourceName;
  }

  public KeyList getTagKeys() {
    return tagKeys;
  }

  public void setTagKeys(final KeyList tagKeys) {
    this.tagKeys = tagKeys;
  }

}
