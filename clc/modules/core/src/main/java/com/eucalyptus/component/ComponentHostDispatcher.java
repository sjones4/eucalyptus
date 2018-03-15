package com.eucalyptus.component;

import org.springframework.integration.handler.advice.AbstractRequestHandlerAdvice;
import org.springframework.messaging.Message;
import org.xbill.DNS.Name;
import org.xbill.DNS.TextParseException;
import com.eucalyptus.bootstrap.Host;
import com.eucalyptus.bootstrap.Hosts;
import com.eucalyptus.component.annotation.ComponentMessage;
import com.eucalyptus.component.annotation.ComponentNamed;
import com.eucalyptus.context.Context;
import com.eucalyptus.context.Contexts;
import com.eucalyptus.context.NoSuchContextException;
import com.eucalyptus.context.ServiceStateException;
import com.eucalyptus.http.MappingHttpRequest;
import com.eucalyptus.system.Ats;
import com.eucalyptus.util.Exceptions;
import com.eucalyptus.util.async.AsyncExceptions;
import com.eucalyptus.util.async.AsyncExceptions.AsyncWebServiceError;
import com.eucalyptus.util.async.AsyncRequests;
import com.eucalyptus.util.async.FailedRequestException;
import com.eucalyptus.util.dns.DomainNames;
import com.eucalyptus.ws.EucalytpusWebServiceStatusException;
import com.google.common.base.Optional;
import com.google.common.net.HostAndPort;
import com.google.common.net.HttpHeaders;
import com.google.common.net.InetAddresses;
import edu.ucsb.eucalyptus.msgs.BaseMessage;
import edu.ucsb.eucalyptus.msgs.BaseMessages;

/**
 *
 */
@ComponentNamed
public class ComponentHostDispatcher extends AbstractRequestHandlerAdvice {

  @Override
  protected Object doInvoke(
      final ExecutionCallback callback,
      final Object target,
      final Message<?> message
  ) throws Exception {
    final Object payload = message.getPayload( );
    if ( payload instanceof BaseMessage ) try {
      final BaseMessage baseMessage = (BaseMessage) payload; //TODO:STEVE: check if message is host dispatchable
      final ComponentMessage componentMessage =
          Ats.inClassHierarchy( baseMessage.getClass( ) ).get( ComponentMessage.class );
      final ComponentId componentId = ComponentIds.lookup( componentMessage.value( ) );
      final Context context = Contexts.lookup( ( (BaseMessage) payload ).getCorrelationId( ) );
      final MappingHttpRequest request = context.getHttpRequest( );
      final String hostHeader = request.getHeader( HttpHeaders.HOST );
      if ( hostHeader != null && componentId.isAlwaysLocal( ) ) {
        final String host = HostAndPort.fromString( hostHeader ).getHostText( );
        final Host coordinator = Hosts.getCoordinator( );
        if ( !InetAddresses.isInetAddress( host ) &&
            (coordinator == null || !coordinator.isLocalHost( )) &&
            DomainNames.isExternalSubdomain( Name.fromString( host, Name.root ) ) ) {
          if ( coordinator == null ) {
            throw Exceptions.toUndeclared( new ServiceStateException( "Service not available" ) );
          }
          try {
            final BaseMessage backendRequest = BaseMessages.deepCopy( baseMessage, baseMessage.getClass( ) );
            final BaseMessage backendResponse = send(
                ServiceConfigurations.createEphemeral( componentId, coordinator.getBindAddress( ) ),
                backendRequest );
            final BaseMessage response = BaseMessages.deepCopy(
                backendResponse,
                (Class<? extends  BaseMessage>)baseMessage.getReply( ).getClass( ) );
            response.setCorrelationId( request.getCorrelationId( ) );
            return response;
          } catch ( final Throwable e ) {
            throw Exceptions.toUndeclared( e );
          }
        }
      }
    } catch ( NoSuchContextException | IllegalArgumentException | TextParseException ignore ) {
    }
    return callback.execute( );
  }

  private static <T extends BaseMessage> T send(
      final ServiceConfiguration configuration,
      final BaseMessage request
  ) throws Throwable {
    try {
      return AsyncRequests.sendSyncWithCurrentIdentity( configuration, request );
    } catch ( final Exception e ) {
      final FailedRequestException failedRequestException = Exceptions.findCause( e, FailedRequestException.class );
      if ( failedRequestException != null ) {
        if ( request.getReply( ).getClass( ).isInstance( failedRequestException.getRequest( ) ) ) {
          return failedRequestException.getRequest( ); // if it is a (failure) response then return it
        }
        throw e.getCause( ) == null ? e : e.getCause( );
      } else {
        final Optional<AsyncWebServiceError> errorOptional = AsyncExceptions.asWebServiceError( e );
        if ( errorOptional.isPresent( ) ) {
          final AsyncExceptions.AsyncWebServiceError serviceError = errorOptional.get( );
          throw new EucalytpusWebServiceStatusException(
              serviceError.getCode( ),
              serviceError.getHttpErrorCode( ),
              serviceError.getMessage( )
          );
        }
        throw e;
      }
    }
  }
}
