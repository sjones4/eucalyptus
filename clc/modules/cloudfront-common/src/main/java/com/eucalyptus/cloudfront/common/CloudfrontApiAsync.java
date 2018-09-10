/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudfront.common;

import com.eucalyptus.cloudfront.common.msgs.*;
import com.eucalyptus.util.async.CheckedListenableFuture;

public interface CloudfrontApiAsync {

  CheckedListenableFuture<CreateCloudFrontOriginAccessIdentityResponseType> createCloudFrontOriginAccessIdentityAsync( final CreateCloudFrontOriginAccessIdentityType request );

  CheckedListenableFuture<CreateDistributionResponseType> createDistributionAsync( final CreateDistributionType request );

  CheckedListenableFuture<CreateDistributionWithTagsResponseType> createDistributionWithTagsAsync( final CreateDistributionWithTagsType request );

  CheckedListenableFuture<CreateFieldLevelEncryptionConfigResponseType> createFieldLevelEncryptionConfigAsync( final CreateFieldLevelEncryptionConfigType request );

  CheckedListenableFuture<CreateFieldLevelEncryptionProfileResponseType> createFieldLevelEncryptionProfileAsync( final CreateFieldLevelEncryptionProfileType request );

  CheckedListenableFuture<CreateInvalidationResponseType> createInvalidationAsync( final CreateInvalidationType request );

  CheckedListenableFuture<CreatePublicKeyResponseType> createPublicKeyAsync( final CreatePublicKeyType request );

  CheckedListenableFuture<CreateStreamingDistributionResponseType> createStreamingDistributionAsync( final CreateStreamingDistributionType request );

  CheckedListenableFuture<CreateStreamingDistributionWithTagsResponseType> createStreamingDistributionWithTagsAsync( final CreateStreamingDistributionWithTagsType request );

  CheckedListenableFuture<DeleteCloudFrontOriginAccessIdentityResponseType> deleteCloudFrontOriginAccessIdentityAsync( final DeleteCloudFrontOriginAccessIdentityType request );

  CheckedListenableFuture<DeleteDistributionResponseType> deleteDistributionAsync( final DeleteDistributionType request );

  CheckedListenableFuture<DeleteFieldLevelEncryptionConfigResponseType> deleteFieldLevelEncryptionConfigAsync( final DeleteFieldLevelEncryptionConfigType request );

  CheckedListenableFuture<DeleteFieldLevelEncryptionProfileResponseType> deleteFieldLevelEncryptionProfileAsync( final DeleteFieldLevelEncryptionProfileType request );

  CheckedListenableFuture<DeletePublicKeyResponseType> deletePublicKeyAsync( final DeletePublicKeyType request );

  CheckedListenableFuture<DeleteStreamingDistributionResponseType> deleteStreamingDistributionAsync( final DeleteStreamingDistributionType request );

  CheckedListenableFuture<GetCloudFrontOriginAccessIdentityResponseType> getCloudFrontOriginAccessIdentityAsync( final GetCloudFrontOriginAccessIdentityType request );

  CheckedListenableFuture<GetCloudFrontOriginAccessIdentityConfigResponseType> getCloudFrontOriginAccessIdentityConfigAsync( final GetCloudFrontOriginAccessIdentityConfigType request );

  CheckedListenableFuture<GetDistributionResponseType> getDistributionAsync( final GetDistributionType request );

  CheckedListenableFuture<GetDistributionConfigResponseType> getDistributionConfigAsync( final GetDistributionConfigType request );

  CheckedListenableFuture<GetFieldLevelEncryptionResponseType> getFieldLevelEncryptionAsync( final GetFieldLevelEncryptionType request );

  CheckedListenableFuture<GetFieldLevelEncryptionConfigResponseType> getFieldLevelEncryptionConfigAsync( final GetFieldLevelEncryptionConfigType request );

  CheckedListenableFuture<GetFieldLevelEncryptionProfileResponseType> getFieldLevelEncryptionProfileAsync( final GetFieldLevelEncryptionProfileType request );

  CheckedListenableFuture<GetFieldLevelEncryptionProfileConfigResponseType> getFieldLevelEncryptionProfileConfigAsync( final GetFieldLevelEncryptionProfileConfigType request );

  CheckedListenableFuture<GetInvalidationResponseType> getInvalidationAsync( final GetInvalidationType request );

  CheckedListenableFuture<GetPublicKeyResponseType> getPublicKeyAsync( final GetPublicKeyType request );

