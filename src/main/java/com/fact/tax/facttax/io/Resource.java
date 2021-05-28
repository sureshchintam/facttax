package com.fact.tax.facttax.io;

import java.io.IOException;
import java.io.InputStream;

public interface Resource {
    String getName();

    InputStream getInputStream() throws IOException;

    boolean exists();
}
