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
package com.eucalyptus.container.ws

import com.eucalyptus.container.common.model.EcsMessage
import com.google.common.collect.Lists
import com.google.common.collect.Sets
import org.junit.Test
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider
import org.springframework.core.type.filter.AssignableTypeFilter

import java.lang.reflect.Field
import java.lang.reflect.ParameterizedType

/**
 *
 */
class ContainerQueryBindingGenerator {
  @Test
  void generate() {
    ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider( false )
    scanner.addIncludeFilter( new AssignableTypeFilter( EcsMessage ) );
    Set<String> messageClasses = Sets.newTreeSet( scanner.findCandidateComponents( EcsMessage.package.name )*.beanClassName )
    messageClasses.removeAll( [ 'com.eucalyptus.container.common.model.EcsMessage', 'com.eucalyptus.container.common.model.EcsErrorResponse' ] )
    Set<String> beanClasses = Sets.newTreeSet( )
    Set<String> printedBeanClasses = Sets.newHashSet( )
    for ( String messageclass : messageClasses ) {
      String simpleName = messageclass.substring( messageclass.lastIndexOf( '.' ) + 1 )

      if ( messageclass.endsWith( "Request" ) ) {
        println """  <mapping name="${simpleName.substring(0,simpleName.length()-7)}" class="${messageclass}">"""
        println """    <structure map-as="com.eucalyptus.container.common.model.EcsMessage"/>"""
        printFields( messageclass, beanClasses )
        println """  </mapping>"""
      } else if ( messageclass.endsWith( "Response" ) ) {
        println """  <mapping name="${simpleName}" class="${messageclass}">"""
        println """    <structure map-as="com.eucalyptus.container.common.model.EcsMessage"/>"""
        println """    <structure name="${simpleName.substring(0,simpleName.length()-8)}Result" field="result" usage="required" type="${messageclass.replace("Response", "Result")}"/>"""
        println """    <structure map-as="EcsResponseMessage"/>"""
        println """  </mapping>"""
        println """  <mapping class="${messageclass.replace("Response", "Result")}" abstract="true">"""
        printFields( messageclass.replace("Response", "Result"), beanClasses )
        println """  </mapping>"""
      } else {
        throw new Exception( "Unexpected message class : ${messageclass}" )
      }
    }

    while ( !printedBeanClasses.containsAll( beanClasses ) ) {
      for ( String beanClass : Lists.newArrayList( beanClasses ) ) {
        if ( printedBeanClasses.contains( beanClass ) ) continue;
        println """  <mapping class="${beanClass}" abstract="true">"""
        printFields( beanClass, beanClasses )
        println """  </mapping>"""
        printedBeanClasses << beanClass
      }
    }
  }

  void printFields( String messageclass, Collection<String> beanClasses ) {
    Class.forName( messageclass ).declaredFields.each { Field field ->
      if ( field.type.package.name.startsWith( 'java' ) ) {
        println """    <value name="${field.name}" field="${field.name}" usage="optional"/>"""
      } else if ( Collection.class.isAssignableFrom( field.type ) ) {
        Class itemType = ( Class ) ( ( ParameterizedType ) field.genericType ).actualTypeArguments[0];
        if ( itemType.name.startsWith( 'java' ) ) {
          println """    <collection name="${field.name}" field="${field.name}">"""
          println """      <value name="member" type="${itemType.name}"/>"""
          println """    </collection>"""
        } else {
          println """    <collection field="${field.name}">"""
          println """      <structure name="member" type="${itemType.name}"/>"""
          println """    </collection>"""
          beanClasses << itemType.name
        }
      } else {
        println """    <structure name="${field.name}" field="${field.name}" usage="optional" type="${field.type.name}"/>"""
        beanClasses << field.type.name
      }
    }
  }
}
