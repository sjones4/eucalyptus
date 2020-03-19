/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common;

import com.eucalyptus.auth.policy.annotation.PolicyVendor;
import com.eucalyptus.component.ComponentId;
import com.eucalyptus.component.annotation.AwsServiceName;
import com.eucalyptus.component.annotation.Description;
import com.eucalyptus.component.annotation.Partition;
import com.eucalyptus.component.annotation.PublicService;
import com.eucalyptus.util.techpreview.TechPreview;

/**
 *
 */
@PublicService
@AwsServiceName("rds")
@PolicyVendor("rds")
@Partition(value = Rds.class, manyToOne = true)
@Description("Amazon RDS API service")
@TechPreview(enableByDefaultProperty = "enable.rds.tech.preview")
public class Rds extends ComponentId {

  private static final long serialVersionUID = 1L;
}
