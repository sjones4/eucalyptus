/*************************************************************************
 * Copyright 2009-2016 Ent. Services Development Corporation LP
 *
 * Redistribution and use of this software in source and binary forms,
 * with or without modification, are permitted provided that the
 * following conditions are met:
 *
 *   Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 *
 *   Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer
 *   in the documentation and/or other materials provided with the
 *   distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
 * FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
 * COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN
 * ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 ************************************************************************/
package com.eucalyptus.loadbalancing.workflow;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import com.eucalyptus.crypto.Digest;
import com.eucalyptus.loadbalancing.common.msgs.LoadBalancerDescription;
import com.eucalyptus.loadbalancing.common.msgs.PolicyDescription;
import org.apache.log4j.Logger;

import com.amazonaws.services.simpleworkflow.flow.ActivitySchedulingOptions;
import com.amazonaws.services.simpleworkflow.flow.ActivityTaskTimedOutException;
import com.amazonaws.services.simpleworkflow.flow.DecisionContextProvider;
import com.amazonaws.services.simpleworkflow.flow.DecisionContextProviderImpl;
import com.amazonaws.services.simpleworkflow.flow.WorkflowClock;
import com.amazonaws.services.simpleworkflow.flow.annotations.Asynchronous;
import com.amazonaws.services.simpleworkflow.flow.core.AndPromise;
import com.amazonaws.services.simpleworkflow.flow.core.OrPromise;
import com.amazonaws.services.simpleworkflow.flow.core.Promise;
import com.amazonaws.services.simpleworkflow.flow.core.Promises;
import com.amazonaws.services.simpleworkflow.flow.core.Settable;
import com.amazonaws.services.simpleworkflow.flow.core.TryCatchFinally;
import com.eucalyptus.component.annotation.ComponentPart;
import com.eucalyptus.loadbalancing.common.LoadBalancing;
import com.eucalyptus.loadbalancing.common.msgs.LoadBalancerServoDescription;
import com.eucalyptus.loadbalancing.common.msgs.LoadBalancerServoDescriptions;
import com.eucalyptus.util.Exceptions;
import com.eucalyptus.util.Pair;
import com.google.common.base.MoreObjects;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheBuilderSpec;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.Callables;
import javaslang.Value;
import javaslang.control.Option;

/**
 * @author Sang-Min Park (sangmin.park@hpe.com)
 *
 */
@ComponentPart(LoadBalancing.class)
public class UpdateLoadBalancerWorkflowImpl implements UpdateLoadBalancerWorkflow {
  private static Logger    LOG     = 
      Logger.getLogger(  UpdateLoadBalancerWorkflowImpl.class );

  private final LoadBalancingActivitiesClient client =
      new LoadBalancingActivitiesClientImpl();
  
  private final UpdateLoadBalancerWorkflowSelfClient selfClient =
      new UpdateLoadBalancerWorkflowSelfClientImpl();
  
  private final LoadBalancingVmActivitiesClient vmClient =
      new LoadBalancingVmActivitiesClientImpl();
  private DecisionContextProvider contextProvider = 
      new DecisionContextProviderImpl();
  final WorkflowClock clock = 
      contextProvider.getDecisionContext().getWorkflowClock();

  private Settable<Boolean> signalReceived = new Settable<Boolean>();

  private static final String resourceCacheSpec = "expireAfterAccess=120s";
  private static final Cache<String,VmInstanceResourceSha1s> resourceCache =
      CacheBuilder.from(CacheBuilderSpec.parse(resourceCacheSpec)).build();
  private static final String sha1CacheSpec = "expireAfterAccess=60s";
  private static final Cache<String,String> sha1Cache =
      CacheBuilder.from(CacheBuilderSpec.parse(sha1CacheSpec)).build();
  private static final Callable<VmInstanceResourceSha1s> EMPTY =
      Callables.returning(VmInstanceResourceSha1s.empty());

  private TryCatchFinally task = null;
  private final int MAX_UPDATE_PER_WORKFLOW = 10;
  private final int UPDATE_PERIOD_SEC = 60;
  private String accountId = null;
  private String loadbalancer = null;

  private static final class VmInstanceResourceSha1s {
    private final Option<String> lbResourceSha1;
    private final Set<String> policyResourceSha1s;

    public VmInstanceResourceSha1s(
        final Option<String> lbResourceSha1,
        final Set<String> policyResourceSha1s
    ) {
      this.lbResourceSha1 = lbResourceSha1;
      this.policyResourceSha1s = policyResourceSha1s;
    }

    private static VmInstanceResourceSha1s empty()  {
      return new VmInstanceResourceSha1s(Option.none(), Collections.emptySet());
    }

