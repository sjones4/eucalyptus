/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.secretsmanager.service;

import com.eucalyptus.component.annotation.ComponentNamed;
import com.eucalyptus.secretsmanager.common.msgs.*;

/**
 *
 */
@ComponentNamed
public class SecretsmanagerService {

  public CancelRotateSecretResponseType cancelRotateSecret( final CancelRotateSecretType request ) {
    return request.getReply( );
  }
  
  public CreateSecretResponseType createSecret( final CreateSecretType request ) {
    return request.getReply( );
  }
  
  public DeleteResourcePolicyResponseType deleteResourcePolicy( final DeleteResourcePolicyType request ) {
    return request.getReply( );
  }
  
  public DeleteSecretResponseType deleteSecret( final DeleteSecretType request ) {
    return request.getReply( );
  }
  
  public DescribeSecretResponseType describeSecret( final DescribeSecretType request ) {
    return request.getReply( );
  }
  
  public GetRandomPasswordResponseType getRandomPassword( final GetRandomPasswordType request ) {
    return request.getReply( );
  }
  
  public GetResourcePolicyResponseType getResourcePolicy( final GetResourcePolicyType request ) {
    return request.getReply( );
  }
  
  public GetSecretValueResponseType getSecretValue( final GetSecretValueType request ) {
    return request.getReply( );
  }
  
  public ListSecretVersionIdsResponseType listSecretVersionIds( final ListSecretVersionIdsType request ) {
    return request.getReply( );
  }
  
  public ListSecretsResponseType listSecrets( final ListSecretsType request ) {
    return request.getReply( );
  }
  
  public PutResourcePolicyResponseType putResourcePolicy( final PutResourcePolicyType request ) {
    return request.getReply( );
  }
  
  public PutSecretValueResponseType putSecretValue( final PutSecretValueType request ) {
    return request.getReply( );
  }
  
  public RestoreSecretResponseType restoreSecret( final RestoreSecretType request ) {
    return request.getReply( );
  }
  
  public RotateSecretResponseType rotateSecret( final RotateSecretType request ) {
    return request.getReply( );
  }
  
  public TagResourceResponseType tagResource( final TagResourceType request ) {
    return request.getReply( );
  }
  
  public UntagResourceResponseType untagResource( final UntagResourceType request ) {
    return request.getReply( );
  }
  
  public UpdateSecretResponseType updateSecret( final UpdateSecretType request ) {
    return request.getReply( );
  }
  
  public UpdateSecretVersionStageResponseType updateSecretVersionStage( final UpdateSecretVersionStageType request ) {
    return request.getReply( );
  }
  
}
