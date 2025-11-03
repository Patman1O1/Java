package com.gradecalc.io;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gradecalc.Course;

import java.io.File;
import java.io.IOException;
import java.nio.file.InvalidPathException;

public class CourseFile extends File {
    /* --------------------------------------------------Fields------------------------------------------------------ */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private JsonNode nameNode, gradeNode;



    /* -----------------------------------------------Constructors--------------------------------------------------- */
    public CourseFile(String pathname) throws NullPointerException, InvalidPathException { super(pathname); }

    /* -------------------------------------------------Methods------------------------------------------------------ */
    public Course read() throws IOException { return objectMapper.readValue(this, Course.class); }

    public void write(Course course) throws IOException {
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(this, course);
    }
}
