/*
package com.tutorial.socket;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.junit.jupiter.api.Timeout;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.PKIXParameters;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.Base64;
import java.util.Iterator;

import static org.apache.http.conn.ssl.SSLConnectionSocketFactory.TLS;

public class ServerSocketTesting {
    public static void main(String[] args) throws IOException, KeyStoreException, CertificateException, NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        //ServerSocket server = new ServerSocket(8081);
        //System.out.println("Server is started, listening connections on port :8081");
        //server.accept();

        new ServerSocket(0, 1, InetAddress.getLocalHost());

        System.getenv().entrySet().forEach(e -> System.out.println(e.getKey() + ":" + e.getValue()));

        System.out.println(System.getProperty("javax.net.ssl.trustStore"));;

        String filename = System.getProperty("java.home") + "/lib/security/cacerts".replace("/", File.separator);
        System.out.println(filename);

        FileInputStream is = new FileInputStream(filename);

        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        String password = "changeit";
        keyStore.load(is, password.toCharArray());

        // This class retrieves the most-trusted CAs from the keystore
        PKIXParameters params = new PKIXParameters(keyStore);

        // Get the set of trust anchors, which contain the most-trusted CA certificates
        Iterator it = params.getTrustAnchors().iterator();
        while (it.hasNext()){
            TrustAnchor ta = (TrustAnchor) it.next();
            // get certificate
            X509Certificate cert = ta.getTrustedCert();
            //System.out.println(cert);
            System.out.println(cert.getIssuerX500Principal());
        }

        ////
        */
/*PoolingHttpClientConnectionManager connectionManager = PoolingHttpClientConnectionManagerBuilder.create()
                .setSSLSocketFactory(SSLConnectionSocketFactoryBuilder.create()
                        .setSslContext(SSLContexts.createSystemDefault())
                        .setTlsVersions(TLS.V_1_3)
                        .build())
                .setDefaultSocketConfig(SocketConfig.custom()
                        .setSoTimeout(Timeout.ofMinutes(1))
                        .build())
                .setPoolConcurrencyPolicy(PoolConcurrencyPolicy.STRICT)
                .setConnPoolPolicy(PoolReusePolicy.LIFO)
                .setDefaultConnectionConfig(ConnectionConfig.custom()
                        .setSocketTimeout(Timeout.ofMinutes(1))
                        .setConnectTimeout(Timeout.ofMinutes(1))
                        .setTimeToLive(TimeValue.ofMinutes(10))
                        .build())
                .build();*//*


        CloseableHttpClient apiClient = HttpClients.custom().setSSLContext(getSSLSocketFactory()).build();
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
        System.out.println(responseString);




        ////

    }

    private static SSLContext getSSLSocketFactory() throws Exception {
        // Client key store in .jks format. Convert your .pkcs12 file into jks if needed using:
        // keytool -importkeystore -srckeystore "<path to .p12 file>" -srcstoretype pkcs12
        // -destkeystore "<reqd jks name>" -deststoretype JKS\n\n
        //String mKeyStoreFilePath = "H:/certs/chime.jks";
        String mKeyStoreFilePath = System.getProperty("java.home") + "/lib/security/cacerts".replace("/", File.separator);
        //String mKeyStorePassword = "apiTest";
        String mKeyStorePassword = "changeit";

        // Client Trust Store with trusted CA's for server certificate validation
        //String mTrustStoreFilePath = "C:JDK64/1.8.0.102/jre/lib/security/cacerts";
        String mTrustStoreFilePath = System.getProperty("java.home") + "/lib/security/cacerts".replace("/", File.separator);

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
}
*/
