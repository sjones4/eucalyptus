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
package com.eucalyptus.ecs.common.model;

import static com.eucalyptus.util.MessageValidation.validateRecursively;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import com.eucalyptus.component.annotation.ComponentMessage;
import com.eucalyptus.ecs.common.Ecs;
import com.eucalyptus.system.Ats;
import com.eucalyptus.util.MessageValidation;
import com.eucalyptus.util.Pair;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import edu.ucsb.eucalyptus.msgs.BaseMessage;

/**
 *
 */
@ComponentMessage( Ecs.class )
public class EcsMessage extends BaseMessage {
  public <TYPE extends EcsMessage> TYPE reply( final TYPE response ) {
    return super.reply( response );
  }

  public Map<String, String> validate() {
    return validateRecursively(
        Maps.<String, String>newTreeMap(),
        new EcsMessageValidationAssistant(),
        "",
        this );
  }

  private static class EcsMessageValidationAssistant implements MessageValidation.ValidationAssistant {
    private final Set<Class<?>> simpleTypes = ImmutableSet.<Class<?>>of(
        Boolean.class,
        Date.class,
        Integer.class,
        Long.class,
        String.class
    );

    @Override
    public boolean validate( final Object object ) {
      return object != null &&
          !simpleTypes.contains( object.getClass() ) &&
          !Iterable.class.isAssignableFrom( object.getClass() );
    }

    @Override
    public Pair<Long, Long> range( final Ats ats ) {
      final FieldRange range = ats.get( FieldRange.class );
      return range == null ?
          null :
          Pair.pair( range.min(), range.max() );
    }

    @Override
    public Pattern regex( final Ats ats ) {
      final FieldRegex regex = ats.get( FieldRegex.class );
      return regex == null ?
          null :
          regex.value().pattern();
    }
  }

  @Target( ElementType.FIELD )
  @Retention( RetentionPolicy.RUNTIME )
  public @interface FieldRegex {
    FieldRegexValue value();
  }

  @Target( ElementType.FIELD )
  @Retention( RetentionPolicy.RUNTIME )
  public @interface FieldRange {
    long min() default 0;

    long max() default Long.MAX_VALUE;
  }

  public enum FieldRegexValue {
    // General
    STRING_128( "(?s).{1,128}" ),
    STRING_256( "(?s).{1,256}" ),
    STRING_1024( "(?s).{1,1024}" ),

    OPT_STRING_128( "(?s).{0,128}" ),
    OPT_STRING_256( "(?s).{0,256}" ),
    OPT_STRING_1024( "(?s).{0,1024}" ),

    TASK_DEFINITION_NAME( "(?s).{1,256}:[0-9]+" ),

    ;

    private final Pattern pattern;

    private FieldRegexValue( final String regex ) {
      this.pattern = Pattern.compile( regex );
    }

    public Pattern pattern() {
      return pattern;
    }
  }
}