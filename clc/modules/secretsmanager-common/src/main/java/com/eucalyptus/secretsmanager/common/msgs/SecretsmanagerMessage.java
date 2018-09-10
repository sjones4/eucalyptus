/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.secretsmanager.common.msgs;

import java.lang.reflect.Method;
import java.util.Map;
import com.eucalyptus.secretsmanager.common.Secretsmanager;
import com.eucalyptus.secretsmanager.common.SecretsmanagerMessageValidation;
import com.eucalyptus.component.annotation.ComponentMessage;
import com.eucalyptus.util.MessageValidation;
import com.google.common.collect.Maps;
import edu.ucsb.eucalyptus.msgs.BaseMessage;

@ComponentMessage( Secretsmanager.class )
public class SecretsmanagerMessage extends BaseMessage {



  public Map<String, String> validate( ) {
    return MessageValidation.validateRecursively( Maps.newTreeMap( ), new SecretsmanagerMessageValidation.SecretsmanagerMessageValidationAssistant( ), "", this );
  }
}
