package org.cloud.mud.resource;

import java.io.InputStream;

public interface Resource {
    public InputStream getAsInputStream();

    public boolean isExist();
}
