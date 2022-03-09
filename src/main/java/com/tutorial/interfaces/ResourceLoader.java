package com.tutorial.interfaces;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Path;
import java.util.Map;
import javax.faces.application.Resource;
import javax.faces.context.FacesContext;

public interface ResourceLoader {

    Resource load(String resourcePath);

    default Resource load(Path resourcePath){
        // default implementation to load
        // resource from a Path and return the content
        // in a resource object
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
