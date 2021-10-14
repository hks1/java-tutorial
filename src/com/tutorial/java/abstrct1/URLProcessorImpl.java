package com.tutorial.java.abstrct1;

import java.io.IOException;
import java.io.InputStream;

public class URLProcessorImpl extends URLProcessorBase{
    @Override
    protected void processURLData(InputStream inputStream) throws IOException {
        int data = inputStream.read();
        while (data != -1){
            System.out.println((char) data);
            data = inputStream.read();
        }
    }
}
