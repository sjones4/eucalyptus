/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.mq.service;

import com.eucalyptus.component.annotation.ComponentNamed;
import com.eucalyptus.mq.common.msgs.*;

/**
 *
 */
@ComponentNamed
public class MqService {

  public CreateBrokerResponseType createBroker( final CreateBrokerType request ) {
    return request.getReply( );
  }
  
  public CreateConfigurationResponseType createConfiguration( final CreateConfigurationType request ) {
    return request.getReply( );
  }
  
  public CreateUserResponseType createUser( final CreateUserType request ) {
    return request.getReply( );
  }
  
  public DeleteBrokerResponseType deleteBroker( final DeleteBrokerType request ) {
    return request.getReply( );
  }
  
  public DeleteUserResponseType deleteUser( final DeleteUserType request ) {
    return request.getReply( );
  }
  
  public DescribeBrokerResponseType describeBroker( final DescribeBrokerType request ) {
    return request.getReply( );
  }
  
  public DescribeConfigurationResponseType describeConfiguration( final DescribeConfigurationType request ) {
    return request.getReply( );
  }
  
  public DescribeConfigurationRevisionResponseType describeConfigurationRevision( final DescribeConfigurationRevisionType request ) {
    return request.getReply( );
  }
  
  public DescribeUserResponseType describeUser( final DescribeUserType request ) {
    return request.getReply( );
  }
  
  public ListBrokersResponseType listBrokers( final ListBrokersType request ) {
    return request.getReply( );
  }
  
  public ListConfigurationRevisionsResponseType listConfigurationRevisions( final ListConfigurationRevisionsType request ) {
    return request.getReply( );
  }
  
  public ListConfigurationsResponseType listConfigurations( final ListConfigurationsType request ) {
    return request.getReply( );
  }
  
  public ListUsersResponseType listUsers( final ListUsersType request ) {
    return request.getReply( );
  }
  
  public RebootBrokerResponseType rebootBroker( final RebootBrokerType request ) {
    return request.getReply( );
  }
  
  public UpdateBrokerResponseType updateBroker( final UpdateBrokerType request ) {
    return request.getReply( );
  }
  
  public UpdateConfigurationResponseType updateConfiguration( final UpdateConfigurationType request ) {
    return request.getReply( );
  }
  
  public UpdateUserResponseType updateUser( final UpdateUserType request ) {
    return request.getReply( );
  }
  
}
