package com.tutorial.interfaces;

import javax.faces.application.Resource;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Map;

public class FileLoader implements ResourceLoader{
    public Resource load(String resourcePath){
        //implementation
        // return
        return new Resource() {
            @Override
            public InputStream getInputStream() throws IOException {
                return null;
            }

            @Override
            public Map<String, String> getResponseHeaders() {
                return null;
            }

            @Override
            public String getRequestPath() {
                return null;
            }

            @Override
            public URL getURL() {
                return null;
            }

            @Override
            public boolean userAgentNeedsUpdate(FacesContext facesContext) {
                return false;
            }
        };
    }
}
