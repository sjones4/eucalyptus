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

import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.Nonnull;
import com.eucalyptus.binding.HttpParameterMapping;
import edu.ucsb.eucalyptus.msgs.EucalyptusData;

public class Subnets extends EucalyptusData {

  private static final long serialVersionUID = 1L;
  @HttpParameterMapping( parameter = "member" )
  @Nonnull
  @LoadBalancingMessageValidation.FieldRange( min = 1L )
  @LoadBalancingMessageValidation.FieldRegex( LoadBalancingMessageValidation.FieldRegexValue.EC2_SUBNET_ID )
  private ArrayList<String> member = new ArrayList<>( );

  public Subnets( ) {
  }

  public Subnets( Collection<String> subnetId ) {
    if ( subnetId != null ) member.addAll( subnetId );
  }

  public ArrayList<String> getMember( ) {
    return member;
  }

  public void setMember( ArrayList<String> member ) {
    this.member = member;
  }
}
