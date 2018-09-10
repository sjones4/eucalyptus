/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.mq.common;

import com.eucalyptus.mq.common.msgs.*;
import com.eucalyptus.util.async.CheckedListenableFuture;

public interface MqApiAsync {

  CheckedListenableFuture<CreateBrokerResponseType> createBrokerAsync( final CreateBrokerType request );

  default CheckedListenableFuture<CreateBrokerResponseType> createBrokerAsync( ) {
    return createBrokerAsync( new CreateBrokerType( ) );
  }

  CheckedListenableFuture<CreateConfigurationResponseType> createConfigurationAsync( final CreateConfigurationType request );

  default CheckedListenableFuture<CreateConfigurationResponseType> createConfigurationAsync( ) {
    return createConfigurationAsync( new CreateConfigurationType( ) );
  }

  CheckedListenableFuture<CreateUserResponseType> createUserAsync( final CreateUserType request );

  CheckedListenableFuture<DeleteBrokerResponseType> deleteBrokerAsync( final DeleteBrokerType request );

  CheckedListenableFuture<DeleteUserResponseType> deleteUserAsync( final DeleteUserType request );

  CheckedListenableFuture<DescribeBrokerResponseType> describeBrokerAsync( final DescribeBrokerType request );

  CheckedListenableFuture<DescribeConfigurationResponseType> describeConfigurationAsync( final DescribeConfigurationType request );

  CheckedListenableFuture<DescribeConfigurationRevisionResponseType> describeConfigurationRevisionAsync( final DescribeConfigurationRevisionType request );

  CheckedListenableFuture<DescribeUserResponseType> describeUserAsync( final DescribeUserType request );

  CheckedListenableFuture<ListBrokersResponseType> listBrokersAsync( final ListBrokersType request );

  default CheckedListenableFuture<ListBrokersResponseType> listBrokersAsync( ) {
    return listBrokersAsync( new ListBrokersType( ) );
  }

  CheckedListenableFuture<ListConfigurationRevisionsResponseType> listConfigurationRevisionsAsync( final ListConfigurationRevisionsType request );

  CheckedListenableFuture<ListConfigurationsResponseType> listConfigurationsAsync( final ListConfigurationsType request );

  default CheckedListenableFuture<ListConfigurationsResponseType> listConfigurationsAsync( ) {
    return listConfigurationsAsync( new ListConfigurationsType( ) );
  }

  CheckedListenableFuture<ListUsersResponseType> listUsersAsync( final ListUsersType request );

  CheckedListenableFuture<RebootBrokerResponseType> rebootBrokerAsync( final RebootBrokerType request );

  CheckedListenableFuture<UpdateBrokerResponseType> updateBrokerAsync( final UpdateBrokerType request );

  CheckedListenableFuture<UpdateConfigurationResponseType> updateConfigurationAsync( final UpdateConfigurationType request );

  CheckedListenableFuture<UpdateUserResponseType> updateUserAsync( final UpdateUserType request );

}
