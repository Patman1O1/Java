import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;

public class ItemDeserializer extends JsonDeserializer<Item> {
    /* -------------------------------------------------Methods------------------------------------------------------ */
    @Override
    public Item deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode jsonNode = jsonParser.getCodec().readTree(jsonParser);

        // Read the item's name
        String itemName = jsonNode.get("Name").asText();

        // Read the item's grade
        double itemGrade = jsonNode.get("Grade").asDouble();

        // Create a new instance of the item with the data
        return new Item(itemName, itemGrade);
    }
}
