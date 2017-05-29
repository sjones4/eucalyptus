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
import java.util.Map;
import com.eucalyptus.bootstrap.SystemBootstrapper;
import com.eucalyptus.scripting.Groovyness;
import com.eucalyptus.system.SubDirectory;
import com.eucalyptus.util.DNSProperties;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

/**
 * Entry point for test eucalyptus cloud.
 *
 * Run with the working directory set to eucalyptus home.
 *
 * TODO:STEVE: move to deploy and run using that modules classpath / build dir
 */
public class Main {

  /**
   * Entry point.
   */
  public static void main( final String[] args ) throws Throwable {
    //org.apache.log4j.LogManager.getRootLogger().setLevel(Level.INFO);
    //System.setProperty("euca.initialize", "true");

    //TODO:STEVE: check if postgres available?

    final File home = new File(".");
    System.setProperty("euca.home", home.getAbsolutePath());
    System.setProperty("euca.var.dir", path(home, "var"));
    System.setProperty("euca.conf.dir", path(home, "conf"));
    System.setProperty("euca.lib.dir", path(home, "var/lib"));
    System.setProperty("euca.log.dir", path(home, "var/log"));
    System.setProperty("euca.run.dir", path(home, "var/run/eucalyptus"));
    System.setProperty("euca.libexec.dir", path(home, "usr/libexec"));
    System.setProperty("euca.state.dir", path(home, "var/run/state"));
    System.setProperty("euca.jni.dir", path(home, "var/run/jni"));

    System.setProperty("euca.log.appender", "console");
    System.setProperty("euca.log.level", "INFO");

    DNSProperties.PORT = 5553;
    File ibdata1 = SubDirectory.DB.getChildFile( "data", "ibdata1" );
    if ( ibdata1.exists( ) ) {
      ibdata1.createNewFile( );
    }
    //TODO:STEVE: could resolve relative to Main classpath resource?
    final Map<String,String> scriptMap = ImmutableMap.<String,String>builder( )
        .put( "initialize_cloud.groovy", "/home/steve/Work/euca-internal-clean/eucalyptus/clc/modules/msgs/conf/scripts/initialize_cloud.groovy" )
        .put( "setup_db", "/home/steve/Work/euca-internal-clean/eucalyptus/clc/modules/postgresql/conf/scripts/setup_db.groovy" )
        .put( "setup_dbpool.groovy", "/home/steve/Work/euca-internal-clean/eucalyptus/clc/modules/msgs/conf/scripts/setup_dbpool.groovy" )
        .put( "setup_dbpool_remote.groovy", "/home/steve/Work/euca-internal-clean/eucalyptus/clc/modules/msgs/conf/scripts/setup_dbpool_remote.groovy" )
        .put( "setup_membership.groovy", "/home/steve/Work/euca-internal-clean/eucalyptus/clc/modules/msgs/conf/scripts/setup_membership.groovy" )
        .put( "setup_persistence.groovy", "/home/steve/Work/euca-internal-clean/eucalyptus/clc/modules/msgs/conf/scripts/setup_persistence.groovy" )
        .put( "setup_persistence_remote.groovy", "/home/steve/Work/euca-internal-clean/eucalyptus/clc/modules/msgs/conf/scripts/setup_persistence_remote.groovy" )
        .build( );
    Groovyness.registerFileMapper( scriptMap::get );

    final SystemBootstrapper boot = SystemBootstrapper.getInstance();
    if ( true ) { //TODO detect if init required
      System.setProperty("euca.initialize", "true");
      boot.init( );
      boot.load( );
    }
    System.clearProperty("euca.initialize");
    boot.init( );
    boot.load( );
    boot.start( );

    //TODO:STEVE: configure basic services, create a keypair and log it ...
  }

  private static String path( final File file, final String path ) {
    return new File( file, path ).getAbsolutePath();
  }
}
