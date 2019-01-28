/**
 * Copyright 2019 AppScale Systems, Inc
 *
 * SPDX-License-Identifier: BSD-2-Clause
 */
package com.eucalyptus.node;

import static com.eucalyptus.node.NodeKeys.jks;
import static com.eucalyptus.util.Json.JsonOption.IgnoreBaseMessageUpper;
import static com.eucalyptus.util.Json.JsonOption.OmitNullValues;
import static com.eucalyptus.util.Json.JsonOption.UpperCamelPropertyNaming;
import static spark.Spark.*;
import java.util.EnumSet;
import java.util.UUID;
import com.eucalyptus.cluster.common.msgs.CloudNodeMessage;
import com.eucalyptus.util.Json;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.common.base.MoreObjects;
import edu.ucsb.eucalyptus.msgs.BaseMessages;

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

  private static final String CONTENT_TYPE_JSON = "application/json";
  private static final String CONTENT_TYPE_XML = "text/xml";
  private static final String CONTENT_TYPE_ANY = "*/*";

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

  private static String contentType(final String type) {
    return contentType(type, CONTENT_TYPE_JSON);
  }

  private static String contentType(final String type, final String defaultType) {
    return CONTENT_TYPE_ANY.equals(type) ?
        defaultType :
        MoreObjects.firstNonNull(type, defaultType).trim().toLowerCase();
  }

  private static String handle(final CloudNodeMessage request, final String contentType) {
    final CloudNodeMessage response = nodeRouter.handle(request);
    try {
      return contentType.startsWith(CONTENT_TYPE_XML) ?
          BaseMessages.toString(response) :
          writer.writeValueAsString(response);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static void main(final String[] args) throws Exception {
    NodeInterface.doInitNC();
    final String keystorePassword = UUID.randomUUID().toString();
    final String keystoreFile = jks(keystorePassword.toCharArray());
    secure(keystoreFile, keystorePassword, null, null);
    get("/", (req, res) -> NodeInterface.getEucaVersion());
    get("/node/:action", (req, res) -> {
      final CloudNodeMessage request = messageType(req.params(":action")).newInstance();
      return handle(request, contentType(req.headers("Accept")));
    });
    post("/node", (req, res) -> {
      final Class<? extends CloudNodeMessage> typeClazz = messageType(req.headers("X-Euca-Type"));
      final String contentType = contentType(req.headers("Content-Type"));
      final CloudNodeMessage request = contentType.startsWith(CONTENT_TYPE_XML) ?
          BaseMessages.fromString(req.body(), typeClazz) :
          Json.readObject(reader, typeClazz, req.body());
      return handle(request, contentType(req.headers("Accept"), contentType));
    });
  }
}
