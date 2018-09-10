/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.secretsmanager.common.policy;

/**
 *
 */
public interface SecretsmanagerPolicySpec {

  // Vendor
  String VENDOR_SECRETSMANAGER = "secretsmanager";

  // Actions
  String SECRETSMANAGER_CANCELROTATESECRET = "cancelrotatesecret";
  String SECRETSMANAGER_CREATESECRET = "createsecret";
  String SECRETSMANAGER_DELETERESOURCEPOLICY = "deleteresourcepolicy";
  String SECRETSMANAGER_DELETESECRET = "deletesecret";
  String SECRETSMANAGER_DESCRIBESECRET = "describesecret";
  String SECRETSMANAGER_GETRANDOMPASSWORD = "getrandompassword";
  String SECRETSMANAGER_GETRESOURCEPOLICY = "getresourcepolicy";
  String SECRETSMANAGER_GETSECRETVALUE = "getsecretvalue";
  String SECRETSMANAGER_LISTSECRETVERSIONIDS = "listsecretversionids";
  String SECRETSMANAGER_LISTSECRETS = "listsecrets";
  String SECRETSMANAGER_PUTRESOURCEPOLICY = "putresourcepolicy";
  String SECRETSMANAGER_PUTSECRETVALUE = "putsecretvalue";
  String SECRETSMANAGER_RESTORESECRET = "restoresecret";
  String SECRETSMANAGER_ROTATESECRET = "rotatesecret";
  String SECRETSMANAGER_TAGRESOURCE = "tagresource";
  String SECRETSMANAGER_UNTAGRESOURCE = "untagresource";
  String SECRETSMANAGER_UPDATESECRET = "updatesecret";
  String SECRETSMANAGER_UPDATESECRETVERSIONSTAGE = "updatesecretversionstage";

}
