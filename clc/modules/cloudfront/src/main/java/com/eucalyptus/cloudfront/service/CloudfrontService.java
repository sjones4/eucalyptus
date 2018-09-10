/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudfront.service;

import com.eucalyptus.component.annotation.ComponentNamed;
import com.eucalyptus.cloudfront.common.msgs.*;

/**
 *
 */
@ComponentNamed
public class CloudfrontService {

  public CreateCloudFrontOriginAccessIdentityResponseType createCloudFrontOriginAccessIdentity( final CreateCloudFrontOriginAccessIdentityType request ) {
    return request.getReply( );
  }
  
  public CreateDistributionResponseType createDistribution( final CreateDistributionType request ) {
    return request.getReply( );
  }
  
  public CreateDistributionWithTagsResponseType createDistributionWithTags( final CreateDistributionWithTagsType request ) {
    return request.getReply( );
  }
  
  public CreateFieldLevelEncryptionConfigResponseType createFieldLevelEncryptionConfig( final CreateFieldLevelEncryptionConfigType request ) {
    return request.getReply( );
  }
  
  public CreateFieldLevelEncryptionProfileResponseType createFieldLevelEncryptionProfile( final CreateFieldLevelEncryptionProfileType request ) {
    return request.getReply( );
  }
  
  public CreateInvalidationResponseType createInvalidation( final CreateInvalidationType request ) {
    return request.getReply( );
  }
  
  public CreatePublicKeyResponseType createPublicKey( final CreatePublicKeyType request ) {
    return request.getReply( );
  }
  
  public CreateStreamingDistributionResponseType createStreamingDistribution( final CreateStreamingDistributionType request ) {
    return request.getReply( );
  }
  
  public CreateStreamingDistributionWithTagsResponseType createStreamingDistributionWithTags( final CreateStreamingDistributionWithTagsType request ) {
    return request.getReply( );
  }
  
  public DeleteCloudFrontOriginAccessIdentityResponseType deleteCloudFrontOriginAccessIdentity( final DeleteCloudFrontOriginAccessIdentityType request ) {
    return request.getReply( );
  }
  
  public DeleteDistributionResponseType deleteDistribution( final DeleteDistributionType request ) {
    return request.getReply( );
  }
  
  public DeleteFieldLevelEncryptionConfigResponseType deleteFieldLevelEncryptionConfig( final DeleteFieldLevelEncryptionConfigType request ) {
    return request.getReply( );
  }
  
  public DeleteFieldLevelEncryptionProfileResponseType deleteFieldLevelEncryptionProfile( final DeleteFieldLevelEncryptionProfileType request ) {
    return request.getReply( );
  }
  
  public DeletePublicKeyResponseType deletePublicKey( final DeletePublicKeyType request ) {
    return request.getReply( );
  }
  
  public DeleteStreamingDistributionResponseType deleteStreamingDistribution( final DeleteStreamingDistributionType request ) {
    return request.getReply( );
  }
  
  public GetCloudFrontOriginAccessIdentityResponseType getCloudFrontOriginAccessIdentity( final GetCloudFrontOriginAccessIdentityType request ) {
    return request.getReply( );
  }
  
  public GetCloudFrontOriginAccessIdentityConfigResponseType getCloudFrontOriginAccessIdentityConfig( final GetCloudFrontOriginAccessIdentityConfigType request ) {
    return request.getReply( );
  }
  
  public GetDistributionResponseType getDistribution( final GetDistributionType request ) {
    return request.getReply( );
  }
  
  public GetDistributionConfigResponseType getDistributionConfig( final GetDistributionConfigType request ) {
    return request.getReply( );
  }
  
  public GetFieldLevelEncryptionResponseType getFieldLevelEncryption( final GetFieldLevelEncryptionType request ) {
    return request.getReply( );
  }
  
  public GetFieldLevelEncryptionConfigResponseType getFieldLevelEncryptionConfig( final GetFieldLevelEncryptionConfigType request ) {
    return request.getReply( );
  }
  
