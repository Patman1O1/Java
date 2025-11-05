package com.gradecalc.io;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.gradecalc.Item;

import java.io.IOException;

public class ItemSerializer extends JsonSerializer<Item> {
    /* -------------------------------------------------Methods------------------------------------------------------ */
    @Override
    public void serialize(Item item, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException, NullPointerException {
        if (item == null) {
            throw new NullPointerException("\"item\" cannot be null");
        }

        // Begin writing to the .json file
        jsonGenerator.writeStartObject();

        // Create the name field
        jsonGenerator.writeStringField("name", item.getName());

        // Create the earned points field
        jsonGenerator.writeNumberField("earnedPoints", item.getEarnedPoints());

        // Create the total points field
        jsonGenerator.writeNumberField("totalPoints", item.getTotalPoints());

        // Create the grade field
        jsonGenerator.writeNumberField("grade", item.calculateGrade());

        // Stop writing to the .json file
        jsonGenerator.writeEndObject();
    }
}
