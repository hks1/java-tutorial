package com.tutorial.java.abstrct;

import java.io.IOException;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws IOException {
        URLProcessorImpl urlProcessor = new URLProcessorImpl();
        urlProcessor.process(new URL("http://jenkov.com"));
    }

}
