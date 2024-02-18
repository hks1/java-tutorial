package com.tutorial.socket;

import java.io.*;
import java.util.*;
import java.net.*;
//import org.apache.http.*;
import javax.net.ssl.*;


public class ChaseOrbitalTest {
    /*try {
        URL obj = null;
        try {
            obj = new URL("https://orbitalvar1.chasepaymentech.com/gwapi/v4/gateway/token");
        } catch (MalformedURLException ex) {
            throw new RuntimeException(ex);
        }
        HttpsURLConnection urlConnection = null;
        try {
            urlConnection = (HttpsURLConnection) obj.openConnection();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        try {
            urlConnection.setRequestMethod("POST");
        } catch (ProtocolException ex) {
            throw new RuntimeException(ex);
        }


                urlConnection.setRequestProperty("orbitalConnectionUsername", "TEST0257HUGH"    );

                        urlConnection.setRequestProperty("orbitalConnectionPassword", "Lv1KJb6p"   );

                                urlConnection.setRequestProperty("merchantID", "750257"
                                        urlConnection.setDoOutput(true);
        OutputStreamWriter osw = new OutputStreamWriter(urlConnection.getOutputStream());

        osw.write("{  \"version\": \"5.1\",  \"merchant\": {    \"bin\": \"000001\",    \"terminalID\": \"001\"  },  \"paymentInstrument\": {    \"card\": {      \"cardBrand\": \"VI\",      \"ccAccountNum\": \"4444444444444448\",      \"ccExp\": \"202506\"    }  },  \"order\": {    \"orderID\": \"123456\",    \"currencyCode\": \"840\"  },  \"token\": {    \"actionCode\": \"TK\"  }}");

        osw.flush();

        int responseCode = urlConnection.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), StandardCharsets.UTF_8));

        String line;

        while ((line = in.readLine()) != null) {

            System.out.println(line);

        }

        in.close();
    } catch (IOException e) {
        // handle exception
        e.printStackTrace();
    }*/
}