    private VmInstanceResourceSha1s lbResourceSha1(final String lbResourceSha1)  {
      return this.lbResourceSha1.isEmpty() ?
          new VmInstanceResourceSha1s(Option.of(lbResourceSha1), policyResourceSha1s) :
          new VmInstanceResourceSha1s(Option.of(lbResourceSha1), Collections.emptySet());
    }

    private VmInstanceResourceSha1s policyResourceSha1s(final Set<String> policyResourceSha1s)  {
      return this.policyResourceSha1s.isEmpty( ) ?
          new VmInstanceResourceSha1s(lbResourceSha1, ImmutableSet.copyOf(policyResourceSha1s)) :
          new VmInstanceResourceSha1s(Option.none( ), ImmutableSet.copyOf(policyResourceSha1s));
    }
  }

  @Override
  public void updateLoadBalancer(final String accountId, final String loadbalancer) {
    this.accountId = accountId;
    this.loadbalancer = loadbalancer;
    final Settable<Boolean> exception = new Settable<Boolean>();
    task = new TryCatchFinally() {
      @Override
      protected void doTry() throws Throwable {
        updateInstancesPeriodic(0, Promise.asPromise(null), Promise.asPromise(null), Promise.asPromise(null));
      }

      @Override
      protected void doCatch(final Throwable ex) throws Throwable {
        if (ex instanceof ActivityTaskTimedOutException) {
          ;
        }else if (ex instanceof CancellationException) {
          ;
        }else {
          ;
        }
        exception.set(true);
        throw ex;
      }

      @Override
      protected void doFinally() throws Throwable {      
        if(exception.isReady() && exception.get())
          return;
        else if (task.isCancelRequested())
          return;
        else {
          selfClient.getSchedulingOptions().setTagList(
              Lists.newArrayList(String.format("account:%s", accountId), 
                  String.format("loadbalancer:%s", loadbalancer)));
          selfClient.updateLoadBalancer(accountId, loadbalancer);
        }  
      }
    };
  }

  private Promise<Map<String, LoadBalancerServoDescriptionHolder>> lookupLoadBalancerDescription(
      final Map<String, LoadBalancerServoDescriptionHolder> loadbalancerPrev
  ) {
    String lbSha1 = null;
    LoadBalancerServoDescriptionHolder lbPrevServoDescription = null;
    if (loadbalancerPrev != null && !loadbalancerPrev.isEmpty()) {
      for ( final LoadBalancerServoDescriptionHolder lbServoDescription : loadbalancerPrev.values() ) {
        String sha1 = lbServoDescription.sha1();
        if (lbSha1!=null && !lbSha1.equals(sha1)) {
            lbSha1 = null;
            lbPrevServoDescription = null;
            break;
        }
        lbSha1 = sha1;
        lbPrevServoDescription = lbServoDescription;
      }
    }
    return resolveLoadBalancerDescriptions(
        lbPrevServoDescription,
        client.lookupLoadBalancerDescription(this.accountId, this.loadbalancer, lbSha1) );
  }

  @Asynchronous
  private Promise<Map<String, LoadBalancerServoDescriptionHolder>> resolveLoadBalancerDescriptions(
      final LoadBalancerServoDescriptionHolder lbPrevServoDescription,
      final Promise<Map<String, LoadBalancerServoDescription>> loadbalancer
  ) {
    final Map<String, LoadBalancerServoDescriptionHolder> resolved = Maps.newHashMap( );
    for ( final Map.Entry<String,LoadBalancerServoDescription> entry : loadbalancer.get().entrySet( ) ) {
      resolved.put(entry.getKey(), MoreObjects.firstNonNull(
          LoadBalancerServoDescriptionHolder.from(entry.getValue()),
          lbPrevServoDescription));
    }
    return Promise.asPromise(resolved);
  }


  private Promise<List<String>> listLoadBalancerPolicies(
      final List<String> policiesPrev
  ) {
    String policiesSha1 = null;
    if (policiesPrev != null && !policiesPrev.isEmpty()) {
      policiesSha1 = sha1(Sets.newTreeSet(policiesPrev).toString());
    }
    return resolveLoadBalancerPolicies(
        policiesSha1,
        policiesPrev,
        client.listLoadBalancerPolicies(this.accountId, this.loadbalancer, policiesSha1));
  }

  @Asynchronous
  private Promise<List<String>> resolveLoadBalancerPolicies(
      final String policiesSha1,
      final List<String> policiesPrev,
      final Promise<List<String>> policies
  ) {
    final List<String> resolved = Lists.newArrayList();
    if (Collections.singletonList(policiesSha1).equals(policies.get())) {
      resolved.addAll(policiesPrev);
    } else {
      resolved.addAll(policies.get());
    }
    return Promise.asPromise(resolved);
  }

