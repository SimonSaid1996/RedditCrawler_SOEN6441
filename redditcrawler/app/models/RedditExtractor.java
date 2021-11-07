package models;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

import org.json.*;



public class RedditExtractor{
	
	public String searchKey;
	
	public RedditExtractor() {
		
	}
	
	public RedditExtractor(String searchKey) {
		this.searchKey = searchKey;
	}
	
	
	public void getlatestsubmissions(User user){
        
		try{
			searchKey = URLEncoder.encode(searchKey,"UTF-8");
		} catch(Exception e){
			System.out.println(e);
		}	
		
		Hashtable<String,List<RedditSearch>> cache = user.getCache();
		
		if( !cache.containsKey(searchKey) ) {
			cache.put(searchKey, new ArrayList<RedditSearch>());
			String sampleurl = "https://api.pushshift.io/reddit/search/submission/?q="+searchKey+"&size=10";
			
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(sampleurl)).build();
			client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
							.thenApply(HttpResponse::body)
							.thenApply(this::parse)
							.join();
		}	
		
	}
	
	public String parse(String responseBody){
	
		JSONObject submissionObject = new JSONObject(responseBody);
        JSONArray submissions = submissionObject.getJSONArray("data");

		for(int i =0; i < submissions.length(); i++){
			JSONObject submission = submissions.getJSONObject(i);
			String author = submission.getString("author");
			String subreddit = submission.getString("subreddit");
			String title = submission.getString("title");
			
			RedditSearch search = new RedditSearch(author, subreddit, title);
			List<RedditSearch> searchResult = cache.get(RedditExtractor.searchKey);
			searchResult.add(search);
			
			//System.out.println(author+" "+subreddit+" "+title);
		}
		
		return null;
	}
	
	
}
