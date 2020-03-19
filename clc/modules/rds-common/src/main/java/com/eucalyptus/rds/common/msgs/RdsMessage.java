/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import java.lang.reflect.Method;
import java.util.Map;
import com.eucalyptus.component.annotation.ComponentMessage;
import com.eucalyptus.rds.common.Rds;
import com.eucalyptus.rds.common.RdsMessageValidation;
import com.eucalyptus.util.MessageValidation;
import com.google.common.collect.Maps;
import edu.ucsb.eucalyptus.msgs.BaseMessage;

@ComponentMessage(Rds.class)
public class RdsMessage extends BaseMessage {


  public static ResponseMetadata getResponseMetadata(final BaseMessage message) {
    try {
      Method responseMetadataMethod = message.getClass().getMethod("getResponseMetadata");
      return ((ResponseMetadata) responseMetadataMethod.invoke(message));
    } catch (Exception e) {
    }

    return null;
  }

  @Override
  public <TYPE extends BaseMessage> TYPE getReply() {
    TYPE type = super.getReply();
    final ResponseMetadata responseMetadata = getResponseMetadata(type);
    if (responseMetadata != null) {
      responseMetadata.setRequestId(type.getCorrelationId());
    }
    return type;
  }

  public Map<String, String> validate() {
    return MessageValidation.validateRecursively(Maps.newTreeMap(), new RdsMessageValidation.RdsMessageValidationAssistant(), "", this);
  }
}