  @Asynchronous
  private void updateInstancesPeriodic(final int count,
                                       final Promise<Map<String, LoadBalancerServoDescriptionHolder>> loadbalancerPrev,
                                       final Promise<List<String>> policiesPrev,
                                       final Promise<Map<String, PolicyDescriptionHolder>> policiesDescriptionsPrev,
                                       final Promise<?>... waitFor) {
    if (signalReceived.isReady() || count >= MAX_UPDATE_PER_WORKFLOW) {
      return;
    }
    // get map of instance->ELB description
    final Promise<Map<String, LoadBalancerServoDescriptionHolder>> loadbalancer =
        lookupLoadBalancerDescription(loadbalancerPrev.get());
    // each policy is a large text and SWF has a  limit on input/output text;
    // so we push the policy in iteration
    final Promise<List<String>> policies =
        listLoadBalancerPolicies(policiesPrev.get());
    final Promise<Map<String, PolicyDescriptionHolder>> policiesDescriptions =
        updatePolicies(loadbalancer, policies, policiesDescriptionsPrev);
    doUpdateInstances(count, loadbalancer, policies, policiesDescriptions); // push LB definition after policies are pushed
  }

  @Asynchronous
  Promise<Map<String, PolicyDescriptionHolder>> updatePolicies(
      final Promise<Map<String, LoadBalancerServoDescriptionHolder>> loadbalancer,
      final Promise<List<String>> policyNames,
      final Promise<Map<String, PolicyDescriptionHolder>> policiesDescriptionsPrev
  ) {
    final List<Promise<PolicyDescriptionHolder>> policies = Lists.newArrayList();
    final Map<String, PolicyDescriptionHolder> policyDescriptionPrevMap =
        MoreObjects.firstNonNull(policiesDescriptionsPrev.get(),Collections.emptyMap());
    for (final String policyName : policyNames.get()) {
      final PolicyDescriptionHolder prevPolicyDescription = policyDescriptionPrevMap.get(policyName);
      final String policyDescSha1 = prevPolicyDescription==null ? null :prevPolicyDescription.sha1();
      policies.add(resolvePolicyDescription(client.getLoadBalancerPolicy(
          Promise.asPromise(this.accountId),
          Promise.asPromise(this.loadbalancer),
          Promise.asPromise(policyName),
          Promise.asPromise(policyDescSha1)),prevPolicyDescription));
    }

    final Promise<Map<String, PolicyDescriptionHolder>> policyUpdated =
            pushPolicies(loadbalancer, Promises.listOfPromisesToPromise(policies));
    return policyUpdated;
  }

  @Asynchronous
  private Promise<PolicyDescriptionHolder> resolvePolicyDescription(
      final Promise<PolicyDescription> description,
      final PolicyDescriptionHolder prevDescription
  ) {
    return Promise.asPromise(MoreObjects.firstNonNull(PolicyDescriptionHolder.from(description.get()),prevDescription));
  }

  @Asynchronous
  private void doUpdateInstances(final int count,
                                 final Promise<Map<String, LoadBalancerServoDescriptionHolder>> loadbalancer,
                                 final Promise<List<String>> policies,
                                 final Promise<Map<String, PolicyDescriptionHolder>> policiesDescriptions) {
    // update each instance
    final Map<String, LoadBalancerServoDescriptionHolder> description = loadbalancer.get();

    final List<Promise<Void>> result = Lists.newArrayList();
    for(final String instanceId : description.keySet()) {
      final LoadBalancerServoDescriptionHolder desc = description.get(instanceId);
      result.add(doUpdateInstance(instanceId, desc));
    }

    final Promise<Void> timer = startDaemonTimer(UPDATE_PERIOD_SEC);
    final OrPromise waitOrSignal = new OrPromise(timer, signalReceived);
    updateInstancesPeriodic(count+1,
            loadbalancer,
            policies,
            policiesDescriptions,
            new AndPromise(waitOrSignal, Promises.listOfPromisesToPromise(result)));
  }

  private static String sha1(final String text) {
    try {
      return sha1Cache.get(
          text,
          () -> Digest.SHA1.digestHex(text.getBytes(StandardCharsets.UTF_8)));
    } catch ( ExecutionException e ) {
      throw Exceptions.toUndeclared( e );
    }
  }

  private static Set<String> sha1s(final Set<String> texts) {
    return texts.stream().map(UpdateLoadBalancerWorkflowImpl::sha1).collect(Collectors.toSet());
  }