  CheckedListenableFuture<GetPublicKeyConfigResponseType> getPublicKeyConfigAsync( final GetPublicKeyConfigType request );

  CheckedListenableFuture<GetStreamingDistributionResponseType> getStreamingDistributionAsync( final GetStreamingDistributionType request );

  CheckedListenableFuture<GetStreamingDistributionConfigResponseType> getStreamingDistributionConfigAsync( final GetStreamingDistributionConfigType request );

  CheckedListenableFuture<ListCloudFrontOriginAccessIdentitiesResponseType> listCloudFrontOriginAccessIdentitiesAsync( final ListCloudFrontOriginAccessIdentitiesType request );

  default CheckedListenableFuture<ListCloudFrontOriginAccessIdentitiesResponseType> listCloudFrontOriginAccessIdentitiesAsync( ) {
    return listCloudFrontOriginAccessIdentitiesAsync( new ListCloudFrontOriginAccessIdentitiesType( ) );
  }

  CheckedListenableFuture<ListDistributionsResponseType> listDistributionsAsync( final ListDistributionsType request );

  default CheckedListenableFuture<ListDistributionsResponseType> listDistributionsAsync( ) {
    return listDistributionsAsync( new ListDistributionsType( ) );
  }

  CheckedListenableFuture<ListDistributionsByWebACLIdResponseType> listDistributionsByWebACLIdAsync( final ListDistributionsByWebACLIdType request );

  CheckedListenableFuture<ListFieldLevelEncryptionConfigsResponseType> listFieldLevelEncryptionConfigsAsync( final ListFieldLevelEncryptionConfigsType request );

  default CheckedListenableFuture<ListFieldLevelEncryptionConfigsResponseType> listFieldLevelEncryptionConfigsAsync( ) {
    return listFieldLevelEncryptionConfigsAsync( new ListFieldLevelEncryptionConfigsType( ) );
  }

  CheckedListenableFuture<ListFieldLevelEncryptionProfilesResponseType> listFieldLevelEncryptionProfilesAsync( final ListFieldLevelEncryptionProfilesType request );

  default CheckedListenableFuture<ListFieldLevelEncryptionProfilesResponseType> listFieldLevelEncryptionProfilesAsync( ) {
    return listFieldLevelEncryptionProfilesAsync( new ListFieldLevelEncryptionProfilesType( ) );
  }

  CheckedListenableFuture<ListInvalidationsResponseType> listInvalidationsAsync( final ListInvalidationsType request );

  CheckedListenableFuture<ListPublicKeysResponseType> listPublicKeysAsync( final ListPublicKeysType request );

  default CheckedListenableFuture<ListPublicKeysResponseType> listPublicKeysAsync( ) {
    return listPublicKeysAsync( new ListPublicKeysType( ) );
  }

  CheckedListenableFuture<ListStreamingDistributionsResponseType> listStreamingDistributionsAsync( final ListStreamingDistributionsType request );

  default CheckedListenableFuture<ListStreamingDistributionsResponseType> listStreamingDistributionsAsync( ) {
    return listStreamingDistributionsAsync( new ListStreamingDistributionsType( ) );
  }

  CheckedListenableFuture<ListTagsForResourceResponseType> listTagsForResourceAsync( final ListTagsForResourceType request );

  CheckedListenableFuture<TagResourceResponseType> tagResourceAsync( final TagResourceType request );

  CheckedListenableFuture<UntagResourceResponseType> untagResourceAsync( final UntagResourceType request );

  CheckedListenableFuture<UpdateCloudFrontOriginAccessIdentityResponseType> updateCloudFrontOriginAccessIdentityAsync( final UpdateCloudFrontOriginAccessIdentityType request );

  CheckedListenableFuture<UpdateDistributionResponseType> updateDistributionAsync( final UpdateDistributionType request );

  CheckedListenableFuture<UpdateFieldLevelEncryptionConfigResponseType> updateFieldLevelEncryptionConfigAsync( final UpdateFieldLevelEncryptionConfigType request );

  CheckedListenableFuture<UpdateFieldLevelEncryptionProfileResponseType> updateFieldLevelEncryptionProfileAsync( final UpdateFieldLevelEncryptionProfileType request );

  CheckedListenableFuture<UpdatePublicKeyResponseType> updatePublicKeyAsync( final UpdatePublicKeyType request );

  CheckedListenableFuture<UpdateStreamingDistributionResponseType> updateStreamingDistributionAsync( final UpdateStreamingDistributionType request );

}
