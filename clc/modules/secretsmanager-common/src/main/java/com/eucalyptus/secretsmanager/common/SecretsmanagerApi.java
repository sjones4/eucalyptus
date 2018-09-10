/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.secretsmanager.common;

import com.eucalyptus.secretsmanager.common.msgs.*;


public interface SecretsmanagerApi {

  CancelRotateSecretResponseType cancelRotateSecret( final CancelRotateSecretType request );

  CreateSecretResponseType createSecret( final CreateSecretType request );

  DeleteResourcePolicyResponseType deleteResourcePolicy( final DeleteResourcePolicyType request );

  DeleteSecretResponseType deleteSecret( final DeleteSecretType request );

  DescribeSecretResponseType describeSecret( final DescribeSecretType request );

  GetRandomPasswordResponseType getRandomPassword( final GetRandomPasswordType request );

  default GetRandomPasswordResponseType getRandomPassword( ) {
    return getRandomPassword( new GetRandomPasswordType( ) );
  }

  GetResourcePolicyResponseType getResourcePolicy( final GetResourcePolicyType request );

  GetSecretValueResponseType getSecretValue( final GetSecretValueType request );

  ListSecretVersionIdsResponseType listSecretVersionIds( final ListSecretVersionIdsType request );

  ListSecretsResponseType listSecrets( final ListSecretsType request );

  default ListSecretsResponseType listSecrets( ) {
    return listSecrets( new ListSecretsType( ) );
  }

  PutResourcePolicyResponseType putResourcePolicy( final PutResourcePolicyType request );

  PutSecretValueResponseType putSecretValue( final PutSecretValueType request );

  RestoreSecretResponseType restoreSecret( final RestoreSecretType request );

  RotateSecretResponseType rotateSecret( final RotateSecretType request );

  TagResourceResponseType tagResource( final TagResourceType request );

  UntagResourceResponseType untagResource( final UntagResourceType request );

  UpdateSecretResponseType updateSecret( final UpdateSecretType request );

  UpdateSecretVersionStageResponseType updateSecretVersionStage( final UpdateSecretVersionStageType request );

}
