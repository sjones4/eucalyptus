/**
 * Copyright 2019 AppScale Systems, Inc
 *
 * SPDX-License-Identifier: BSD-2-Clause
 */
package com.eucalyptus.node;

import static com.eucalyptus.util.Json.JsonOption.IgnoreBaseMessageUpper;
import static com.eucalyptus.util.Json.JsonOption.OmitNullValues;
import static com.eucalyptus.util.Json.JsonOption.UpperCamelPropertyNaming;
import static spark.Spark.*;
import java.util.EnumSet;
import com.eucalyptus.cluster.common.msgs.CloudNodeMessage;
import com.eucalyptus.util.Json;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.common.base.MoreObjects;

/**
 * Node controller entry point
 */
public class Main {
  private static final ObjectMapper mapper =
      Json.mapper(EnumSet.of(IgnoreBaseMessageUpper, OmitNullValues, UpperCamelPropertyNaming))
          .disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
  private static final ObjectReader reader = mapper.reader();
  private static final ObjectWriter writer = mapper.writer();

  private static final String TYPE_PREFIX = "com.eucalyptus.cluster.common.msgs.Nc";
  private static final String TYPE_SUFFIX = "Type";

  private static final NodeServiceImpl nodeService = new NodeServiceImpl();
  private static final NodeRequestRouter nodeRouter = new NodeRequestRouter(nodeService);

  @SuppressWarnings( "unchecked" )
  private static Class<? extends CloudNodeMessage> messageType(
      final String typeOrAction
  ) throws ClassNotFoundException {
    final String action = MoreObjects.firstNonNull(typeOrAction, "DescribeInstances");
    final String type = action.startsWith(TYPE_PREFIX) ? action : TYPE_PREFIX + action + TYPE_SUFFIX;
    return (Class<? extends CloudNodeMessage>) Class.forName(type);
  }

  private static String handle(final CloudNodeMessage request) {
    final CloudNodeMessage response = nodeRouter.handle(request);
    try {
      return writer.writeValueAsString(response);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static void main(final String[] args) {
    NodeInterface.doInitNC();
    get("/", (req, res) -> NodeInterface.getEucaVersion());
    get("/node/:action", (req, res) -> {
      final CloudNodeMessage request = messageType(req.params(":action")).newInstance();
      return handle(request);
    });
    post("/node", (req, res) -> {
      final Class<?> typeClazz = messageType(req.headers("X-Euca-Type"));
      final CloudNodeMessage request = (CloudNodeMessage) Json.readObject(reader, typeClazz, req.body());
      return handle(request);
    });
  }
}
