package models;

import Interface.RedditExtraInter;
import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;

/**
 * Class for handling all the business logic for handling the search request
 * @author All
 */
public class RedditExtractor implements RedditExtraInter {
	public static boolean isTesting = false;
    public RedditSearchResult hardCodeSubm;
	public String searchKey;
	public User curUser;

	/**
	 * Default Constructor
	 * @author All
	 */
	public RedditExtractor() {

	}

	/**
	 * Copy User Constructor
	 * @author Ziran Cao and Yugansh Goyal
	 * @param user - A user class object for the current user's session
	 */
	public RedditExtractor(User user) {
		this.curUser = user;     //to store the user temperarily, for later adding data purpose
	}

	public void setSearchKey(String searchKey) {
		System.out.println("searchkey set");
		this.searchKey = searchKey;
	}
	/**
	 * 
	 * @author Ziran Cao
	 * @param searchKey a string representing the searchkey word
	 * @return a finishing message, showing the operation is successful
	 */

	/**
	 * Get latest 10 reddit search results asynchronously
	 * @author Yugansh Goyal
	 * @param searchKey - A string containing the searchkey
	 * @return RedditSearchResult representing the latest 10 reddit submissions having author, title and subreddit for the search key
	 */
	public CompletableFuture<RedditSearchResult> getLatestSubmissions(String searchKey){
		this.searchKey=searchKey;
		try{
			this.searchKey = URLEncoder.encode(this.searchKey,"UTF-8");} catch(Exception e){System.out.println(e);}
		String api = "https://api.pushshift.io/reddit/search/submission/?q="+this.searchKey+"&size=10";
		RedditSearchResult submissions ;
		if(hardCodeSubm ==null){submissions = getApiResults(api);} else{submissions =hardCodeSubm;}
		System.out.println("search key is "+this.searchKey+" curUser is "+curUser);
		curUser.removeOlderResult(this.searchKey);
		curUser.keepLatestTenResults();
		curUser.appendCache(submissions);
		return CompletableFuture.supplyAsync(()->getApiResults(api));
	}


	/**
	 * Query the api for submissions for the search key and parses the results, Yugansh Goyal - core logic, Simon Cao - refactor the sendAsync to send combined results
	 * @author Yugansh Goyal and Simon Cao
	 * @param api - a string representing the api URL
	 * @return RedditSearchResult representing the results from the api after parsing it with parse() method, returns empty if no results
	 */
	public RedditSearchResult getApiResults(String api){
		RedditSearchResult submissions= new RedditSearchResult();
		if(hardCodeSubm ==null){
			try{
				HttpClient client = HttpClient.newHttpClient();
				HttpRequest request = HttpRequest.newBuilder().uri(URI.create(api)).build();
				submissions = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
						.thenApply(HttpResponse::body)
						.thenApply(this::parse)
						.join();
			} catch(Exception e){
				submissions = this.getEmptyResults();
			}
			System.out.println("submission is "+submissions);
		}
		else{
			submissions =hardCodeSubm;
		}
		return submissions;
	}
	/**
	 * Method to return empty results to getApiResults incase the latter gets no results
	 * @author Yugansh Goyal
	 * @return RedditSearchResult representing empty results
	 */
	public RedditSearchResult getEmptyResults(){
		
		RedditSearchResult submissions= new RedditSearchResult();
		submissions.setSearchKey(this.searchKey);
		List<SingleSubmission> searchResult = new ArrayList<>();
		SingleSubmission singlesub = new SingleSubmission("", "", "", "");
		searchResult.add(singlesub);
		submissions.setResults(searchResult);
		
		return submissions;
	}

	/**
	 * to parse the response body of the results got from the api, Yugansh Goyal - core logic, Pooya Zargaran - parallel stream of individual parts
	 * @author Yugansh Goyal and Pooya Zargaran
	 * @param responseBody - a string containing the body of the response of the api
	 * @return RedditSearchResult after parsing data from the json
	 */
	public RedditSearchResult parse(String responseBody){
		RedditSearchResult result= new RedditSearchResult();
		result.setSearchKey(this.searchKey);
		List<SingleSubmission> searchResult = new ArrayList<>();  //adding to the new list
		JSONObject submissionObject = new JSONObject(responseBody);
        JSONArray submissions = submissionObject.getJSONArray("data");
		for(int i =0; i < submissions.length(); i++){
			JSONObject submission = submissions.getJSONObject(i);
			String author = submission.getString("author");
			String subreddit = submission.getString("subreddit");
			String title = submission.getString("title");
			String submissionlink = submission.getString("full_link");
			SingleSubmission singlesub = new SingleSubmission(author, subreddit, title, submissionlink);
			searchResult.add(singlesub);
			
			result.setResults(searchResult);
		}
		result.getResults().parallelStream().forEach(r->r.setAuthor("<a href='/profile/"+r.getAuthor()+"'>"+r.getAuthor()+"</a>"));
		result.getResults().parallelStream().forEach(r->r.setSubreddit("<a href='/subreddit/"+r.getSubreddit()+"'>"+r.getSubreddit()+"</a>"));
		
		return result;
	}

	//Simon individual's task
	
	/**
	 * Get distinct word count asynchronously
	 * @author Ziran Cao
	 * @param searchKey current collection of redditSearch results based on one key word
	 * @param count Number of reddits wanted to analysis
	 * @return a list of list<string>, which contains the information of the distinct words and thier work counts
	 */
	public CompletableFuture<List<List<String>>> getDistW(String searchKey, int count){
		
		this.searchKey=searchKey;
		try{
				this.searchKey = URLEncoder.encode(this.searchKey,"UTF-8");} catch(Exception e){System.out.println(e);
		}
		if(hardCodeSubm == null){return CompletableFuture.supplyAsync(()->new DistWordDesc().desDistWdCount( searchKey, count));}
		else{
			return null;
		}
	}
	
	//Yugansh's Individual task
	/**
	 * method to get latest 10 submissions belonging to a subreddit
	 * @author Yugansh Goyal
	 * @param Subreddit - a string representing the name of the subreddit
	 * @return RedditSearchResult - a model class representing the results
	 */
	public CompletableFuture<RedditSearchResult> PartC_getSubredditSubmissions(String Subreddit){
		try{
			Subreddit = URLEncoder.encode(Subreddit,"UTF-8");} catch(Exception e){System.out.println(e);}
		
		String api = "https://api.pushshift.io/reddit/search/submission/?subreddit="+Subreddit+"&size=10";

		this.searchKey = "dummy";
		return CompletableFuture.supplyAsync(()->getApiResults(api));
	}

	/**setter class for build in submission
	 * @author Ziran Cao
	 * @param hcs
	 */
	public void setHardCodeSubm(RedditSearchResult hcs){
		hardCodeSubm = hcs;
	}
	
}
