package com.gradecalc;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class CategorySerializer extends JsonSerializer<Category> {
    /* -------------------------------------------------Methods------------------------------------------------------ */
    @Override
    public void serialize(Category category, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException, NullPointerException {
        if (category == null) {
            throw new NullPointerException("\"category\" cannot be null");
        }

        // Begin writing to the .json file
        jsonGenerator.writeStartObject();

        // Create the name field
        jsonGenerator.writeStringField("name", category.getName());

        // Create the grade field
        jsonGenerator.writeNumberField("grade", category.getGrade());

        // Create the weight field
        jsonGenerator.writeNumberField("weight", category.getWeight());

        // Create the items field
        jsonGenerator.writeArrayFieldStart("items");
        for (Item item : category.getItems()) {
            if (item == null) {
                continue;
            }

            ItemSerializer itemSerializer = new ItemSerializer();
            itemSerializer.serialize(item, jsonGenerator, serializerProvider);
        }
        jsonGenerator.writeEndArray();

        // Create the drops field
        jsonGenerator.writeArrayFieldStart("drops");

        for (Item item : category.getDrops()) {
            if (item == null) {
                jsonGenerator.writeNull();
                continue;
            }

            new ItemSerializer().serialize(item, jsonGenerator, serializerProvider);
        }
        jsonGenerator.writeEndArray();

        // Stop writing to the .json file
        jsonGenerator.writeEndObject();
    }
}
