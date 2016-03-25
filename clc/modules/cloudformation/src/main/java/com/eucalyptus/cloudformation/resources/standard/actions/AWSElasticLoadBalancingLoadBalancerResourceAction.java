/*************************************************************************
 * Copyright 2009-2015 Eucalyptus Systems, Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; version 3 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses/.
 *
 * Please contact Eucalyptus Systems, Inc., 6755 Hollister Ave., Goleta
 * CA 93117, USA or visit http://www.eucalyptus.com/licenses/ if you need
 * additional information or have any questions.
 ************************************************************************/
package com.eucalyptus.cloudformation.resources.standard.actions;


import com.eucalyptus.auth.Accounts;
import com.amazonaws.services.simpleworkflow.flow.core.Promise;
import com.eucalyptus.cloudformation.ValidationErrorException;
import com.eucalyptus.cloudformation.resources.ResourceAction;
import com.eucalyptus.cloudformation.resources.ResourceInfo;
import com.eucalyptus.cloudformation.resources.ResourceProperties;
import com.eucalyptus.cloudformation.resources.standard.TagHelper;
import com.eucalyptus.cloudformation.resources.standard.info.AWSElasticLoadBalancingLoadBalancerResourceInfo;
import com.eucalyptus.cloudformation.resources.standard.propertytypes.AWSElasticLoadBalancingLoadBalancerProperties;
import com.eucalyptus.cloudformation.resources.standard.propertytypes.CloudFormationResourceTag;
import com.eucalyptus.cloudformation.resources.standard.propertytypes.ElasticLoadBalancingAccessLoggingPolicy;
import com.eucalyptus.cloudformation.resources.standard.propertytypes.ElasticLoadBalancingAppCookieStickinessPolicy;
import com.eucalyptus.cloudformation.resources.standard.propertytypes.ElasticLoadBalancingLBCookieStickinessPolicyType;
import com.eucalyptus.cloudformation.resources.standard.propertytypes.ElasticLoadBalancingListener;
import com.eucalyptus.cloudformation.resources.standard.propertytypes.ElasticLoadBalancingPolicyType;
import com.eucalyptus.cloudformation.resources.standard.propertytypes.ElasticLoadBalancingPolicyTypeAttribute;
import com.eucalyptus.cloudformation.template.JsonHelper;
import com.eucalyptus.cloudformation.util.MessageHelper;
import com.eucalyptus.cloudformation.workflow.steps.Step;
import com.eucalyptus.cloudformation.workflow.steps.StepBasedResourceAction;
import com.eucalyptus.cloudformation.workflow.updateinfo.UpdateType;
import com.eucalyptus.component.ServiceConfiguration;
import com.eucalyptus.component.Topology;
import com.eucalyptus.loadbalancing.common.LoadBalancing;
import com.eucalyptus.loadbalancing.common.msgs.AddTagsResponseType;
import com.eucalyptus.loadbalancing.common.msgs.AddTagsType;
import com.eucalyptus.loadbalancing.common.msgs.AccessLog;
import com.eucalyptus.loadbalancing.common.msgs.AvailabilityZones;
import com.eucalyptus.loadbalancing.common.msgs.ConfigureHealthCheckResponseType;
import com.eucalyptus.loadbalancing.common.msgs.ConfigureHealthCheckType;
import com.eucalyptus.loadbalancing.common.msgs.ConnectionSettings;
import com.eucalyptus.loadbalancing.common.msgs.CreateAppCookieStickinessPolicyResponseType;
import com.eucalyptus.loadbalancing.common.msgs.CreateAppCookieStickinessPolicyType;
import com.eucalyptus.loadbalancing.common.msgs.CreateLBCookieStickinessPolicyResponseType;
import com.eucalyptus.loadbalancing.common.msgs.CreateLBCookieStickinessPolicyType;
import com.eucalyptus.loadbalancing.common.msgs.CreateLoadBalancerPolicyResponseType;
import com.eucalyptus.loadbalancing.common.msgs.CreateLoadBalancerPolicyType;
import com.eucalyptus.loadbalancing.common.msgs.CreateLoadBalancerResponseType;
import com.eucalyptus.loadbalancing.common.msgs.CreateLoadBalancerType;
import com.eucalyptus.loadbalancing.common.msgs.CrossZoneLoadBalancing;
import com.eucalyptus.loadbalancing.common.msgs.DeleteLoadBalancerResponseType;
import com.eucalyptus.loadbalancing.common.msgs.DeleteLoadBalancerType;
import com.eucalyptus.loadbalancing.common.msgs.DescribeLoadBalancersResponseType;
import com.eucalyptus.loadbalancing.common.msgs.DescribeLoadBalancersType;
import com.eucalyptus.loadbalancing.common.msgs.HealthCheck;
import com.eucalyptus.loadbalancing.common.msgs.Instance;
import com.eucalyptus.loadbalancing.common.msgs.Instances;
import com.eucalyptus.loadbalancing.common.msgs.Listener;
import com.eucalyptus.loadbalancing.common.msgs.Listeners;
import com.eucalyptus.loadbalancing.common.msgs.LoadBalancerAttributes;
import com.eucalyptus.loadbalancing.common.msgs.LoadBalancerDescription;
import com.eucalyptus.loadbalancing.common.msgs.LoadBalancerNames;
import com.eucalyptus.loadbalancing.common.msgs.ModifyLoadBalancerAttributesResponseType;
import com.eucalyptus.loadbalancing.common.msgs.ModifyLoadBalancerAttributesType;
import com.eucalyptus.loadbalancing.common.msgs.PolicyAttribute;
import com.eucalyptus.loadbalancing.common.msgs.PolicyAttributes;
import com.eucalyptus.loadbalancing.common.msgs.PolicyNames;
import com.eucalyptus.loadbalancing.common.msgs.RegisterInstancesWithLoadBalancerResponseType;
import com.eucalyptus.loadbalancing.common.msgs.RegisterInstancesWithLoadBalancerType;
import com.eucalyptus.loadbalancing.common.msgs.SecurityGroups;
import com.eucalyptus.loadbalancing.common.msgs.SetLoadBalancerPoliciesForBackendServerResponseType;
import com.eucalyptus.loadbalancing.common.msgs.SetLoadBalancerPoliciesForBackendServerType;
import com.eucalyptus.loadbalancing.common.msgs.SetLoadBalancerPoliciesOfListenerResponseType;
import com.eucalyptus.loadbalancing.common.msgs.SetLoadBalancerPoliciesOfListenerType;
import com.eucalyptus.loadbalancing.common.msgs.Subnets;
import com.eucalyptus.util.async.AsyncRequests;
import com.fasterxml.jackson.databind.node.TextNode;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.netflix.glisten.WorkflowOperations;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Nullable;

