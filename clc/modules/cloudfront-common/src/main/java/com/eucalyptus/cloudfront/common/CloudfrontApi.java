/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudfront.common;

import com.eucalyptus.cloudfront.common.msgs.*;


public interface CloudfrontApi {

  CreateCloudFrontOriginAccessIdentityResponseType createCloudFrontOriginAccessIdentity( final CreateCloudFrontOriginAccessIdentityType request );

  CreateDistributionResponseType createDistribution( final CreateDistributionType request );

  CreateDistributionWithTagsResponseType createDistributionWithTags( final CreateDistributionWithTagsType request );

  CreateFieldLevelEncryptionConfigResponseType createFieldLevelEncryptionConfig( final CreateFieldLevelEncryptionConfigType request );

  CreateFieldLevelEncryptionProfileResponseType createFieldLevelEncryptionProfile( final CreateFieldLevelEncryptionProfileType request );

  CreateInvalidationResponseType createInvalidation( final CreateInvalidationType request );

  CreatePublicKeyResponseType createPublicKey( final CreatePublicKeyType request );

  CreateStreamingDistributionResponseType createStreamingDistribution( final CreateStreamingDistributionType request );

  CreateStreamingDistributionWithTagsResponseType createStreamingDistributionWithTags( final CreateStreamingDistributionWithTagsType request );

  DeleteCloudFrontOriginAccessIdentityResponseType deleteCloudFrontOriginAccessIdentity( final DeleteCloudFrontOriginAccessIdentityType request );

  DeleteDistributionResponseType deleteDistribution( final DeleteDistributionType request );

  DeleteFieldLevelEncryptionConfigResponseType deleteFieldLevelEncryptionConfig( final DeleteFieldLevelEncryptionConfigType request );

  DeleteFieldLevelEncryptionProfileResponseType deleteFieldLevelEncryptionProfile( final DeleteFieldLevelEncryptionProfileType request );

  DeletePublicKeyResponseType deletePublicKey( final DeletePublicKeyType request );

  DeleteStreamingDistributionResponseType deleteStreamingDistribution( final DeleteStreamingDistributionType request );

  GetCloudFrontOriginAccessIdentityResponseType getCloudFrontOriginAccessIdentity( final GetCloudFrontOriginAccessIdentityType request );

  GetCloudFrontOriginAccessIdentityConfigResponseType getCloudFrontOriginAccessIdentityConfig( final GetCloudFrontOriginAccessIdentityConfigType request );

  GetDistributionResponseType getDistribution( final GetDistributionType request );

  GetDistributionConfigResponseType getDistributionConfig( final GetDistributionConfigType request );

  GetFieldLevelEncryptionResponseType getFieldLevelEncryption( final GetFieldLevelEncryptionType request );

  GetFieldLevelEncryptionConfigResponseType getFieldLevelEncryptionConfig( final GetFieldLevelEncryptionConfigType request );

  GetFieldLevelEncryptionProfileResponseType getFieldLevelEncryptionProfile( final GetFieldLevelEncryptionProfileType request );

  GetFieldLevelEncryptionProfileConfigResponseType getFieldLevelEncryptionProfileConfig( final GetFieldLevelEncryptionProfileConfigType request );

  GetInvalidationResponseType getInvalidation( final GetInvalidationType request );

  GetPublicKeyResponseType getPublicKey( final GetPublicKeyType request );

  GetPublicKeyConfigResponseType getPublicKeyConfig( final GetPublicKeyConfigType request );

  GetStreamingDistributionResponseType getStreamingDistribution( final GetStreamingDistributionType request );

  GetStreamingDistributionConfigResponseType getStreamingDistributionConfig( final GetStreamingDistributionConfigType request );

  ListCloudFrontOriginAccessIdentitiesResponseType listCloudFrontOriginAccessIdentities( final ListCloudFrontOriginAccessIdentitiesType request );

  default ListCloudFrontOriginAccessIdentitiesResponseType listCloudFrontOriginAccessIdentities( ) {
    return listCloudFrontOriginAccessIdentities( new ListCloudFrontOriginAccessIdentitiesType( ) );
  }

  ListDistributionsResponseType listDistributions( final ListDistributionsType request );

  default ListDistributionsResponseType listDistributions( ) {
    return listDistributions( new ListDistributionsType( ) );
  }

  ListDistributionsByWebACLIdResponseType listDistributionsByWebACLId( final ListDistributionsByWebACLIdType request );

  ListFieldLevelEncryptionConfigsResponseType listFieldLevelEncryptionConfigs( final ListFieldLevelEncryptionConfigsType request );

  default ListFieldLevelEncryptionConfigsResponseType listFieldLevelEncryptionConfigs( ) {
    return listFieldLevelEncryptionConfigs( new ListFieldLevelEncryptionConfigsType( ) );
  }

  ListFieldLevelEncryptionProfilesResponseType listFieldLevelEncryptionProfiles( final ListFieldLevelEncryptionProfilesType request );

  default ListFieldLevelEncryptionProfilesResponseType listFieldLevelEncryptionProfiles( ) {
    return listFieldLevelEncryptionProfiles( new ListFieldLevelEncryptionProfilesType( ) );
  }

  ListInvalidationsResponseType listInvalidations( final ListInvalidationsType request );

  ListPublicKeysResponseType listPublicKeys( final ListPublicKeysType request );

  default ListPublicKeysResponseType listPublicKeys( ) {
    return listPublicKeys( new ListPublicKeysType( ) );
  }

  ListStreamingDistributionsResponseType listStreamingDistributions( final ListStreamingDistributionsType request );

  default ListStreamingDistributionsResponseType listStreamingDistributions( ) {
    return listStreamingDistributions( new ListStreamingDistributionsType( ) );
  }

  ListTagsForResourceResponseType listTagsForResource( final ListTagsForResourceType request );

  TagResourceResponseType tagResource( final TagResourceType request );

  UntagResourceResponseType untagResource( final UntagResourceType request );

  UpdateCloudFrontOriginAccessIdentityResponseType updateCloudFrontOriginAccessIdentity( final UpdateCloudFrontOriginAccessIdentityType request );

  UpdateDistributionResponseType updateDistribution( final UpdateDistributionType request );

  UpdateFieldLevelEncryptionConfigResponseType updateFieldLevelEncryptionConfig( final UpdateFieldLevelEncryptionConfigType request );

  UpdateFieldLevelEncryptionProfileResponseType updateFieldLevelEncryptionProfile( final UpdateFieldLevelEncryptionProfileType request );

  UpdatePublicKeyResponseType updatePublicKey( final UpdatePublicKeyType request );

  UpdateStreamingDistributionResponseType updateStreamingDistribution( final UpdateStreamingDistributionType request );

}
