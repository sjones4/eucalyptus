/**
 * Copyright 2019 AppScale Systems, Inc
 *
 * SPDX-License-Identifier: BSD-2-Clause
 */
package com.eucalyptus.node;

import java.util.List;
import org.graalvm.nativeimage.c.CContext;
import org.graalvm.nativeimage.c.constant.CConstant;
import com.eucalyptus.node.NodeInterface.NodeInterfaceDirectives;
import com.google.common.collect.Lists;

/**
 *
 */
@CContext( NodeInterfaceDirectives.class)
public class NodeInterface {

  static class NodeInterfaceDirectives implements CContext.Directives {
    @Override
      public List<String> getHeaderFiles() {
        return Lists.newArrayList(
            "\"handlers.h\""
        );
      }
    }

  @CConstant("LIBVIRT_QUERY_RETRIES")
  public static native int getLibvirtQueryRetries();
}
