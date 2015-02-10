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
package com.eucalyptus.container;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.Locale;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.deser.DateDeserializer;
import org.codehaus.jackson.map.module.SimpleModule;
import com.eucalyptus.container.common.model.EcsMessage;
import com.eucalyptus.util.Exceptions;
import com.google.common.base.Charsets;
import com.google.common.base.Strings;

/**
 *
 */
public class EcsJsonUtils {

  private static final ObjectMapper mapper = new ObjectMapper( );
  static {
    final SimpleModule module = new SimpleModule( "SwfModule", new Version(1, 0, 0, null) )
        .addSerializer( Date.class, new EpochSecondsDateSerializer( )  )
        .addDeserializer( Date.class, new EpochSecondsDateDeserializer( ) );
    mapper.registerModule( module );
    mapper.setDateFormat( new EpochSecondsDateFormat() );
    mapper.getSerializationConfig().addMixInAnnotations( EcsMessage.class, BindingMixIn.class );
    mapper.getSerializationConfig().addMixInAnnotations( com.eucalyptus.container.common.model.ContainerDefinition.class, BindingMixIn.class );
    mapper.getSerializationConfig().set( SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false );
    mapper.getSerializationConfig().setSerializationInclusion( JsonSerialize.Inclusion.NON_NULL );
  }

  public static String writeObjectAsString( final Object object ) {
    final ByteArrayOutputStream out = new ByteArrayOutputStream( 512 );
    try {
      mapper.writeValue( out, object );
    } catch ( IOException ioe ) {
      throw Exceptions.toUndeclared( ioe );
    }
    return new String( out.toByteArray( ), Charsets.UTF_8 );
  }

  public static void writeObject( final OutputStream out, final Object object ) throws IOException {
    mapper.writeValue( out, object );
  }

  public static <T> T readObject( final String in, final Class<T> type ) throws IOException {
    return mapper.readValue( new StringReader( in ){
      @Override public String toString() { return "message"; } // overridden for better source in error message
    }, type );
  }

  // ignore properties of BaseMessage
  @JsonIgnoreProperties( { "correlationId", "effectiveUserId", "reply", "statusMessage", "userId",
      "_disabledServices", "_notreadyServices", "_stoppedServices", "_epoch", "_services", "_return",
      "callerContext" } )
  private interface BindingMixIn {
    @JsonIgnore Boolean isEssential( );
  }

  private static final class EpochSecondsDateDeserializer extends JsonDeserializer<Date> {

    @Override
    public Date deserialize( final JsonParser jsonParser,
                             final DeserializationContext deserializationContext ) throws IOException {
      final JsonToken token = jsonParser.getCurrentToken( );
      switch ( token ) {
        case VALUE_NUMBER_FLOAT:
          return new Date( jsonParser.getDecimalValue( ).movePointRight( 3 ).longValue( ) );
        case VALUE_NUMBER_INT:
          return new Date( jsonParser.getLongValue( ) * 1000L );
        default:
          return new DateDeserializer( ).deserialize( jsonParser, deserializationContext );
      }
    }
  }

  private static final class EpochSecondsDateSerializer extends JsonSerializer<Date> {
    @Override
    public void serialize( final Date date,
                           final JsonGenerator jsonGenerator,
                           final SerializerProvider serializerProvider ) throws IOException {
      jsonGenerator.writeRawValue( String.valueOf( date.getTime( ) / 1000 ) + "." + Strings.padStart( Long.toString( date.getTime() % 1000 ), 3, '0' ) );
    }
  }

  private static final class EpochSecondsDateFormat extends DateFormat implements Cloneable {
    private static final long serialVersionUID = 1L;

    @Override
    public StringBuffer format( final Date date, final StringBuffer toAppendTo, final FieldPosition fieldPosition ) {
      StringBuffer out = toAppendTo == null ? new StringBuffer( ) : toAppendTo;
      if ( date != null ) {
        out.append( date.getTime( ) / 1000 );
        out.append( '.' );
        out.append( Strings.padStart( Long.toString( date.getTime( ) % 1000 ), 3, '0' ) );
      }
      return out;
    }

    @Override
    public Date parse( final String source, final ParsePosition pos ) {
      if ( source != null ) try {
        Number number = DecimalFormat.getInstance( new Locale( "en" ) ).parse( source );
        pos.setIndex( source.length( ) ) ;
        return new Date( (long)(number.doubleValue() * 1000d) );
      } catch ( ParseException e ) {
      }
      return null;
    }

    @SuppressWarnings( "CloneDoesntCallSuperClone" )
    @Override
    public Object clone( ) {
      return this;
    }
  }
}
