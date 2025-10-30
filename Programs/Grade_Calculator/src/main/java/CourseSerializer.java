import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class CourseSerializer extends JsonSerializer<Course> {
    /* --------------------------------------------------Fields------------------------------------------------------ */

    /* -----------------------------------------------Constructors--------------------------------------------------- */

    /* -------------------------------------------------Setters------------------------------------------------------ */

    /* -------------------------------------------------Getters------------------------------------------------------ */

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
        jsonGenerator.writeStringField("Name", course.getName());

        // Create the grade field
        jsonGenerator.writeNumberField("Grade", course.calculateGrade());

        // Create the categories field
        jsonGenerator.writeArrayFieldStart("Categories");
        for (Category category : course.getCategories()) {
            if (category == null || category.isEmpty()) {
                jsonGenerator.writeNull();
                continue;
            }

            new CategorySerializer().serialize(category, jsonGenerator, serializerProvider);
        }
        jsonGenerator.writeEndArray();

        // Stop writing to the .json file
        jsonGenerator.writeEndObject();
    }
}
