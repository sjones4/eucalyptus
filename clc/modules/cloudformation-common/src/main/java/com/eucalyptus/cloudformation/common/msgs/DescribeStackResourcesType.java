/*************************************************************************
 * (c) Copyright 2017 Hewlett Packard Enterprise Development Company LP
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
 ************************************************************************/
package com.eucalyptus.cloudformation.common.msgs;

public class DescribeStackResourcesType extends CloudFormationMessage {

  private String logicalResourceId;
  private String physicalResourceId;
  private String stackName;

  public String getLogicalResourceId( ) {
    return logicalResourceId;
  }

  public void setLogicalResourceId( String logicalResourceId ) {
    this.logicalResourceId = logicalResourceId;
  }

  public String getPhysicalResourceId( ) {
    return physicalResourceId;
  }

  public void setPhysicalResourceId( String physicalResourceId ) {
    this.physicalResourceId = physicalResourceId;
  }

  public String getStackName( ) {
    return stackName;
  }

  public void setStackName( String stackName ) {
    this.stackName = stackName;
  }
}
