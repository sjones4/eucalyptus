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

import org.apache.log4j.Logger;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import com.eucalyptus.container.EcsJsonUtils;
import com.eucalyptus.container.agent.ContainerAgentMessage;
import com.eucalyptus.container.agent.PollRequest;
import com.eucalyptus.ws.handlers.MessageStackHandler;

/**
 *
 */
public class ContainerWebSocketJsonHandler extends MessageStackHandler {

  private static final Logger logger = Logger.getLogger( ContainerWebSocketJsonHandler.class );

  @Override
  public void handleUpstream( final ChannelHandlerContext ctx, final ChannelEvent channelEvent ) throws Exception {
    if ( channelEvent instanceof MessageEvent ) {
      final MessageEvent event = (MessageEvent) channelEvent;
      if ( event.getMessage() instanceof TextWebSocketFrame ) {
        final String text = ( (TextWebSocketFrame) event.getMessage( ) ).getText();
        Channels.fireMessageReceived( ctx.getChannel( ), EcsJsonUtils.readObject( text, PollRequest.class ) );
      } else {
        ctx.sendUpstream( event );
      }
    } else {
      ctx.sendUpstream( channelEvent );
    }
  }

  @Override
  public void handleDownstream( final ChannelHandlerContext ctx, final ChannelEvent channelEvent ) throws Exception {
    if ( channelEvent instanceof MessageEvent ) {
      final MessageEvent event = (MessageEvent) channelEvent;
      if ( event.getMessage() instanceof ContainerAgentMessage ) {
        Channels.write( ctx.getChannel(), new TextWebSocketFrame( EcsJsonUtils.writeObjectAsString( event.getMessage() ) ) );
      } else {
        if ( event.getMessage() instanceof TextWebSocketFrame ) {
        }
        ctx.sendDownstream( event );
      }
    } else {
      ctx.sendDownstream( channelEvent );
    }
  }
}
