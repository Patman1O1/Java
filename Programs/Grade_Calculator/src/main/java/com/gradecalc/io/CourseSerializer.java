package com.gradecalc.io;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.gradecalc.Category;
import com.gradecalc.Course;

import java.io.IOException;

public class CourseSerializer extends JsonSerializer<Course> {
    /* -------------------------------------------------Methods------------------------------------------------------ */
    @Override
    public void serialize(Course course, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException {
        if (course == null) {
            throw new NullPointerException("\"course\" cannot be null");
        }

        // Begin writing to the .json file
        jsonGenerator.writeStartObject();

        // Create the name field
        jsonGenerator.writeStringField("name", course.getName());

        // Create the grade field
        jsonGenerator.writeNumberField("grade", course.calculateGrade());

        // Create the categories field
        jsonGenerator.writeArrayFieldStart("categories");
        for (Category category : course.getCategories()) {
            if (category == null || category.isEmpty()) {
                continue;
            }

            new CategorySerializer().serialize(category, jsonGenerator, serializerProvider);
        }
        jsonGenerator.writeEndArray();

        // Stop writing to the .json file
        jsonGenerator.writeEndObject();
    }
}
