package models;
import static java.util.stream.Collectors.toMap;

import java.util.*;

import Interface.DistWordDescInter;
import play.libs.Json;
/**
 * Task b, displaying each unique word counts from the 250 newest search results based on a string searchkey
 * @author Ziran Cao
 * @version v1
 */
public class DistWordDesc implements DistWordDescInter {
    public RedditSearchResult hardCoded;

    /**
     * in a descending order, displaying each unique word and their word count number
     * @author Ziran Cao
     * @param searchKey current searchkey word
     * @param count the number of reddits wanted to get the distinct word counts
     * @return a list of list<String>, containing the data of distinct word and thier number count
     * @version v1
     */

    public List<List<String>> desDistWdCount(String searchKey,int count) {   //count here should be 250, could modify the size by customer
        List<List<String>> dataList = new ArrayList<>();

        //getting the list from the Reditsearch
        String api = "https://api.pushshift.io/reddit/search/submission/?q="+searchKey+"&size="+Integer.toString(count);

        RedditSearchResult submissions =  null;

        if(hardCoded == null){
            submissions =  new RedditExtractor().getApiResults(api);
            //System.out.println("not sneaky, normal");
        }
        else{
            submissions = hardCoded;
            //System.out.println("$$$$$$$$$\nsneaky!!!");
        }
        List<SingleSubmission> results = submissions.getResults(); //getting the list of reds
        Map<String,Integer> wordCountMap = results.stream().map(SingleSubmission::getTitle).map(String::toLowerCase) .map(subRed ->subRed.split(" "))
                .flatMap(Arrays::stream).collect(toMap(token ->token , num -> 1, (key1,key2) ->key1.intValue()+1 ));

        wordCountMap.entrySet().stream().forEach(e->{System.out.println(e.getKey() + " count: " + e.getValue());});

        wordCountMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(x->{
                    List<String> node1 = new ArrayList<>();   //to store two values, one word, another value
                    node1.add(x.getKey()) ;
                    node1.add(Integer.toString(x.getValue()))  ;
                    dataList.add(node1);

                });
        return dataList;
    }

    @Override
    public void setHardCodedResult(RedditSearchResult re) {
         this.hardCoded = re;
    }

}
