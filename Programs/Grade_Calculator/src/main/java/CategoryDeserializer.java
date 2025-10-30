import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.json.JsonMapper;
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
        JsonMapper jsonMapper = (JsonMapper) jsonParser.getCodec();

        // Read the category's name
        String categoryName = jsonNode.get("Name").asText();

        // Read the category's weight
        double categoryWeight = jsonNode.get("Weight").asDouble();

        // Read the category's items
        List<Item> items = new ArrayList<>();
        arrayNode = (ArrayNode)jsonNode.get("Items");
        if (arrayNode != null) {
            for (JsonNode itemNode : arrayNode) {
                items.add(jsonMapper.treeToValue(itemNode, Item.class));
            }
        }

        // Read the category's drops
        int numDrops = 0;
        arrayNode = (ArrayNode)jsonNode.get("Drops");
        if (arrayNode != null) {
            for (JsonNode itemNode : arrayNode) {
                items.add(jsonMapper.treeToValue(itemNode, Item.class));
                ++numDrops;
            }
        }

        return new Category(categoryName, categoryWeight, items, numDrops);
    }
}
