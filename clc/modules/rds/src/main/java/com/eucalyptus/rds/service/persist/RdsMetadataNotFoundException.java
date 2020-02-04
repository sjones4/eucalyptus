/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.service.persist;

/**
 *
 */
public class RdsMetadataNotFoundException extends RdsMetadataException {
  private static final long serialVersionUID = 1L;

  public RdsMetadataNotFoundException( final String message ) {
    super( message );
  }

  public RdsMetadataNotFoundException( final String message, final Throwable cause ) {
    super( message, cause );
  }
}
