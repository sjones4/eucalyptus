/**
 * Copyright 2019 AppScale Systems, Inc
 *
 * SPDX-License-Identifier: BSD-2-Clause
 */
package com.eucalyptus.node;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermissions;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.util.Base64;
import java.util.List;
import sun.security.util.DerInputStream;
import sun.security.util.DerValue;

/**
 * Utilities for working with node PEM key/cert
 */
public class NodeKeys {
  public static final String PATH_CERT = "/var/lib/eucalyptus/keys/node-cert.pem";
  public static final String PATH_KEY = "/var/lib/eucalyptus/keys/node-pk.pem";

  public static X509Certificate certificate(final String certPemFile) throws GeneralSecurityException, IOException {
    final byte[] certPem = Files.readAllBytes(FileSystems.getDefault().getPath(certPemFile));
    final CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
    final Certificate certificate = certificateFactory.generateCertificate(new ByteArrayInputStream(certPem));
    return (X509Certificate) certificate;
  }

  public static PrivateKey privateKey(final String keyPemFile) throws GeneralSecurityException, IOException {
    final List<String> keyPemLines = Files.readAllLines(FileSystems.getDefault().getPath(keyPemFile));
    final byte[] keyEncoded = Base64.getDecoder().decode(String.join("", keyPemLines.subList(1, keyPemLines.size() - 1)));
    final DerInputStream derInputStream = new DerInputStream(keyEncoded);
    final DerValue[] sequence = derInputStream.getSequence(0);
    final BigInteger modulus = sequence[1].getBigInteger();
    final BigInteger publicExponent = sequence[2].getBigInteger();
    final BigInteger privateExponent = sequence[3].getBigInteger();
    final BigInteger primeP = sequence[4].getBigInteger();
    final BigInteger primeQ = sequence[5].getBigInteger();
    final BigInteger primeExponentP = sequence[6].getBigInteger();
    final BigInteger primeExponentQ = sequence[7].getBigInteger();
    final BigInteger crtCoefficient = sequence[8].getBigInteger();
    final RSAPrivateCrtKeySpec keySpec =
        new RSAPrivateCrtKeySpec(modulus, publicExponent, privateExponent, primeP, primeQ, primeExponentP, primeExponentQ, crtCoefficient);
    final KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    return keyFactory.generatePrivate(keySpec);
  }

  public static String jks(final char[] keystorePassword) throws GeneralSecurityException, IOException {
    return jks(PATH_CERT, PATH_KEY, keystorePassword);
  }

  public static String jks(
      final String certPemFile,
      final String keyPemFile,
      final char[] keystorePassword
  ) throws GeneralSecurityException, IOException {
    final FileAttribute fileAttribute = PosixFilePermissions.asFileAttribute(
        PosixFilePermissions.fromString( "rw-------"));
    final Path keystoreFile = Files.createTempFile( "nc", ".jks", fileAttribute);
    final KeyStore keyStore = KeyStore.getInstance( "jks" );
    keyStore.load(null, null);
    final Certificate cert = certificate(certPemFile);
    final PrivateKey privateKey = privateKey(keyPemFile);
    keyStore.setKeyEntry("node", privateKey, keystorePassword, new Certificate[]{cert});
    try (final OutputStream keystoreOutputStream = new FileOutputStream(keystoreFile.toFile())) {
      keyStore.store(keystoreOutputStream, keystorePassword );
    }
    return keystoreFile.toString();
  }
}
