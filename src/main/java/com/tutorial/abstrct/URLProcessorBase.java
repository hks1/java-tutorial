package com.tutorial.abstrct;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public abstract class URLProcessorBase {
    public void process(URL url) throws IOException {
        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();

        try {
            processURLData(inputStream);
        } finally {
            inputStream.close();
        }
    }

    public abstract void processURLData(InputStream input)
        throws IOException;
}

// READ
// Abstract Classes and the Template Method Design Pattern