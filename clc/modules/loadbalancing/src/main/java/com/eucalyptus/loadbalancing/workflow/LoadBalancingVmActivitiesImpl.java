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
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import com.eucalyptus.crypto.Digest;
import com.eucalyptus.util.Pair;
import com.google.common.base.Supplier;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheBuilderSpec;
import com.google.common.hash.Hasher;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

/**
 * @author Sang-Min Park (sangmin.park@hpe.com)
 *
 */
public class LoadBalancingVmActivitiesImpl
    implements LoadBalancingVmActivities {
  private static Logger    LOG     = 
      Logger.getLogger(  LoadBalancingVmActivitiesImpl.class );
  
  static class NoSubscriberException extends Exception { }

  private static RedisPubSubClient setPolicyClient =
          new RedisPubSubClient("localhost", "set-policy");
  private static RedisPubSubClient setLoadBalancerClient =
      new RedisPubSubClient("localhost", "set-loadbalancer");
  private static RedisPubSubClient getInstanceStatusClient =
      new RedisPubSubClient("localhost", "get-instance-status");
  private static RedisBlockingListClient getInstanceStatusReplyClient =
      new RedisBlockingListClient("localhost", "get-instance-status-reply");
  private static RedisPubSubClient getCloudwatchMetricsClient =
      new RedisPubSubClient("localhost", "get-cloudwatch-metrics");
  private static RedisBlockingListClient getCloudwatchMetricsReplyClient =
      new RedisBlockingListClient("localhost", "get-cloudwatch-metrics-reply");

  private enum CacheType { LoadBalancer, Policy }

  private static final int vmInterfaceVersion = 1;
  private static final Pattern sha1Pattern = Pattern.compile("[a-f0-9]{40}");
  private static final String resourceCacheSpec = "maximumSize=500, expireAfterAccess=120s";
  private static final Cache<Pair<CacheType,String>,String> resourceCache =
      CacheBuilder.from(CacheBuilderSpec.parse(resourceCacheSpec)).build();

  static class RedisClient {
    private String server = null;
    private Jedis jedis = null;
    public RedisClient(final String server) {
      this.server  = server;
    }
    
    protected Jedis connect() {
      if (jedis == null) {
        jedis = new Jedis(this.server);
      }
      return jedis;
    }
    
    protected void close() {
      if (jedis != null) {
        jedis.quit();
        jedis = null;
      }
    }
  }
  
  static class RedisPubSubClient extends RedisClient {
    public RedisPubSubClient(String server) {
      super(server);
    }
    
    public RedisPubSubClient(String server, String channel) {
      super(server);
      this.channel = channel;
    }
    
    private String channel = "euca-vmservice";
    public void publish(Supplier<String> message) throws NoSubscriberException {
      try {
        final Jedis server = this.connect();
        if( server.publish(channel, message.get()) <= 0 )
          throw new NoSubscriberException();
      }finally{
        this.close();
      }
    }
    
    public void subscribe(JedisPubSub callback) {
      final Jedis server = this.connect();
      server.subscribe(callback, this.channel);
      this.close();
    }
  }
  
  static class RedisBlockingListClient extends RedisClient {
    public RedisBlockingListClient(String server) {
      super(server);
    }
    
    private String defaultKey = null;
    public RedisBlockingListClient(String server, String key) {
      super(server);
      this.defaultKey = key;
    }
    
    public String pop() {
      return this.pop(defaultKey);
    }
    
    public String pop(final String key) {
      return this.pop(key, 0);
    }
    
    public String pop(final String key, final int timeout) {
     try{
       final Jedis server = this.connect();
       final List<String> results = server.blpop(timeout, key);
       
       String result = null;
       if (results != null && !results.isEmpty())
         result = results.get(1);
       return result;
     }finally {
       this.close();
     }
    }
  }

  private String getCachedResource(final CacheType type, final String key) throws LoadBalancingActivityException {
    final String resource = resourceCache.getIfPresent(Pair.of(type, key));
    if (resource == null) {
      throw new LoadBalancingActivityException(type.name() + " not found for " + key);
    }
    return resource;
  }

  private String setCachedResource(final CacheType type, final String resource) {
    if (resource != null) {
      resourceCache.put(Pair.of(type, sha1(resource)), resource);
    }
    return resource;
  }

  private String sha1(final String text) {
    return Digest.SHA1.digestHex(text.getBytes(StandardCharsets.UTF_8));
  }

  private String cacheProcess(final CacheType type, final String resourceOrResourceSha1) throws LoadBalancingActivityException {
    final String resource;
    if(sha1Pattern.matcher(resourceOrResourceSha1).matches()) {
      resource = getCachedResource(type, resourceOrResourceSha1);
    } else {
      resource = setCachedResource(type, resourceOrResourceSha1);
    }
    return resource;
  }

  private String getVersionPrefix() {
    return "viv" + vmInterfaceVersion + "|";
  }

  @Override
  public void setPolicy(final String policyOrPolicySha1) throws LoadBalancingActivityException {
    try {
      final String policy = cacheProcess(CacheType.Policy, policyOrPolicySha1);
      setPolicyClient.publish(new Supplier<String>() {
        @Override
        public String get() {
          return policy;
        }
      });
    } catch(final NoSubscriberException ex) {
      throw new LoadBalancingActivityException("No subscriber is found to receive the policy");
    }
  }

  @Override
  public void setLoadBalancer(final String loadbalancerOrloadbalancerSha1) throws LoadBalancingActivityException{
    try{
      final String loadbalancer = cacheProcess(CacheType.LoadBalancer, loadbalancerOrloadbalancerSha1);
      setLoadBalancerClient.publish(new Supplier<String>() {
        @Override
        public String get() {
          return loadbalancer;
        }
      });
      LOG.debug(String.format("New loadbalancer: %n%s", loadbalancer));
    }catch(final NoSubscriberException ex) {
      throw new LoadBalancingActivityException("No subscriber is found to receive the loadbalanacer");
    }
  }

  @Override
  public String getCloudWatchMetrics() throws LoadBalancingActivityException {
    try{
      getCloudwatchMetricsClient.publish(new Supplier<String> () { 
        @Override
        public String get() {
          return "GetCloudWatchMetrics";
        }
      });
    }catch(final NoSubscriberException ex) {
      throw new LoadBalancingActivityException("No subscriber is found to send the cloudwatch metrics");
    }
    
    String output = null;
    try{
      output = getCloudwatchMetricsReplyClient.pop();
    }catch(final Exception ex) {
      throw new LoadBalancingActivityException("Failed to receive cloudwatch metrics");
    }
    LOG.debug(String.format("get-cloudwatch-metric result: %n%s", output));
    return output;
  }
  
  @Override
  public String getInstanceStatus() throws LoadBalancingActivityException {
    try{
      getInstanceStatusClient.publish(new Supplier<String>() {
        @Override
        public String get() {
          return "GetInstanceStatus";
        }
      });
    }catch(final NoSubscriberException ex) {
      throw new LoadBalancingActivityException("No subscriber is found to send the instance status");
    }

    String output = null;
    try{
      output =  getVersionPrefix() + getInstanceStatusReplyClient.pop();
    }catch(final Exception ex) {
      throw new LoadBalancingActivityException("Failed to receive instance status");
    }

    LOG.debug(String.format("get-instance-status result: %n%s", output));
    return output;
  }
}