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
package com.eucalyptus.resolver;

import static com.eucalyptus.ws.util.HmacUtils.SignatureVariant;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.net.URLCodec;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.handler.codec.http.HttpMethod;
import org.jboss.netty.handler.codec.http.HttpRequest;
import com.eucalyptus.auth.login.AuthenticationException;
import com.eucalyptus.auth.policy.PolicySpec;
import com.eucalyptus.http.MappingHttpRequest;
import com.eucalyptus.util.CollectionUtils;
import com.eucalyptus.ws.protocol.OperationParameter;
import com.eucalyptus.ws.protocol.RequiredQueryParams;
import com.eucalyptus.ws.util.HmacUtils;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

/**
 *
 */
enum ServiceResolver {

  /**
   * Auto Scaling
   */
  AutoScaling(
      ImmutableSet.of( "2011-01-01" ),
      PolicySpec.AUTOSCALING_ACTIONS,
      ImmutableSet.of(
          OperationParameter.Action.toString( ),
          OperationParameter.Operation.toString( ) ),
      EnumSet.allOf( SignatureVariant.class )
  ),

  /**
   * CloudWatch
   */
  CloudWatch(
      ImmutableSet.of( "2010-08-01" ),
      PolicySpec.CLOUDWATCH_ACTIONS,
      ImmutableSet.of( OperationParameter.Action.toString( ) ),
      EnumSet.allOf( SignatureVariant.class )
  ),

  /**
   * IAM / EUARE
   */
  Euare(
      ImmutableSet.of( "2010-05-08" ),
      ImmutableSet.copyOf( Iterables.concat(
          PolicySpec.IAM_ACTIONS,
          ImmutableSet.of(
              "createaccount",
              "deleteaccount",
              "listaccounts",
              "putaccountpolicy",
              "deleteaccountpolicy",
              "getaccountpolicy",
              "listaccountpolicies",
              "getldapsyncstatus" ) ) ),
      ImmutableSet.of(
          OperationParameter.Action.toString(),
          OperationParameter.Operation.toString() ),
      EnumSet.allOf( SignatureVariant.class )
  ),

  /**
   * EC2 / Eucalyptus
   */
  Eucalyptus(
      ImmutableSet.of(
          "2006-06-26",
          "2006-10-01",
          "2007-01-03",
          "2007-01-19",
          "2007-03-01",
          "2007-08-29",
          "2008-02-01",
          "2008-05-05",
          "2008-08-08",
          "2008-12-01",
          "2009-03-01",
          "2009-04-04",
          "2009-07-15",
          "2009-08-15",
          "2009-10-31",
          "2009-11-30",
          "2010-06-15",
          "2010-08-31",
          "2010-11-15",
          //"2011-01-01", // disabled due to conflict with Auto Scaling
          "2011-02-28",
          "2011-05-15",
          "2011-07-15",
          "2011-11-01",
          "2011-12-01",
          "2011-12-15",
          "2012-03-01",
          "2012-04-01",
          "2012-05-01",
          "2012-06-01",
          "2012-06-15",
          "2012-07-20",
          "2012-08-15",
          "2012-10-01",
          "2012-12-01",
          "2013-02-01" ),
      ImmutableSet.copyOf( Iterables.concat(
          PolicySpec.EC2_ACTIONS,
          ImmutableSet.of(
              "describeinstancetypes",
              "modifyinstancetypeattribute" ) ) ),
      ImmutableSet.of(
          OperationParameter.Action.toString(),
          OperationParameter.Operation.toString() ),
      EnumSet.allOf( SignatureVariant.class )
  ),

  /**
   * ELB / LoadBalancing
   */
  LoadBalancing(
      ImmutableSet.of( "2012-06-01" ),
      PolicySpec.LOADBALANCING_ACTIONS,
      ImmutableSet.of( OperationParameter.Action.toString( ) ),
      EnumSet.allOf( SignatureVariant.class )
  ),

  /**
   * STS / Tokens
   */
  Tokens(
      ImmutableSet.of( "2011-06-15" ),
      PolicySpec.STS_ACTIONS,
      ImmutableSet.of( OperationParameter.Action.toString( ) ),
      EnumSet.allOf( SignatureVariant.class )
  );

  public Set<String> getActions( ) {
    return actions;
  }

  public Set<String> getVersions( ) {
    return versions;
  }

  private final Set<String> versions;
  private final Set<String> actions;
  private final Set<String> actionParameters;
  private final Set<SignatureVariant> variants;

  private ServiceResolver( final Set<String> versions,
                           final Set<String> actions,
                           final Set<String> actionParameters,
                           final Set<SignatureVariant> variants ) {
    this.versions = versions;
    this.actions = actions;
    this.actionParameters = actionParameters;
    this.variants = variants;
  }

  boolean accepts( final HttpRequest message ) {
    if ( message instanceof MappingHttpRequest &&
        ( message.getUri().isEmpty() || message.getUri().equals( "/" ) ) ) {
      final MappingHttpRequest httpRequest = ( MappingHttpRequest ) message;
      if ( httpRequest.getMethod( ).equals( HttpMethod.POST ) ) {
        final Map<String,String> parameters = new HashMap<>( httpRequest.getParameters( ) );
        final Set<String> nonQueryParameters = Sets.newHashSet();
        final ChannelBuffer buffer = httpRequest.getContent( );
        buffer.markReaderIndex( );
        final byte[] read = new byte[buffer.readableBytes( )];
        buffer.readBytes( read );
        final String query = new String( read );
        buffer.resetReaderIndex( );
        for ( String p : query.split( "&" ) ) {
          String[] splitParam = p.split( "=" );
          String lhs = splitParam[0];
          String rhs = splitParam.length == 2 ? splitParam[1] : null;
          try {
            if( lhs != null ) lhs = new URLCodec().decode(lhs);
          } catch ( DecoderException e ) {}
          try {
            if( rhs != null ) rhs = new URLCodec().decode(rhs);
          } catch ( DecoderException e ) {}
          parameters.put( lhs, rhs );
          nonQueryParameters.add( lhs );
        }

        httpRequest.getParameters( ).putAll( parameters );
        httpRequest.addNonQueryParameterKeys( nonQueryParameters );
      }

      final String version = httpRequest.getParameters().get( RequiredQueryParams.Version.toString() );
      String action = null;
      for ( final String actionParameter : actionParameters ) {
        action = httpRequest.getParameters().get( actionParameter );
        if ( action != null ) break;
      }

      try {
        final SignatureVariant variant = HmacUtils.detectSignatureVariant(
          headerLookup( httpRequest ),
          parameterLookup( httpRequest ) );

        return version != null && action != null &&
            versions.contains( version ) &&
            actions.contains( action.toLowerCase() ) &&
            variants.contains( variant );
      } catch ( AuthenticationException e ) {
        // No signature in request
      }
    }

    return false;
  }

  static Function<String,List<String>> headerLookup( final MappingHttpRequest request ) {
    return new Function<String,List<String>>(){
      @Override
      public List<String> apply( final String header ) {
        return request.getHeaders( header );
      }
    };
  }

  static Function<String,List<String>> parameterLookup( final MappingHttpRequest request ) {
    final Map<String,String> parameters = request.getParameters();
    return new Function<String,List<String>>(){
      @Override
      public List<String> apply( final String header ) {
        return CollectionUtils.<String>listUnit().apply( parameters.get( header ) );
      }
    };
  }
}
