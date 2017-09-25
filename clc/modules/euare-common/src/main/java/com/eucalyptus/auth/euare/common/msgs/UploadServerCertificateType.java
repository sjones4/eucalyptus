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
package com.eucalyptus.auth.euare.common.msgs;

import com.eucalyptus.auth.euare.common.policy.IamPolicySpec;
import com.eucalyptus.auth.policy.PolicySpec;
import com.eucalyptus.auth.policy.annotation.PolicyAction;

@PolicyAction( vendor = PolicySpec.VENDOR_IAM, action = IamPolicySpec.IAM_UPLOADSERVERCERTIFICATE )
public class UploadServerCertificateType extends EuareMessage implements EuareMessageWithDelegate {

  private String delegateAccount;
  private String path;
  private String serverCertificateName;
  private String certificateBody;
  private String privateKey;
  private String certificateChain;

  public String getDelegateAccount( ) {
    return delegateAccount;
  }

  public void setDelegateAccount( String delegateAccount ) {
    this.delegateAccount = delegateAccount;
  }

  public String getPath( ) {
    return path;
  }

  public void setPath( String path ) {
    this.path = path;
  }

  public String getServerCertificateName( ) {
    return serverCertificateName;
  }

  public void setServerCertificateName( String serverCertificateName ) {
    this.serverCertificateName = serverCertificateName;
  }

  public String getCertificateBody( ) {
    return certificateBody;
  }

  public void setCertificateBody( String certificateBody ) {
    this.certificateBody = certificateBody;
  }

  public String getPrivateKey( ) {
    return privateKey;
  }

  public void setPrivateKey( String privateKey ) {
    this.privateKey = privateKey;
  }

  public String getCertificateChain( ) {
    return certificateChain;
  }

  public void setCertificateChain( String certificateChain ) {
    this.certificateChain = certificateChain;
  }
}
