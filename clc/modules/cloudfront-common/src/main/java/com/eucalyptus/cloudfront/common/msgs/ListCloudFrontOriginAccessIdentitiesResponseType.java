/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudfront.common.msgs;

import javax.annotation.Nonnull;
import com.eucalyptus.binding.HttpContent;
import com.eucalyptus.binding.HttpHeaderMapping;
import com.eucalyptus.binding.HttpNoContent;
import com.eucalyptus.cloudfront.common.CloudfrontMessageValidation.FieldRange;
import com.eucalyptus.cloudfront.common.CloudfrontMessageValidation.FieldRegex;
import com.eucalyptus.cloudfront.common.CloudfrontMessageValidation.FieldRegexValue;



@HttpContent(payload="cloudFrontOriginAccessIdentityList")
public class ListCloudFrontOriginAccessIdentitiesResponseType extends CloudfrontMessage {


  private CloudFrontOriginAccessIdentityList cloudFrontOriginAccessIdentityList = new CloudFrontOriginAccessIdentityList();

  public CloudFrontOriginAccessIdentityList getCloudFrontOriginAccessIdentityList( ) {
    return cloudFrontOriginAccessIdentityList;
  }

  public void setCloudFrontOriginAccessIdentityList( final CloudFrontOriginAccessIdentityList cloudFrontOriginAccessIdentityList ) {
    this.cloudFrontOriginAccessIdentityList = cloudFrontOriginAccessIdentityList;
  }

}
