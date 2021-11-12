package models;
import static java.util.stream.Collectors.toMap;

import java.util.*;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import play.libs.Json;

public class DistWordDesc {

    public ArrayNode desDistWdCount(RedditSearchResult curRed) {
        ArrayNode distinctWordJsonList = Json.newArray();
        //getting the list from the Reditsearch
        List<SingleSubmission> results = curRed.getResults(); //getting the list of reds
        //json nodes has key and values correspondent, which is similar to map
        //not sure we should extract from title or subreddit, ask pooya
        Map<String,Integer> wordCountMap = results.stream().map(SingleSubmission::getTitle).map(String::toLowerCase) .map(subRed ->subRed.split(" "))
                .flatMap(Arrays::stream).collect(toMap(token ->token , num -> 1, (key1,key2) ->key1.intValue()+1 ));

        wordCountMap.entrySet().stream().forEach(e->{System.out.println(e.getKey() + " count: " + e.getValue());});

        wordCountMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
//        			.thenComparing(Map.Entry.comparingByKey().reversed()))
                .forEach(x->{
                    ObjectNode node = Json.newObject();
                    node.put("word", x.getKey());
                    node.put("count",x.getValue());
                    distinctWordJsonList.add(node);
                });
        return distinctWordJsonList;
    }
}
