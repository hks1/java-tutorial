package com.examples;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class Example1 {
    public static void main(String[] args) throws NoSuchAlgorithmException, KeyManagementException, IOException {

        // Generate RSA Key Pair: Use the java.security.KeyPairGenerator class to generate an RSA key pair, which consists of a private key and a corresponding public key.
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048); // key size
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();
        RSAPublicKey rsaPublicKey = (RSAPublicKey) keyPair.getPublic();

        System.out.println(rsaPublicKey.toString());

        // Setup SSLContext: Create an SSLContext object that specifies the desired TLS version and encryption algorithm, along with the RSA key pair for authentication. You can use the javax.net.ssl.SSLContext class for this purpose.
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(
                null, // KeyManager array (use default)
                new TrustManager[]{}, // TrustManager array (use default)
                null // Random number generator (use default)
        );
        // Note that in a real-world scenario, you would typically configure the KeyManager and TrustManager appropriately to handle the server's private key and certificates.

        // Create SSLSocketFactory: Obtain an SSLSocketFactory instance from the SSLContext created in the previous step. This factory is responsible for creating SSL sockets
        SSLSocketFactory socketFactory = sslContext.getSocketFactory();

        // Establish TLS Connection: Use the SSLSocketFactory to create an SSLSocket and establish a TLS connection with the desired server.
        String serverHost = "localhost";
        int serverPort = 443;

        SSLSocket socket = (SSLSocket) socketFactory.createSocket(serverHost, serverPort);
        // Now you can read from and write to the socket for secure communication
    }
}
