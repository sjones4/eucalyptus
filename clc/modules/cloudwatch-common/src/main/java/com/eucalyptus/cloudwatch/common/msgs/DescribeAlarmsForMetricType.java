/*************************************************************************
 * Copyright 2009-2014 Ent. Services Development Corporation LP
 *
 * Redistribution and use of this software in source and binary forms,
 * with or without modification, are permitted provided that the
 * following conditions are met:
 *
 *   Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 *
 *   Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer
 *   in the documentation and/or other materials provided with the
 *   distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
 * FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
 * COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN
 * ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 ************************************************************************/
package com.eucalyptus.cloudwatch.common.msgs;

public class DescribeAlarmsForMetricType extends CloudWatchMessage {

  private String metricName;
  private String namespace;
  private String statistic;
  private Dimensions dimensions;
  private Integer period;
  private String unit;

  public String getMetricName( ) {
    return metricName;
  }

  public void setMetricName( String metricName ) {
    this.metricName = metricName;
  }

  public String getNamespace( ) {
    return namespace;
  }

  public void setNamespace( String namespace ) {
    this.namespace = namespace;
  }

  public String getStatistic( ) {
    return statistic;
  }

  public void setStatistic( String statistic ) {
    this.statistic = statistic;
  }

  public Dimensions getDimensions( ) {
    return dimensions;
  }

  public void setDimensions( Dimensions dimensions ) {
    this.dimensions = dimensions;
  }

  public Integer getPeriod( ) {
    return period;
  }

  public void setPeriod( Integer period ) {
    this.period = period;
  }

  public String getUnit( ) {
    return unit;
  }

  public void setUnit( String unit ) {
    this.unit = unit;
  }
}
