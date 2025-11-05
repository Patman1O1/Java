package com.gradecalc.io;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.gradecalc.Item;

import java.io.IOException;

public class ItemDeserializer extends JsonDeserializer<Item> {
    /* -------------------------------------------------Methods------------------------------------------------------ */
    @Override
    public Item deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode jsonNode = jsonParser.getCodec().readTree(jsonParser);

        // Read the item's name
        String itemName = jsonNode.get("name").asText();

        // Read the item's earned points
        double earnedPoints = jsonNode.get("earnedPoints").asDouble();

        // Read the item's total points
        double totalPoints = jsonNode.get("totalPoints").asDouble();

        // Create a new instance of the item with the data
        return new Item(itemName, earnedPoints, totalPoints);
    }
}
