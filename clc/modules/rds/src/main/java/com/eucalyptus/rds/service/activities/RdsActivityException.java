/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.service.activities;

/**
 *
 */
public class RdsActivityException extends Exception {

  private static final long serialVersionUID = 1L;

  public RdsActivityException(String message){
    super(message);
  }

  public RdsActivityException(String message, Throwable cause){
    super(message, cause);
  }
}

