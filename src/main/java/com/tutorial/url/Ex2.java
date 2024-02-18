package com.tutorial.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Ex2 {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://oracle.com");

            URLConnection connection = url.openConnection();

            //connection.connect();

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null){
                System.out.println(inputLine);
            }
            in.close();
        } catch (MalformedURLException e){
            // new URL failed
            throw new RuntimeException(e.getCause());
        } catch (IOException e){
            // openConnection() failed
            throw new RuntimeException(e.getMessage());
        }


    }
}
