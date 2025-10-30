package com.gradecalc;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class CourseFile extends File  {
    /* --------------------------------------------------Fields------------------------------------------------------ */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private String pathname;

    private CourseSerializer courseSerializer;

    private CourseDeserializer courseDeserializer;

    /* -----------------------------------------------Constructors--------------------------------------------------- */
    public CourseFile(String pathname) throws NullPointerException, InvalidPathException {
        super(CourseFile.validatePathname(pathname));
        this.pathname = pathname;
        this.courseSerializer = new CourseSerializer();
        this.courseDeserializer = new CourseDeserializer();
    }

    /* -------------------------------------------------Setters------------------------------------------------------ */
    private static String validatePathname(String pathname) throws NullPointerException, InvalidPathException {
        if (pathname == null) {
            throw new NullPointerException("\"pathname\" cannot be null");
        }



        return pathname;
    }

    /* -------------------------------------------------Getters------------------------------------------------------ */

    /* -------------------------------------------------Methods------------------------------------------------------ */
    // TODO
    public void read() throws IOException {

    }

    // TODO
    public void write() throws IOException {

    }
}
