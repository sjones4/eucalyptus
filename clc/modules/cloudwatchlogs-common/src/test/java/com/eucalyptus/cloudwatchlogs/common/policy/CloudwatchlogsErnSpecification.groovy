/*
 * Copyright 2020 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudwatchlogs.common.policy

import com.eucalyptus.auth.policy.PolicySpec
import com.eucalyptus.auth.policy.ern.Ern
import spock.lang.Specification

import static com.eucalyptus.auth.policy.ern.Ern.parse


/**
 *
 */
class CloudwatchlogsErnSpecification extends Specification {

  def setupSpec( ) {
    Ern.registerServiceErnBuilder( new CloudwatchlogsErnBuilder( ) )
  }

  def 'should support arns for all resource types'() {
    expect: 'arn parts are parsed correctly'
    parse( arn ).region == region
    parse( arn ).account == account
    parse( arn ).resourceType == PolicySpec.qualifiedName( CloudwatchlogsPolicySpec.VENDOR_CLOUDWATCHLOGS, type )
    parse( arn ).resourceName == resource

    where:
    region       | account        | type          | resource                                       | arn
    'eucalyptus' | '000070854946' | 'log-group'   | '*'                                            | 'arn:aws:logs:eucalyptus:000070854946:log-group:*'
    'eucalyptus' | '000070854946' | 'log-group'   | '/a/log/group/name'                            | 'arn:aws:logs:eucalyptus:000070854946:log-group:/a/log/group/name'
    null         | '000070854946' | 'log-stream'  | '*'                                            | 'arn:aws:logs::000070854946:log-group:group:log-stream:*'
    null         | '000070854946' | 'log-stream'  | '/a/log/stream/name'                           | 'arn:aws:logs::000070854946:log-group:group:log-stream:/a/log/stream/name'
    null         | '000070854946' | 'destination' | 'adestination'                                 | 'arn:aws:logs::000070854946:destination:adestination'
  }
}
