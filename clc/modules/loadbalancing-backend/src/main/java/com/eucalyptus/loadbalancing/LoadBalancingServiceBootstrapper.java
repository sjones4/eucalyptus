/*************************************************************************
 * Copyright 2009-2014 Eucalyptus Systems, Inc.
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

package com.eucalyptus.loadbalancing;

import com.eucalyptus.bootstrap.Provides;
import com.eucalyptus.bootstrap.RunDuring;
import com.eucalyptus.bootstrap.Bootstrap;
import com.eucalyptus.bootstrap.Bootstrapper;
import com.eucalyptus.bootstrap.DependsLocal;

import com.eucalyptus.component.Components;
import com.eucalyptus.component.Faults;
import com.eucalyptus.component.ServiceConfiguration;
import com.eucalyptus.component.Topology;
import com.eucalyptus.compute.common.ImageDetails;
import com.eucalyptus.compute.common.Compute;
import com.eucalyptus.compute.common.CloudMetadatas;
import com.eucalyptus.loadbalancing.activities.EucalyptusActivityTasks;
import com.eucalyptus.loadbalancing.activities.LoadBalancerASGroupCreator;
import com.eucalyptus.loadbalancing.common.LoadBalancingBackend;
import com.google.common.collect.Lists;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.concurrent.Callable;

@Provides(LoadBalancingBackend.class)
@RunDuring(Bootstrap.Stage.Final)
@DependsLocal(LoadBalancingBackend.class)
public class LoadBalancingServiceBootstrapper extends Bootstrapper.Simple {
    private static Logger LOG = Logger.getLogger(LoadBalancingServiceBootstrapper.class);

    private static LoadBalancingServiceBootstrapper singleton;
    private static final Callable<String> imageNotConfiguredFaultRunnable =
            Faults.forComponent(LoadBalancingBackend.class).havingId(1014).logOnFirstRun();

    public static Bootstrapper getInstance() {
        synchronized (LoadBalancingServiceBootstrapper.class) {
            if (singleton == null) {
                singleton = new LoadBalancingServiceBootstrapper();
                LOG.info("Creating Load Balancing Bootstrapper instance.");
            } else {
                LOG.info("Returning Load Balancing Bootstrapper instance.");
            }
        }
        return singleton;
    }

    private static int CheckCounter = 0;
    private static boolean EmiCheckResult = true;

    @Override
    public boolean check() throws Exception {
        if (CloudMetadatas.isMachineImageIdentifier(LoadBalancerASGroupCreator.IMAGE)) {
            if (CheckCounter >= 3 && Topology.isEnabled(Compute.class)) {
                try {
                    final List<ImageDetails> emis =
                            EucalyptusActivityTasks.getInstance().describeImagesWithVerbose(Lists.newArrayList(LoadBalancerASGroupCreator.IMAGE));
                    EmiCheckResult = LoadBalancerASGroupCreator.IMAGE.equals(emis.get(0).getImageId());
                    EmiCheckResult = "available".equals(emis.get(0).getImageState());
                } catch (final Exception ex) {
                    EmiCheckResult = false;
                }
                CheckCounter = 0;
            } else
                CheckCounter++;
            return EmiCheckResult;
        } else {
            try {
                //GRZE: do this bit in the way that it allows getting the information with out needing to spelunk log files.
                final ServiceConfiguration localService = Components.lookup(LoadBalancingBackend.class).getLocalServiceConfiguration();
                final Faults.CheckException ex = Faults.failure(localService, imageNotConfiguredFaultRunnable.call().split("\n")[1]);
                Faults.submit(localService, localService.lookupStateMachine().getTransitionRecord(), ex);
            } catch (Exception e) {
                LOG.debug(e);
            }
            return false;
        }
    }

    @Override
    public boolean enable() throws Exception {
        if (!super.enable())
            return false;
        try {
            LoadBalancerPolicies.initialize();
        } catch (final Exception ex) {
            LOG.error("Unable to initialize ELB policy types", ex);
            return false;
        }
        try{
            if(LoadBalancingSystemVpcs.isCloudVpc()) {
                if (!LoadBalancingSystemVpcs.prepareSystemVpc())
                    return false;
            }
        } catch (final Exception ex) {
            LOG.error("Failed to prepare system VPC for loadbalancing service", ex);
            return false;
        }
        return true;
    }
}