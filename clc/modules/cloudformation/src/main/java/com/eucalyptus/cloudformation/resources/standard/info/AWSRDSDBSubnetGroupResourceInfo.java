/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudformation.resources.standard.info;

import com.eucalyptus.cloudformation.resources.ResourceInfo;
import com.google.common.base.MoreObjects;

/**
 *
 */
public class AWSRDSDBSubnetGroupResourceInfo extends ResourceInfo {

  public AWSRDSDBSubnetGroupResourceInfo( ) {
    setType( "AWS::RDS::DBSubnetGroup" );
  }

  @Override
  public boolean supportsTags( ) {
    return true;
  }

  @Override
  public String toString( ) {
    return MoreObjects.toStringHelper( this )
        .toString( );
  }
}