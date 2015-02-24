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


import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.apache.log4j.Logger;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.DownstreamMessageEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.handler.codec.http.HttpResponseStatus;
import org.jboss.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.jboss.netty.handler.codec.http.websocketx.WebSocket13FrameDecoder;
import org.jboss.netty.handler.codec.http.websocketx.WebSocket13FrameEncoder;
import com.eucalyptus.container.agent.AgentRendezvous;
import com.eucalyptus.crypto.Digest;
import com.eucalyptus.crypto.util.B64;
import com.eucalyptus.http.MappingHttpRequest;
import com.eucalyptus.http.MappingHttpResponse;
import com.eucalyptus.ws.handlers.MessageStackHandler;
import com.google.common.collect.ImmutableSet;

/**
 *
 */
public class ContainerWebSocketHandler extends MessageStackHandler {

  private static final Logger logger = Logger.getLogger( ContainerWebSocketHandler.class );

  private static final Set<String> requiredHandlers = ImmutableSet.of( "ssl", "idlehandler", "idlecloser" );

  @Override
  public void incomingMessage( final ChannelHandlerContext ctx, final MessageEvent event ) throws Exception {
    if ( event.getMessage( ) instanceof MappingHttpRequest ) {
      final MappingHttpRequest request = ( MappingHttpRequest ) event.getMessage( );

      if ( !request.getHeaders( "Upgrade" ).isEmpty( ) ) {
        String key = request.getHeader("Sec-WebSocket-Key");
        final String acceptSeed = key + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
        final String accept = B64.standard.encString( Digest.SHA1.digestBinary( acceptSeed.getBytes( StandardCharsets.UTF_8 ) ) );
        final MappingHttpResponse response = new MappingHttpResponse( request.getProtocolVersion( ), HttpResponseStatus.SWITCHING_PROTOCOLS );
        response.addHeader( "Upgrade", "websocket" );
        response.addHeader( "Connection", "Upgrade" );
        response.addHeader("Sec-WebSocket-Accept", accept);

        final Map<String,String> parameters = request.getParameters( );
        final String clusterArn = parameters.get( "clusterArn" );
        final String containerInstanceArn = parameters.get( "containerInstanceArn" );
        final String agentHash = parameters.get( "agentHash" );
        final String agentVersion = parameters.get( "agentVersion" );

        logger.info( "Agent websocket connection for "+clusterArn+" " + containerInstanceArn + " " + agentHash + " " + agentVersion );

        final DownstreamMessageEvent downstreamEvent = new DownstreamMessageEvent( ctx.getChannel( ), Channels.future( ctx.getChannel() ), response, null );
        downstreamEvent.getFuture( ).addListener( new ChannelFutureListener() {
          @Override
          public void operationComplete( final ChannelFuture channelFuture ) throws Exception {
            final ChannelPipeline pipeline = ctx.getPipeline( );
            for ( final String name : pipeline.getNames( ) ) {
              if ( !requiredHandlers.contains( name ) ) pipeline.remove( name );
            }
            pipeline.addLast( "ecs-websocket-decoder", new WebSocket13FrameDecoder( false, false, 1024 * 32 ) );
            pipeline.addLast( "ecs-websocket-encoder", new WebSocket13FrameEncoder( false ) );
            pipeline.addLast( "ecs-websocket-json", new ContainerWebSocketJsonHandler( ) );

            AgentRendezvous.register( containerInstanceArn, ctx.getChannel( ) );
          }
        } );
        ctx.sendDownstream( downstreamEvent );
      }
    }
  }
}
