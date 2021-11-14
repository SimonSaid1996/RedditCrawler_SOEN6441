package models;
import models.RedditSearchResult;
import com.fasterxml.jackson.databind.node.ObjectNode;
import play.libs.Json;

//might not need this class anymore, along with the TenRedsExtractor class

public class JsonNodeMapper {   //if need more info, could set it later
    public ObjectNode convertRedsToJson(SingleSubmission redS) {
        ObjectNode node = Json.newObject();
        node.put("name",redS.getAuthor());
        node.put("rubRed",redS.getSubreddit());
        node.put("title",redS.getTitle());
        return node;
    }

}