  public GetFieldLevelEncryptionProfileResponseType getFieldLevelEncryptionProfile( final GetFieldLevelEncryptionProfileType request ) {
    return request.getReply( );
  }
  
  public GetFieldLevelEncryptionProfileConfigResponseType getFieldLevelEncryptionProfileConfig( final GetFieldLevelEncryptionProfileConfigType request ) {
    return request.getReply( );
  }
  
  public GetInvalidationResponseType getInvalidation( final GetInvalidationType request ) {
    return request.getReply( );
  }
  
  public GetPublicKeyResponseType getPublicKey( final GetPublicKeyType request ) {
    return request.getReply( );
  }
  
  public GetPublicKeyConfigResponseType getPublicKeyConfig( final GetPublicKeyConfigType request ) {
    return request.getReply( );
  }
  
  public GetStreamingDistributionResponseType getStreamingDistribution( final GetStreamingDistributionType request ) {
    return request.getReply( );
  }
  
  public GetStreamingDistributionConfigResponseType getStreamingDistributionConfig( final GetStreamingDistributionConfigType request ) {
    return request.getReply( );
  }
  
  public ListCloudFrontOriginAccessIdentitiesResponseType listCloudFrontOriginAccessIdentities( final ListCloudFrontOriginAccessIdentitiesType request ) {
    return request.getReply( );
  }
  
  public ListDistributionsResponseType listDistributions( final ListDistributionsType request ) {
    return request.getReply( );
  }
  
  public ListDistributionsByWebACLIdResponseType listDistributionsByWebACLId( final ListDistributionsByWebACLIdType request ) {
    return request.getReply( );
  }
  
  public ListFieldLevelEncryptionConfigsResponseType listFieldLevelEncryptionConfigs( final ListFieldLevelEncryptionConfigsType request ) {
    return request.getReply( );
  }
  
  public ListFieldLevelEncryptionProfilesResponseType listFieldLevelEncryptionProfiles( final ListFieldLevelEncryptionProfilesType request ) {
    return request.getReply( );
  }
  
  public ListInvalidationsResponseType listInvalidations( final ListInvalidationsType request ) {
    return request.getReply( );
  }
  
  public ListPublicKeysResponseType listPublicKeys( final ListPublicKeysType request ) {
    return request.getReply( );
  }
  
  public ListStreamingDistributionsResponseType listStreamingDistributions( final ListStreamingDistributionsType request ) {
    return request.getReply( );
  }
  
  public ListTagsForResourceResponseType listTagsForResource( final ListTagsForResourceType request ) {
    return request.getReply( );
  }
  
  public TagResourceResponseType tagResource( final TagResourceType request ) {
    return request.getReply( );
  }
  
  public UntagResourceResponseType untagResource( final UntagResourceType request ) {
    return request.getReply( );
  }
  
  public UpdateCloudFrontOriginAccessIdentityResponseType updateCloudFrontOriginAccessIdentity( final UpdateCloudFrontOriginAccessIdentityType request ) {
    return request.getReply( );
  }
  
  public UpdateDistributionResponseType updateDistribution( final UpdateDistributionType request ) {
    return request.getReply( );
  }
  
  public UpdateFieldLevelEncryptionConfigResponseType updateFieldLevelEncryptionConfig( final UpdateFieldLevelEncryptionConfigType request ) {
    return request.getReply( );
  }
  
  public UpdateFieldLevelEncryptionProfileResponseType updateFieldLevelEncryptionProfile( final UpdateFieldLevelEncryptionProfileType request ) {
    return request.getReply( );
  }
  
  public UpdatePublicKeyResponseType updatePublicKey( final UpdatePublicKeyType request ) {
    return request.getReply( );
  }
  
  public UpdateStreamingDistributionResponseType updateStreamingDistribution( final UpdateStreamingDistributionType request ) {
    return request.getReply( );
  }
  
}
