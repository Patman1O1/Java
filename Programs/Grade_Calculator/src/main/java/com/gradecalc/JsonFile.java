package com.gradecalc;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class JsonFile<T> extends File {
    /* --------------------------------------------------Fields------------------------------------------------------ */
    protected static final ObjectMapper objectMapper = new ObjectMapper();

    /* -----------------------------------------------Constructors--------------------------------------------------- */
    public JsonFile(String pathname) throws NullPointerException, InvalidPathException { super(pathname); }

    public JsonFile(Path path) { super(path.toString()); }

    /* -------------------------------------------------Methods------------------------------------------------------ */
    public T read(Class<T> type) throws IOException { return objectMapper.readValue(this, type); }

    public void write(T object) throws IOException {
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(this, object);
    }

}
