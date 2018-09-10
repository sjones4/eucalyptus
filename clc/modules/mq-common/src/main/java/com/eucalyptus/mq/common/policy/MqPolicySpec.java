/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.mq.common.policy;

/**
 *
 */
public interface MqPolicySpec {

  // Vendor
  String VENDOR_MQ = "mq";

  // Actions
  String MQ_CREATEBROKER = "createbroker";
  String MQ_CREATECONFIGURATION = "createconfiguration";
  String MQ_CREATEUSER = "createuser";
  String MQ_DELETEBROKER = "deletebroker";
  String MQ_DELETEUSER = "deleteuser";
  String MQ_DESCRIBEBROKER = "describebroker";
  String MQ_DESCRIBECONFIGURATION = "describeconfiguration";
  String MQ_DESCRIBECONFIGURATIONREVISION = "describeconfigurationrevision";
  String MQ_DESCRIBEUSER = "describeuser";
  String MQ_LISTBROKERS = "listbrokers";
  String MQ_LISTCONFIGURATIONREVISIONS = "listconfigurationrevisions";
  String MQ_LISTCONFIGURATIONS = "listconfigurations";
  String MQ_LISTUSERS = "listusers";
  String MQ_REBOOTBROKER = "rebootbroker";
  String MQ_UPDATEBROKER = "updatebroker";
  String MQ_UPDATECONFIGURATION = "updateconfiguration";
  String MQ_UPDATEUSER = "updateuser";

}
