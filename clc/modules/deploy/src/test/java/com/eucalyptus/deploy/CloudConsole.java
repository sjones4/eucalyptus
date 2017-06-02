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
package com.eucalyptus.deploy;

import static com.eucalyptus.auth.euare.persist.entities.ServerCertificateEntity_.privateKey;
import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.InetAddress;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.sql.DriverManager;
import java.util.List;
import org.postgresql.Driver;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.S3ClientOptions;
import com.eucalyptus.crypto.Digest;
import com.eucalyptus.crypto.Signatures;
import groovy.sql.GroovyRowResult;
import groovy.sql.Sql;

/**
 * Console for interaction with local cloud
 *
 * TODO:STEVE: switch to groovy and output creds as a eucatools ini file?
 */
public class CloudConsole {

  public static void main( final String[] args ) throws Throwable {
    final BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
    out: while ( true ) {
      System.out.print( "Enter command: " );
      final String command = reader.readLine( );
      switch ( command ) {
        case "show credentials":
          showCredentials();
          break;
        case "show s3-buckets":
          showS3Buckets();
          break;
        case "exit":
        case "quit":
          break out;
      }
    }
  }

  private static void showS3Buckets( ) {
    try {
      getS3Client( ).listBuckets( ).forEach( System.out::println );
    } catch ( Exception e ) {
      e.printStackTrace( );
    }
  }

  private static void showCredentials( ) {
    try {
      final BasicAWSCredentials credentials = getCredentials( );
      System.out.println( credentials.getAWSAccessKeyId( ) );
      System.out.println( credentials.getAWSSecretKey( ) );
    } catch ( Exception e ) {
      e.printStackTrace( );
    }
  }

  private static AmazonS3 getS3Client( ) throws Exception {
    final ClientConfiguration config = new ClientConfiguration();
    config.setSignerOverride( "S3SignerType" );
    final S3ClientOptions clientOptions = S3ClientOptions.builder( ).setPathStyleAccess( true ).build( );
    final BasicAWSCredentials credentials = getCredentials( );
    final AmazonS3Client s3 = new AmazonS3Client( credentials );
    s3.setS3ClientOptions( clientOptions );
    s3.setEndpoint( "http://127.0.0.1:8773/services/objectstorage" );
    return s3;
  }

  private static BasicAWSCredentials getCredentials( ) throws Exception {
    Sql sql = getConnection( "eucalyptus_auth" );
    List<GroovyRowResult> rows = sql.rows( "SELECT k.auth_access_key_query_id, k.auth_access_key_key FROM eucalyptus_auth.auth_access_key k JOIN eucalyptus_auth.auth_user u ON k.auth_access_key_owning_user=u.id JOIN eucalyptus_auth.auth_group_has_users gu ON u.id=gu.auth_user_id JOIN eucalyptus_auth.auth_group g ON gu.auth_group_id=g.id JOIN eucalyptus_auth.auth_account a ON g.auth_group_owning_account=a.id WHERE a.auth_account_name='eucalyptus' AND g.auth_group_name='_admin' AND k.auth_access_key_active=TRUE" );
    if ( rows.isEmpty( ) ) {
      throw new IllegalStateException( "Credentials not found" );
    }
    return new BasicAWSCredentials(
        String.valueOf( rows.get( 0 ).getAt( 0 ) ),
        String.valueOf( rows.get( 0 ).getAt( 1 ) )
    );
  }

  private static Sql getConnection( String schema ) throws Exception {
    if ( !Driver.isRegistered( ) ) {
      Driver.register( );
    }
    String url = "jdbc:postgresql://127.0.0.1:8777/eucalyptus_shared?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
    Sql sql = Sql.newInstance( url, "eucalyptus", getDatabasePassword( ), "org.postgresql.Driver" );
    if ( schema != null ) {
      sql.execute( "SET search_path TO " + schema );
    }
    return sql;
  }

  private static String getDatabasePassword( ) throws Exception {
    final File keyStoreFile = new File( "var/keys/euca.p12" );
    if ( !keyStoreFile.isFile( ) ) {
      throw new IllegalStateException( "Keystore not found " + keyStoreFile.getAbsolutePath( ) );
    }
    final KeyStore keyStore = KeyStore.getInstance( "PKCS12" );
    final char[] password = "eucalyptus".toCharArray( );
    keyStore.load( new FileInputStream( keyStoreFile ), password );
    final PrivateKey privateKey = (PrivateKey) keyStore.getKey( "eucalyptus", password );
    return Digest.SHA256.digestHex( Signatures.SHA256withRSA.signBinary( privateKey, "eucalyptus".getBytes() ) );
  }
}
