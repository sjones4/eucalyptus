/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.cloudfront.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.regex.Pattern;
import com.eucalyptus.system.Ats;
import com.eucalyptus.util.MessageValidation;
import com.eucalyptus.util.Pair;
import edu.ucsb.eucalyptus.msgs.EucalyptusData;

/**
 *
 */
public class CloudfrontMessageValidation {

  public static class CloudfrontMessageValidationAssistant implements MessageValidation.ValidationAssistant {
    @Override
    public boolean validate( final Object object ) {
      return object instanceof EucalyptusData;
    }

    @Override
    public Pair<Long, Long> range( final Ats ats ) {
      final FieldRange range = ats.get( FieldRange.class );
      return range == null ?
          null :
          Pair.pair( range.min( ), range.max( ) );
    }

    @Override
    public Pattern regex( final Ats ats ) {
      final FieldRegex regex = ats.get( FieldRegex.class );
      return regex == null ?
          null :
          regex.value( ).pattern( );
    }
  }

  @Target( ElementType.FIELD)
  @Retention( RetentionPolicy.RUNTIME)
  public @interface FieldRegex {
    FieldRegexValue value();
  }

  @Target(ElementType.FIELD)
  @Retention(RetentionPolicy.RUNTIME)
  public @interface FieldRange {
    long min() default 0;
    long max() default Long.MAX_VALUE;
  }

  public enum FieldRegexValue {
    // Generic
    STRING_128( "(?s).{1,128}" ),
    STRING_256( "(?s).{1,256}" ),

    // Enums
    ENUM_CERTIFICATESOURCE("cloudfront|iam|acm"),
    ENUM_EVENTTYPE("viewer-request|viewer-response|origin-request|origin-response"),
    ENUM_FORMAT("URLEncoded"),
    ENUM_GEORESTRICTIONTYPE("blacklist|whitelist|none"),
    ENUM_HTTPVERSION("http1.1|http2"),
    ENUM_ITEMSELECTION("none|whitelist|all"),
    ENUM_METHOD("GET|HEAD|POST|PUT|PATCH|OPTIONS|DELETE"),
    ENUM_MINIMUMPROTOCOLVERSION("SSLv3|TLSv1|TLSv1_2016|TLSv1.1_2016|TLSv1.2_2018"),
    ENUM_ORIGINPROTOCOLPOLICY("http-only|match-viewer|https-only"),
    ENUM_PRICECLASS("PriceClass_100|PriceClass_200|PriceClass_All"),
    ENUM_SSLSUPPORTMETHOD("sni-only|vip"),
    ENUM_SSLPROTOCOL("SSLv3|TLSv1|TLSv1.1|TLSv1.2"),
    ENUM_VIEWERPROTOCOLPOLICY("allow-all|https-only|redirect-to-https"),
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
