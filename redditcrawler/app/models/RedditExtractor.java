package models;

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
//import play.libs.Json;
import static java.util.stream.Collectors.toList;


public class RedditExtractor {
	public static boolean isTesting = false;
	//executor for the api, will ge the search key and data for that search

	public String searchKey;
	public User curUser;


	public RedditExtractor() {

	}

	public RedditExtractor(User user) {
		this.curUser = user;     //to store the user temperarily, for later adding data purpose
	}
	

	/**
	 * Get latest 10 reddit search results asynchronously
	 * @author 
	 * @param searchKey a string representing the searchkey word
	 * @return a finishing message, showing the operation is successful
	 * @version v1
	 */
	//public CompletableFuture<String> getLatestSubmissions(String searchKey){
	public CompletableFuture<RedditSearchResult> getLatestSubmissions(String searchKey){
		
		this.searchKey=searchKey;
		
		try{
			this.searchKey = URLEncoder.encode(this.searchKey,"UTF-8");
		} catch(Exception e){
			System.out.println(e);
		}	
		
		//System.out.println(cache.toString());  ///the place to print the {}

		String api = "https://api.pushshift.io/reddit/search/submission/?q="+this.searchKey+"&size=10";

		RedditSearchResult submissions = getApiResults(api);

		//to store the data on the cache with the user
		curUser.removeOlderResult(this.searchKey);

		curUser.keepLatestTenResults();
		curUser.appendCache(submissions);
		
		//return CompletableFuture.supplyAsync(()->"searching operation successful");
		return CompletableFuture.supplyAsync(()->getApiResults(api));

	}
	
	
	public RedditSearchResult getApiResults(String api){
		
		RedditSearchResult submissions= new RedditSearchResult();
		
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
				
		return submissions;
		
	}

	public RedditSearchResult getEmptyResults(){
		
		RedditSearchResult submissions= new RedditSearchResult();
		
		submissions.setSearchKey(this.searchKey);
		List<SingleSubmission> searchResult = new ArrayList<>();
		SingleSubmission singlesub = new SingleSubmission("", "", "", "");
		searchResult.add(singlesub);
		submissions.setResults(searchResult);
		
		return submissions;
	}


	public RedditSearchResult parse(String responseBody){
        
		//and return a list of redditsearches
		//adding new result to the user cache
		RedditSearchResult result= new RedditSearchResult();
		result.setSearchKey(this.searchKey);
		List<SingleSubmission> searchResult = new ArrayList<>();  //adding to the new list
		
		JSONObject submissionObject = new JSONObject(responseBody);
        JSONArray submissions = submissionObject.getJSONArray("data");

		/*
		for(int i =0; i < submissions.length(); i++){
			JSONObject submission = submissions.getJSONObject(i);
			String author = submission.getString("author");
			String subreddit = submission.getString("subreddit");
			String title = submission.getString("title");
			String submissionlink = submission.getString("full_link");
			
			SingleSubmission singlesub = new SingleSubmission(author, subreddit, title, submissionlink);
			searchResult.add(singlesub);
			
			result.setResults(searchResult);
			
			//System.out.println(i+"!!!"+author+"***"+subreddit+" +++ "+title);  //max to 99 searches
		}*/
		
		for(int i =0; i < submissions.length(); i++){
			JSONObject submission = submissions.getJSONObject(i);
			String author = submission.getString("author");
			String subreddit = submission.getString("subreddit");
			String title = submission.getString("title");
			String submissionlink = submission.getString("full_link");
			
			SingleSubmission singlesub = new SingleSubmission(author, subreddit, title, submissionlink);
			searchResult.add(singlesub);
			
			result.setResults(searchResult);
			
			//System.out.println(i+"!!!"+author+"***"+subreddit+" +++ "+title);  //max to 99 searches
		}
		
		result.getResults().parallelStream().forEach(r->r.setAuthor("<a href='/profile/"+r.getAuthor()+"'>"+r.getAuthor()+"</a>"));
		result.getResults().parallelStream().forEach(r->r.setSubreddit("<a href='/subreddit/"+r.getSubreddit()+"'>"+r.getSubreddit()+"</a>"));
		
		return result;
	}
	
	
	
	//Simon individual's task
	
	/**
	 * Get distinct word count asynchronously
	 * @author Ziran Cao
	 * @param curRed current collection of redditSearch results based on one key word
	 * @param count Number of reddits wanted to analysis
	 * @return a list of list<string>, which contains the information of the distinct words and thier work counts
	 * @version v1
	 */

	public CompletableFuture<List<List<String>>> getDistW(String searchKey, int count){
		
		this.searchKey=searchKey;
		
		try{
				this.searchKey = URLEncoder.encode(this.searchKey,"UTF-8");
		} catch(Exception e){
				System.out.println(e);
		}	
		
		return CompletableFuture.supplyAsync(()->new DistWordDesc().desDistWdCount( searchKey, count));
	}
	
	
	//Yugansh's Individual task
	public CompletableFuture<RedditSearchResult> PartC_getSubredditSubmissions(String Subreddit){
		try{
			Subreddit = URLEncoder.encode(Subreddit,"UTF-8");
		} catch(Exception e){
			System.out.println(e);
		}
		
		String api = "https://api.pushshift.io/reddit/search/submission/?subreddit="+Subreddit+"&size=10";

		this.searchKey = "dummy";
		
		//RedditSearchResult submissions = getApiResults(api);
		
		return CompletableFuture.supplyAsync(()->getApiResults(api));
		//return submissions;

	}
	
	
}
