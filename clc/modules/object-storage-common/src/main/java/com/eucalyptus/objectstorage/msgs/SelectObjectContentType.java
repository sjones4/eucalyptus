/**
 * Copyright 2020 AppScale Systems, Inc
 *
 * SPDX-License-Identifier: BSD-2-Clause
 */
package com.eucalyptus.objectstorage.msgs;

import com.eucalyptus.binding.HttpParameterMapping;
import com.eucalyptus.objectstorage.policy.AdminOverrideAllowed;
import com.eucalyptus.objectstorage.policy.RequiresACLPermission;
import com.eucalyptus.objectstorage.policy.RequiresPermission;
import com.eucalyptus.objectstorage.policy.ResourceType;
import com.eucalyptus.objectstorage.policy.S3PolicySpec;
import com.eucalyptus.objectstorage.util.ObjectStorageProperties;

@AdminOverrideAllowed
@RequiresPermission( standard = S3PolicySpec.S3_GETOBJECT, version = S3PolicySpec.S3_GETOBJECTVERSION )
@ResourceType( S3PolicySpec.S3_RESOURCE_OBJECT )
@RequiresACLPermission( object = { ObjectStorageProperties.Permission.READ }, bucket = {} )
public class SelectObjectContentType extends ObjectStorageRequestType {

  private String expression;
  private String expressionType;

  @HttpParameterMapping(parameter = "select-type")
  private String selectType;

  public String getExpression() {
    return expression;
  }

  public void setExpression(final String expression) {
    this.expression = expression;
  }

  public String getExpressionType() {
    return expressionType;
  }

  public void setExpressionType(final String expressionType) {
    this.expressionType = expressionType;
  }

  public String getSelectType() {
    return selectType;
  }

  public void setSelectType(final String selectType) {
    this.selectType = selectType;
  }
}