/**
 * Created by ethomas on 2/3/14.
 */
public class AWSElasticLoadBalancingLoadBalancerResourceAction extends StepBasedResourceAction {

  private AWSElasticLoadBalancingLoadBalancerProperties properties = new AWSElasticLoadBalancingLoadBalancerProperties();
  private AWSElasticLoadBalancingLoadBalancerResourceInfo info = new AWSElasticLoadBalancingLoadBalancerResourceInfo();

  public AWSElasticLoadBalancingLoadBalancerResourceAction() {
    super(fromEnum(CreateSteps.class), fromEnum(DeleteSteps.class), null, null);
  }

  private enum CreateSteps implements Step {
    CREATE_LOAD_BALANCER {
      @Override
      public ResourceAction perform(ResourceAction resourceAction) throws Exception {
        AWSElasticLoadBalancingLoadBalancerResourceAction action = (AWSElasticLoadBalancingLoadBalancerResourceAction) resourceAction;
        ServiceConfiguration configuration = Topology.lookup(LoadBalancing.class);
        CreateLoadBalancerType createLoadBalancerType = MessageHelper.createMessage(CreateLoadBalancerType.class, action.info.getEffectiveUserId());
        if (action.properties.getLoadBalancerName() == null) {

          // The name here is a little weird.  It needs to be no more than 32 characters
          createLoadBalancerType.setLoadBalancerName(action.getDefaultPhysicalResourceId(32));
        } else {
          createLoadBalancerType.setLoadBalancerName(action.properties.getLoadBalancerName());
        }
        if ( action.properties.getAvailabilityZones( ) != null && !action.properties.getAvailabilityZones( ).isEmpty( ) ) {
          AvailabilityZones availabilityZones = new AvailabilityZones();
          ArrayList<String> member = Lists.newArrayList(action.properties.getAvailabilityZones());
          availabilityZones.setMember(member);
          createLoadBalancerType.setAvailabilityZones(availabilityZones);
        }
        if (action.properties.getListeners() != null) {
          Listeners listeners = new Listeners();
          ArrayList<Listener> member = Lists.newArrayList();
          for (ElasticLoadBalancingListener elasticLoadBalancingListener: action.properties.getListeners()) {
            Listener listener = new Listener();
            listener.setInstancePort(elasticLoadBalancingListener.getInstancePort());
            listener.setInstanceProtocol(elasticLoadBalancingListener.getInstanceProtocol());
            listener.setLoadBalancerPort(elasticLoadBalancingListener.getLoadBalancerPort());
            listener.setProtocol(elasticLoadBalancingListener.getProtocol());
            listener.setSSLCertificateId(elasticLoadBalancingListener.getSslCertificateId());
            // TO set the policies, look at the next step
            member.add(listener);
          }
          listeners.setMember(member);
          createLoadBalancerType.setListeners(listeners);
        }
        createLoadBalancerType.setScheme(action.properties.getScheme());
        if ( action.properties.getSecurityGroups( ) != null && !action.properties.getSecurityGroups( ).isEmpty( ) ) {
          SecurityGroups securityGroups = new SecurityGroups();
          ArrayList<String> member = Lists.newArrayList(action.properties.getSecurityGroups());
          securityGroups.setMember(member);
          createLoadBalancerType.setSecurityGroups(securityGroups);
        }
        if ( action.properties.getSubnets( ) != null && !action.properties.getSubnets( ).isEmpty( ) ) {
          Subnets subnets = new Subnets();
          ArrayList<String> member = Lists.newArrayList(action.properties.getSubnets());
          subnets.setMember(member);
          createLoadBalancerType.setSubnets(subnets);
        }
        CreateLoadBalancerResponseType createLoadBalancerResponseType = AsyncRequests.<CreateLoadBalancerType,CreateLoadBalancerResponseType> sendSync(configuration, createLoadBalancerType);
        action.info.setPhysicalResourceId(createLoadBalancerType.getLoadBalancerName());
        action.info.setCreatedEnoughToDelete(true);
        action.info.setDnsName(JsonHelper.getStringFromJsonNode(new TextNode(createLoadBalancerResponseType.getCreateLoadBalancerResult().getDnsName())));
        action.info.setReferenceValueJson(JsonHelper.getStringFromJsonNode(new TextNode(action.info.getPhysicalResourceId())));
        return action;
      }
    },
    ADD_TAGS {
      @Override
      public ResourceAction perform(ResourceAction resourceAction) throws Exception {
        AWSElasticLoadBalancingLoadBalancerResourceAction action = (AWSElasticLoadBalancingLoadBalancerResourceAction) resourceAction;
        ServiceConfiguration configuration = Topology.lookup(LoadBalancing.class);
        // Create 'system' tags as admin user
        String effectiveAdminUserId = Accounts.lookupPrincipalByAccountNumber(Accounts.lookupPrincipalByUserId(action.info.getEffectiveUserId()).getAccountNumber()).getUserId();
        AddTagsType addSystemTagsType = MessageHelper.createPrivilegedMessage(AddTagsType.class, effectiveAdminUserId);
        addSystemTagsType.setLoadBalancerNames(getLoadBalancerNames(action));
        addSystemTagsType.setTags(TagHelper.convertToTagList(TagHelper.getCloudFormationResourceSystemTags(action.info, action.getStackEntity())));
        AsyncRequests.<AddTagsType, AddTagsResponseType>sendSync(configuration, addSystemTagsType);
        // Create non-system tags as regular user
        List<CloudFormationResourceTag> tags = TagHelper.getCloudFormationResourceStackTags(action.getStackEntity());
        if (action.properties.getTags() != null && !action.properties.getTags().isEmpty()) {
          TagHelper.checkReservedCloudFormationResourceTemplateTags(action.properties.getTags());
          tags.addAll(action.properties.getTags());
        }
        if (!tags.isEmpty()) {
          AddTagsType addTagsType = MessageHelper.createMessage(AddTagsType.class, action.info.getEffectiveUserId());
          addTagsType.setLoadBalancerNames(getLoadBalancerNames(action));
          addTagsType.setTags(TagHelper.convertToTagList(tags));
          AsyncRequests.<AddTagsType, AddTagsResponseType>sendSync(configuration, addTagsType);
        }
        return action;
      }

    },
    ADD_INSTANCES_TO_LOAD_BALANCER {
      @Override
      public ResourceAction perform(ResourceAction resourceAction) throws Exception {
        AWSElasticLoadBalancingLoadBalancerResourceAction action = (AWSElasticLoadBalancingLoadBalancerResourceAction) resourceAction;
        ServiceConfiguration configuration = Topology.lookup(LoadBalancing.class);
        if ( action.properties.getInstances( ) != null && !action.properties.getInstances( ).isEmpty( ) ) {
          RegisterInstancesWithLoadBalancerType registerInstancesWithLoadBalancerType = MessageHelper.createMessage(RegisterInstancesWithLoadBalancerType.class, action.info.getEffectiveUserId());
          registerInstancesWithLoadBalancerType.setLoadBalancerName(action.info.getPhysicalResourceId());
          Instances instances = new Instances();
          ArrayList<Instance> member = Lists.newArrayList();
          for (String instanceId: action.properties.getInstances()) {
            Instance instance = new Instance();
            instance.setInstanceId(instanceId);
            member.add(instance);
          }
          instances.setMember(member);
          registerInstancesWithLoadBalancerType.setInstances(instances);
          AsyncRequests.<RegisterInstancesWithLoadBalancerType,RegisterInstancesWithLoadBalancerResponseType> sendSync(configuration, registerInstancesWithLoadBalancerType);
        }
        return action;
      }
    },
    ADD_HEALTH_CHECK_TO_LOAD_BALANCER {
      @Override
      public ResourceAction perform(ResourceAction resourceAction) throws Exception {
        AWSElasticLoadBalancingLoadBalancerResourceAction action = (AWSElasticLoadBalancingLoadBalancerResourceAction) resourceAction;
        ServiceConfiguration configuration = Topology.lookup(LoadBalancing.class);
        if (action.properties.getHealthCheck() != null) {
          ConfigureHealthCheckType configureHealthCheckType = MessageHelper.createMessage(ConfigureHealthCheckType.class, action.info.getEffectiveUserId());
          configureHealthCheckType.setLoadBalancerName(action.info.getPhysicalResourceId());
          HealthCheck healthCheck = new HealthCheck();
          healthCheck.setHealthyThreshold(action.properties.getHealthCheck().getHealthyThreshold());
          healthCheck.setInterval(action.properties.getHealthCheck().getInterval());
          healthCheck.setTarget(action.properties.getHealthCheck().getTarget());
          healthCheck.setTimeout(action.properties.getHealthCheck().getTimeout());
          healthCheck.setUnhealthyThreshold(action.properties.getHealthCheck().getUnhealthyThreshold());
          configureHealthCheckType.setHealthCheck(healthCheck);
          AsyncRequests.<ConfigureHealthCheckType,ConfigureHealthCheckResponseType> sendSync(configuration, configureHealthCheckType);
        }
        return action;
      }
    },
    ADD_POLICIES_TO_LOAD_BALANCER {
      @Override
      public ResourceAction perform(ResourceAction resourceAction) throws Exception {
        AWSElasticLoadBalancingLoadBalancerResourceAction action = (AWSElasticLoadBalancingLoadBalancerResourceAction) resourceAction;
        ServiceConfiguration configuration = Topology.lookup(LoadBalancing.class);
        if (action.properties.getPolicies() != null) {
          for (ElasticLoadBalancingPolicyType elasticLoadBalancingPropertyType: action.properties.getPolicies()) {
            CreateLoadBalancerPolicyType createLoadBalancerPolicyType = MessageHelper.createMessage(CreateLoadBalancerPolicyType.class, action.info.getEffectiveUserId());
            createLoadBalancerPolicyType.setLoadBalancerName(action.info.getPhysicalResourceId());
            if (elasticLoadBalancingPropertyType.getAttributes() != null) {
              PolicyAttributes policyAttributes = new PolicyAttributes();
              ArrayList<PolicyAttribute> member = Lists.newArrayList();
              for (ElasticLoadBalancingPolicyTypeAttribute elasticLoadBalancingPolicyTypeAttribute: elasticLoadBalancingPropertyType.getAttributes()) {
                PolicyAttribute policyAttribute = new PolicyAttribute();
                policyAttribute.setAttributeName(elasticLoadBalancingPolicyTypeAttribute.getName());
                policyAttribute.setAttributeValue(elasticLoadBalancingPolicyTypeAttribute.getValue());
                member.add(policyAttribute);
              }
              policyAttributes.setMember(member);
              createLoadBalancerPolicyType.setPolicyAttributes(policyAttributes);
            }
            createLoadBalancerPolicyType.setPolicyName(elasticLoadBalancingPropertyType.getPolicyName());
            createLoadBalancerPolicyType.setPolicyTypeName(elasticLoadBalancingPropertyType.getPolicyType());
            // NOTE: Cloudformation says that policies have two more fields, "InstanceIds" (which bind to the back end, but which we don't currently support), and
            // "LoadBalancerPorts" which seems redundant since Listeners have PolicyNames associated with them (the docs say load balancer ports are only associated with
            // some policy types).  The first one we don't support and the second we don't know what it means in a non-circular way (TODO: figure that out) so we don't
            // support either currently
            AsyncRequests.<CreateLoadBalancerPolicyType,CreateLoadBalancerPolicyResponseType> sendSync(configuration, createLoadBalancerPolicyType);
          }
        }
        return action;
      }
    },
    ADD_APP_STICKINESS_POLICY_TO_LOAD_BALANCER {
      @Override
      public ResourceAction perform(ResourceAction resourceAction) throws Exception {
        AWSElasticLoadBalancingLoadBalancerResourceAction action = (AWSElasticLoadBalancingLoadBalancerResourceAction) resourceAction;
        ServiceConfiguration configuration = Topology.lookup(LoadBalancing.class);
        if (action.properties.getAppCookieStickinessPolicy() != null) {
          for (ElasticLoadBalancingAppCookieStickinessPolicy elasticLoadBalancingAppCookieStickinessPolicy: action.properties.getAppCookieStickinessPolicy()) {
            CreateAppCookieStickinessPolicyType createAppCookieStickinessPolicyType = MessageHelper.createMessage(CreateAppCookieStickinessPolicyType.class, action.info.getEffectiveUserId());
            createAppCookieStickinessPolicyType.setPolicyName(elasticLoadBalancingAppCookieStickinessPolicy.getPolicyName());
            createAppCookieStickinessPolicyType.setLoadBalancerName(action.info.getPhysicalResourceId());
            createAppCookieStickinessPolicyType.setCookieName(elasticLoadBalancingAppCookieStickinessPolicy.getCookieName());
            AsyncRequests.<CreateAppCookieStickinessPolicyType, CreateAppCookieStickinessPolicyResponseType>sendSync(configuration, createAppCookieStickinessPolicyType);
          }
        }
        return action;
      }
    },
    ADD_LB_STICKINESS_POLICY_TO_LOAD_BALANCER {
      @Override
      public ResourceAction perform(ResourceAction resourceAction) throws Exception {
        AWSElasticLoadBalancingLoadBalancerResourceAction action = (AWSElasticLoadBalancingLoadBalancerResourceAction) resourceAction;
        ServiceConfiguration configuration = Topology.lookup(LoadBalancing.class);
        if (action.properties.getLbCookieStickinessPolicy() != null) {
          for (ElasticLoadBalancingLBCookieStickinessPolicyType elasticLoadBalancingLbCookieStickinessPolicy: action.properties.getLbCookieStickinessPolicy()) {
            CreateLBCookieStickinessPolicyType createLBCookieStickinessPolicyType = MessageHelper.createMessage(CreateLBCookieStickinessPolicyType.class, action.info.getEffectiveUserId());
            createLBCookieStickinessPolicyType.setPolicyName(elasticLoadBalancingLbCookieStickinessPolicy.getPolicyName());
            createLBCookieStickinessPolicyType.setLoadBalancerName(action.info.getPhysicalResourceId());
            createLBCookieStickinessPolicyType.setCookieExpirationPeriod(elasticLoadBalancingLbCookieStickinessPolicy.getCookieExpirationPeriod());
            AsyncRequests.<CreateLBCookieStickinessPolicyType, CreateLBCookieStickinessPolicyResponseType>sendSync(configuration, createLBCookieStickinessPolicyType);
          }
        }
        return action;
      }
    },
    ADD_LOAD_BALANCER_POLICIES_TO_LISTENERS {
      @Override
      public ResourceAction perform(ResourceAction resourceAction) throws Exception {
        AWSElasticLoadBalancingLoadBalancerResourceAction action = (AWSElasticLoadBalancingLoadBalancerResourceAction) resourceAction;
        ServiceConfiguration configuration = Topology.lookup(LoadBalancing.class);
        Multimap<Integer, String> listenerPolicyMap = HashMultimap.create();
        Multimap<Integer, String> backendPolicyMap = HashMultimap.create();
        Set<Integer> listenerPorts = Sets.newHashSet();
        // first add policies explicitly listed in the map.
        if (action.properties.getListeners() != null) {
          for (ElasticLoadBalancingListener elasticLoadBalancingListener : action.properties.getListeners()) {
            listenerPorts.add(elasticLoadBalancingListener.getLoadBalancerPort());
            if (elasticLoadBalancingListener.getPolicyNames() != null) {
              listenerPolicyMap.putAll(elasticLoadBalancingListener.getLoadBalancerPort(), elasticLoadBalancingListener.getPolicyNames());
            }
          }
        }
        // now add policies by their load balancer port (assuming a proper listener exists) and backend by their instance ports
        if (action.properties.getPolicies() != null) {
          for (ElasticLoadBalancingPolicyType policyType : action.properties.getPolicies()) {
            if (policyType.getLoadBalancerPorts() != null) {
              for (Integer loadBalancerPort : policyType.getLoadBalancerPorts()) {
                if (!listenerPorts.contains(loadBalancerPort)) {
                  throw new ValidationErrorException("Policy " + policyType.getPolicyName() + " has a load balancer port of " + loadBalancerPort + ", which has no listener defined");
                } else {
                  listenerPolicyMap.put(loadBalancerPort, policyType.getPolicyName());
                }
              }
            }
            if (policyType.getInstancePorts() != null) {
              for (Integer instancePort : policyType.getInstancePorts()) {
                backendPolicyMap.put(instancePort, policyType.getPolicyName());
              }
            }
          }
        }
        for (Integer listenerLBPort: listenerPolicyMap.keySet()) {
          ArrayList<String> policyNamesStr = Lists.newArrayList(listenerPolicyMap.get(listenerLBPort));
          SetLoadBalancerPoliciesOfListenerType setLoadBalancerPoliciesOfListenerType = MessageHelper.createMessage(SetLoadBalancerPoliciesOfListenerType.class, action.info.getEffectiveUserId());
          setLoadBalancerPoliciesOfListenerType.setLoadBalancerName(action.info.getPhysicalResourceId());
          setLoadBalancerPoliciesOfListenerType.setLoadBalancerPort(listenerLBPort);
          PolicyNames policyNames = new PolicyNames();
          policyNames.setMember(policyNamesStr);
          setLoadBalancerPoliciesOfListenerType.setPolicyNames(policyNames);
          AsyncRequests.<SetLoadBalancerPoliciesOfListenerType,SetLoadBalancerPoliciesOfListenerResponseType> sendSync(configuration, setLoadBalancerPoliciesOfListenerType);
        }
        for (Integer backendInstancePort: backendPolicyMap.keySet()) {
          ArrayList<String> policyNamesStr = Lists.newArrayList(backendPolicyMap.get(backendInstancePort));
          SetLoadBalancerPoliciesForBackendServerType setLoadBalancerPoliciesForBackendServerType = MessageHelper.createMessage(SetLoadBalancerPoliciesForBackendServerType.class, action.info.getEffectiveUserId());
          setLoadBalancerPoliciesForBackendServerType.setLoadBalancerName(action.info.getPhysicalResourceId());
          setLoadBalancerPoliciesForBackendServerType.setInstancePort(backendInstancePort);
          PolicyNames policyNames = new PolicyNames();
          policyNames.setMember(policyNamesStr);
          setLoadBalancerPoliciesForBackendServerType.setPolicyNames(policyNames);
          AsyncRequests.<SetLoadBalancerPoliciesForBackendServerType,SetLoadBalancerPoliciesForBackendServerResponseType> sendSync(configuration, setLoadBalancerPoliciesForBackendServerType);
        }
        return action;
      }
    },
    SET_CROSS_ZONE_ATTRIBUTE { // For any configured load balancer attributes
      @Override
      public ResourceAction perform(ResourceAction resourceAction) throws Exception {
        final AWSElasticLoadBalancingLoadBalancerResourceAction action =
            (AWSElasticLoadBalancingLoadBalancerResourceAction) resourceAction;
        final ServiceConfiguration configuration = Topology.lookup(LoadBalancing.class);
        final boolean accessLogging = action.properties.getAccessLoggingPolicy( ) != null;
        final boolean crossZone = action.properties.getCrossZone() != null &&
            action.properties.getCrossZone() == Boolean.TRUE;
        final boolean idleTimeout = action.properties.getConnectionSettings( ) != null &&
            action.properties.getConnectionSettings( ).getIdleTimeout( ) != null;
        if ( accessLogging || crossZone || idleTimeout ) {
          ModifyLoadBalancerAttributesType modifyLoadBalancerAttributesType = MessageHelper.createMessage(ModifyLoadBalancerAttributesType.class, action.info.getEffectiveUserId());
          modifyLoadBalancerAttributesType.setLoadBalancerName(action.info.getPhysicalResourceId());
          LoadBalancerAttributes loadBalancerAttributes = new LoadBalancerAttributes();
          if ( accessLogging ) {
            final ElasticLoadBalancingAccessLoggingPolicy accessLoggingPolicy = action.properties.getAccessLoggingPolicy( );
            final AccessLog accessLog = new AccessLog( );
            accessLog.setEnabled( accessLoggingPolicy.getEnabled( ) );
            accessLog.setEmitInterval( accessLoggingPolicy.getEmitInterval( ) );
            accessLog.setS3BucketName( accessLoggingPolicy.getS3BucketName( ) );
            accessLog.setS3BucketPrefix( accessLoggingPolicy.getS3BucketPrefix( ) );
            loadBalancerAttributes.setAccessLog( accessLog );
          }
          if ( crossZone ) {
            CrossZoneLoadBalancing crossZoneLoadBalancing = new CrossZoneLoadBalancing( );
            crossZoneLoadBalancing.setEnabled( Boolean.TRUE );
            loadBalancerAttributes.setCrossZoneLoadBalancing( crossZoneLoadBalancing );
          }
          if ( idleTimeout ) {
            ConnectionSettings connectionSettings = new ConnectionSettings( );
            connectionSettings.setIdleTimeout( action.properties.getConnectionSettings( ).getIdleTimeout( ) );
            loadBalancerAttributes.setConnectionSettings( connectionSettings );
          }
          modifyLoadBalancerAttributesType.setLoadBalancerAttributes(loadBalancerAttributes);
          AsyncRequests.<ModifyLoadBalancerAttributesType, ModifyLoadBalancerAttributesResponseType>sendSync(configuration, modifyLoadBalancerAttributesType);
        }
        return action;
      }
    },
    PLACEHOLDER_FOR_OTHER_FIELDS { //// placeholder for ""ConnectionDrainingPolicy"
      @Override
      public ResourceAction perform(ResourceAction resourceAction) throws Exception {
        AWSElasticLoadBalancingLoadBalancerResourceAction action = (AWSElasticLoadBalancingLoadBalancerResourceAction) resourceAction;
        ServiceConfiguration configuration = Topology.lookup(LoadBalancing.class);
        // not currently supported
        return action;
      }
    },
    DESCRIBE_LOAD_BALANCER_TO_GET_ATTRIBUTES {
      @Override
      public ResourceAction perform(ResourceAction resourceAction) throws Exception {
        AWSElasticLoadBalancingLoadBalancerResourceAction action = (AWSElasticLoadBalancingLoadBalancerResourceAction) resourceAction;
        ServiceConfiguration configuration = Topology.lookup(LoadBalancing.class);
        DescribeLoadBalancersType describeLoadBalancersType = MessageHelper.createMessage(DescribeLoadBalancersType.class, action.info.getEffectiveUserId());
        LoadBalancerNames loadBalancerNames = new LoadBalancerNames();
        ArrayList<String> member = Lists.newArrayList(action.info.getPhysicalResourceId());
        loadBalancerNames.setMember(member);
        describeLoadBalancersType.setLoadBalancerNames(loadBalancerNames);
        DescribeLoadBalancersResponseType describeLoadBalancersResponseType = AsyncRequests.<DescribeLoadBalancersType,DescribeLoadBalancersResponseType> sendSync(configuration, describeLoadBalancersType);
        if (describeLoadBalancersResponseType != null && describeLoadBalancersResponseType.getDescribeLoadBalancersResult() != null
          && describeLoadBalancersResponseType.getDescribeLoadBalancersResult().getLoadBalancerDescriptions() != null &&
          describeLoadBalancersResponseType.getDescribeLoadBalancersResult().getLoadBalancerDescriptions().getMember() != null &&
          describeLoadBalancersResponseType.getDescribeLoadBalancersResult().getLoadBalancerDescriptions().getMember().size() > 0) {
          LoadBalancerDescription loadBalancerDescription = describeLoadBalancersResponseType.getDescribeLoadBalancersResult().getLoadBalancerDescriptions().getMember().get(0);
          String canonicalHostedZoneName = loadBalancerDescription.getCanonicalHostedZoneName();
          String canonicalHostedZoneNameId = loadBalancerDescription.getCanonicalHostedZoneNameID();
          String sourceSecurityGroupGroupName = loadBalancerDescription.getSourceSecurityGroup().getGroupName();
          String sourceSecurityGroupGroupOwnerAlias = loadBalancerDescription.getSourceSecurityGroup().getOwnerAlias();
          if ("internal".equals(loadBalancerDescription.getScheme())) {
            canonicalHostedZoneName = loadBalancerDescription.getDnsName();
          }
          action.info.setSourceSecurityGroupGroupName(JsonHelper.getStringFromJsonNode(new TextNode(sourceSecurityGroupGroupName)));
          action.info.setSourceSecurityGroupOwnerAlias(JsonHelper.getStringFromJsonNode(new TextNode(sourceSecurityGroupGroupOwnerAlias)));
          action.info.setCanonicalHostedZoneNameID(JsonHelper.getStringFromJsonNode(new TextNode(canonicalHostedZoneNameId)));
          action.info.setCanonicalHostedZoneName(JsonHelper.getStringFromJsonNode(new TextNode(canonicalHostedZoneName)));
        }
        return action;
      }
    };

