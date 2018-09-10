/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.loadbalancingv2.common;

import com.eucalyptus.loadbalancingv2.common.msgs.*;


public interface Loadbalancingv2Api {

  AddListenerCertificatesResponseType addListenerCertificates( final AddListenerCertificatesType request );

  AddTagsResponseType addTags( final AddTagsType request );

  CreateListenerResponseType createListener( final CreateListenerType request );

  CreateLoadBalancerResponseType createLoadBalancer( final CreateLoadBalancerType request );

  CreateRuleResponseType createRule( final CreateRuleType request );

  CreateTargetGroupResponseType createTargetGroup( final CreateTargetGroupType request );

  DeleteListenerResponseType deleteListener( final DeleteListenerType request );

  DeleteLoadBalancerResponseType deleteLoadBalancer( final DeleteLoadBalancerType request );

  DeleteRuleResponseType deleteRule( final DeleteRuleType request );

  DeleteTargetGroupResponseType deleteTargetGroup( final DeleteTargetGroupType request );

  DeregisterTargetsResponseType deregisterTargets( final DeregisterTargetsType request );

  DescribeAccountLimitsResponseType describeAccountLimits( final DescribeAccountLimitsType request );

  default DescribeAccountLimitsResponseType describeAccountLimits( ) {
    return describeAccountLimits( new DescribeAccountLimitsType( ) );
  }

  DescribeListenerCertificatesResponseType describeListenerCertificates( final DescribeListenerCertificatesType request );

  DescribeListenersResponseType describeListeners( final DescribeListenersType request );

  default DescribeListenersResponseType describeListeners( ) {
    return describeListeners( new DescribeListenersType( ) );
  }

  DescribeLoadBalancerAttributesResponseType describeLoadBalancerAttributes( final DescribeLoadBalancerAttributesType request );

  DescribeLoadBalancersResponseType describeLoadBalancers( final DescribeLoadBalancersType request );

  default DescribeLoadBalancersResponseType describeLoadBalancers( ) {
    return describeLoadBalancers( new DescribeLoadBalancersType( ) );
  }

  DescribeRulesResponseType describeRules( final DescribeRulesType request );

  default DescribeRulesResponseType describeRules( ) {
    return describeRules( new DescribeRulesType( ) );
  }

  DescribeSSLPoliciesResponseType describeSSLPolicies( final DescribeSSLPoliciesType request );

  default DescribeSSLPoliciesResponseType describeSSLPolicies( ) {
    return describeSSLPolicies( new DescribeSSLPoliciesType( ) );
  }

  DescribeTagsResponseType describeTags( final DescribeTagsType request );

  DescribeTargetGroupAttributesResponseType describeTargetGroupAttributes( final DescribeTargetGroupAttributesType request );

  DescribeTargetGroupsResponseType describeTargetGroups( final DescribeTargetGroupsType request );

  default DescribeTargetGroupsResponseType describeTargetGroups( ) {
    return describeTargetGroups( new DescribeTargetGroupsType( ) );
  }

  DescribeTargetHealthResponseType describeTargetHealth( final DescribeTargetHealthType request );

  ModifyListenerResponseType modifyListener( final ModifyListenerType request );

  ModifyLoadBalancerAttributesResponseType modifyLoadBalancerAttributes( final ModifyLoadBalancerAttributesType request );

  ModifyRuleResponseType modifyRule( final ModifyRuleType request );

  ModifyTargetGroupResponseType modifyTargetGroup( final ModifyTargetGroupType request );

  ModifyTargetGroupAttributesResponseType modifyTargetGroupAttributes( final ModifyTargetGroupAttributesType request );

  RegisterTargetsResponseType registerTargets( final RegisterTargetsType request );

  RemoveListenerCertificatesResponseType removeListenerCertificates( final RemoveListenerCertificatesType request );

  RemoveTagsResponseType removeTags( final RemoveTagsType request );

  SetIpAddressTypeResponseType setIpAddressType( final SetIpAddressTypeType request );

  SetRulePrioritiesResponseType setRulePriorities( final SetRulePrioritiesType request );

  SetSecurityGroupsResponseType setSecurityGroups( final SetSecurityGroupsType request );

  SetSubnetsResponseType setSubnets( final SetSubnetsType request );

}
