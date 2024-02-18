package com.tutorial.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Ex1 {
    public static void main(String[] args) throws MalformedURLException {
        URL myURL = new URL("https://oracle.com/");
        URL mapURL = new URL(myURL, "maps");
        System.out.println(myURL.getAuthority());
        System.out.println(mapURL.getFile());

        BufferedReader in = null;
        try {
            in = new BufferedReader(
                    new InputStreamReader(myURL.openStream())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String input;

        while(true){
            try {
                if (!((input = in.readLine()) != null)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println();
        }
        try {
            in.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
