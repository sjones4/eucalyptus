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
public class RdsMetadataException extends Exception {
  private static final long serialVersionUID = 1L;

  public RdsMetadataException( final String message ) {
    super( message );
  }

  public RdsMetadataException( final String message, final Throwable cause ) {
    super( message, cause );
  }
}
