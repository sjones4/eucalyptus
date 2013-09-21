/*************************************************************************
 * Copyright 2009-2013 Eucalyptus Systems, Inc.
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
 *
 * Please contact Eucalyptus Systems, Inc., 6755 Hollister Ave., Goleta
 * CA 93117, USA or visit http://www.eucalyptus.com/licenses/ if you need
 * additional information or have any questions.
 ************************************************************************/
package com.eucalyptus.publicipquota;

import java.util.Collections;
import javax.persistence.EntityTransaction;
import org.hibernate.criterion.Restrictions;
import com.eucalyptus.address.Address;
import com.eucalyptus.address.Addresses;
import com.eucalyptus.auth.AuthException;
import com.eucalyptus.auth.policy.PolicySpec;
import com.eucalyptus.auth.policy.key.KeyUtils;
import com.eucalyptus.auth.policy.key.PolicyKey;
import com.eucalyptus.auth.policy.key.QuotaKey;
import com.eucalyptus.auth.principal.AccountFullName;
import com.eucalyptus.auth.principal.UserFullName;
import com.eucalyptus.context.Contexts;
import com.eucalyptus.entities.Entities;
import com.eucalyptus.util.OwnerFullName;
import com.eucalyptus.util.RestrictedTypes;
import com.eucalyptus.vm.VmInstance;
import com.google.common.collect.Iterables;
import edu.ucsb.eucalyptus.msgs.BaseMessage;
import edu.ucsb.eucalyptus.msgs.RunInstancesType;
import net.sf.json.JSONException;

/**
 *
 */
@PolicyKey( PublicIPAddressQuotaKey.KEY )
public class PublicIPAddressQuotaKey extends QuotaKey {

  static final String KEY = "ec2:quota-publicipnumber";

  @Override
  public void validateValueType( final String value ) throws JSONException {
    KeyUtils.validateIntegerValue( value, KEY );
  }

  @Override
  public boolean canApply( final String action,
                           final String resourceType ) {
    return
        (PolicySpec.qualifiedName( PolicySpec.VENDOR_EC2, PolicySpec.EC2_RESOURCE_ADDRESS ).equals( resourceType ) ||
         PolicySpec.qualifiedName( PolicySpec.VENDOR_EC2, PolicySpec.EC2_RESOURCE_INSTANCE ).equals( resourceType ) ) &&
        (PolicySpec.qualifiedName( PolicySpec.VENDOR_EC2, PolicySpec.EC2_ALLOCATEADDRESS ).equals( action ) ||
         PolicySpec.qualifiedName( PolicySpec.VENDOR_EC2, PolicySpec.EC2_RUNINSTANCES ).equals( action ) ||
         PolicySpec.qualifiedName( PolicySpec.VENDOR_EC2, PolicySpec.EC2_STARTINSTANCES ).equals( action ) );
  }

  @Override
  public String value( final QuotaKey.Scope scope,
                       final String id,
                       final String resource,
                       final Long quantity ) throws AuthException {
    final OwnerFullName owner;
    switch ( scope ) {
      case ACCOUNT:
        owner = AccountFullName.getInstance( id );
        break;
      case USER:
        owner = UserFullName.getInstance( id );
        break;
      case GROUP:
        return NOT_SUPPORTED;
      default:
        throw new AuthException( "Invalid scope" );
    }

    final EntityTransaction db = Entities.get( VmInstance.class );
    long instancePublicIpCount = 0;
    try {
      instancePublicIpCount = Entities.count( 
          VmInstance.named( owner, null ), 
          Restrictions.ne( "networkConfig.publicAddress", "0.0.0.0" ), 
          Collections.<String,String>emptyMap( ) );  
    } finally {
      db.rollback( );
    }

    int unusedAllocatedIPs = 0;
    for ( final Address address : Iterables.filter( Addresses.getInstance().listValues(), RestrictedTypes.filterByOwner( owner ) ) ) {
      if ( address.isAllocated( ) && !address.isReallyAssigned( )  ) {
        unusedAllocatedIPs++;
      }
    }

    long requested = quantity;
    if ( Contexts.exists( ) ) {
      final BaseMessage request = Contexts.lookup( ).getRequest( );
      if ( request instanceof RunInstancesType ) {
        final RunInstancesType runInstances = (RunInstancesType) request;
        if ( "private".equals( runInstances.getAddressingType( ) ) ) {
          requested = 0;  
        }
      }
    }
    
    return Long.toString( instancePublicIpCount + unusedAllocatedIPs + requested );
  }
}
