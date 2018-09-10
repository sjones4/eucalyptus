/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.secretsmanager.common;

import com.eucalyptus.secretsmanager.common.msgs.*;
import com.eucalyptus.util.async.CheckedListenableFuture;

public interface SecretsmanagerApiAsync {

  CheckedListenableFuture<CancelRotateSecretResponseType> cancelRotateSecretAsync( final CancelRotateSecretType request );

  CheckedListenableFuture<CreateSecretResponseType> createSecretAsync( final CreateSecretType request );

  CheckedListenableFuture<DeleteResourcePolicyResponseType> deleteResourcePolicyAsync( final DeleteResourcePolicyType request );

  CheckedListenableFuture<DeleteSecretResponseType> deleteSecretAsync( final DeleteSecretType request );

  CheckedListenableFuture<DescribeSecretResponseType> describeSecretAsync( final DescribeSecretType request );

  CheckedListenableFuture<GetRandomPasswordResponseType> getRandomPasswordAsync( final GetRandomPasswordType request );

  default CheckedListenableFuture<GetRandomPasswordResponseType> getRandomPasswordAsync( ) {
    return getRandomPasswordAsync( new GetRandomPasswordType( ) );
  }

  CheckedListenableFuture<GetResourcePolicyResponseType> getResourcePolicyAsync( final GetResourcePolicyType request );

  CheckedListenableFuture<GetSecretValueResponseType> getSecretValueAsync( final GetSecretValueType request );

  CheckedListenableFuture<ListSecretVersionIdsResponseType> listSecretVersionIdsAsync( final ListSecretVersionIdsType request );

  CheckedListenableFuture<ListSecretsResponseType> listSecretsAsync( final ListSecretsType request );

  default CheckedListenableFuture<ListSecretsResponseType> listSecretsAsync( ) {
    return listSecretsAsync( new ListSecretsType( ) );
  }

  CheckedListenableFuture<PutResourcePolicyResponseType> putResourcePolicyAsync( final PutResourcePolicyType request );

  CheckedListenableFuture<PutSecretValueResponseType> putSecretValueAsync( final PutSecretValueType request );

  CheckedListenableFuture<RestoreSecretResponseType> restoreSecretAsync( final RestoreSecretType request );

  CheckedListenableFuture<RotateSecretResponseType> rotateSecretAsync( final RotateSecretType request );

  CheckedListenableFuture<TagResourceResponseType> tagResourceAsync( final TagResourceType request );

  CheckedListenableFuture<UntagResourceResponseType> untagResourceAsync( final UntagResourceType request );

  CheckedListenableFuture<UpdateSecretResponseType> updateSecretAsync( final UpdateSecretType request );

  CheckedListenableFuture<UpdateSecretVersionStageResponseType> updateSecretVersionStageAsync( final UpdateSecretVersionStageType request );

}
