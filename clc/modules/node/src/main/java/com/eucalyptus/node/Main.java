/**
 * Copyright 2019 AppScale Systems, Inc
 *
 * SPDX-License-Identifier: BSD-2-Clause
 */
package com.eucalyptus.node;

/**
 * Node controller entry point
 */
public class Main {
  public static void main(String[] args) {
    System.out.println("Node controller starting");
    NodeInterface.doInitNC();
    System.out.println("Node controller exiting");
  }
}
