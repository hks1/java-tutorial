package com.tutorial.abstrct;

import java.io.IOException;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws IOException {
        URLProcessorImpl urlProcessor = new URLProcessorImpl();
        urlProcessor.process(new URL("http://demo.com"));
    }

}