  /**
   * Use the sha1 of the given text if it matches the cached value
   */
  private <R> R resourceOrCachedResourceSha1(
      final String instanceId,
      final R resource,
      final Function<R,R> sha1er,
      final BiFunction<VmInstanceResourceSha1s,R,Boolean> cachedPredicate
  ) {
    final VmInstanceResourceSha1s values = resourceCache.getIfPresent(instanceId);
    final R result;
    if (values != null) {
      final R sha1 = sha1er.apply(resource);
      result = cachedPredicate.apply(values,sha1) ? sha1 : resource;
    } else {
      result = resource;
    }
    return result;

  }

  private String lbOrCachedSha1(final String instanceId, final String text, final String sha1) {
    return resourceOrCachedResourceSha1(
        instanceId,
        text,
        (__) -> sha1,
        (vmInstanceResourceSha1s, value) -> vmInstanceResourceSha1s.lbResourceSha1.contains(value));
  }

  private Set<String> policyOrCachedSha1Set(final String instanceId, final Set<String> texts) {
    return resourceOrCachedResourceSha1(
        instanceId,
        texts,
        UpdateLoadBalancerWorkflowImpl::sha1s,
        (vmInstanceResourceSha1s, value) -> vmInstanceResourceSha1s.policyResourceSha1s.equals(value));
  }

  private void cacheUpdate(final String instanceId, Function<VmInstanceResourceSha1s,VmInstanceResourceSha1s> updater) {
    if (LoadBalancingActivitiesImpl.getVmInterfaceVersion(instanceId) > 0) {
      try {
        resourceCache.put(instanceId, updater.apply(resourceCache.get(instanceId,EMPTY)));
      } catch ( ExecutionException e ) {
        // loader does not throw
      }
    }
  }

  private void cachelbSha1(final String instanceId, final String text) {
    cacheUpdate(instanceId, resourceSha1s -> resourceSha1s.lbResourceSha1(sha1(text)));
  }

  private void cachePolicySha1Set(final String instanceId, final Set<String> policies) {
    cacheUpdate(instanceId, resourceSha1s -> resourceSha1s.policyResourceSha1s(sha1s(policies)));
  }

  private void clearCached(final String instanceId) {
    resourceCache.invalidate(instanceId);
  }

  @Asynchronous
  private Promise<Void> doUpdateInstance(final String instanceId,
                                         final LoadBalancerServoDescriptionHolder desc) {
    // update each servo VM
    final String encodedLB = desc.encoded();
    final String message = lbOrCachedSha1(instanceId, encodedLB, desc.sha1());
    final Settable<Void> result = new Settable<Void>();
    final Settable<String> failure = new Settable<String>();
    new TryCatchFinally() {
      protected void doTry() throws Throwable {
        final ActivitySchedulingOptions scheduler =
                new ActivitySchedulingOptions();
        scheduler.setTaskList(instanceId);
        scheduler.setScheduleToCloseTimeoutSeconds(120L); /// account for VM startup delay
        scheduler.setStartToCloseTimeoutSeconds(10L);
        result.chain(vmClient.setLoadBalancer(message, scheduler));
      }

      protected void doCatch(Throwable e) {
        failure.set(instanceId);
      }

      protected void doFinally() throws Throwable {
        if (!failure.isReady()) {
          failure.set(null);
          if (message.equals(encodedLB)) {
            cachelbSha1(instanceId, message);
          }
        } else { // purge cache
          clearCached(instanceId);
        }
      }
    };
    return checkInstanceFailure(failure);
  }

  @Asynchronous
  private Promise<Map<String, PolicyDescriptionHolder>> pushPolicies(
      final Promise<Map<String, LoadBalancerServoDescriptionHolder>> loadbalancer,
      final Promise<List<PolicyDescriptionHolder>> policies
  ) {
    final Map<String, LoadBalancerServoDescriptionHolder> description = loadbalancer.get();
    final List<Promise<Void>> result = Lists.newArrayList();
    for(final String instanceId : description.keySet()) {
      result.add(pushPoliciesToVM(instanceId, policies));
    }
    return pushedPolicies(policies, Promises.listOfPromisesToPromise(result));
  }

  @Asynchronous
  private Promise<Map<String, PolicyDescriptionHolder>> pushedPolicies(
      final Promise<List<PolicyDescriptionHolder>> policies,
      final Promise<?> waitFor
  ) {
    final Map<String,PolicyDescriptionHolder> pushedPolicyDescriptions = Maps.newHashMap();
    for (final PolicyDescriptionHolder description : policies.get()) {
      pushedPolicyDescriptions.put(description.get().getPolicyName(),description);
    }
    return Promise.asPromise(pushedPolicyDescriptions);
  }

