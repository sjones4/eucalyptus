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
package com.eucalyptus.walrus.msgs;

import java.util.ArrayList;
import java.util.Date;
import com.eucalyptus.auth.principal.Principals;
import com.eucalyptus.auth.principal.User;
import com.eucalyptus.storage.msgs.s3.MetaDataEntry;

public class WalrusDataResponseType extends WalrusStreamingResponseType {

  private String etag;
  private Date lastModified;
  private Long size;
  private ArrayList<MetaDataEntry> metaData = new ArrayList<MetaDataEntry>( );
  private Integer errorCode;
  private String contentType;
  private String contentDisposition;
  private String versionId;

  public User getUser( ) {
    return Principals.nobodyUser( );
  }

  public String getEtag( ) {
    return etag;
  }

  public void setEtag( String etag ) {
    this.etag = etag;
  }

  public Date getLastModified( ) {
    return lastModified;
  }

  public void setLastModified( Date lastModified ) {
    this.lastModified = lastModified;
  }

  public Long getSize( ) {
    return size;
  }

  public void setSize( Long size ) {
    this.size = size;
  }

  public ArrayList<MetaDataEntry> getMetaData( ) {
    return metaData;
  }

  public void setMetaData( ArrayList<MetaDataEntry> metaData ) {
    this.metaData = metaData;
  }

  public Integer getErrorCode( ) {
    return errorCode;
  }

  public void setErrorCode( Integer errorCode ) {
    this.errorCode = errorCode;
  }

  public String getContentType( ) {
    return contentType;
  }

  public void setContentType( String contentType ) {
    this.contentType = contentType;
  }

  public String getContentDisposition( ) {
    return contentDisposition;
  }

  public void setContentDisposition( String contentDisposition ) {
    this.contentDisposition = contentDisposition;
  }

  public String getVersionId( ) {
    return versionId;
  }

  public void setVersionId( String versionId ) {
    this.versionId = versionId;
  }
}
