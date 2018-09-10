/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.loadbalancingv2.common;

import com.eucalyptus.loadbalancingv2.common.msgs.*;
import com.eucalyptus.util.async.CheckedListenableFuture;

public interface Loadbalancingv2ApiAsync {

  CheckedListenableFuture<AddListenerCertificatesResponseType> addListenerCertificatesAsync( final AddListenerCertificatesType request );

  CheckedListenableFuture<AddTagsResponseType> addTagsAsync( final AddTagsType request );

  CheckedListenableFuture<CreateListenerResponseType> createListenerAsync( final CreateListenerType request );

  CheckedListenableFuture<CreateLoadBalancerResponseType> createLoadBalancerAsync( final CreateLoadBalancerType request );

  CheckedListenableFuture<CreateRuleResponseType> createRuleAsync( final CreateRuleType request );

  CheckedListenableFuture<CreateTargetGroupResponseType> createTargetGroupAsync( final CreateTargetGroupType request );

  CheckedListenableFuture<DeleteListenerResponseType> deleteListenerAsync( final DeleteListenerType request );

  CheckedListenableFuture<DeleteLoadBalancerResponseType> deleteLoadBalancerAsync( final DeleteLoadBalancerType request );

  CheckedListenableFuture<DeleteRuleResponseType> deleteRuleAsync( final DeleteRuleType request );

  CheckedListenableFuture<DeleteTargetGroupResponseType> deleteTargetGroupAsync( final DeleteTargetGroupType request );

  CheckedListenableFuture<DeregisterTargetsResponseType> deregisterTargetsAsync( final DeregisterTargetsType request );

  CheckedListenableFuture<DescribeAccountLimitsResponseType> describeAccountLimitsAsync( final DescribeAccountLimitsType request );

  default CheckedListenableFuture<DescribeAccountLimitsResponseType> describeAccountLimitsAsync( ) {
    return describeAccountLimitsAsync( new DescribeAccountLimitsType( ) );
  }

  CheckedListenableFuture<DescribeListenerCertificatesResponseType> describeListenerCertificatesAsync( final DescribeListenerCertificatesType request );

  CheckedListenableFuture<DescribeListenersResponseType> describeListenersAsync( final DescribeListenersType request );

  default CheckedListenableFuture<DescribeListenersResponseType> describeListenersAsync( ) {
    return describeListenersAsync( new DescribeListenersType( ) );
  }

  CheckedListenableFuture<DescribeLoadBalancerAttributesResponseType> describeLoadBalancerAttributesAsync( final DescribeLoadBalancerAttributesType request );

  CheckedListenableFuture<DescribeLoadBalancersResponseType> describeLoadBalancersAsync( final DescribeLoadBalancersType request );

  default CheckedListenableFuture<DescribeLoadBalancersResponseType> describeLoadBalancersAsync( ) {
    return describeLoadBalancersAsync( new DescribeLoadBalancersType( ) );
  }

  CheckedListenableFuture<DescribeRulesResponseType> describeRulesAsync( final DescribeRulesType request );

  default CheckedListenableFuture<DescribeRulesResponseType> describeRulesAsync( ) {
    return describeRulesAsync( new DescribeRulesType( ) );
  }

  CheckedListenableFuture<DescribeSSLPoliciesResponseType> describeSSLPoliciesAsync( final DescribeSSLPoliciesType request );

  default CheckedListenableFuture<DescribeSSLPoliciesResponseType> describeSSLPoliciesAsync( ) {
    return describeSSLPoliciesAsync( new DescribeSSLPoliciesType( ) );
  }

  CheckedListenableFuture<DescribeTagsResponseType> describeTagsAsync( final DescribeTagsType request );

  CheckedListenableFuture<DescribeTargetGroupAttributesResponseType> describeTargetGroupAttributesAsync( final DescribeTargetGroupAttributesType request );

  CheckedListenableFuture<DescribeTargetGroupsResponseType> describeTargetGroupsAsync( final DescribeTargetGroupsType request );

  default CheckedListenableFuture<DescribeTargetGroupsResponseType> describeTargetGroupsAsync( ) {
    return describeTargetGroupsAsync( new DescribeTargetGroupsType( ) );
  }

  CheckedListenableFuture<DescribeTargetHealthResponseType> describeTargetHealthAsync( final DescribeTargetHealthType request );

  CheckedListenableFuture<ModifyListenerResponseType> modifyListenerAsync( final ModifyListenerType request );

  CheckedListenableFuture<ModifyLoadBalancerAttributesResponseType> modifyLoadBalancerAttributesAsync( final ModifyLoadBalancerAttributesType request );

  CheckedListenableFuture<ModifyRuleResponseType> modifyRuleAsync( final ModifyRuleType request );

  CheckedListenableFuture<ModifyTargetGroupResponseType> modifyTargetGroupAsync( final ModifyTargetGroupType request );

  CheckedListenableFuture<ModifyTargetGroupAttributesResponseType> modifyTargetGroupAttributesAsync( final ModifyTargetGroupAttributesType request );

  CheckedListenableFuture<RegisterTargetsResponseType> registerTargetsAsync( final RegisterTargetsType request );

  CheckedListenableFuture<RemoveListenerCertificatesResponseType> removeListenerCertificatesAsync( final RemoveListenerCertificatesType request );

  CheckedListenableFuture<RemoveTagsResponseType> removeTagsAsync( final RemoveTagsType request );

  CheckedListenableFuture<SetIpAddressTypeResponseType> setIpAddressTypeAsync( final SetIpAddressTypeType request );

  CheckedListenableFuture<SetRulePrioritiesResponseType> setRulePrioritiesAsync( final SetRulePrioritiesType request );

  CheckedListenableFuture<SetSecurityGroupsResponseType> setSecurityGroupsAsync( final SetSecurityGroupsType request );

  CheckedListenableFuture<SetSubnetsResponseType> setSubnetsAsync( final SetSubnetsType request );

}
