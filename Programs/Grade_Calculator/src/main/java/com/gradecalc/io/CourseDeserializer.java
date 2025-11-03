package com.gradecalc.io;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.gradecalc.Category;
import com.gradecalc.Course;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CourseDeserializer extends JsonDeserializer<Course> {
    /* -------------------------------------------------Methods------------------------------------------------------ */
    @Override
    public Course deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode jsonNode = jsonParser.getCodec().readTree(jsonParser);
        ArrayNode arrayNode;
        ObjectMapper objectMapper = (ObjectMapper) jsonParser.getCodec();

        // Read the course's name
        String courseName = jsonNode.get("name").asText();

        // Read the course's categories
        List<Category> categories = new ArrayList<>();
        arrayNode = (ArrayNode) jsonNode.get("categories");
        if (arrayNode != null) {
            for (JsonNode categoryNode : arrayNode) {
                categories.add(objectMapper.treeToValue(categoryNode, Category.class));
            }
        }

        return new Course(courseName, categories);
    }

}
