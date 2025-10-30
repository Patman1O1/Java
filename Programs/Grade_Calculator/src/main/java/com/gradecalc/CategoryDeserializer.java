package com.gradecalc;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.IOException;
import java.util.*;

public class CategoryDeserializer extends JsonDeserializer<Category> {
    /* -------------------------------------------------Methods------------------------------------------------------ */
    @Override
    public Category deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {
        JsonNode jsonNode = jsonParser.getCodec().readTree(jsonParser);
        ArrayNode arrayNode;
        ObjectMapper objectMapper = (ObjectMapper)jsonParser.getCodec();

        // Read the category's name
        String categoryName = jsonNode.get("name").asText();

        // Read the category's weight
        double categoryWeight = jsonNode.get("weight").asDouble();

        // Read the category's items
        List<Item> items = new ArrayList<>();
        arrayNode = (ArrayNode)jsonNode.get("items");
        if (arrayNode != null) {
            for (JsonNode itemNode : arrayNode) {
                items.add(objectMapper.treeToValue(itemNode, Item.class));
            }
        }

        // Read the category's drops
        int numDrops = 0;
        arrayNode = (ArrayNode)jsonNode.get("drops");
        if (arrayNode != null) {
            for (JsonNode itemNode : arrayNode) {
                items.add(objectMapper.treeToValue(itemNode, Item.class));
                ++numDrops;
            }
        }

        return new Category(categoryName, categoryWeight, items, numDrops);
    }
}
