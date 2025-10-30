package com.gradecalc;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class CourseFile extends File {
    /* --------------------------------------------------Fields------------------------------------------------------ */
    protected static final ObjectMapper objectMapper = new ObjectMapper();

    /* -----------------------------------------------Constructors--------------------------------------------------- */
    protected CourseFile(String pathname) throws NullPointerException, InvalidPathException {
        super(CourseFile.validatePathname(pathname));
    }

    protected CourseFile(Path path) { super(CourseFile.validatePathname(path.toString())); }

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

    public Course read() throws IOException { return CourseFile.objectMapper.readValue(this, Course.class); }

    public void write(Course course) throws IOException {
        CourseFile.objectMapper.writerWithDefaultPrettyPrinter().writeValue(this, course);
    }

}
