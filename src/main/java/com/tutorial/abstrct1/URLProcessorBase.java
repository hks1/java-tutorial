package com.tutorial.abstrct1;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

// Abstract Base Class
public abstract class URLProcessorBase implements URLProcessor{
    @Override
    public void process(URL url) throws IOException {
        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();

        try{
            processURLData(inputStream);
        } finally {
            inputStream.close();
        }
    }

    protected abstract void processURLData(InputStream inputStream)
        throws IOException;
}
