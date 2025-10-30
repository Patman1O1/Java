package com.gradecalc;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class JsonFile<T> extends File {
    /* --------------------------------------------------Fields------------------------------------------------------ */
    protected static final ObjectMapper objectMapper = new ObjectMapper();

    /* -----------------------------------------------Constructors--------------------------------------------------- */
    protected JsonFile(String pathname) throws NullPointerException, InvalidPathException {
        super(validatePathname(pathname));
    }

    protected JsonFile(Path path) { super(validatePathname(path.toString())); }

    /* -------------------------------------------------Methods------------------------------------------------------ */
    private static String validatePathname(String pathname) throws NullPointerException, InvalidPathException {
        if (pathname == null) {
            throw new NullPointerException("\"pathname\" cannot be null");
        }

        Path path = Paths.get(pathname);

        if (!Files.exists(path)) {
            throw new InvalidPathException(pathname, "\"pathname\" does not exist");
        }

        // If the pathname leads to a regular file that doesn't have the file extension .json..
        if (Files.isRegularFile(path) && !pathname.substring(pathname.lastIndexOf('.')).equals(".json")) {
            // Throw an exception
            throw new InvalidPathException(pathname, "\"pathname\" does not lead to a directory nor a .json file");
        }

        return pathname;
    }

    public T read(Class<T> type) throws IOException { return objectMapper.readValue(this, type); }

    public void write(T object) throws IOException {
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(this, object);
    }
}
