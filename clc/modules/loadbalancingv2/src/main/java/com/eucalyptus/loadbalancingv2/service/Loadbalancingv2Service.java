/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.loadbalancingv2.service;

import com.eucalyptus.component.annotation.ComponentNamed;
import com.eucalyptus.loadbalancingv2.common.msgs.*;

/**
 *
 */
@ComponentNamed
public class Loadbalancingv2Service {

  public AddListenerCertificatesResponseType addListenerCertificates( final AddListenerCertificatesType request ) {
    return request.getReply( );
  }
  
  public AddTagsResponseType addTags( final AddTagsType request ) {
    return request.getReply( );
  }
  
  public CreateListenerResponseType createListener( final CreateListenerType request ) {
    return request.getReply( );
  }
  
  public CreateLoadBalancerResponseType createLoadBalancer( final CreateLoadBalancerType request ) {
    return request.getReply( );
  }
  
  public CreateRuleResponseType createRule( final CreateRuleType request ) {
    return request.getReply( );
  }
  
  public CreateTargetGroupResponseType createTargetGroup( final CreateTargetGroupType request ) {
    return request.getReply( );
  }
  
  public DeleteListenerResponseType deleteListener( final DeleteListenerType request ) {
    return request.getReply( );
  }
  
  public DeleteLoadBalancerResponseType deleteLoadBalancer( final DeleteLoadBalancerType request ) {
    return request.getReply( );
  }
  
  public DeleteRuleResponseType deleteRule( final DeleteRuleType request ) {
    return request.getReply( );
  }
  
  public DeleteTargetGroupResponseType deleteTargetGroup( final DeleteTargetGroupType request ) {
    return request.getReply( );
  }
  
  public DeregisterTargetsResponseType deregisterTargets( final DeregisterTargetsType request ) {
    return request.getReply( );
  }
  
  public DescribeAccountLimitsResponseType describeAccountLimits( final DescribeAccountLimitsType request ) {
    return request.getReply( );
  }
  
  public DescribeListenerCertificatesResponseType describeListenerCertificates( final DescribeListenerCertificatesType request ) {
    return request.getReply( );
  }
  
  public DescribeListenersResponseType describeListeners( final DescribeListenersType request ) {
    return request.getReply( );
  }
  
  public DescribeLoadBalancerAttributesResponseType describeLoadBalancerAttributes( final DescribeLoadBalancerAttributesType request ) {
    return request.getReply( );
  }
  
  public DescribeLoadBalancersResponseType describeLoadBalancers( final DescribeLoadBalancersType request ) {
    return request.getReply( );
  }
  
  public DescribeRulesResponseType describeRules( final DescribeRulesType request ) {
    return request.getReply( );
  }
  
  public DescribeSSLPoliciesResponseType describeSSLPolicies( final DescribeSSLPoliciesType request ) {
    return request.getReply( );
  }
  
  public DescribeTagsResponseType describeTags( final DescribeTagsType request ) {
    return request.getReply( );
  }
  
  public DescribeTargetGroupAttributesResponseType describeTargetGroupAttributes( final DescribeTargetGroupAttributesType request ) {
    return request.getReply( );
  }
  
  public DescribeTargetGroupsResponseType describeTargetGroups( final DescribeTargetGroupsType request ) {
    return request.getReply( );
  }
  
  public DescribeTargetHealthResponseType describeTargetHealth( final DescribeTargetHealthType request ) {
    return request.getReply( );
  }
  
  public ModifyListenerResponseType modifyListener( final ModifyListenerType request ) {
    return request.getReply( );
  }
  
  public ModifyLoadBalancerAttributesResponseType modifyLoadBalancerAttributes( final ModifyLoadBalancerAttributesType request ) {
    return request.getReply( );
  }
  
  public ModifyRuleResponseType modifyRule( final ModifyRuleType request ) {
    return request.getReply( );
  }
  
  public ModifyTargetGroupResponseType modifyTargetGroup( final ModifyTargetGroupType request ) {
    return request.getReply( );
  }
  
  public ModifyTargetGroupAttributesResponseType modifyTargetGroupAttributes( final ModifyTargetGroupAttributesType request ) {
    return request.getReply( );
  }
  
  public RegisterTargetsResponseType registerTargets( final RegisterTargetsType request ) {
    return request.getReply( );
  }
  
  public RemoveListenerCertificatesResponseType removeListenerCertificates( final RemoveListenerCertificatesType request ) {
    return request.getReply( );
  }
  
  public RemoveTagsResponseType removeTags( final RemoveTagsType request ) {
    return request.getReply( );
  }
  
  public SetIpAddressTypeResponseType setIpAddressType( final SetIpAddressTypeType request ) {
    return request.getReply( );
  }
  
  public SetRulePrioritiesResponseType setRulePriorities( final SetRulePrioritiesType request ) {
    return request.getReply( );
  }
  
  public SetSecurityGroupsResponseType setSecurityGroups( final SetSecurityGroupsType request ) {
    return request.getReply( );
  }
  
  public SetSubnetsResponseType setSubnets( final SetSubnetsType request ) {
    return request.getReply( );
  }
  
}
