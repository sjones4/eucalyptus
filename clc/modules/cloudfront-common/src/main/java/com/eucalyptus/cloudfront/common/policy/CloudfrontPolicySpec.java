/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudfront.common.policy;

/**
 *
 */
public interface CloudfrontPolicySpec {

  // Vendor
  String VENDOR_CLOUDFRONT = "cloudfront";

  // Actions
  String CLOUDFRONT_CREATECLOUDFRONTORIGINACCESSIDENTITY = "createcloudfrontoriginaccessidentity";
  String CLOUDFRONT_CREATEDISTRIBUTION = "createdistribution";
  String CLOUDFRONT_CREATEDISTRIBUTIONWITHTAGS = "createdistributionwithtags";
  String CLOUDFRONT_CREATEFIELDLEVELENCRYPTIONCONFIG = "createfieldlevelencryptionconfig";
  String CLOUDFRONT_CREATEFIELDLEVELENCRYPTIONPROFILE = "createfieldlevelencryptionprofile";
  String CLOUDFRONT_CREATEINVALIDATION = "createinvalidation";
  String CLOUDFRONT_CREATEPUBLICKEY = "createpublickey";
  String CLOUDFRONT_CREATESTREAMINGDISTRIBUTION = "createstreamingdistribution";
  String CLOUDFRONT_CREATESTREAMINGDISTRIBUTIONWITHTAGS = "createstreamingdistributionwithtags";
  String CLOUDFRONT_DELETECLOUDFRONTORIGINACCESSIDENTITY = "deletecloudfrontoriginaccessidentity";
  String CLOUDFRONT_DELETEDISTRIBUTION = "deletedistribution";
  String CLOUDFRONT_DELETEFIELDLEVELENCRYPTIONCONFIG = "deletefieldlevelencryptionconfig";
  String CLOUDFRONT_DELETEFIELDLEVELENCRYPTIONPROFILE = "deletefieldlevelencryptionprofile";
  String CLOUDFRONT_DELETEPUBLICKEY = "deletepublickey";
  String CLOUDFRONT_DELETESTREAMINGDISTRIBUTION = "deletestreamingdistribution";
  String CLOUDFRONT_GETCLOUDFRONTORIGINACCESSIDENTITY = "getcloudfrontoriginaccessidentity";
  String CLOUDFRONT_GETCLOUDFRONTORIGINACCESSIDENTITYCONFIG = "getcloudfrontoriginaccessidentityconfig";
  String CLOUDFRONT_GETDISTRIBUTION = "getdistribution";
  String CLOUDFRONT_GETDISTRIBUTIONCONFIG = "getdistributionconfig";
  String CLOUDFRONT_GETFIELDLEVELENCRYPTION = "getfieldlevelencryption";
  String CLOUDFRONT_GETFIELDLEVELENCRYPTIONCONFIG = "getfieldlevelencryptionconfig";
  String CLOUDFRONT_GETFIELDLEVELENCRYPTIONPROFILE = "getfieldlevelencryptionprofile";
  String CLOUDFRONT_GETFIELDLEVELENCRYPTIONPROFILECONFIG = "getfieldlevelencryptionprofileconfig";
  String CLOUDFRONT_GETINVALIDATION = "getinvalidation";
  String CLOUDFRONT_GETPUBLICKEY = "getpublickey";
  String CLOUDFRONT_GETPUBLICKEYCONFIG = "getpublickeyconfig";
  String CLOUDFRONT_GETSTREAMINGDISTRIBUTION = "getstreamingdistribution";
  String CLOUDFRONT_GETSTREAMINGDISTRIBUTIONCONFIG = "getstreamingdistributionconfig";
  String CLOUDFRONT_LISTCLOUDFRONTORIGINACCESSIDENTITIES = "listcloudfrontoriginaccessidentities";
  String CLOUDFRONT_LISTDISTRIBUTIONS = "listdistributions";
  String CLOUDFRONT_LISTDISTRIBUTIONSBYWEBACLID = "listdistributionsbywebaclid";
  String CLOUDFRONT_LISTFIELDLEVELENCRYPTIONCONFIGS = "listfieldlevelencryptionconfigs";
  String CLOUDFRONT_LISTFIELDLEVELENCRYPTIONPROFILES = "listfieldlevelencryptionprofiles";
  String CLOUDFRONT_LISTINVALIDATIONS = "listinvalidations";
  String CLOUDFRONT_LISTPUBLICKEYS = "listpublickeys";
  String CLOUDFRONT_LISTSTREAMINGDISTRIBUTIONS = "liststreamingdistributions";
  String CLOUDFRONT_LISTTAGSFORRESOURCE = "listtagsforresource";
  String CLOUDFRONT_TAGRESOURCE = "tagresource";
  String CLOUDFRONT_UNTAGRESOURCE = "untagresource";
  String CLOUDFRONT_UPDATECLOUDFRONTORIGINACCESSIDENTITY = "updatecloudfrontoriginaccessidentity";
  String CLOUDFRONT_UPDATEDISTRIBUTION = "updatedistribution";
  String CLOUDFRONT_UPDATEFIELDLEVELENCRYPTIONCONFIG = "updatefieldlevelencryptionconfig";
  String CLOUDFRONT_UPDATEFIELDLEVELENCRYPTIONPROFILE = "updatefieldlevelencryptionprofile";
  String CLOUDFRONT_UPDATEPUBLICKEY = "updatepublickey";
  String CLOUDFRONT_UPDATESTREAMINGDISTRIBUTION = "updatestreamingdistribution";

}
