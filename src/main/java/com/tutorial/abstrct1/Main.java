package com.tutorial.abstrct1;

import java.io.IOException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {
        URLProcessor urlProcessor = new URLProcessorImpl();
        urlProcessor.process( new URL("http://demo.com"));
    }
}
