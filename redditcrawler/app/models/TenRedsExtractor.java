package models;
import static java.util.stream.Collectors.toList;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import play.libs.Json;

public class TenRedsExtractor {
    //will retrieve 10 reddit results from the result array and return
    //an ArrayNode version of the 10 results
    //the search function to display data or other method needs it
    public ArrayNode getTweetsAsync(List<SingleSubmission> curSearch) {
        ArrayNode reddits = Json.newArray();   //sending through arraynode
        //ask pooya how to add the previous results into this objectNodes, it is lambda, too tired to write anymore
        List<CompletableFuture<ObjectNode>> nodesFuture = curSearch.stream().map(singleSubmission -> CompletableFuture.supplyAsync(
                ()->new JsonNodeMapper().convertRedsToJson(singleSubmission))).collect(Collectors.toList());

        List<ObjectNode> nodes = nodesFuture.stream().map(CompletableFuture::join)
                .collect(toList());
        nodes.forEach(node->reddits.add(node));
        return reddits;
    }
}
