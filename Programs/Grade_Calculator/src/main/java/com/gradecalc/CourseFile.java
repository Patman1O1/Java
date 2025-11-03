package com.gradecalc;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.InvalidPathException;

public class CourseFile extends File {
    /* --------------------------------------------------Fields------------------------------------------------------ */
    protected static final ObjectMapper objectMapper = new ObjectMapper();

    /* -----------------------------------------------Constructors--------------------------------------------------- */
    public CourseFile(String pathname) throws NullPointerException, InvalidPathException { super(pathname); }

    /* -------------------------------------------------Methods------------------------------------------------------ */
    public Course read() throws IOException { return objectMapper.readValue(this, Course.class); }

    public void write(Course course) throws IOException {
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(this, course);
    }
}
