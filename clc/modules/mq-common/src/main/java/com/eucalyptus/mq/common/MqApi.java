/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.mq.common;

import com.eucalyptus.mq.common.msgs.*;


public interface MqApi {

  CreateBrokerResponseType createBroker( final CreateBrokerType request );

  default CreateBrokerResponseType createBroker( ) {
    return createBroker( new CreateBrokerType( ) );
  }

  CreateConfigurationResponseType createConfiguration( final CreateConfigurationType request );

  default CreateConfigurationResponseType createConfiguration( ) {
    return createConfiguration( new CreateConfigurationType( ) );
  }

  CreateUserResponseType createUser( final CreateUserType request );

  DeleteBrokerResponseType deleteBroker( final DeleteBrokerType request );

  DeleteUserResponseType deleteUser( final DeleteUserType request );

  DescribeBrokerResponseType describeBroker( final DescribeBrokerType request );

  DescribeConfigurationResponseType describeConfiguration( final DescribeConfigurationType request );

  DescribeConfigurationRevisionResponseType describeConfigurationRevision( final DescribeConfigurationRevisionType request );

  DescribeUserResponseType describeUser( final DescribeUserType request );

  ListBrokersResponseType listBrokers( final ListBrokersType request );

  default ListBrokersResponseType listBrokers( ) {
    return listBrokers( new ListBrokersType( ) );
  }

  ListConfigurationRevisionsResponseType listConfigurationRevisions( final ListConfigurationRevisionsType request );

  ListConfigurationsResponseType listConfigurations( final ListConfigurationsType request );

  default ListConfigurationsResponseType listConfigurations( ) {
    return listConfigurations( new ListConfigurationsType( ) );
  }

  ListUsersResponseType listUsers( final ListUsersType request );

  RebootBrokerResponseType rebootBroker( final RebootBrokerType request );

  UpdateBrokerResponseType updateBroker( final UpdateBrokerType request );

  UpdateConfigurationResponseType updateConfiguration( final UpdateConfigurationType request );

  UpdateUserResponseType updateUser( final UpdateUserType request );

}
