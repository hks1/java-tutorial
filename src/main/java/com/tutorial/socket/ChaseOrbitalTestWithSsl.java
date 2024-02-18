package com.tutorial.socket;

import java.io.*;
import java.security.KeyStore;
import java.util.*;
import java.net.*;
//import org.apache.http.*;
import javax.net.ssl.*;


public class ChaseOrbitalTestWithSsl {

    private static SSLContext getSSLSocketFactory() throws Exception {
        // Client key store in .jks format. Convert your .pkcs12 file into jks if needed using:
        // keytool -importkeystore -srckeystore "<path to .p12 file>" -srcstoretype pkcs12
        // -destkeystore "<reqd jks name>" -deststoretype JKS\n\n
        String mKeyStoreFilePath = "H:/certs/chime.jks";
        String mKeyStorePassword = "apiTest";

        // Client Trust Store with trusted CA's for server certificate validation
        String mTrustStoreFilePath = "C:JDK64/1.8.0.102/jre/lib/security/cacerts";

        KeyStore keyStore = KeyStore.getInstance("JKS");
        InputStream keyStoreInput = null;
        InputStream trustStoreInput = null;
        keyStoreInput = new FileInputStream(mKeyStoreFilePath);
        trustStoreInput = new FileInputStream(mTrustStoreFilePath);

        try {
            keyStore.load(keyStoreInput, mKeyStorePassword.toCharArray());
            KeyStore trustStore = KeyStore.getInstance("JKS");
            trustStore.load(trustStoreInput, null);
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(trustStore);
            keyManagerFactory.init(keyStore, mKeyStorePassword.toCharArray());
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), null);
            return sslContext;
        } finally {
            if (trustStoreInput != null) {
                trustStoreInput.close();
            }
            keyStoreInput.close();
        }
    }

    public static void main(String args[]) throws Exception
    {

        System.out.println(getSSLSocketFactory().getProtocol());
        /*CloseableHttpClient apiClient = HttpClients.custom().setSSLContext(getSSLSocketFactory()).build();
        HttpPost request = new HttpPost("https://orbitalvar1.chasepaymentech.com/gwapi/v4/gateway/token");
        String payload = "{  \"version\": \"5.1\",  \"merchant\": {    \"bin\": \"000001\",    \"terminalID\": \"001\"  },  \"paymentInstrument\": {    \"card\": {      \"cardBrand\": \"VI\",      \"ccAccountNum\": \"4444444444444448\",      \"ccExp\": \"202506\"    }  },  \"order\": {    \"orderID\": \"123456\",    \"currencyCode\": \"840\"  },  \"token\": {    \"actionCode\": \"TK\"  }}";
        StringEntity entity = new StringEntity(payload);
        request.setEntity(entity);


        // base64 encoded Janus username & password in the format username:password
        String authStr = "username:password";
        String authEncoded = Base64.getEncoder().encodeToString(authStr.getBytes());
        request.addHeader("Authorization", "Basic " + authEncoded);
        request.addHeader("orbitalConnectionUsername", "TEST0257HUGH");
        request.addHeader("orbitalConnectionPassword", "Lv1KJb6p");
        request.addHeader("merchantID", "750257");
        final HttpResponse httpResponse = apiClient.execute(request);
        String responseString = new BasicResponseHandler().handleResponse(httpResponse);
        System.out.println(responseString);*/
    }


}
