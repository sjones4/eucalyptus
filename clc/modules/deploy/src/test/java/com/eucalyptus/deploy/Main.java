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

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import org.apache.log4j.Level;
import com.eucalyptus.bootstrap.DatabaseBootstrapper;
import com.eucalyptus.bootstrap.SystemBootstrapper;
import com.eucalyptus.scripting.Groovyness;
import com.eucalyptus.system.SubDirectory;
import com.eucalyptus.util.DNSProperties;
import com.google.common.collect.ImmutableMap;
import com.google.common.io.Files;

/**
 * Entry point for test eucalyptus cloud.
 *
 * Run with the working directory set to eucalyptus home.
 */
public class Main {

  /**
   * Entry point.
   */
  public static void main( final String[] args ) throws Throwable {
    org.apache.log4j.LogManager.getRootLogger().setLevel( Level.INFO);

    //TODO:STEVE: check if postgres available?
    //TODO:STEVE: set up fault registry?
    //TODO:STEVE: java.lang.ClassNotFoundException: com.eucalyptus.database.activities.VmDatabaseSSLSocketFactory
    //TODO:STEVE: java.util.concurrent.ExecutionException: java.net.ConnectException: Connection refused: /127.0.0.1:8775

    final URL resourcePath = Main.class.getResource(".");
    File clcDir = new File( resourcePath.getPath( ) );
    File classes = null;
    while ( clcDir != null && !"clc".equals( clcDir.getName( ) )  ) {
      if ( "com".equals( clcDir.getName( ) ) ) {
        classes = clcDir.getParentFile( );
      }
      clcDir = clcDir.getParentFile( );
    }
    if ( classes==null || clcDir==null || clcDir.getParentFile()==null || !"eucalyptus".equals(clcDir.getParentFile( ).getName() ) ) {
      throw new IllegalStateException( "Unable to detect eucalyptus/clc directory" );
    }

    final File home = new File(".");
    System.setProperty("euca.home", home.getAbsolutePath());
    System.setProperty("euca.var.dir", path(home, "var"));
    System.setProperty("euca.conf.dir", path(home, "conf"));
    System.setProperty("euca.lib.dir", path(home, "var"));
    System.setProperty("euca.log.dir", path(home, "log"));
    System.setProperty("euca.run.dir", path(home, "run"));
    System.setProperty("euca.libexec.dir", path(home, "libexec"));
    System.setProperty("euca.state.dir", path(home, "var"));
    System.setProperty("euca.jni.dir", path(home, "jni"));

    System.setProperty("euca.classcache.dir", classes.getPath( ) );

    System.setProperty("euca.version", "5.0.0");
    System.setProperty("euca.log.appender", "console");
    System.setProperty("euca.db.user", System.getProperty( "user.name", DatabaseBootstrapper.DB_USERNAME ));
    System.setProperty("euca.user", System.getProperty( "user.name", DatabaseBootstrapper.DB_USERNAME ));
    System.setProperty("euca.log.level", "INFO");

    System.setProperty("com.eucalyptus.cluster.service.enable", "true");
    System.setProperty("com.eucalyptus.deploy.register", "clusterservice,user-api,walrusbackend");

    DNSProperties.PORT = 5553;
    final Map<String,String> scriptMap = ImmutableMap.<String,String>builder( ) //TODO:STEVE: simpler to just copy these?
        .put( "initialize_cloud.groovy", new File( clcDir, "modules/msgs/conf/scripts/initialize_cloud.groovy" ).getPath( ) )
        .put( "notifications", new File( clcDir, "modules/msgs/conf/scripts/notifications.groovy" ).getPath( ) )
        .put( "notifications_digest", new File( clcDir, "modules/msgs/conf/scripts/notifications_digest.groovy" ).getPath( ) )
        .put( "setup_db", new File( clcDir, "modules/postgresql/conf/scripts/setup_db.groovy" ).getPath( ) )
        .put( "setup_dbpool.groovy", new File( clcDir, "modules/msgs/conf/scripts/setup_dbpool.groovy" ).getPath( ) )
        .put( "setup_dbpool_remote.groovy", new File( clcDir, "modules/msgs/conf/scripts/setup_dbpool_remote.groovy" ).getPath( ) )
        .put( "setup_membership.groovy", new File( clcDir, "modules/msgs/conf/scripts/setup_membership.groovy" ).getPath( ) )
        .put( "setup_persistence.groovy", new File( clcDir, "modules/msgs/conf/scripts/setup_persistence.groovy" ).getPath( ) )
        .put( "setup_persistence_remote.groovy", new File( clcDir, "modules/msgs/conf/scripts/setup_persistence_remote.groovy" ).getPath( ) )
        .build( );
    Groovyness.registerFileMapper( scriptMap::get );

    File eucaConf = new File( "conf/eucalyptus.conf" );
    Files.write(
        "SCHEDPOLICY=\"ROUNDROBIN\"\n" +
        "NODES=\"127.0.0.1\"\n" +
        "\n",
        eucaConf,
        StandardCharsets.UTF_8 );

    final SystemBootstrapper boot = SystemBootstrapper.getInstance();
    if ( !SubDirectory.DB.getChildFile( "data", "postgresql.conf" ).exists( ) ) {
      System.setProperty("euca.initialize", "true");
      boot.init( );
      boot.load( );
    }
    System.clearProperty("euca.initialize");
    boot.init( );
    boot.load( );
    boot.start( );
  }

  private static String path( final File file, final String path ) {
    return new File( file, path ).getAbsolutePath();
  }
}
