/*
 * Copyright 2018 AppScale Systems, Inc
 *
 * Use of this source code is governed by a BSD-2-Clause
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/BSD-2-Clause
 */
package com.eucalyptus.rds.common.msgs;

import javax.annotation.Nonnull;
import com.eucalyptus.binding.HttpContent;
import com.eucalyptus.binding.HttpNoContent;
import com.eucalyptus.binding.HttpHeaderMapping;
import com.eucalyptus.binding.HttpParameterMapping;
import com.eucalyptus.binding.HttpRequestMapping;
import com.eucalyptus.binding.HttpUriMapping;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRange;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRegex;
import com.eucalyptus.rds.common.RdsMessageValidation.FieldRegexValue;



public class DescribeDBEngineVersionsType extends RdsMessage {

  private String dBParameterGroupFamily;
  private Boolean defaultOnly;
  private String engine;
  private String engineVersion;
  private FilterList filters;
  private Boolean listSupportedCharacterSets;
  private Boolean listSupportedTimezones;
  private String marker;
  private Integer maxRecords;

  public String getDBParameterGroupFamily( ) {
    return dBParameterGroupFamily;
  }

  public void setDBParameterGroupFamily( final String dBParameterGroupFamily ) {
    this.dBParameterGroupFamily = dBParameterGroupFamily;
  }

  public Boolean getDefaultOnly( ) {
    return defaultOnly;
  }

  public void setDefaultOnly( final Boolean defaultOnly ) {
    this.defaultOnly = defaultOnly;
  }

  public String getEngine( ) {
    return engine;
  }

  public void setEngine( final String engine ) {
    this.engine = engine;
  }

  public String getEngineVersion( ) {
    return engineVersion;
  }

  public void setEngineVersion( final String engineVersion ) {
    this.engineVersion = engineVersion;
  }

  public FilterList getFilters( ) {
    return filters;
  }

  public void setFilters( final FilterList filters ) {
    this.filters = filters;
  }

  public Boolean getListSupportedCharacterSets( ) {
    return listSupportedCharacterSets;
  }

  public void setListSupportedCharacterSets( final Boolean listSupportedCharacterSets ) {
    this.listSupportedCharacterSets = listSupportedCharacterSets;
  }

  public Boolean getListSupportedTimezones( ) {
    return listSupportedTimezones;
  }

  public void setListSupportedTimezones( final Boolean listSupportedTimezones ) {
    this.listSupportedTimezones = listSupportedTimezones;
  }

  public String getMarker( ) {
    return marker;
  }

  public void setMarker( final String marker ) {
    this.marker = marker;
  }

  public Integer getMaxRecords( ) {
    return maxRecords;
  }

  public void setMaxRecords( final Integer maxRecords ) {
    this.maxRecords = maxRecords;
  }

}