    @Nullable
    @Override
    public Integer getTimeout() {
      return null;
    }
  }

  private static LoadBalancerNames getLoadBalancerNames(AWSElasticLoadBalancingLoadBalancerResourceAction action) {
    LoadBalancerNames loadBalancerNames = new LoadBalancerNames();
    loadBalancerNames.setMember(Lists.newArrayList(action.info.getPhysicalResourceId()));
    return loadBalancerNames;
  }

  private enum DeleteSteps implements Step {
    DELETE_LOAD_BALANCER {
      @Override
      public ResourceAction perform(ResourceAction resourceAction) throws Exception {
        AWSElasticLoadBalancingLoadBalancerResourceAction action = (AWSElasticLoadBalancingLoadBalancerResourceAction) resourceAction;
        ServiceConfiguration configuration = Topology.lookup(LoadBalancing.class);
        if (action.info.getCreatedEnoughToDelete() != Boolean.TRUE) return action;
        DescribeLoadBalancersType describeLoadBalancersType = MessageHelper.createMessage(DescribeLoadBalancersType.class, action.info.getEffectiveUserId());
        LoadBalancerNames loadBalancerNames = new LoadBalancerNames();
        ArrayList<String> member = Lists.newArrayList(action.info.getPhysicalResourceId());
        loadBalancerNames.setMember(member);
        describeLoadBalancersType.setLoadBalancerNames(loadBalancerNames);
        DescribeLoadBalancersResponseType describeLoadBalancersResponseType = AsyncRequests.<DescribeLoadBalancersType,DescribeLoadBalancersResponseType> sendSync(configuration, describeLoadBalancersType);
        if ( describeLoadBalancersResponseType != null && describeLoadBalancersResponseType.getDescribeLoadBalancersResult() != null &&
            describeLoadBalancersResponseType.getDescribeLoadBalancersResult().getLoadBalancerDescriptions() != null &&
            describeLoadBalancersResponseType.getDescribeLoadBalancersResult().getLoadBalancerDescriptions().getMember() != null &&
            describeLoadBalancersResponseType.getDescribeLoadBalancersResult().getLoadBalancerDescriptions().getMember().size() == 1 ) {
          DeleteLoadBalancerType deleteLoadBalancerType = MessageHelper.createMessage(DeleteLoadBalancerType.class, action.info.getEffectiveUserId());
          deleteLoadBalancerType.setLoadBalancerName(action.info.getPhysicalResourceId());
          AsyncRequests.<DeleteLoadBalancerType,DeleteLoadBalancerResponseType> sendSync(configuration, deleteLoadBalancerType);
        }
        return action;
      }
    };

    @Nullable
    @Override
    public Integer getTimeout() {
      return null;
    }
  }

  @Override
  public ResourceProperties getResourceProperties() {
    return properties;
  }

  @Override
  public void setResourceProperties(ResourceProperties resourceProperties) {
    properties = (AWSElasticLoadBalancingLoadBalancerProperties) resourceProperties;
  }

  @Override
  public ResourceInfo getResourceInfo() {
    return info;
  }

  @Override
  public void setResourceInfo(ResourceInfo resourceInfo) {
    info = (AWSElasticLoadBalancingLoadBalancerResourceInfo) resourceInfo;
  }

}
