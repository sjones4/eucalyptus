/*************************************************************************
 * Copyright 2009-2015 Eucalyptus Systems, Inc.
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
package com.eucalyptus.container.ws;

import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.handler.codec.http.HttpHeaders;
import org.jboss.netty.handler.codec.http.HttpRequest;
import com.eucalyptus.auth.principal.TemporaryAccessKey;
import com.eucalyptus.component.annotation.ComponentPart;
import com.eucalyptus.container.common.Container;
import com.eucalyptus.container.config.ContainerConfiguration;
import com.eucalyptus.http.MappingHttpRequest;
import com.eucalyptus.util.Strings;
import com.eucalyptus.ws.handlers.MessageStackHandler;
import com.eucalyptus.ws.server.FilteredPipeline;
import com.eucalyptus.ws.stages.HmacUserAuthenticationStage;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;

/**
 *
 */
@ComponentPart( Container.class )
public class ContainerWebSocketPipeline extends FilteredPipeline {
  private final HmacUserAuthenticationStage auth =
      new HmacUserAuthenticationStage( EnumSet.allOf( TemporaryAccessKey.TemporaryKeyType.class ) );
  private final Set<String> servicePathPrefixes = ImmutableSet.of( "/ws", ContainerConfiguration.SERVICE_PATH + "/ws" );

  @Override
  public String getName() {
    return "ecs-websocket-pipeline";
  }

  @Override
  public ChannelPipeline addHandlers( final ChannelPipeline pipeline ) {
    pipeline.addLast( "container-hmac-host-cleaner", new ContainerHostHeaderDedupeHandler( ) );
    auth.unrollStage( pipeline );
    pipeline.addLast( "ecs-websocket-handler", new ContainerWebSocketHandler( ) );
    return null;
  }

  @Override
  public boolean checkAccepts( final HttpRequest message ) {
    if ( message instanceof MappingHttpRequest ) {
      final boolean hasWebSocketHeader = "websocket".equals( message.getHeader( "Upgrade" ) );
      final boolean usesServicePath = Iterables.any( servicePathPrefixes, Strings.isPrefixOf( message.getUri() ) );
      final boolean noPath = message.getUri( ).isEmpty( ) || message.getUri( ).equals( "/" ) || message.getUri( ).startsWith( "/?" );
      return
          hasWebSocketHeader &&
              ( usesServicePath ||
                  ( noPath && resolvesByHost( message.getHeader( HttpHeaders.Names.HOST ) ) ) );
    }
    return false;
  }

  //TODO:STEVE: update signature implementation so duplicate host headers are ignored?
  protected static class ContainerHostHeaderDedupeHandler extends MessageStackHandler {
    @Override
    public void incomingMessage( final MessageEvent event ) throws Exception {
      if ( event.getMessage( ) instanceof MappingHttpRequest ) {
        final MappingHttpRequest httpRequest = (MappingHttpRequest) event.getMessage();
        final List<String> headerValues = httpRequest.getHeaders( HttpHeaders.Names.HOST );
        if ( headerValues.size( ) > 1 ) {
          final String hostValue = headerValues.get( 0 );
          httpRequest.removeHeader( HttpHeaders.Names.HOST );
          httpRequest.addHeader( HttpHeaders.Names.HOST, hostValue );
        }
      }
    }
  }
}
