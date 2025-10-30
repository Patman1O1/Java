import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CourseDeserializer extends JsonDeserializer<Course> {
    /* -------------------------------------------------Methods------------------------------------------------------ */
    @Override
    public Course deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode jsonNode = jsonParser.getCodec().readTree(jsonParser);
        ArrayNode arrayNode;
        JsonMapper jsonMapper = (JsonMapper) jsonParser.getCodec();

        // Read the course's name
        String courseName = jsonNode.get("Name").asText();

        // Read the course's categories
        List<Category> categories = new ArrayList<>();
        arrayNode = (ArrayNode)jsonNode.get("Categories");
        if (arrayNode != null) {
            for (JsonNode categoryNode : arrayNode) {
                categories.add(jsonMapper.treeToValue(categoryNode, Category.class));
            }
        }

        return new Course(courseName, categories);
    }

}
