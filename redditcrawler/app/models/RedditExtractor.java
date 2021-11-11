package models;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;


public class RedditExtractor {
	
	//executor for the api, will ge the search key and data for that search

	public String searchKey;
	public User curUser;


	public RedditExtractor() {

	}

	public RedditExtractor(User user) {
		this.curUser = user;     //to store the user temperarily, for later adding data purpose
	}
	
	
	public void getLatestSubmissions(String searchKey){
		
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
		if (curUser.isThereaSameKey(this.searchKey)) {
			curUser.remove(this.searchKey);
		}
		curUser.appendCache(submissions);
		
	}
	
	public RedditSearchResult getApiResults(String api){
		
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(api)).build();
		RedditSearchResult submissions = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
											.thenApply(HttpResponse::body)
											.thenApply(this::parse)      
											.join();
				
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

		for(int i =0; i < submissions.length(); i++){
			JSONObject submission = submissions.getJSONObject(i);
			String author = submission.getString("author");
			String subreddit = submission.getString("subreddit");
			String title = submission.getString("title");
			
			SingleSubmission singlesub = new SingleSubmission(author, subreddit, title);
			searchResult.add(singlesub);
			
			result.setResults(searchResult);
			
			//System.out.println(i+"!!!"+author+"***"+subreddit+" +++ "+title);  //max to 99 searches
		}
		
		return result;
	}
	
	
}
