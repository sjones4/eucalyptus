/**
 * Copyright 2019 AppScale Systems, Inc
 *
 * SPDX-License-Identifier: BSD-2-Clause
 */
package com.eucalyptus.node;

import java.util.List;
import org.graalvm.nativeimage.c.CContext;
import org.graalvm.nativeimage.c.constant.CConstant;
import org.graalvm.nativeimage.c.function.CFunction;
import org.graalvm.nativeimage.c.struct.CFieldAddress;
import org.graalvm.nativeimage.c.struct.CStruct;
import org.graalvm.nativeimage.c.type.CCharPointer;
import org.graalvm.word.PointerBase;
import com.eucalyptus.node.NodeInterface.NodeInterfaceDirectives;
import com.google.common.collect.Lists;

/**
 *
 */
@CContext( NodeInterfaceDirectives.class)
public class NodeInterface {

  static class NodeInterfaceDirectives implements CContext.Directives {

    @Override
    public List<String> getOptions( ) {
      return Lists.newArrayList(
          "-DHANDLERS_FANOUT"
      );
    }

    @Override
    public List<String> getHeaderFiles() {
      return Lists.newArrayList(
          "\"handlers.h\""
      );
    }

    @Override
    public List<String> getLibraries( ) {
      return Lists.newArrayList(
          "eucanode", "crypto", "curl", "dl", "m", "json-c", "virt", "ssl", "xml2", "xslt", "z"
      );
    }
  }

  @CStruct("serviceInfoType")
  interface ServiceInfoType extends PointerBase {
    @CFieldAddress("type")
    CCharPointer type();

    @CFieldAddress("name")
    CCharPointer name();

    @CFieldAddress("partition")
    CCharPointer partition();

//    char uris[MAX_SERVICE_URIS][512];  //!< Service URI list
//    int urisLen;                       //!< Number of service URI in the list (a value of -1 indicates an error with the URIS)
  }


  //String javaString = CTypeConversion.toJavaString(data.getCString()) + " at " + new Date();

//  //! Structure defining the NC metadata
//  typedef struct ncMetadata_t {
//    char *correlationId;               //!< Request Correlation Identifier
//    char *userId;                      //!< User identifier
//    char *nodeName;                    //!< Name/IP of the node the request is bound for (optional)
//    int epoch;                         //!< Request timestamp in EPOCH format
//    serviceInfoType services[16];      //!< List of services available
//    serviceInfoType disabledServices[16];   //!< List of disabled services
//    serviceInfoType notreadyServices[16];   //!< List of unavailable services
//    int servicesLen;                   //!< Number of available services in the available list (a value of -1 indicates an error with the services)
//    int disabledServicesLen;           //!< Number of disabled services in the disabled list (a value of -1 indicates an error with the services)
//    int notreadyServicesLen;           //!< Number of unavailable services in the not ready list (a value of -1 indicates an error with the services)
//    char *replyString;                 //!< If set, can be used to propagate error messages from handlers to marshalling code (and to the user)
//  } ncMetadata;

  @CConstant("LIBVIRT_QUERY_RETRIES")
  public static native int getLibvirtQueryRetries();

  @CFunction("doInitNC")
  public static native void doInitNC();
}
