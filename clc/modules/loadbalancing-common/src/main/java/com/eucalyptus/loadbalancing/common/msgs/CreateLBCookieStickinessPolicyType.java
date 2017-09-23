/*************************************************************************
 * (c) Copyright 2017 Hewlett Packard Enterprise Development Company LP
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; version 3 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses/.
 ************************************************************************/
package com.eucalyptus.loadbalancing.common.msgs;

public class CreateLBCookieStickinessPolicyType extends LoadBalancingMessage {

  private String loadBalancerName;
  private String policyName;
  private Long cookieExpirationPeriod;

  public CreateLBCookieStickinessPolicyType( ) {
  }

  public String getLoadBalancerName( ) {
    return loadBalancerName;
  }

  public void setLoadBalancerName( String loadBalancerName ) {
    this.loadBalancerName = loadBalancerName;
  }

  public String getPolicyName( ) {
    return policyName;
  }

  public void setPolicyName( String policyName ) {
    this.policyName = policyName;
  }

  public Long getCookieExpirationPeriod( ) {
    return cookieExpirationPeriod;
  }

  public void setCookieExpirationPeriod( Long cookieExpirationPeriod ) {
    this.cookieExpirationPeriod = cookieExpirationPeriod;
  }
}
