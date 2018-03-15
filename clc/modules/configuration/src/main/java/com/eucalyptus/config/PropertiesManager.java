package com.eucalyptus.config;

import com.eucalyptus.config.msgs.DescribePropertiesResponseType;
import com.eucalyptus.config.msgs.DescribePropertiesType;
import com.eucalyptus.config.msgs.ModifyPropertyValueResponseType;
import com.eucalyptus.config.msgs.ModifyPropertyValueType;
import com.eucalyptus.util.EucalyptusCloudException;

/**
 *
 */
public interface PropertiesManager {

  DescribePropertiesResponseType describeProperties( DescribePropertiesType request ) throws EucalyptusCloudException;

  ModifyPropertyValueResponseType modifyProperty( ModifyPropertyValueType request ) throws EucalyptusCloudException;
}
