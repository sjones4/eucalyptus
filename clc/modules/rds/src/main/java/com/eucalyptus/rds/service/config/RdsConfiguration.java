/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.service.config;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.PersistenceContext;
import com.eucalyptus.component.annotation.ComponentPart;
import com.eucalyptus.config.ComponentConfiguration;
import com.eucalyptus.rds.common.Rds;

/**
 *
 */
@Entity
@PersistenceContext(name = "eucalyptus_config")
@ComponentPart(Rds.class)
public class RdsConfiguration extends ComponentConfiguration implements Serializable {

  public static final String SERVICE_PATH = "/services/Rds";

  private static final long serialVersionUID = 1L;

  public RdsConfiguration() {
  }

  public RdsConfiguration(String partition, String name, String hostName, Integer port) {
    super(partition, name, hostName, port, SERVICE_PATH);
  }
}
