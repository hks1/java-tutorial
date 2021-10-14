package com.tutorial.java.abstrct;

import java.io.IOException;
import java.io.InputStream;

public class URLProcessorImpl extends URLProcessorBase{
    @Override
    public void processURLData(InputStream input) throws IOException {
        int data = input.read();
        while (data != -1){
            System.out.println((char) data);
            data = input.read();
        }
    }
}