  @Asynchronous
  private Promise<Void> pushPoliciesToVM(final String instanceId, final Promise<List<PolicyDescriptionHolder>> policies) {
    final List<Promise<Void>> result =  Lists.newArrayList();
    final Settable<String> failure = new Settable<String>();
    final Set<String> encodedPolicies = Sets.newHashSet();
    final Set<String> sha1Policies = Sets.newHashSet();
    new TryCatchFinally() {
      protected void doTry() throws Throwable {
        final ActivitySchedulingOptions scheduler =
                new ActivitySchedulingOptions();
        scheduler.setTaskList(instanceId);
        scheduler.setScheduleToCloseTimeoutSeconds(120L); /// account for VM startup delay
        scheduler.setStartToCloseTimeoutSeconds(10L);
        for (final PolicyDescriptionHolder p : policies.get()) {
          final String encodedPolicy = p.encoded();
          encodedPolicies.add(encodedPolicy);
        }
        sha1Policies.addAll(policyOrCachedSha1Set(instanceId, encodedPolicies));
        for (final String policyOrSha1 : sha1Policies) {
          result.add(vmClient.setPolicy(policyOrSha1, scheduler));
        }
      }

      protected void doCatch(Throwable e) {
        failure.set(instanceId);
      }

      protected void doFinally() throws Throwable {
        if (!failure.isReady()) {
          failure.set(null);
          if (sha1Policies.equals(encodedPolicies) && !encodedPolicies.isEmpty()) {
            cachePolicySha1Set(instanceId, encodedPolicies);
          }
        } else { // purge cache
          clearCached(instanceId);
        }
      }
    };
    return checkInstanceFailure(failure);
  }

  @Asynchronous
  private Promise<Void> checkInstanceFailure(Promise<String> failure) {
    final String instanceId = failure.get();
    if (instanceId != null) {
      return client.recordInstanceTaskFailure(instanceId);
    }
    return Promise.Void();
  }

  @Asynchronous
  private Promise<Void> done(Promise<List<Void>> result) {
    return Promise.Void();
  }

  @Asynchronous(daemon = true)
  private Promise<Void> startDaemonTimer(int seconds) {
      Promise<Void> timer = clock.createTimer(seconds);
      return timer;
  }

  @Override
  public void updateImmediately() {
    if(!signalReceived.isReady())
      signalReceived.set(true);
  }

  private static String encodePolicy(final PolicyDescription policy) {
    return VmWorkflowMarshaller.marshalPolicy(policy);
  }

  private static String encodeLoadBalancer(final LoadBalancerServoDescription lbDescription) {
    return VmWorkflowMarshaller.marshalLoadBalancer(lbDescription);
  }

  private static final class PolicyDescriptionHolder {
    private final PolicyDescription description;
    private final Supplier<String> encodedSupplier = Suppliers.memoize(()->encodePolicy(get()));
    private final Supplier<String> sha1Supplier =
        Suppliers.memoize(()->UpdateLoadBalancerWorkflowImpl.sha1(encoded()));

    public PolicyDescriptionHolder(final PolicyDescription description) {
      this.description = description;
    }

    @Nullable
    private static PolicyDescriptionHolder from(@Nullable final PolicyDescription description) {
      return description == null ? null : new PolicyDescriptionHolder( description );
    }

    @Nonnull private PolicyDescription get() { return description; }
    @Nonnull private String encoded() { return encodedSupplier.get(); }
    @Nonnull private String sha1() { return sha1Supplier.get(); }
  }

  private static final class LoadBalancerServoDescriptionHolder {
    private final LoadBalancerServoDescription description;
    private final Supplier<String> encodedSupplier = Suppliers.memoize(()->encodeLoadBalancer(get()));
    private final Supplier<String> sha1Supplier =
        Suppliers.memoize(()->UpdateLoadBalancerWorkflowImpl.sha1(encoded()));

    public LoadBalancerServoDescriptionHolder(final LoadBalancerServoDescription description) {
      this.description = description;
    }

    @Nullable
    private static LoadBalancerServoDescriptionHolder from(@Nullable final LoadBalancerServoDescription description) {
      return description == null ? null : new LoadBalancerServoDescriptionHolder( description );
    }

    @Nonnull private LoadBalancerServoDescription get() { return description; }
    @Nonnull private String encoded() { return encodedSupplier.get(); }
    @Nonnull private String sha1() { return sha1Supplier.get(); }
  }
}