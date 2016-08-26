package org.cloud.mud.resource;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

public class ClasspathResource implements Resource {
    private String path;

    public ClasspathResource(String path) {
        this.path = path;
    }

    @Override
    public InputStream getAsInputStream() {
        return ClassLoader.getSystemResourceAsStream(path);
    }

    public Reader getAsReader() {
        return new BufferedReader(new InputStreamReader(getAsInputStream(), StandardCharsets.UTF_8));
    }

    @Override
    public boolean isExist() {
        return ClassLoader.getSystemResource(path) != null;
    }
}
