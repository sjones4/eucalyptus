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
import com.eucalyptus.cluster.common.msgs.NcDescribeInstancesType;
import com.eucalyptus.util.Json;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * Node controller entry point
 */
public class Main {
  private static final ObjectMapper mapper =
      Json.mapper(EnumSet.of(IgnoreBaseMessageUpper, OmitNullValues, UpperCamelPropertyNaming))
          .disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
  private static final ObjectReader reader = mapper.reader();
  private static final ObjectWriter writer = mapper.writer();

  private static final NodeServiceImpl nodeService = new NodeServiceImpl();
  private static final NodeRequestRouter nodeRouter = new NodeRequestRouter(nodeService);

  public static void main(final String[] args) {
    NodeInterface.doInitNC();

    get("/node", (req, res) -> {
      // "X-Euca-Type"
      final NcDescribeInstancesType request =
          (NcDescribeInstancesType)Class.forName("com.eucalyptus.cluster.common.msgs.NcDescribeInstancesType").newInstance();
      final CloudNodeMessage response = nodeRouter.handle(request);
      try {
        return writer.writeValueAsString(response);
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    });
  }
}
