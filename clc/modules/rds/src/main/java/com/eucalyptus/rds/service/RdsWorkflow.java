/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.service;

import java.util.Collections;
import java.util.List;
import org.apache.log4j.Logger;
import com.eucalyptus.bootstrap.Bootstrap;
import com.eucalyptus.component.Topology;
import com.eucalyptus.component.id.Eucalyptus;
import com.eucalyptus.entities.Entities;
import com.eucalyptus.entities.PersistenceExceptions;
import com.eucalyptus.entities.TransactionResource;
import com.eucalyptus.event.ClockTick;
import com.eucalyptus.event.EventListener;
import com.eucalyptus.event.Listeners;
import com.eucalyptus.event.SystemClock;
import com.eucalyptus.rds.common.Rds;
import com.eucalyptus.rds.service.persist.DBInstances;
import com.eucalyptus.rds.service.persist.RdsMetadataException;
import com.eucalyptus.rds.service.persist.entities.DBInstance;
import com.eucalyptus.rds.service.persist.entities.DBInstance.Status;
import com.eucalyptus.rds.service.persist.entities.PersistenceDBInstances;
import com.google.common.base.Functions;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;

/**
 *
 */
public class RdsWorkflow {

  private static final Logger logger = Logger.getLogger(RdsWorkflow.class);

  private final DBInstances dbInstances;

  private final List<WorkflowTask> workflowTasks = ImmutableList.<WorkflowTask>builder()
      .add(new WorkflowTask(10, "DBInstances.Create") {@Override void doWork(){ dbInstanceCreate(); }})
      .add(new WorkflowTask(10, "DBInstances.Delete") {@Override void doWork(){ dbInstanceDelete(); }})
      .build();

  public RdsWorkflow(
      final DBInstances dbInstances
  ) {
    this.dbInstances = dbInstances;
  }

  private void doWorkflow() {
    for (final WorkflowTask workflowTask : workflowTasks) {
      try {
        workflowTask.perhapsWork();
      } catch (Exception e) {
        logger.error(e, e);
      }
    }
  }

  private List<String> listDbInstanceUuids(final DBInstance.Status status) {
    List<String> dbInstanceUuids = Collections.emptyList();
    try (final TransactionResource tx = Entities.transactionFor(DBInstance.class)) {
      dbInstanceUuids = dbInstances.listByExample(
          DBInstance.exampleWithStatus(status),
          Predicates.alwaysTrue(),
          DBInstance::getNaturalId);
    } catch (RdsMetadataException e) {
      logger.error("Error listing db instances", e);
    }
    return dbInstanceUuids;
  }

  private void dbInstanceCreate() {
    for (final String dbInstanceUuid : listDbInstanceUuids(Status.creating)) {
      try (final TransactionResource tx = Entities.transactionFor(DBInstance.class)) {
        final DBInstance dbInstance = dbInstances.lookupByExample(
            DBInstance.exampleWithUuid(dbInstanceUuid),
            null,
            dbInstanceUuid,
            Predicates.alwaysTrue(),
            Functions.identity());
        dbInstances.updateByExample(dbInstance, null, dbInstanceUuid, instance -> {
          instance.setState(Status.available);
          return instance;
        });
        tx.commit();
      } catch (Exception e) {
        if (PersistenceExceptions.isStaleUpdate(e)) {
          logger.debug("Conflict creating db instance " + dbInstanceUuid + " (will retry)");
        } else {
          logger.error("Error processing db instance create " + dbInstanceUuid, e);
        }
      }
    }
  }

  private void dbInstanceDelete() {
    for (final String dbInstanceUuid : listDbInstanceUuids(DBInstance.Status.deleting)) {
      try (final TransactionResource tx = Entities.transactionFor(DBInstance.class)) {
        final DBInstance dbInstance = dbInstances.lookupByExample(
            DBInstance.exampleWithUuid(dbInstanceUuid),
            null,
            dbInstanceUuid,
            Predicates.alwaysTrue(),
            Functions.identity());
        dbInstances.deleteByExample(dbInstance);
        tx.commit();
      } catch (Exception e) {
        if (PersistenceExceptions.isStaleUpdate(e)) {
          logger.debug("Conflict deleting db instance " + dbInstanceUuid + " (will retry)");
        } else {
          logger.error("Error processing db instance delete " + dbInstanceUuid, e);
        }
      }
    }
  }

  private static abstract class WorkflowTask {

    private volatile int count = 0;

    private final int factor;

    private final String task;

    protected WorkflowTask(final int factor, final String task) {
      this.factor = factor;
      this.task = task;
    }

    protected final int calcFactor() {
      return factor / (int) Math.max(1, SystemClock.RATE / 1000);
    }

    protected final void perhapsWork() throws Exception {
      if (++count % calcFactor() == 0) {
        logger.trace("Running RDS workflow task: " + task);
        doWork();
        logger.trace("Completed RDS workflow task: " + task);
      }
    }

    abstract void doWork() throws Exception;
  }

  public static class RdsWorkflowEventListener implements EventListener<ClockTick> {

    private final RdsWorkflow rdsWorkflow = new RdsWorkflow(
        new PersistenceDBInstances()
    );

    public static void register() {
      Listeners.register(ClockTick.class, new RdsWorkflowEventListener());
    }

    @Override
    public void fireEvent(final ClockTick event) {
      if (Bootstrap.isOperational() &&
          Topology.isEnabledLocally(Eucalyptus.class) &&
          Topology.isEnabled(Rds.class)) {
        rdsWorkflow.doWorkflow();
      }
    }
  }
}
