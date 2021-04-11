/*
 * Copyright 2021 AppScale Systems, Inc
 *
 * SPDX-License-Identifier: BSD-2-Clause
 */
package com.eucalyptus.rds.service;

import com.eucalyptus.ws.EucalyptusWebServiceException;
import com.eucalyptus.ws.Role;

/**
 *
 */
public class RdsException extends EucalyptusWebServiceException {

  private static final long serialVersionUID = 1L;

  public RdsException(
      final String code,
      final Role role,
      final String message) {
    super(code, role, message);
  }
}
